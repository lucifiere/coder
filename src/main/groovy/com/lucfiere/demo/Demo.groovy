package com.lucfiere.demo

import com.lucfiere.bootstrap.Bootstrap
import com.lucfiere.common.Cons
import com.lucfiere.resolver.BootstrapContext
import com.lucfiere.resolver.ResolverFactory

class Demo {

    static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap()
        BootstrapContext context = new BootstrapContext.Builder()
                .setDdlPath(Cons.INPUT_PATH)
                .setTargetPath(Cons.OUT_PATH)
                .setTablePrefix("themis_")
                .create()
        bootstrap.resolvers(ResolverFactory.damaiResolvers)
        bootstrap.execute(context)
    }

}
