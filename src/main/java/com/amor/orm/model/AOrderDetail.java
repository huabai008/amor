package com.amor.orm.model;

import java.util.Date;

public class AOrderDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER_DETAIL.id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER_DETAIL.deal_id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    private Integer dealId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER_DETAIL.status
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER_DETAIL.mortgage
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    private String mortgage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER_DETAIL.back_time
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    private Date backTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER_DETAIL.staff_id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    private Integer staffId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER_DETAIL.comment
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    private String comment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER_DETAIL.id
     *
     * @return the value of A_ORDER_DETAIL.id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER_DETAIL.id
     *
     * @param id the value for A_ORDER_DETAIL.id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER_DETAIL.deal_id
     *
     * @return the value of A_ORDER_DETAIL.deal_id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public Integer getDealId() {
        return dealId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER_DETAIL.deal_id
     *
     * @param dealId the value for A_ORDER_DETAIL.deal_id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER_DETAIL.status
     *
     * @return the value of A_ORDER_DETAIL.status
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER_DETAIL.status
     *
     * @param status the value for A_ORDER_DETAIL.status
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER_DETAIL.mortgage
     *
     * @return the value of A_ORDER_DETAIL.mortgage
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public String getMortgage() {
        return mortgage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER_DETAIL.mortgage
     *
     * @param mortgage the value for A_ORDER_DETAIL.mortgage
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public void setMortgage(String mortgage) {
        this.mortgage = mortgage == null ? null : mortgage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER_DETAIL.back_time
     *
     * @return the value of A_ORDER_DETAIL.back_time
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public Date getBackTime() {
        return backTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER_DETAIL.back_time
     *
     * @param backTime the value for A_ORDER_DETAIL.back_time
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER_DETAIL.staff_id
     *
     * @return the value of A_ORDER_DETAIL.staff_id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER_DETAIL.staff_id
     *
     * @param staffId the value for A_ORDER_DETAIL.staff_id
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER_DETAIL.comment
     *
     * @return the value of A_ORDER_DETAIL.comment
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER_DETAIL.comment
     *
     * @param comment the value for A_ORDER_DETAIL.comment
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}