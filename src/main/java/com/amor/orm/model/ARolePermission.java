package com.amor.orm.model;

public class ARolePermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE_PERMISSION.id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE_PERMISSION.role_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column A_ROLE_PERMISSION.permission_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    private Integer permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE_PERMISSION.id
     *
     * @return the value of A_ROLE_PERMISSION.id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE_PERMISSION.id
     *
     * @param id the value for A_ROLE_PERMISSION.id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE_PERMISSION.role_id
     *
     * @return the value of A_ROLE_PERMISSION.role_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE_PERMISSION.role_id
     *
     * @param roleId the value for A_ROLE_PERMISSION.role_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column A_ROLE_PERMISSION.permission_id
     *
     * @return the value of A_ROLE_PERMISSION.permission_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column A_ROLE_PERMISSION.permission_id
     *
     * @param permissionId the value for A_ROLE_PERMISSION.permission_id
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}