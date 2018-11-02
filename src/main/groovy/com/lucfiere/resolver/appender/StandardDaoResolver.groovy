package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.ddl.Table
import com.lucfiere.resolver.BaseResolver
import com.lucfiere.resolver.Resolver
import org.apache.commons.lang3.StringUtils

import static com.lucfiere.utils.CommonUtils.capitalFirst
import static com.lucfiere.utils.CommonUtils.toCamel

class StandardDaoResolver extends BaseResolver implements Appender {

    StandardDaoResolver(Table table) {
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

    private static String generateClassHead(String entity) {
        """
/**
 * @author ${Cons.AUTHOR}
 */ 
@Repository
public class ${capitalFirst(entity)}DaoImpl implements ${capitalFirst(entity)}Dao {

    @Autowire
    private ${capitalFirst(entity)}Mapper ${entity}Mapper;
        """
    }

    private static String generateMethod(String entity) {
        """
    public List<${capitalFirst(entity)}> select${capitalFirst(entity)}ListByExample(${capitalFirst(entity)} ${entity}Example) {
        return ${entity}Mapper.select${capitalFirst(entity)}ListByExample(${entity}Example);
    }

    public List<${capitalFirst(entity)}> select${capitalFirst(entity)}ListByParam(${capitalFirst(entity)} ${entity}) {
        return ${entity}Mapper.select${capitalFirst(entity)}ListByParam(${entity})
    }

    public ${capitalFirst(entity)} select${capitalFirst(entity)}ListById(Long id) {
        return ${entity}Mapper.select${capitalFirst(entity)}ListById(id);
    }

    public Long insert${capitalFirst(entity)}(${capitalFirst(entity)} ${entity}) {
        return ${entity}Mapper.insert${capitalFirst(entity)}(${entity});
    }

    public Long update${capitalFirst(entity)}(${capitalFirst(entity)} ${entity}) {
        return ${entity}Mapper.update${capitalFirst(entity)}(${entity});
    }

    public void delete${capitalFirst(entity)}ById(Long id) {
        ${entity}Mapper.delete${capitalFirst(entity)}ById(id);
    }
        """
    }

    private static String generateClassTail() {
        """
}
        """
    }

}
