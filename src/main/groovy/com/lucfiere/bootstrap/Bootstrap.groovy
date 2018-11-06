package com.lucfiere.bootstrap

import com.lucfiere.ddl.Table
import com.lucfiere.file.DefaultFileHelper
import com.lucfiere.file.FileHelper
import com.lucfiere.file.SourceCodeBundle
import com.lucfiere.resolver.BootstrapContext
import com.lucfiere.resolver.Resolver
import com.lucfiere.resolver.ResolverBundle
import com.lucfiere.wapper.TableWrapper
import com.lucfiere.wapper.re.ReLexer
import com.lucfiere.wapper.re.SimpleLexer
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Bootstrap {

    private String ddlPath

    private FileHelper fileHelper

    private ResolverBundle resolvers

    private TableWrapper wrapper

    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class)

    Bootstrap() {
        this.fileHelper = new DefaultFileHelper()
        this.wrapper = new SimpleLexer()
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

    Bootstrap wrapper(ReLexer wrapper) {
        this.wrapper = wrapper
        this
    }

    void execute(BootstrapContext context) {
        contextCheck(context)
        String ddlPath = context.getDdlPath()
        String ddlText = fileHelper.loadDdlFile(ddlPath)
        context.setDdlContent(ddlText)
        Table table = new Table()
        wrapper.wrap(table, context)
        context.setTable(table)
        SourceCodeBundle sourceCodes = new SourceCodeBundle()
        resolvers.resolve(sourceCodes, context)
        fileHelper.exportSourceCodeFile(sourceCodes, context.getTargetPath())
    }

    private static void contextCheck(BootstrapContext context) {
        if (StringUtils.isEmpty(context.getDdlPath())) {
            throw new IllegalArgumentException("ddl path in context can not be blank!")
        }
    }

}
