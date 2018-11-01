package com.lucfiere.lexer

import com.lucfiere.common.Tuple2

class Statement {

    String prev

    String next

    String cur

    List<String> line

    Tuple2<Integer, Integer> position

    Statement() {
        this.position = new Tuple2<>(0, 0)
    }

    Statement line(List<String> line) {
        this.line = line
        this
    }

    Statement content(String prev, String next, String cur) {
        this.prev = prev != null ? prev.toLowerCase() : null
        this.next = next != null ? next.toLowerCase() : null
        this.cur = cur != null ? cur.toLowerCase() : null
        this
    }

    Statement position(Integer lineIndex, Integer tokenIndex) {
        this.position.first = lineIndex
        this.position.second = tokenIndex
        this
    }

}
