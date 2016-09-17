package com.amor.orm.model;

import java.util.Date;

public class AService {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.customer_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Integer customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.store_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.staff_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Integer staffId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.status
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.order_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Date orderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.service_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Date serviceTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_SERVICE.comment
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private String comment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.id
     *
     * @return the value of A_SERVICE.id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.id
     *
     * @param id the value for A_SERVICE.id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.customer_id
     *
     * @return the value of A_SERVICE.customer_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.customer_id
     *
     * @param customerId the value for A_SERVICE.customer_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.store_id
     *
     * @return the value of A_SERVICE.store_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.store_id
     *
     * @param storeId the value for A_SERVICE.store_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.staff_id
     *
     * @return the value of A_SERVICE.staff_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.staff_id
     *
     * @param staffId the value for A_SERVICE.staff_id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.status
     *
     * @return the value of A_SERVICE.status
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.status
     *
     * @param status the value for A_SERVICE.status
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.order_time
     *
     * @return the value of A_SERVICE.order_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.order_time
     *
     * @param orderTime the value for A_SERVICE.order_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.service_time
     *
     * @return the value of A_SERVICE.service_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Date getServiceTime() {
        return serviceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.service_time
     *
     * @param serviceTime the value for A_SERVICE.service_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_SERVICE.comment
     *
     * @return the value of A_SERVICE.comment
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_SERVICE.comment
     *
     * @param comment the value for A_SERVICE.comment
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}