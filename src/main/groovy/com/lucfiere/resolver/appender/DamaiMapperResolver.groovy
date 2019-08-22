package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.resolver.type.MapperResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst

/**
 * 大麦代码风格
 */
class DamaiMapperResolver extends BaseAppender implements Appender, MapperResolver {

    @Override
    protected String headCode() {
        """
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * Mapper层
 * 
 * @author ${Cons.AUTHOR}
 * @date ${new Date().format("yyyy-MM-dd")}
 */ 
@Mapper
public interface ${capitalFirst(entityName)}Mapper {
        """
    }

    @Override
    protected String bodyCode() {
        String capitalFirstEntityName = capitalFirst(entityName)
        """
    /**
     * 根据Example查询符合条件的结果列表
     * 
     * @param ${entityName}Example 查询条件
     * @return 结果列表
     */
    List<${capitalFirstEntityName}> select${capitalFirstEntityName}ListByExample(${capitalFirstEntityName} ${entityName}Example);

    /**
     * 根据DO参数查询符合条件的结果列表
     * 
     * @param ${entityName} 查询条件
     * @return 结果列表
     */
    List<${capitalFirstEntityName}> select${capitalFirstEntityName}ListByParam(${capitalFirstEntityName} ${entityName});

/**
     * 根据DO参数查询符合条件的结果列表(分页)
     *
     * @param paperInbound 查询条件
     * @param pageInfo     分页
     * @return 结果列表
     */
    List<${capitalFirstEntityName}> select${capitalFirstEntityName}ByParamAndPage(@Param("param") ${capitalFirstEntityName}DO paperInbound, @Param("pageInfo") PageInfo pageInfo);

    /**
     * 根据DO参数查询符合条件的结果列表(分页)
     *
     * @param paperInbound 查询条件
     * @param pageInfo     分页
     * @return 结果列表
     */
    Long select${capitalFirstEntityName}ListPageCount(@Param("param") ${capitalFirstEntityName}DO paperInbound, @Param("pageInfo") Pager pageInfo);

    /**
     * 根据ID查询符合条件的结果
     * 
     * @param id 查询条件
     * @return 结果
     */
    ${capitalFirstEntityName} select${capitalFirstEntityName}ById(Long id);

    /**
     * 单条数据新增
     * 
     * @param ${entityName} 待入库数据
     * @return 影响行数
     */
    Long insert${capitalFirstEntityName}(${capitalFirstEntityName} ${entityName});

    /**
     * 根据ID对单条数据更新
     * 
     * @param ${entityName} 待入库数据
     * @return 影响行数
     */
    Long update${capitalFirstEntityName}ById(${capitalFirstEntityName} ${entityName});

    /**
     * 根据主键删除
     * 
     * @param id 主键
     */
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
