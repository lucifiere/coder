package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.ddl.Table
import com.lucfiere.resolver.BaseResolver
import com.lucfiere.resolver.Resolver
import org.apache.commons.lang3.StringUtils

import static com.lucfiere.utils.CommonUtils.capitalFirst
import static com.lucfiere.utils.CommonUtils.toCamel

class StandardMapperResolver extends BaseResolver implements Appender {

    StandardMapperResolver(Table table) {
        super(table)
    }

    @Override
    Resolver autoAppend() {
        result = ""
        if (StringUtils.isNoneBlank(table.name)) {
            String tableName = toCamel(table.name)
            result += generateClassHead(tableName)
            result += generateMethod(tableName)
            result += generateClassTail()
        }
        this
    }

    private static String generateClassHead(String tableName) {
        """
/**
 * @author ${Cons.AUTHOR}
 */ 
public interface ${tableName}Mapper {
        """
    }

    private static String generateMethod(String entity) {
        """
    List<${capitalFirst(entity)}> select${capitalFirst(entity)}ListByExample(${capitalFirst(entity)} ${entity}Example);

    List<${capitalFirst(entity)}> select${capitalFirst(entity)}ListByParam(${capitalFirst(entity)} ${entity});

    ${capitalFirst(entity)} select${capitalFirst(entity)}ListById(Long id);

    Long insert${capitalFirst(entity)}(${capitalFirst(entity)} ${entity});

    Long update${capitalFirst(entity)}(${capitalFirst(entity)} ${entity});

    void delete${capitalFirst(entity)}ById(Long id);
        """
    }

    private static String generateClassTail() {
        """
}
        """
    }

}
