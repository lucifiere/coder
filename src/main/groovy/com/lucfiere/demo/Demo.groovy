package com.lucfiere.demo

import com.lucfiere.bootstrap.Bootstrap
import com.lucfiere.resolver.ResolveContext

class Demo {

    static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap()
        ResolveContext context = new ResolveContext.Builder()
                .setDdlPath("xxx").setTargetPath("xxx").create()
        bootstrap.execute(context)
    }

}
