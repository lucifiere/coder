package com.lucfiere.db

import com.lucfiere.common.FieldType

class Field {

    private FieldType fieldType

    private String name

    private Integer length

    private String comment

    FieldType getFieldType() {
        return fieldType
    }

    void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Integer getLength() {
        return length
    }

    void setLength(Integer length) {
        this.length = length
    }

    String getComment() {
        return comment
    }

    void setComment(String comment) {
        this.comment = comment
    }

}
