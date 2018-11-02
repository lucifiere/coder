package com.lucfiere.demo

/**
 * @author XD.Wang
 */
class CouponCouponBatch {

    /**
     * 批次编码
     */
    private Long id;

    /**
     * 券模板编码
     */
    private Long templateCode;

    /**
     * 券类型(1,代金券，2.兑换券，3.折扣券)
     */
    private Integer templateType;

    /**
     * 商品类型(1.卖品。2.电影票)
     */
    private Integer productType;

    /**
     * 已核销数量
     */
    private Integer checkCount;

    /**
     * 已发送数量
     */
    private Long sendCount;

    /**
     * 券批次面值
     */
    private Long price;

    /**
     * 数量
     */
    private Integer batchCount;

    /**
     * 流向类型(1,系统设定，2.手动发券)
     */
    private Integer directType;

    /**
     * 流向
     */
    private String directTo;

    /**
     *
     */
    private Integer state;

    /**
     * 券批次审核状态(1.未提交，2.待审核，3.审核通过，4.驳回)
     */
    private Integer auditState;

    /**
     * 有效开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 修改时间
     */
    private Date gmtModify;

    /**
     * 审核人
     */
    private String auditUser;

    /**
     * 审核时间
     */
    private Date gmtAudit;

    /**
     * 扩展字段
     */
    private String extension;

    /**
     * 驳回原因
     */
    private String reason;

    /**
     * 租户信息
     */
    private String leaseCode;

    /**
     * 批次结算价
     */
    private Integer basePrice;

    /**
     * 批次发行方
     */
    private String issuer;

    /**
     * 备注
     */
    private String remark;

    /**
     * 外部券开始号
     */
    private String startSerialno;

    /**
     * 外部券结束号
     */
    private String endSerialno;

    /**
     *
     */
    private String voucherNoType;

    /**
     * 激活时间\n
     */
    private Date activeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(Long templateCode) {
        this.templateCode = templateCode;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }

    public Long getSendCount() {
        return sendCount;
    }

    public void setSendCount(Long sendCount) {
        this.sendCount = sendCount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(Integer batchCount) {
        this.batchCount = batchCount;
    }

    public Integer getDirectType() {
        return directType;
    }

    public void setDirectType(Integer directType) {
        this.directType = directType;
    }

    public String getDirectTo() {
        return directTo;
    }

    public void setDirectTo(String directTo) {
        this.directTo = directTo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public Date getGmtAudit() {
        return gmtAudit;
    }

    public void setGmtAudit(Date gmtAudit) {
        this.gmtAudit = gmtAudit;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLeaseCode() {
        return leaseCode;
    }

    public void setLeaseCode(String leaseCode) {
        this.leaseCode = leaseCode;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStartSerialno() {
        return startSerialno;
    }

    public void setStartSerialno(String startSerialno) {
        this.startSerialno = startSerialno;
    }

    public String getEndSerialno() {
        return endSerialno;
    }

    public void setEndSerialno(String endSerialno) {
        this.endSerialno = endSerialno;
    }

    public String getVoucherNoType() {
        return voucherNoType;
    }

    public void setVoucherNoType(String voucherNoType) {
        this.voucherNoType = voucherNoType;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

}
