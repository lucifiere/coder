package com.lucfiere.resolver

import com.lucfiere.ddl.Table
import com.lucfiere.template.Template

class ResolveContext {

    private String ddlPath

    private String targetPath

    private Table table

    private Map<String, Object> templateData

    private Template template

    Table getTable() {
        return table
    }

    void setTable(Table table) {
        this.table = table
    }

    Map<String, Object> getTemplateData() {
        return templateData
    }

    void setTemplateData(Map<String, Object> templateData) {
        this.templateData = templateData
    }

    Template getTemplate() {
        return template
    }

    void setTemplate(Template template) {
        this.template = template
    }

    String getDdlPath() {
        return ddlPath
    }

    void setDdlPath(String ddlPath) {
        this.ddlPath = ddlPath
    }

    String getTargetPath() {
        return targetPath
    }

    void setTargetPath(String targetPath) {
        this.targetPath = targetPath
    }
}
