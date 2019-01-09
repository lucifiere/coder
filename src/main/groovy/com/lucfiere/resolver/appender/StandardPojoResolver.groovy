package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.ddl.Field
import com.lucfiere.resolver.type.PojoResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst

class StandardPojoResolver extends BaseAppender implements Appender, PojoResolver {

    @Override
    protected String headCode() {
        """
import java.util.Date;

/**
 * DO POJO
 * 
 * @author ${Cons.AUTHOR}
 * @date ${new Date().format("yyyy-MM-dd")}
 */ 
public class ${capitalFirst(entityName)} {
        """
    }

    @Override
    protected String bodyCode() {
        attrCode(table.getFieldList()) + getterAndSetterCode(table.getFieldList())
    }

    private attrCode = { List<Field> fieldList ->
        String result = ""
        fieldList.each {
            result += """
    /**
     * ${it.comment}
     */ 
    private ${it.fieldType.javaType.simpleName} ${it.javaName};
            """
        }
        result
    }

    private getterAndSetterCode = { List<Field> fieldList ->
        String result = ""
        fieldList.each {
            result += """
    public ${it.fieldType.javaType.simpleName} get${capitalFirst(it.javaName)}() {
        return ${it.javaName};
    }
    
    public void set${capitalFirst(it.javaName)}(${it.fieldType.javaType.simpleName} ${it.javaName}) {
        this.${it.javaName} = ${it.javaName};
    }
            """
        }
        result
    }

    @Override
    protected String tailCode() {
        """
}
        """
    }

}
