package com.lucfiere.wapper

import com.lucfiere.ddl.Table
import com.lucfiere.resolver.BootstrapContext

interface TableWrapper {

    void wrap(Table table, BootstrapContext bootstrapContext)

}
