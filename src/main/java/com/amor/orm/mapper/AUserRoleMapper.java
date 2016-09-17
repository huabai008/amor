package com.amor.orm.mapper;

import com.amor.orm.model.AUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER_ROLE
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Delete({
        "delete from A_USER_ROLE",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER_ROLE
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Insert({
        "insert into A_USER_ROLE (id, user_id, ",
        "role_id)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=INTEGER})"
    })
    int insert(AUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER_ROLE
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, user_id, role_id",
        "from A_USER_ROLE",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    AUserRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER_ROLE
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, user_id, role_id",
        "from A_USER_ROLE"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    List<AUserRole> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER_ROLE
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Update({
        "update A_USER_ROLE",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "role_id = #{roleId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AUserRole record);
}