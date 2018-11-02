package com.lucfiere.db

class Field {

    private String fieldType

    private String name

    private Integer length

    private String comment

    String getFieldType() {
        return fieldType
    }

    void setFieldType(String fieldType) {
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
