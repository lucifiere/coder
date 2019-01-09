package com.lucfiere.resolver.appender

import com.lucfiere.resolver.BaseResolver
import com.lucfiere.resolver.Resolver
import org.apache.commons.lang3.StringUtils

abstract class BaseAppender extends BaseResolver implements Appender {

    protected String entityName

    protected String tableName

    protected String completeTableName

    @Override
    Resolver autoAppend() {
        if (StringUtils.isBlank(table.entityName)) {
            throw new RuntimeException("resolve table failed")
        }
        this.entityName = table.entityName
        this.tableName = table.tableName
        this.completeTableName = table.completeTableName
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
