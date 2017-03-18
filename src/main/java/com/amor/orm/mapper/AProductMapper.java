package com.amor.orm.mapper;

import com.amor.core.base.BaseMapper;
import com.amor.orm.model.AProduct;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AProductMapper extends BaseMapper<AProduct, Integer>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT
     *
     * @mbggenerated Sun Nov 06 15:37:00 CST 2016
     */
    @Delete({
        "delete from A_PRODUCT",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT
     *
     * @mbggenerated Sun Nov 06 15:37:00 CST 2016
     */
    @Insert({
        "insert into A_PRODUCT (id, item_code, ",
        "item_type, trends, ",
        "silhouette, neckline, ",
        "collar_stays, placket, ",
        "bust, waistline, ",
        "shoulder, back, ",
        "hips, sleeve, white_collar_sleeve, ",
        "cuff_words, cuff_words_type, ",
        "pocket, pants, version, ",
        "color, size, material, ",
        "others, price_cost, ",
        "price_agent, price_rent, ",
        "price_sell, price_alliance, ",
        "create_time, update_time, ",
        "create_uid, update_uid)",
        "values (#{id,jdbcType=INTEGER}, #{itemCode,jdbcType=VARCHAR}, ",
        "#{itemType,jdbcType=INTEGER}, #{trends,jdbcType=VARCHAR}, ",
        "#{silhouette,jdbcType=INTEGER}, #{neckline,jdbcType=INTEGER}, ",
        "#{collarStays,jdbcType=INTEGER}, #{placket,jdbcType=INTEGER}, ",
        "#{bust,jdbcType=INTEGER}, #{waistline,jdbcType=INTEGER}, ",
        "#{shoulder,jdbcType=INTEGER}, #{back,jdbcType=INTEGER}, ",
        "#{hips,jdbcType=INTEGER}, #{sleeve,jdbcType=INTEGER}, #{whiteCollarSleeve,jdbcType=INTEGER}, ",
        "#{cuffWords,jdbcType=INTEGER}, #{cuffWordsType,jdbcType=INTEGER}, ",
        "#{pocket,jdbcType=INTEGER}, #{pants,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{color,jdbcType=INTEGER}, #{size,jdbcType=INTEGER}, #{material,jdbcType=VARCHAR}, ",
        "#{others,jdbcType=VARCHAR}, #{priceCost,jdbcType=DOUBLE}, ",
        "#{priceAgent,jdbcType=DOUBLE}, #{priceRent,jdbcType=DOUBLE}, ",
        "#{priceSell,jdbcType=DOUBLE}, #{priceAlliance,jdbcType=DOUBLE}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createUid,jdbcType=INTEGER}, #{updateUid,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insert(AProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT
     *
     * @mbggenerated Sun Nov 06 15:37:00 CST 2016
     */
    @Select({
        "select",
        "id, item_code, item_type, trends, silhouette, neckline, collar_stays, placket, ",
        "bust, waistline, shoulder, back, hips, sleeve, white_collar_sleeve, cuff_words, ",
        "cuff_words_type, pocket, pants, version, color, size, material, others, price_cost, ",
        "price_agent, price_rent, price_sell, price_alliance, create_time, update_time, ",
        "create_uid, update_uid",
        "from A_PRODUCT",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item_code", property="itemCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="trends", property="trends", jdbcType=JdbcType.VARCHAR),
        @Result(column="silhouette", property="silhouette", jdbcType=JdbcType.INTEGER),
        @Result(column="neckline", property="neckline", jdbcType=JdbcType.INTEGER),
        @Result(column="collar_stays", property="collarStays", jdbcType=JdbcType.INTEGER),
        @Result(column="placket", property="placket", jdbcType=JdbcType.INTEGER),
        @Result(column="bust", property="bust", jdbcType=JdbcType.INTEGER),
        @Result(column="waistline", property="waistline", jdbcType=JdbcType.INTEGER),
        @Result(column="shoulder", property="shoulder", jdbcType=JdbcType.INTEGER),
        @Result(column="back", property="back", jdbcType=JdbcType.INTEGER),
        @Result(column="hips", property="hips", jdbcType=JdbcType.INTEGER),
        @Result(column="sleeve", property="sleeve", jdbcType=JdbcType.INTEGER),
        @Result(column="white_collar_sleeve", property="whiteCollarSleeve", jdbcType=JdbcType.INTEGER),
        @Result(column="cuff_words", property="cuffWords", jdbcType=JdbcType.INTEGER),
        @Result(column="cuff_words_type", property="cuffWordsType", jdbcType=JdbcType.INTEGER),
        @Result(column="pocket", property="pocket", jdbcType=JdbcType.INTEGER),
        @Result(column="pants", property="pants", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="color", property="color", jdbcType=JdbcType.INTEGER),
        @Result(column="size", property="size", jdbcType=JdbcType.INTEGER),
        @Result(column="material", property="material", jdbcType=JdbcType.VARCHAR),
        @Result(column="others", property="others", jdbcType=JdbcType.VARCHAR),
        @Result(column="price_cost", property="priceCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_agent", property="priceAgent", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_rent", property="priceRent", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_sell", property="priceSell", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_alliance", property="priceAlliance", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER)
    })
    AProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT
     *
     * @mbggenerated Sun Nov 06 15:37:00 CST 2016
     */
    @Select({
        "select",
        "id, item_code, item_type, trends, silhouette, neckline, collar_stays, placket, ",
        "bust, waistline, shoulder, back, hips, sleeve, white_collar_sleeve, cuff_words, ",
        "cuff_words_type, pocket, pants, version, color, size, material, others, price_cost, ",
        "price_agent, price_rent, price_sell, price_alliance, create_time, update_time, ",
        "create_uid, update_uid",
        "from A_PRODUCT"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="item_code", property="itemCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="trends", property="trends", jdbcType=JdbcType.VARCHAR),
        @Result(column="silhouette", property="silhouette", jdbcType=JdbcType.INTEGER),
        @Result(column="neckline", property="neckline", jdbcType=JdbcType.INTEGER),
        @Result(column="collar_stays", property="collarStays", jdbcType=JdbcType.INTEGER),
        @Result(column="placket", property="placket", jdbcType=JdbcType.INTEGER),
        @Result(column="bust", property="bust", jdbcType=JdbcType.INTEGER),
        @Result(column="waistline", property="waistline", jdbcType=JdbcType.INTEGER),
        @Result(column="shoulder", property="shoulder", jdbcType=JdbcType.INTEGER),
        @Result(column="back", property="back", jdbcType=JdbcType.INTEGER),
        @Result(column="hips", property="hips", jdbcType=JdbcType.INTEGER),
        @Result(column="sleeve", property="sleeve", jdbcType=JdbcType.INTEGER),
        @Result(column="white_collar_sleeve", property="whiteCollarSleeve", jdbcType=JdbcType.INTEGER),
        @Result(column="cuff_words", property="cuffWords", jdbcType=JdbcType.INTEGER),
        @Result(column="cuff_words_type", property="cuffWordsType", jdbcType=JdbcType.INTEGER),
        @Result(column="pocket", property="pocket", jdbcType=JdbcType.INTEGER),
        @Result(column="pants", property="pants", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="color", property="color", jdbcType=JdbcType.INTEGER),
        @Result(column="size", property="size", jdbcType=JdbcType.INTEGER),
        @Result(column="material", property="material", jdbcType=JdbcType.VARCHAR),
        @Result(column="others", property="others", jdbcType=JdbcType.VARCHAR),
        @Result(column="price_cost", property="priceCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_agent", property="priceAgent", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_rent", property="priceRent", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_sell", property="priceSell", jdbcType=JdbcType.DOUBLE),
        @Result(column="price_alliance", property="priceAlliance", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER)
    })
    List<AProduct> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT
     *
     * @mbggenerated Sun Nov 06 15:37:00 CST 2016
     */
    @Update({
        "update A_PRODUCT",
        "set item_code = #{itemCode,jdbcType=VARCHAR},",
          "item_type = #{itemType,jdbcType=INTEGER},",
          "trends = #{trends,jdbcType=VARCHAR},",
          "silhouette = #{silhouette,jdbcType=INTEGER},",
          "neckline = #{neckline,jdbcType=INTEGER},",
          "collar_stays = #{collarStays,jdbcType=INTEGER},",
          "placket = #{placket,jdbcType=INTEGER},",
          "bust = #{bust,jdbcType=INTEGER},",
          "waistline = #{waistline,jdbcType=INTEGER},",
          "shoulder = #{shoulder,jdbcType=INTEGER},",
          "back = #{back,jdbcType=INTEGER},",
          "hips = #{hips,jdbcType=INTEGER},",
          "sleeve = #{sleeve,jdbcType=INTEGER},",
          "white_collar_sleeve = #{whiteCollarSleeve,jdbcType=INTEGER},",
          "cuff_words = #{cuffWords,jdbcType=INTEGER},",
          "cuff_words_type = #{cuffWordsType,jdbcType=INTEGER},",
          "pocket = #{pocket,jdbcType=INTEGER},",
          "pants = #{pants,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "color = #{color,jdbcType=INTEGER},",
          "size = #{size,jdbcType=INTEGER},",
          "material = #{material,jdbcType=VARCHAR},",
          "others = #{others,jdbcType=VARCHAR},",
          "price_cost = #{priceCost,jdbcType=DOUBLE},",
          "price_agent = #{priceAgent,jdbcType=DOUBLE},",
          "price_rent = #{priceRent,jdbcType=DOUBLE},",
          "price_sell = #{priceSell,jdbcType=DOUBLE},",
          "price_alliance = #{priceAlliance,jdbcType=DOUBLE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "update_uid = #{updateUid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AProduct record);
}