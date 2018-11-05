package com.lucfiere.bootstrap

import com.alibaba.fastjson.JSON
import com.lucfiere.ddl.Table
import com.lucfiere.file.DefaultFileHelper
import com.lucfiere.file.FileHelper
import com.lucfiere.file.SourceCodeBundle
import com.lucfiere.lexer.Lexer
import com.lucfiere.lexer.re.ReLexer
import com.lucfiere.lexer.re.SimpleLexer
import com.lucfiere.resolver.ResolveContext
import com.lucfiere.resolver.Resolver
import com.lucfiere.resolver.ResolverBundle
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Bootstrap {

    private String ddlPath

    private FileHelper fileHelper

    private ResolverBundle resolvers

    private Lexer lexer

    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class)

    Bootstrap() {
        this.fileHelper = new DefaultFileHelper()
        this.lexer = new SimpleLexer()
        this.resolvers = new ResolverBundle()
    }

    Bootstrap path(String ddlPath) {
        this.ddlPath = ddlPath
        this
    }

    Bootstrap fileHelper(FileHelper fileHelper) {
        this.fileHelper = fileHelper
        this
    }

    Bootstrap resovers(List<Resolver> resolvers) {
        this.resolvers.replace(resolvers)
        this
    }

    Bootstrap resover(Resolver resolvers) {
        this.resolvers.add(resolvers)
        this
    }

    Bootstrap lexer(ReLexer lexer) {
        this.lexer = lexer
        this
    }

    void execute(ResolveContext context) {
        contextCheck(context)
        String ddlPath = context.getDdlPath()
        String ddlText = fileHelper.loadDdlFile(ddlPath)
        Table table = new Table()
        lexer.parse(ddlText, table)
        context.setTable(table)
        SourceCodeBundle sourceCodes = new SourceCodeBundle()
        resolvers.resolve(sourceCodes, context)
        fileHelper.exportSourceCodeFile(sourceCodes, context.getTargetPath())
        LOGGER.info(JSON.toJSONString(sourceCodes))
    }

    private static void contextCheck(ResolveContext context) {
        if (StringUtils.isEmpty(context.getDdlPath())) {
            throw new IllegalArgumentException("ddl path in context can not be blank!")
        }
    }

}
