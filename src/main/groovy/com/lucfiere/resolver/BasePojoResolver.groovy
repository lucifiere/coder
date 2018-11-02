package com.lucfiere.resolver

import com.lucfiere.ddl.Table

abstract class BasePojoResolver {

    protected Table table

    protected String result

    BasePojoResolver(Table table) {
        this.table = table
    }

    String result() { result }

    Table table() { table }

}
