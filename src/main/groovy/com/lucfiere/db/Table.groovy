package com.lucfiere.db

class Table {

    private String name

    private List<Field> fieldList = []

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    List<Field> getFieldList() {
        return fieldList
    }

    void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList
    }

    void addField(Field filed) {
        this.fieldList << filed
    }

}
