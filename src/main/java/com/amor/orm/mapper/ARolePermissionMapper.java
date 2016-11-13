package com.amor.orm.mapper;

import com.amor.orm.model.ARolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ARolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_PERMISSION
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    @Delete({
        "delete from A_ROLE_PERMISSION",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_PERMISSION
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    @Insert({
        "replace into A_ROLE_PERMISSION (id, role_id, ",
        "permission_id)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{permissionId,jdbcType=INTEGER})"
    })
    int insert(ARolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_PERMISSION
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    @Select({
        "select",
        "id, role_id, permission_id",
        "from A_ROLE_PERMISSION",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER)
    })
    ARolePermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_PERMISSION
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    @Select({
        "select",
        "id, role_id, permission_id",
        "from A_ROLE_PERMISSION"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER)
    })
    List<ARolePermission> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_PERMISSION
     *
     * @mbggenerated Sun Oct 16 16:13:26 CST 2016
     */
    @Update({
        "update A_ROLE_PERMISSION",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "permission_id = #{permissionId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ARolePermission record);
    
    @Select({
        "select",
        "id, role_id, permission_id",
        "from A_ROLE_PERMISSION",
        "where role_id = #{role_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER)
    })
    List<ARolePermission> selectByRoleId(Integer role_id);
}