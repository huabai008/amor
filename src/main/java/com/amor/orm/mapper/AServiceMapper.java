package com.amor.orm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.amor.orm.model.AService;

public interface AServiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SERVICE
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Delete({
        "delete from A_SERVICE",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SERVICE
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Insert({
        "insert into A_SERVICE (id, customer_id, ",
        "store_id, staff_id, ",
        "status, order_time, ",
        "service_time, comment)",
        "values (#{id,jdbcType=INTEGER}, #{customerId,jdbcType=INTEGER}, ",
        "#{storeId,jdbcType=INTEGER}, #{staffId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=VARCHAR}, #{orderTime,jdbcType=TIMESTAMP}, ",
        "#{serviceTime,jdbcType=TIMESTAMP}, #{comment,jdbcType=VARCHAR})"
    })
    int insert(AService record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SERVICE
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Select({
        "select",
        "id, customer_id, store_id, staff_id, status, order_time, service_time, comment",
        "from A_SERVICE",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_time", property="serviceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR)
    })
    AService selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SERVICE
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Select({
        "select",
        "id, customer_id, store_id, staff_id, status, order_time, service_time, comment",
        "from A_SERVICE"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="service_time", property="serviceTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment", property="comment", jdbcType=JdbcType.VARCHAR)
    })
    List<AService> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SERVICE
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Update({
        "update A_SERVICE",
        "set customer_id = #{customerId,jdbcType=INTEGER},",
          "store_id = #{storeId,jdbcType=INTEGER},",
          "staff_id = #{staffId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=VARCHAR},",
          "order_time = #{orderTime,jdbcType=TIMESTAMP},",
          "service_time = #{serviceTime,jdbcType=TIMESTAMP},",
          "comment = #{comment,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AService record);
}