package com.lucfiere.demo

import com.lucfiere.bootstrap.Bootstrap
import com.lucfiere.common.Cons
import com.lucfiere.resolver.ResolveContext

class Demo {

    static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap()
        ResolveContext context = new ResolveContext.Builder()
                .setDdlPath(Cons.INPUT_PATH).setTargetPath(Cons.OUT_PATH).create()
        bootstrap.execute(context)
    }

}
