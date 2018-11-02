package com.lucfiere.lexer

import com.lucfiere.ddl.Field
import com.lucfiere.ddl.Table

import static com.lucfiere.lexer.Extractor.*

class SimpleLexer extends Lexer {

    SimpleLexer(String text, Table table) {
        super(text, table)
    }

    @Override
    protected void parseTableName(Statement statement) {
        if (statement.prev == "create" && statement.cur == "table") {
            table.setName(extractFiled(statement.next))
        }
    }

    @Override
    protected void parseField(Statement statement) {
        if (statement.prev == null && isFiled(statement.cur)) {
            Field field = new Field()
            field.setName(extractFiled(statement.cur))
            field.setFieldType(extractFiledType(statement.next))
            field.setLength(extractFiledLength(statement.next))
            field.setComment(extractFiledComment(statement))
            table.addField(field)
        }
    }

    @Override
    protected void parseIndex(Statement statement) {

    }

    @Override
    protected void parseTableAttr(Statement statement) {

    }

}
