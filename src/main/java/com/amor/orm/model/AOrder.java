package com.amor.orm.model;

import java.util.Date;

public class AOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER.id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER.product_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER.service_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    private Integer serviceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER.customer_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    private Integer customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER.deal_time
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    private Date dealTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER.deal_price
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    private Long dealPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ORDER.price_off
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    private String priceOff;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER.id
     *
     * @return the value of A_ORDER.id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER.id
     *
     * @param id the value for A_ORDER.id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER.product_id
     *
     * @return the value of A_ORDER.product_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER.product_id
     *
     * @param productId the value for A_ORDER.product_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER.service_id
     *
     * @return the value of A_ORDER.service_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER.service_id
     *
     * @param serviceId the value for A_ORDER.service_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER.customer_id
     *
     * @return the value of A_ORDER.customer_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER.customer_id
     *
     * @param customerId the value for A_ORDER.customer_id
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER.deal_time
     *
     * @return the value of A_ORDER.deal_time
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER.deal_time
     *
     * @param dealTime the value for A_ORDER.deal_time
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER.deal_price
     *
     * @return the value of A_ORDER.deal_price
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public Long getDealPrice() {
        return dealPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER.deal_price
     *
     * @param dealPrice the value for A_ORDER.deal_price
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public void setDealPrice(Long dealPrice) {
        this.dealPrice = dealPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ORDER.price_off
     *
     * @return the value of A_ORDER.price_off
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public String getPriceOff() {
        return priceOff;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ORDER.price_off
     *
     * @param priceOff the value for A_ORDER.price_off
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    public void setPriceOff(String priceOff) {
        this.priceOff = priceOff == null ? null : priceOff.trim();
    }
}