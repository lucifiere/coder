package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.ddl.Field
import com.lucfiere.ddl.Table
import com.lucfiere.resolver.BaseResolver
import com.lucfiere.resolver.Resolver
import org.apache.commons.collections4.CollectionUtils

import static com.lucfiere.utils.CommonUtils.capitalFirst
import static com.lucfiere.utils.CommonUtils.toCamel

class StandardPojoResolver extends BaseResolver implements Appender {

    @Override
    Resolver autoAppend() {
        result = ""
        if (CollectionUtils.isNotEmpty(table.fieldList)) {
            result += generateClassHead(table)
            result += generateAttribute(table.fieldList)
            result += generateGetterAndSetter(table.fieldList)
            result += generateClassTail()
        }
        this
    }

    private static String generateClassHead(Table table) {
        """
/**
 * @author ${Cons.AUTHOR}
 */ 
class ${capitalFirst(toCamel(table.name))} {
        """
    }

    private static String generateAttribute(List<Field> fieldList) {
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

    private static String generateGetterAndSetter(List<Field> fieldList) {
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

    private static String generateClassTail() {
        """
}
        """
    }

}
