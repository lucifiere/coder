package com.lucfiere.resolver.appender

import com.lucfiere.resolver.Resolver

interface Appender extends Resolver {

    Resolver autoAppend()

}