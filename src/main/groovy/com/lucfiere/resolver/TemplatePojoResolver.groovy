package com.lucfiere.resolver

import com.lucfiere.common.TemplateVarType
import com.lucfiere.ddl.Table
import com.lucfiere.template.Template
import org.apache.commons.collections4.CollectionUtils

class TemplatePojoResolver extends BasePojoResolver implements Render {

    TemplatePojoResolver(Table table) {
        super(table)
    }

    @Override
    Resolver render(Map<String, Object> data, Template template) {
        assert CollectionUtils.isNotEmpty(template.getAllPlaceHolder())
        template.getAllPlaceHolder().each {
            it.setValue(format(data[it.getKey()], it.getType()))
        }
        this
    }

    private static String format(Object value, TemplateVarType type) {
        if (type == TemplateVarType.TIME) {
            if (value instanceof Date) {
                return (value as Date).format("yyyy-MM-dd HH:mm:ss")
            }
        }
        value
    }

}
