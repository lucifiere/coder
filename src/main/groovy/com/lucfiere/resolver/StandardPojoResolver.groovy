package com.lucfiere.resolver

import com.lucfiere.common.Cons
import com.lucfiere.ddl.Field
import com.lucfiere.ddl.Table
import org.apache.commons.collections4.CollectionUtils

import static com.lucfiere.utils.CommonUtils.capitalFirst
import static com.lucfiere.utils.CommonUtils.toCamel

class StandardPojoResolver extends BasePojoResolver implements Appender {

    StandardPojoResolver(Table table) {
        super(table)
    }

    @Override
    Resolver autoAppend() {
        result = ""
        if (CollectionUtils.isNotEmpty(table.fieldList)) {
            result += generateClassHead(table)
            table.fieldList.each {
                result += generateAttribute(it)
            }
            table.fieldList.each {
                result += generateGetterAndSetter(it)
            }
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

    private static String generateAttribute(Field field) {
        """
    /**
     * ${field.comment}
     */ 
    private ${field.fieldType.javaType.simpleName} ${field.javaName};
        """
    }

    private static String generateGetterAndSetter(Field field) {
        """
    public ${field.fieldType.javaType.simpleName} get${capitalFirst(field.javaName)}() {
        return ${field.javaName};
    }
    
    public void set${capitalFirst(field.javaName)}(${field.fieldType.javaType.simpleName} ${field.javaName}) {
        this.${field.javaName} = ${field.javaName};
    }
        """
    }

    private static String generateClassTail() {
        """
}
        """
    }

}
