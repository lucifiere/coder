package com.lucfiere.resolver

import com.lucfiere.ddl.Table

interface Resolver {

    Table table()

    String result()

    void resolve(BootstrapContext context)

}