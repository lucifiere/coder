package com.lucfiere.resolver

import com.lucfiere.ddl.Table

abstract class BaseResolver {

    protected Table table

    protected String result

    BaseResolver(Table table) {
        this.table = table
    }

    String result() { result }

    Table table() { table }

}
