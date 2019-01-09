package com.lucfiere.file

class SourceCodeBundle {

    private String entityName

    private String daoContent

    private String mapperContent

    private String pojoContent

    private String daoImplContent

    private String criteriaContent

    private String mapperXmlContent

    private String serviceContent

    private String serviceImplContent

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

    String getDaoImplContent() {
        return daoImplContent
    }

    void setDaoImplContent(String daoImplContent) {
        this.daoImplContent = daoImplContent
    }

    String getServiceContent() {
        return serviceContent
    }

    void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent
    }

    String getServiceImplContent() {
        return serviceImplContent
    }

    void setServiceImplContent(String serviceImplContent) {
        this.serviceImplContent = serviceImplContent
    }
}
