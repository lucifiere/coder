package com.lucfiere.wrapper.re

import com.lucfiere.common.FieldType
import com.lucfiere.ddl.Statement
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang3.StringUtils

class Extractor {

    public static String FILED_IDENTITY = "`"

    static String extractFiled(String value) {
        isFiled(value) ? value.substring(1, value.length() - 1) : ""
    }

    static String extractComment(String text) {
        text.find(~/(?<=\').*(?=\')/) ?: ""
    }

    static boolean isFiled(String value) {
        StringUtils.isNotEmpty(value) && value.startsWith(FILED_IDENTITY) && value.endsWith(FILED_IDENTITY)
    }

    static FieldType extractFiledType(String text) {
        String type = text.find(~/.*(?=\()/) ?: text
        FieldType.findByLiteral(type)
    }

    static Integer extractFiledLength(String text, FieldType fieldType) {
        String length = text.find(~/(?<=\().*(?=\))/)
        def decimalType = [FieldType.NUM_DOUBLE, FieldType.NUM_FLOAT, FieldType.NUM_DECIMAL]
        if (StringUtils.isEmpty(length)) {
            return null
        }
        if (decimalType.contains(fieldType)) {
            return length.split(",")[0] as Integer
        }
        Integer.valueOf(length)
    }

    static String extractFiledComment(Statement statement) {
        if (CollectionUtils.isNotEmpty(statement.line)) {
            int keywordIndex = statement.line.findLastIndexOf { it.toLowerCase() == "comment" } + 1
            return extractComment(statement.line.get(keywordIndex))
        }
        null
    }

    static List<String> cleanToken(List<String> tokens) {
        tokens
    }

}
