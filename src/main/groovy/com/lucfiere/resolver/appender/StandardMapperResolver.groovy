package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.resolver.type.MapperResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst

class StandardMapperResolver extends BaseAppender implements Appender, MapperResolver {

    @Override
    protected String headCode() {
        """
/**
 * @author ${Cons.AUTHOR}
 */ 
public interface ${entityName}Mapper {
        """
    }

    @Override
    protected String bodyCode() {
        String capitalFirstEntityName = capitalFirst(entityName)
        """
    List<${capitalFirstEntityName}> select${capitalFirstEntityName}ListByExample(${capitalFirstEntityName} ${entityName}Example);

    List<${capitalFirstEntityName}> select${capitalFirstEntityName}ListByParam(${capitalFirstEntityName} ${entityName});

    ${capitalFirstEntityName} select${capitalFirstEntityName}ListById(Long id);

    Long insert${capitalFirstEntityName}(${capitalFirstEntityName} ${entityName});

    Long update${capitalFirstEntityName}(${capitalFirstEntityName} ${entityName});

    void delete${capitalFirstEntityName}ById(Long id);
        """
    }

    @Override
    protected String tailCode() {
        """
}
        """
    }

}
