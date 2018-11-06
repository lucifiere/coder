package com.lucfiere.ddl

class Table {

    private String entityName

    private String tableName

    private List<Field> fieldList = []

    String getEntityName() {
        return entityName
    }

    void setEntityName(String entityName) {
        this.entityName = entityName
    }

    String getTableName() {
        return tableName
    }

    void setTableName(String tableName) {
        this.tableName = tableName
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
