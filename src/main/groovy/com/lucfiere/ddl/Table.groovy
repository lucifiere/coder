package com.lucfiere.ddl

class Table {

    private String entityName

    private String tableName

    private String completeTableName

    private String prefix

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

    String getPrefix() {
        return prefix
    }

    void setPrefix(String prefix) {
        this.prefix = prefix
    }

    String getCompleteTableName() {
        return completeTableName
    }

    void setCompleteTableName(String completeTableName) {
        this.completeTableName = completeTableName
    }
}
