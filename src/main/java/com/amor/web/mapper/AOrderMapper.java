package com.amor.web.mapper;

import com.amor.web.model.AOrder;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ORDER
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Delete({
        "delete from A_ORDER",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ORDER
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Insert({
        "insert into A_ORDER (id, product_id, ",
        "service_id, customer_id, ",
        "deal_time, deal_price, ",
        "price_off)",
        "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{serviceId,jdbcType=INTEGER}, #{customerId,jdbcType=INTEGER}, ",
        "#{dealTime,jdbcType=TIMESTAMP}, #{dealPrice,jdbcType=DECIMAL}, ",
        "#{priceOff,jdbcType=VARCHAR})"
    })
    int insert(AOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ORDER
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Select({
        "select",
        "id, product_id, service_id, customer_id, deal_time, deal_price, price_off",
        "from A_ORDER",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="deal_time", property="dealTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deal_price", property="dealPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price_off", property="priceOff", jdbcType=JdbcType.VARCHAR)
    })
    AOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ORDER
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Select({
        "select",
        "id, product_id, service_id, customer_id, deal_time, deal_price, price_off",
        "from A_ORDER"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="deal_time", property="dealTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deal_price", property="dealPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="price_off", property="priceOff", jdbcType=JdbcType.VARCHAR)
    })
    List<AOrder> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_ORDER
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Update({
        "update A_ORDER",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "service_id = #{serviceId,jdbcType=INTEGER},",
          "customer_id = #{customerId,jdbcType=INTEGER},",
          "deal_time = #{dealTime,jdbcType=TIMESTAMP},",
          "deal_price = #{dealPrice,jdbcType=DECIMAL},",
          "price_off = #{priceOff,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AOrder record);
}