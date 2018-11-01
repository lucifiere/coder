package com.lucfiere.lexer

import com.lucfiere.common.FieldType
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang3.StringUtils

class Extractor {

    public static String FILED_IDENTITY = "`"

    public static String COMMENT_IDENTITY = "'"

    static String extractFiled(String value) {
        isFiled(value) ? value.substring(1, value.length() - 1) : ""
    }

    static String extractComment(String text) {
        text.find(~/(?<=\').*(?=\')/)
    }

    static boolean isFiled(String value) {
        StringUtils.isNotEmpty(value) && value.startsWith(FILED_IDENTITY) && value.endsWith(FILED_IDENTITY)
    }

    static boolean isComment(String value) {
        StringUtils.isNotEmpty(value) && value.startsWith(COMMENT_IDENTITY) && value.endsWith(COMMENT_IDENTITY)
    }

    static FieldType extractFiledType(String text) {
        String type = text.find(~/.*(?=\()/)
        if (StringUtils.isEmpty(type)) {
            return null
        }
        FieldType.findByLiteral(type)
    }

    static Integer extractFiledLength(String text) {
        String length = text.find(~/(?<=\().*(?=\))/)
        if (StringUtils.isEmpty(length)) {
            return null
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

}