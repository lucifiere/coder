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
        baseResultMapCode() + baseColCode() + criteriaCode() + selectByExampleCode()
    }

    private criteriaCode = { ->
        """
    <sql id="Example_Where_Clause">
        <where>
            <foreach collection="oredCriteria" item="criteria" separator="or">
                <if test="criteria.valid">
                    <trim prefix="(" suffix=")" prefixOverrides="and">
                        <foreach collection="criteria.criteria" item="criterion">
                            <choose>
                                <when test="criterion.noValue">
                                    and \${criterion.condition}
                                </when>
                                <when test="criterion.singleValue">
                                    and \${criterion.condition} #{criterion.value}
                                </when>
                                <when test="criterion.betweenValue">
                                    and \${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                                </when>
                                <when test="criterion.listValue">
                                    and \${criterion.condition}
                                    <foreach collection="criterion.value" item="listItem" open="(" close=")"
                                             separator=",">
                                        #{listItem}
                                    </foreach>
                                </when>
                            </choose>
                        </foreach>
                    </trim>
                </if>
            </foreach>
        </where>
    </sql>
    <sql id="Update_By_Example_Where_Clause">
        <where>
            <foreach collection="example.oredCriteria" item="criteria" separator="or">
                <if test="criteria.valid">
                    <trim prefix="(" suffix=")" prefixOverrides="and">
                        <foreach collection="criteria.criteria" item="criterion">
                            <choose>
                                <when test="criterion.noValue">
                                    and \${criterion.condition}
                                </when>
                                <when test="criterion.singleValue">
                                    and \${criterion.condition} #{criterion.value}
                                </when>
                                <when test="criterion.betweenValue">
                                    and \${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                                </when>
                                <when test="criterion.listValue">
                                    and \${criterion.condition}
                                    <foreach collection="criterion.value" item="listItem" open="(" close=")"
                                             separator=",">
                                        #{listItem}
                                    </foreach>
                                </when>
                            </choose>
                        </foreach>
                    </trim>
                </if>
            </foreach>
        </where>
    </sql>
    """
    }

    private baseResultMapCode = { ->
        String code = """
    <resultMap id="BaseResultMap" type="cn.com.ykse.marketing.repository.entity.ActivityRuleDO">
        """
        table.fieldList.each {
            code += """
        <id column="${it.sqlName}" property="${it.javaName}" jdbcType="${it.fieldType.sqlLiteral}"/>
        """
        }
        code += """
    </resultMap>
         """
    }

    private baseColCode = { ->
        String code = """<sql id=\"Base_Column_List\">"""
        String filed = ""
        table.fieldList.each {
            filed += """
            ${it.sqlName},
        """
        }
        code += filed[0, -2]
        code += """</sql>"""
        code
    }

    private selectByExampleCode = { ->
        """
    <select id="selectByExample" resultMap="BaseResultMap" parameterType="">
        select
        <if test="distinct">
            distinct
        </if>
        <include refid="Base_Column_List"/>
        from activity_rule
        <if test="_parameter != null">
            <include refid="Example_Where_Clause"/>
        </if>
        <!--<if test="orderByClause != null" >-->
        <!--order by \${orderByClause}-->
        <!--</if>-->
    </select>"""
    }

    private String selectListByExampleCode() {
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
</mapper>        
"""
    }

}
