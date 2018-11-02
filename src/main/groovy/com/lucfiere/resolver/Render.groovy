package com.lucfiere.resolver

import com.lucfiere.template.Template

interface Render extends Resolver  {

    Resolver render(Map<String, Object> data, Template template)

}