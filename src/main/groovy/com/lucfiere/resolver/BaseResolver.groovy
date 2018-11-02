package com.lucfiere.resolver

import com.lucfiere.ddl.Table
import com.lucfiere.resolver.appender.Appender
import com.lucfiere.resolver.render.Render

abstract class BaseResolver {

    protected Table table

    protected String result

    String result() { result }

    Table table() { table }

    void resolve(ResolveContext context) {
        assert context.getTable() != null
        this.table = context.getTable()
        if (this instanceof Appender) {
            Appender appender = this as Appender
            appender.autoAppend()
        }
        if (this instanceof Render) {
            Render render = this as Render
            render.render(context.getTemplateData(), context.getTemplate())
        }
    }

}
