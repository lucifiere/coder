package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.resolver.type.DaoResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst

class StandardDaoResolver extends BaseAppender implements Appender, DaoResolver {

    @Override
    protected String headCode() {
        """
/**
 * @author ${Cons.AUTHOR}
 */ 
@Repository
public class ${capitalFirst(entityName)}DaoImpl implements ${capitalFirst(entityName)}Dao {

    @Autowire
    private ${capitalFirst(entityName)}Mapper ${entityName}Mapper;
        """
    }

    @Override
    protected String bodyCode() {
        String capitalFirstEntity = capitalFirst(entityName)
        """
    public List<${capitalFirstEntity}> select${capitalFirstEntity}ListByExample(${capitalFirstEntity} ${entityName}Example) {
        return ${entityName}Mapper.select${capitalFirstEntity}ListByExample(${entityName}Example);
    }

    public List<${capitalFirstEntity}> select${capitalFirstEntity}ListByParam(${capitalFirstEntity} ${entityName}) {
        return ${entityName}Mapper.select${capitalFirstEntity}ListByParam(${entityName})
    }

    public ${capitalFirstEntity} select${capitalFirstEntity}ById(Long id) {
        return ${entityName}Mapper.select${capitalFirstEntity}ById(id);
    }

    public Long insert${capitalFirstEntity}(${capitalFirstEntity} ${entityName}) {
        return ${entityName}Mapper.insert${capitalFirstEntity}(${entityName});
    }

    public Long update${capitalFirstEntity}ById(${capitalFirstEntity} ${entityName}) {
        return ${entityName}Mapper.update${capitalFirstEntity}(${entityName});
    }

    public void delete${capitalFirstEntity}ById(Long id) {
        ${entityName}Mapper.delete${capitalFirstEntity}ById(id);
    }
        """
    }

    @Override
    protected String tailCode() {
        """
}
        """
    }
    
}
