package com.lucfiere.demo

import com.lucfiere.bootstrap.Bootstrap
import com.lucfiere.common.Cons
import com.lucfiere.resolver.ResolveContext

class Demo {

    static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap()
        ResolveContext context = new ResolveContext.Builder()
                .setDdlPath(Cons.inputPath).setTargetPath(Cons.outPath).create()
        bootstrap.execute(context)
    }

}
