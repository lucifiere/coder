package com.lucfiere.file

class SourceCodeBundle {

    private String entityName

    private String daoContent

    private String mapperContent

    private String pojoContent

    private String criteriaContent

    private String mapperXmlContent

    String getEntityName() {
        return entityName
    }

    void setEntityName(String entityName) {
        this.entityName = entityName
    }

    String getDaoContent() {
        return daoContent
    }

    void setDaoContent(String daoContent) {
        this.daoContent = daoContent
    }

    String getMapperContent() {
        return mapperContent
    }

    void setMapperContent(String mapperContent) {
        this.mapperContent = mapperContent
    }

    String getPojoContent() {
        return pojoContent
    }

    void setPojoContent(String pojoContent) {
        this.pojoContent = pojoContent
    }

    String getCriteriaContent() {
        return criteriaContent
    }

    void setCriteriaContent(String criteriaContent) {
        this.criteriaContent = criteriaContent
    }

    String getMapperXmlContent() {
        return mapperXmlContent
    }

    void setMapperXmlContent(String mapperXmlContent) {
        this.mapperXmlContent = mapperXmlContent
    }
}
