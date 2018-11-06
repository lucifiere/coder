package com.lucfiere.resolver

import com.lucfiere.ddl.Table
import com.lucfiere.template.Template

class BootstrapContext {

    private String ddlPath

    private String targetPath

    private String ddlContent

    private Table table

    private Map<String, Object> templateData

    private Template template

    private boolean debug

    BootstrapContext(String ddlPath, String targetPath, String ddlContent, Table table, Map<String, Object> templateData, Template template, boolean debug) {
        this.ddlPath = ddlPath
        this.targetPath = targetPath
        this.ddlContent = ddlContent
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

    String getDdlContent() {
        return ddlContent
    }

    void setDdlContent(String ddlContent) {
        this.ddlContent = ddlContent
    }

    boolean getDebug() {
        return debug
    }

    void setDebug(boolean debug) {
        this.debug = debug
    }

    void setTargetPath(String targetPath) {
        this.targetPath = targetPath
    }

    static class Builder {

        private String ddlPath

        private String targetPath

        private String ddlContent

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

        Builder setDdlContent(String ddlContent) {
            this.ddlContent = ddlContent
            this
        }

        Builder debug() {
            this.debug = true
            this
        }

        BootstrapContext create() {
            return new BootstrapContext(ddlPath, targetPath, ddlContent, table, templateData, template, debug)
        }
    }

}
