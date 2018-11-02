package com.lucfiere.lexer

import com.lucfiere.ddl.Table

interface Lexer {

    void parse(String text, Table table)

}