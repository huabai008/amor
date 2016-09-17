package com.amor.orm.model;

import java.util.Date;

public class ARole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE.id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE.role_name
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE.role_type
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Integer roleType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE.description
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE.status
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE.create_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE.update_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE.id
     *
     * @return the value of A_ROLE.id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE.id
     *
     * @param id the value for A_ROLE.id
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE.role_name
     *
     * @return the value of A_ROLE.role_name
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE.role_name
     *
     * @param roleName the value for A_ROLE.role_name
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE.role_type
     *
     * @return the value of A_ROLE.role_type
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE.role_type
     *
     * @param roleType the value for A_ROLE.role_type
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE.description
     *
     * @return the value of A_ROLE.description
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE.description
     *
     * @param description the value for A_ROLE.description
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE.status
     *
     * @return the value of A_ROLE.status
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE.status
     *
     * @param status the value for A_ROLE.status
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE.create_time
     *
     * @return the value of A_ROLE.create_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE.create_time
     *
     * @param createTime the value for A_ROLE.create_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE.update_time
     *
     * @return the value of A_ROLE.update_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE.update_time
     *
     * @param updateTime the value for A_ROLE.update_time
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}