package com.lucfiere.lexer.re

import com.lucfiere.ddl.Field
import com.lucfiere.ddl.Table
import org.apache.commons.collections4.CollectionUtils

import static Extractor.*

class SimpleLexer extends ReLexer {

    @Override
    protected void parseTableName(Statement statement) {
        if (statement.prev == "create" && statement.cur == "table") {
            table.setName(extractFiled(statement.next))
        }
    }

    @Override
    protected void parseField(Statement statement) {
        if (statement.prev == null && isFiled(statement.cur)) {
            Field field = new Field()
            field.setName(extractFiled(statement.cur))
            field.setFieldType(extractFiledType(statement.next))
            field.setLength(extractFiledLength(statement.next))
            field.setComment(extractFiledComment(statement))
            table.addField(field)
        }
    }

    @Override
    protected void parseIndex(Statement statement) {

    }

    @Override
    protected void parseTableAttr(Statement statement) {
        if (CollectionUtils.isNotEmpty(statement.line)) {
        }
    }

}