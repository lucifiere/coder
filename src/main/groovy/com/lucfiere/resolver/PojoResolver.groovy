package com.lucfiere.resolver

import com.lucfiere.common.TemplateVarType
import com.lucfiere.db.Table
import com.lucfiere.template.PlaceHolder
import com.lucfiere.template.PojoTemplate
import com.lucfiere.template.Template
import org.apache.commons.collections4.CollectionUtils

abstract class PojoResolver implements Resolver {

    private Table table

    private PojoTemplate template

    private Map<String, Object> data

    PojoResolver(Table table, PojoTemplate template) {
        this.table = table
        this.template = template
    }

    @Override
    Resolver resolve(Map<String, Object> data) {
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

    @Override
    Template getTemplate() { template }

    @Override
    abstract Resolver render(List<PlaceHolder> placeHolders)

    @Override
    Table getTable() { table }

}
