package com.lucfiere.template

import com.lucfiere.common.TemplateVarType

class PlaceHolder {

    private String key

    private String value

    private TemplateVarType type

    String getKey() {
        return key
    }

    void setKey(String key) {
        this.key = key
    }

    String getValue() {
        return value
    }

    void setValue(String value) {
        this.value = value
    }

    TemplateVarType getType() {
        return type
    }

    void setType(TemplateVarType type) {
        this.type = type
    }
}
