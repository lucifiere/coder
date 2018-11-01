package com.lucfiere.common

enum FieldType {

    NUM_TINYINT(Short.class, "tinyint"),
    NUM_SMALLINT(Integer.class, "smallint"),
    NUM_MEDIUMINT(Integer.class, "mediumint"),
    NUM_INT(Integer.class, "int"),
    NUM_BIGINT(Long.class, "bigint"),
    NUM_FLOAT(Float.class, "float"),
    NUM_DOUBLE(Double.class, "double"),
    NUM_DECIMAL(BigDecimal.class, "decimal"),
    TIME_DATE(Date.class, "date"),
    TIME_DATETIME(Date.class, "datetime"),
    TIME_TIMESTAMP(Date.class, "timestamp"),
    TIME_TIME(Date.class, "time"),
    STR_CHAR(String.class, "char"),
    STR_VARCHAR(String.class, "varchar"),
    STR_TEXT(String.class, "text"),
    BYTE_BLOB(Byte[].class, "blob")

    private Class javaType

    private String literal

    FieldType(Class javaType, String literal) {
        this.javaType = javaType
        this.literal = literal
    }

    Class getJavaType() {
        return javaType
    }

    String getLiteral() {
        return literal
    }

    static FieldType findByLiteral(String literal) {
        values().find { it.getLiteral() == literal } as FieldType
    }

}