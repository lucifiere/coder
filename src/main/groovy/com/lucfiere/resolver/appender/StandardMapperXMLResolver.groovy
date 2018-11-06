package com.lucfiere.resolver.appender

import com.lucfiere.resolver.type.MapperResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst

class StandardMapperXMLResolver extends BaseAppender implements Appender, MapperResolver {

    @Override
    protected String headCode() {
        """
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
    <mapper namespace="cn.com.ykse.marketing.repository.dao.ActivityRuleDOMapper">
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

    private String baseResultMapCode() {
        String map = """
    <resultMap id="BaseResultMap" type="cn.com.ykse.marketing.repository.entity.ActivityRuleDO">
        """
        table.fieldList.each {
            map += """
        <id column="${it.sqlName}" property="${it.javaName}" jdbcType="${it.fieldType.sqlLiteral}"/>
        """
        }
        map += """
        </resultMap>
         """
    }

    @Override
    protected String tailCode() {
        """
}
        """
    }

}
