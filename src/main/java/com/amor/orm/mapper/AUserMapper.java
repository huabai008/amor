package com.amor.orm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.amor.core.base.BaseMapper;
import com.amor.orm.model.AUser;

public interface AUserMapper extends BaseMapper<AUser, Integer>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Delete({
        "delete from A_USER",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Insert({
        "insert into A_USER (id, name, ",
        "gender, identity_code, ",
        "tel, email, store_id, ",
        "username, password, ",
        "status, login_code, ",
        "register_from)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=VARCHAR}, #{identityCode,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{storeId,jdbcType=INTEGER}, ",
        "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{loginCode,jdbcType=VARCHAR}, ",
        "#{registerFrom,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insert(AUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, name, gender, identity_code, tel, email, store_id, username, password, status, ",
        "login_code, register_from",
        "from A_USER",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity_code", property="identityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="login_code", property="loginCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="register_from", property="registerFrom", jdbcType=JdbcType.VARCHAR)
    })
    AUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, name, gender, identity_code, tel, email, store_id, username, password, status, ",
        "login_code, register_from",
        "from A_USER"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity_code", property="identityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="login_code", property="loginCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="register_from", property="registerFrom", jdbcType=JdbcType.VARCHAR)
    })
    List<AUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Update({
        "update A_USER",
        "set name = #{name,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=VARCHAR},",
          "identity_code = #{identityCode,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "store_id = #{storeId,jdbcType=INTEGER},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "login_code = #{loginCode,jdbcType=VARCHAR},",
          "register_from = #{registerFrom,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AUser record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_USER
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, name, gender, identity_code, tel, email, store_id, username, password, status, ",
        "login_code, register_from",
        "from A_USER",
        "where username = #{username,jdbcType=VARCHAR} and password = #{password,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity_code", property="identityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="login_code", property="loginCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="register_from", property="registerFrom", jdbcType=JdbcType.VARCHAR)
    })
    AUser authentication(AUser user);
    
    @Select({
        "select",
        "id, name, gender, identity_code, tel, email, store_id, username, password, status, ",
        "login_code, register_from",
        "from A_USER",
        "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity_code", property="identityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="login_code", property="loginCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="register_from", property="registerFrom", jdbcType=JdbcType.VARCHAR)
    })
    AUser selectByName(String username);
}