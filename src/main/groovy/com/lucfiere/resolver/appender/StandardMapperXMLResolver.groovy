package com.lucfiere.resolver.appender

import com.lucfiere.resolver.type.MapperXMLResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst

class StandardMapperXMLResolver extends BaseAppender implements Appender, MapperXMLResolver {

    @Override
    protected String headCode() {
        """
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${capitalFirst(entityName)}Mapper">
        """
    }

    @Override
    protected String bodyCode() {
        baseResultMapCode() +
                baseColCode() +
                criteriaCode() +
                selectByExampleCode() +
                selectById() +
                selectListByParam() +
                deleteById() +
                update() +
                insert()
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
    <resultMap id="BaseResultMap" type="${capitalFirst(entityName)}">"""
        table.fieldList.each {
            code += """
        <id column="${it.sqlName}" property="${it.javaName}" jdbcType="${it.fieldType.sqlLiteral.toUpperCase()}"/>"""
        }
        code += """
    </resultMap>
    """
    }

    private baseColCode = { ->
        String code = """
    <sql id=\"Base_Column_List\">"""
        String filed = ""
        table.fieldList.each {
            filed += """
        ${it.sqlName},"""
        }
        code += filed[0..-2]
        code += """
    </sql>
    """
        code
    }

    private selectByExampleCode = { ->
        """
    <select id="selectByExample" resultMap="BaseResultMap" parameterType="${capitalFirst(entityName)}Example">
        select
        <if test="distinct">
            distinct
        </if>
        <include refid="Base_Column_List"/>
        from ${tableName}
        <if test="_parameter != null">
            <include refid="Example_Where_Clause"/>
        </if>
        <if test="orderByClause != null" >
            order by \${orderByClause}
        </if> 
    </select>
    """
    }

    private selectById = { ->
        """
    <select id="select${capitalFirst(entityName)}ById" resultMap="BaseResultMap" parameterType="java.lang.Long">
        select 
        <include refid="Base_Column_List"/>
        from
        ${tableName}
        where 
        id = #{id,jdbcType=BIGINT}
    </select>
        """
    }

    private selectListByParam = { ->
        String code = """
    <select id="select${capitalFirst(entityName)}ListByParam" resultMap="BaseResultMap" parameterType="${
            capitalFirst(entityName)
        }">
        select 
        <include refid="Base_Column_List"/>
        from
        ${tableName}
        where
        1 = 1"""
        table.fieldList.each {
            code += """
        <if test="${it.javaName} != null">
            and ${it.sqlName} = #{${it.javaName},jdbcType=${it.fieldType.sqlLiteral.toUpperCase()}}
        </if>"""
        }
        code += """
    </select>
"""
        code
    }

    private deleteById = { ->
        """
    <delete id="delete${capitalFirst(entityName)}ById" parameterType="java.lang.Long">
        delete from ${tableName}
        where id = #{id,jdbcType=BIGINT}
    </delete>
"""

    }

    private update = { ->
        String code = """
    <update id="update${capitalFirst(entityName)}ById" parameterType="${capitalFirst(entityName)}" >
        update ${tableName}
        <set>"""
        table.fieldList.each {
            code += """
            <if test="${it.javaName} != null">
                ${it.sqlName} = #{${it.javaName},jdbcType=${it.fieldType.sqlLiteral.toUpperCase()}}
            </if>"""
        }
        code += """
        </set>
        where id = #{id,jdbcType=BIGINT}
    </update>
"""
    }

    private insert = { ->
        String code = """
    <insert id="insert${capitalFirst(entityName)}" parameterType="${capitalFirst(entityName)}" >
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >"""
        table.fieldList.each {
            code += """
            <if test="id != null" >
                ${it.sqlName},
            </if>"""
        }
        code += """
        </trim>
        <trim prefix="(" suffix=")" suffixOverrides="," >"""
        table.fieldList.each {
            code += """
            <if test="id != null" >
                #{${it.javaName},jdbcType=${it.fieldType.sqlLiteral.toUpperCase()}},
            </if>"""
        }
        code += """
        </trim>
    </insert>
"""
    }


    @Override
    protected String tailCode() {
        """
</mapper>
"""
    }

}
