package com.lucfiere.resolver.appender

import com.lucfiere.resolver.BaseResolver
import com.lucfiere.resolver.Resolver
import org.apache.commons.lang3.StringUtils

import static com.lucfiere.utils.CommonUtils.toCamel

abstract class BaseAppender extends BaseResolver implements Appender {

    protected String entityName

    @Override
    Resolver autoAppend() {
        String tableName = toCamel(table.name)
        if (StringUtils.isBlank(tableName)) {
            throw new RuntimeException("resolve table failed")
        }
        this.entityName = tableName
        result = ""
        result += headCode()
        result += bodyCode()
        result += tailCode()
        this
    }

    protected abstract String headCode()

    protected abstract String bodyCode()

    protected abstract String tailCode()

}
