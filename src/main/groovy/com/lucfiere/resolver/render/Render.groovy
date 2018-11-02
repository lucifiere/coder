package com.lucfiere.resolver.render

import com.lucfiere.resolver.Resolver
import com.lucfiere.template.Template

interface Render extends Resolver  {

    Resolver render(Map<String, Object> data, Template template)

}