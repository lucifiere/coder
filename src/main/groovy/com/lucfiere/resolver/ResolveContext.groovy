package com.lucfiere.resolver

import com.lucfiere.ddl.Table
import com.lucfiere.template.Template

class ResolveContext {

    private String ddlPath

    private String targetPath

    private Table table

    private Map<String, Object> templateData

    private Template template

    private boolean debug

    ResolveContext(String ddlPath, String targetPath, Table table, Map<String, Object> templateData, Template template, boolean debug) {
        this.ddlPath = ddlPath
        this.targetPath = targetPath
        this.table = table
        this.templateData = templateData
        this.template = template
        this.debug = debug
    }

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

    static class Builder {

        private String ddlPath

        private String targetPath

        private Table table

        private Map<String, Object> templateData

        private Template template

        private boolean debug

        Builder setDdlPath(String ddlPath) {
            this.ddlPath = ddlPath
            this
        }

        Builder setTargetPath(String targetPath) {
            this.targetPath = targetPath
            this
        }

        Builder setTable(Table table) {
            this.table = table
            this
        }

        Builder setTemplateData(Map<String, Object> templateData) {
            this.templateData = templateData
            this
        }

        Builder setTemplate(Template template) {
            this.template = template
            this
        }

        Builder debug() {
            this.debug = true
            this
        }

        ResolveContext create() {
            return new ResolveContext(ddlPath, targetPath, table, templateData, template, debug)
        }
    }

}
