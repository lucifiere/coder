package com.lucfiere.wrapper.re

import com.lucfiere.ddl.Field
import com.lucfiere.ddl.Statement
import com.lucfiere.utils.CommonUtils
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang3.StringUtils

import static com.lucfiere.wrapper.re.Extractor.*

class SimpleLexer extends ReLexer {

    @Override
    protected void parseTableName(Statement statement) {
        if (statement.prev == "create" && statement.cur == "table") {
            String tableName = extractFiled(statement.next)
            if (StringUtils.isNoneBlank(table.getPrefix())) {
                tableName = tableName.replaceFirst(table.getPrefix(), "")
            }
            table.setTableName(tableName)
            table.setEntityName(CommonUtils.toCamel(tableName))
        }
    }

    @Override
    protected void parseField(Statement statement) {
        if (statement.prev == null && isFiled(statement.cur)) {
            Field field = new Field()
            field.setName(extractFiled(statement.cur))
            field.setFieldType(extractFiledType(statement.next))
            field.setLength(extractFiledLength(statement.next, field.getFieldType()))
            field.setComment(extractFiledComment(statement))
            table.addField(field)
        }
    }

    @Override
    protected void parseIndex(Statement statement) {

    }

    @Override
    protected void parseTableAttr(Statement statement) {
        if (CollectionUtils.isNotEmpty(statement.line)) {
        }
    }

}
