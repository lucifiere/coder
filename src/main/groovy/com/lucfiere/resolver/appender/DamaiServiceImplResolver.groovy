package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.resolver.type.ServiceImplResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst

class DamaiServiceImplResolver extends BaseAppender implements Appender, ServiceImplResolver {

    @Override
    protected String headCode() {
        """
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service层实现
 * 
 * @author ${Cons.AUTHOR}
 * @date ${new Date().format("yyyy-MM-dd")}
 */ 
@Service
public class ${capitalFirst(entityName)}ServiceImpl implements ${capitalFirst(entityName)}Service {

    @Autowired
    private ${capitalFirst(entityName)}DAO ${entityName}DAO;
        """
    }

    @Override
    protected String bodyCode() {
        String capitalFirstEntity = capitalFirst(entityName)
        """
    /**
     * 根据DO参数查询符合条件的结果列表
     * 
     * @param ${entityName} 查询条件
     * @return 结果列表
     */
    @Override
    public List<${capitalFirstEntity}VO> select${capitalFirstEntity}ListByParam(${capitalFirstEntity}Request ${entityName}) {
        ${capitalFirstEntity}DO param = new ${capitalFirstEntity}DO();
        BeanUtils.copyProperties(${entityName}, param);
        List<${capitalFirstEntity}DO> ${capitalFirstEntity}DOList = ${entityName}DAO.select${capitalFirstEntity}ListByParam(param);
        return convertDOListToVOList(${capitalFirstEntity}DOList);
    }
    
    @Override
    public List<${capitalFirstEntity}VO> select${capitalFirstEntity}ByParamAndPage(${capitalFirstEntity}Request ${entityName}) {
        ${capitalFirstEntity}DO param = new ${capitalFirstEntity}DO();
        PageInfo pageInfo = ${entityName}.getPageInfo();
        Pager pageInfo = new Pager(page.getCurPage(), page.getItemsPerPage());
        BeanUtils.copyProperties(${entityName}, param);
        List<${capitalFirstEntity}DO> ${entityName}DOList = ${entityName}DAO.select${capitalFirstEntity}ListByParamAndPage(param, pageInfo);
        Long count = ${entityName}DAO.select${capitalFirstEntity}ListPageCount(param, pageInfo);
        pageInfo.setItems(count);
        return convertDOListToVOList(${entityName}DOList);
    }
    
    /**
     * DOList转化为VOList
     *
     * @param ${entityName}DOList DO List
     * @return VO List
     */
    private List<${capitalFirstEntity}VO> convertDOListToVOList(List<${capitalFirstEntity}DO> ${entityName}DOList) {
        List<${capitalFirstEntity}VO> voList = new ArrayList<>();
        for (${capitalFirstEntity}DO ${entityName}DO : ${capitalFirstEntity}DOList) {
            ${capitalFirstEntity}VO ${entityName}VO = convertDOToVO(${entityName}DO);
            voList.add(${entityName}VO);
        }
        return voList;
    }

    /**
     * DO转化为VO
     *
     * @param ${entityName} DO
     * @return VO
     */
    private ${capitalFirstEntity}VO convertDOToVO(${capitalFirstEntity}DO ${entityName}) {
        ${capitalFirstEntity}VO ${entityName}VO = new ${capitalFirstEntity}VO();
        BeanUtils.copyProperties(${entityName}, ${entityName}VO);
        return ${entityName}VO;
    }
    
    /**
     * Request转化为DO
     *
     * @param request Request
     * @return DO
     */
    private ${capitalFirstEntity}DO convertRequestToDO(${capitalFirstEntity}Request request) {
        ${capitalFirstEntity}DO ${entityName} = new ${capitalFirstEntity}DO();
        BeanUtils.copyProperties(request, ${entityName});
        return ${entityName};
    }

    /**
     * 根据ID查询符合条件的结果
     * 
     * @param id 主键
     * @return 结果
     */
    @Override
    public ${capitalFirstEntity}VO select${capitalFirstEntity}ById(Long id) {
        return ${entityName}DAO.select${capitalFirstEntity}ById(id);
    }

    /**
     * 单条数据新增
     * 
     * @param ${entityName} 待入库数据
     * @return 影响行数
     */
    @Override
    public Long insert${capitalFirstEntity}(${capitalFirstEntity}Request ${entityName}) {
        return ${entityName}DAO.insert${capitalFirstEntity}(${entityName});
    }

    /**
     * 根据ID对单条数据更新
     * 
     * @param ${entityName} 待入库数据
     * @return 影响行数
     */
    @Override
    public Long update${capitalFirstEntity}ById(${capitalFirstEntity}Request ${entityName}) {
        return ${entityName}DAO.update${capitalFirstEntity}ById(${entityName});
    }

    /**
     * 根据主键删除
     * 
     * @param id 主键
     */
    @Override
    public void delete${capitalFirstEntity}ById(Long id) {
        ${entityName}DAO.delete${capitalFirstEntity}ById(id);
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
