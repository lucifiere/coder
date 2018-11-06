package com.lucfiere.common

enum FieldType {

    NUM_TINYINT(Short.class, "tinyint", TemplateVarType.NUMBER),
    NUM_SMALLINT(Integer.class, "smallint", TemplateVarType.NUMBER),
    NUM_MEDIUMINT(Integer.class, "mediumint", TemplateVarType.NUMBER),
    NUM_INT(Integer.class, "int", TemplateVarType.NUMBER),
    NUM_BIGINT(Long.class, "bigint", TemplateVarType.NUMBER),
    NUM_FLOAT(Float.class, "float", TemplateVarType.NUMBER),
    NUM_DOUBLE(Double.class, "double", TemplateVarType.NUMBER),
    NUM_DECIMAL(BigDecimal.class, "decimal", TemplateVarType.NUMBER),
    TIME_DATE(Date.class, "date", TemplateVarType.TIME),
    TIME_DATETIME(Date.class, "datetime", TemplateVarType.TIME),
    TIME_TIMESTAMP(Date.class, "timestamp", TemplateVarType.TIME),
    TIME_TIME(Date.class, "time", TemplateVarType.TIME),
    STR_CHAR(String.class, "char", TemplateVarType.TEXT),
    STR_VARCHAR(String.class, "varchar", TemplateVarType.TEXT),
    STR_TEXT(String.class, "text", TemplateVarType.TEXT),
    BYTE_BLOB(Byte[].class, "blob", TemplateVarType.TEXT)

    private Class javaType

    private String sqlLiteral

    private TemplateVarType templateType

    FieldType(Class javaType, String sqlLiteral, TemplateVarType templateType) {
        this.javaType = javaType
        this.sqlLiteral = sqlLiteral
        this.templateType = templateType
    }

    Class getJavaType() { javaType }

    String getSqlLiteral() { sqlLiteral }

    TemplateVarType getTemplateType() { templateType }

    static FieldType findByLiteral(String literal) {
        values().find { it.getSqlLiteral() == literal } as FieldType
    }

}