package com.amor.orm.mapper;

import com.amor.orm.model.ARoleWebPermission;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ARoleWebPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_WEB_PERMISSION
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Delete({
        "delete from A_ROLE_WEB_PERMISSION",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_WEB_PERMISSION
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Insert({
        "insert into A_ROLE_WEB_PERMISSION (id, role_id, ",
        "privilige_id, web_info_id)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{priviligeId,jdbcType=INTEGER}, #{webInfoId,jdbcType=INTEGER})"
    })
    int insert(ARoleWebPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_WEB_PERMISSION
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, role_id, privilige_id, web_info_id",
        "from A_ROLE_WEB_PERMISSION",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="privilige_id", property="priviligeId", jdbcType=JdbcType.INTEGER),
        @Result(column="web_info_id", property="webInfoId", jdbcType=JdbcType.INTEGER)
    })
    ARoleWebPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_WEB_PERMISSION
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, role_id, privilige_id, web_info_id",
        "from A_ROLE_WEB_PERMISSION"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="privilige_id", property="priviligeId", jdbcType=JdbcType.INTEGER),
        @Result(column="web_info_id", property="webInfoId", jdbcType=JdbcType.INTEGER)
    })
    List<ARoleWebPermission> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ROLE_WEB_PERMISSION
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Update({
        "update A_ROLE_WEB_PERMISSION",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "privilige_id = #{priviligeId,jdbcType=INTEGER},",
          "web_info_id = #{webInfoId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ARoleWebPermission record);
}