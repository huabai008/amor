package com.amor.orm.model;

import java.util.Date;

import com.amor.core.base.BaseModel;

public class APermission extends BaseModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_PERMISSION.id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_PERMISSION.role_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_PERMISSION.permission_code
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private String permissionCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_PERMISSION.operation_code
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private String operationCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_PERMISSION.permission_name
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private String permissionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_PERMISSION.create_time
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_PERMISSION.update_time
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_PERMISSION.id
     *
     * @return the value of A_PERMISSION.id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_PERMISSION.id
     *
     * @param id the value for A_PERMISSION.id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_PERMISSION.role_id
     *
     * @return the value of A_PERMISSION.role_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_PERMISSION.role_id
     *
     * @param roleId the value for A_PERMISSION.role_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_PERMISSION.permission_code
     *
     * @return the value of A_PERMISSION.permission_code
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_PERMISSION.permission_code
     *
     * @param permissionCode the value for A_PERMISSION.permission_code
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_PERMISSION.operation_code
     *
     * @return the value of A_PERMISSION.operation_code
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public String getOperationCode() {
        return operationCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_PERMISSION.operation_code
     *
     * @param operationCode the value for A_PERMISSION.operation_code
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_PERMISSION.permission_name
     *
     * @return the value of A_PERMISSION.permission_name
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_PERMISSION.permission_name
     *
     * @param permissionName the value for A_PERMISSION.permission_name
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_PERMISSION.create_time
     *
     * @return the value of A_PERMISSION.create_time
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_PERMISSION.create_time
     *
     * @param createTime the value for A_PERMISSION.create_time
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_PERMISSION.update_time
     *
     * @return the value of A_PERMISSION.update_time
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_PERMISSION.update_time
     *
     * @param updateTime the value for A_PERMISSION.update_time
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}