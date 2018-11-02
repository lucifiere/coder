package com.lucfiere.resolver

import com.lucfiere.db.Table
import com.lucfiere.template.PlaceHolder
import com.lucfiere.template.Template

interface Resolver {

    Resolver resolve(Map<String, Object> data)

    Table getTable()

    Template getTemplate()

    Resolver render(List<PlaceHolder> placeHolders)

}