package com.lucfiere.wrapper.re

import com.lucfiere.ddl.Statement
import com.lucfiere.ddl.Table
import com.lucfiere.resolver.BootstrapContext
import com.lucfiere.wrapper.TableWrapper
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang3.StringUtils

abstract class ReLexer implements TableWrapper {

    protected List<List<String>> tokens = []

    protected String text

    protected static String LINE_SPLITTER = "\n"

    protected static String TOKEN_SPLITTER = " "

    protected static Table table

    void wrap(Table table, BootstrapContext context) {
        this.table = table
        this.text = context.getDdlContent()
        parseToken()
        parseStatement()
    }

    protected void parseToken() {
        if (StringUtils.isBlank(text)) {
            throw new RuntimeException("parse table failed!")
        }
        List<String> lines = text.tokenize(LINE_SPLITTER)
        lines.each {
            if (StringUtils.isNotEmpty(it)) {
                tokens << Extractor.cleanToken(it.tokenize(TOKEN_SPLITTER))
            }
        }
    }

    protected void parseStatement() {
        if (CollectionUtils.isEmpty(tokens)) {
            throw new RuntimeException("analysis resolver text failed!")
        }
        Statement statement = new Statement()
        for (int i = 0; i < tokens.size(); i++) {
            List<String> line = tokens.get(i)
            statement.line(line)
            for (int k = 0; k < line.size(); k++) {
                String prev = k == 0 ? null : line.get(k - 1)
                String next = k + 1 == line.size() ? null : line.get(k + 1)
                String cur = line.get(k)
                statement.position(i, k).content(prev, next, cur)
                parseNextStatement(statement)
            }
        }
    }

    protected void parseNextStatement(Statement statement) {
        parseTableName(statement)
        parseField(statement)
        parseIndex(statement)
        parseTableAttr(statement)
    }

    abstract protected void parseTableName(Statement statement)

    abstract protected void parseField(Statement statement)

    abstract protected void parseIndex(Statement statement)

    abstract protected void parseTableAttr(Statement statement)

}
