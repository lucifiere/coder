package com.lucfiere.common

class Tuple2<A, B> {

    public A first

    public B second

    Tuple2(A a, B b) {
        first = a
        second = b
    }

    @Override
    String toString() {
        return "(" + first + ", " + second + ")"
    }

}
