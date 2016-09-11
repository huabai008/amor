package com.amor.web.mapper;

import com.amor.web.model.ASuitMeasurement;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ASuitMeasurementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SUIT_MEASUREMENT
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Delete({
        "delete from A_SUIT_MEASUREMENT",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and measure_date = #{measureDate,jdbcType=TIMESTAMP}"
    })
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("measureDate") Date measureDate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SUIT_MEASUREMENT
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Insert({
        "insert into A_SUIT_MEASUREMENT (user_id, measure_date, ",
        "contract_id, consultant_uid, ",
        "collar, wrist, bust, ",
        "shoulder_width, mid_waist, ",
        "waist_line, sleeve, ",
        "hem, back_length, front_length, ",
        "arm, forearm, front_breast_width, ",
        "back_width, pants_length, ",
        "crotch_depth, leg_width, ",
        "thigh, lower_leg, height, ",
        "weight, body_shape, ",
        "stance, shoulder_shape, ",
        "abdomen_shape, payment, ",
        "invoice)",
        "values (#{userId,jdbcType=INTEGER}, #{measureDate,jdbcType=TIMESTAMP}, ",
        "#{contractId,jdbcType=INTEGER}, #{consultantUid,jdbcType=INTEGER}, ",
        "#{collar,jdbcType=DOUBLE}, #{wrist,jdbcType=DOUBLE}, #{bust,jdbcType=DOUBLE}, ",
        "#{shoulderWidth,jdbcType=DOUBLE}, #{midWaist,jdbcType=DOUBLE}, ",
        "#{waistLine,jdbcType=DOUBLE}, #{sleeve,jdbcType=DOUBLE}, ",
        "#{hem,jdbcType=DOUBLE}, #{backLength,jdbcType=DOUBLE}, #{frontLength,jdbcType=DOUBLE}, ",
        "#{arm,jdbcType=DOUBLE}, #{forearm,jdbcType=DOUBLE}, #{frontBreastWidth,jdbcType=DOUBLE}, ",
        "#{backWidth,jdbcType=DOUBLE}, #{pantsLength,jdbcType=DOUBLE}, ",
        "#{crotchDepth,jdbcType=DOUBLE}, #{legWidth,jdbcType=DOUBLE}, ",
        "#{thigh,jdbcType=DOUBLE}, #{lowerLeg,jdbcType=DOUBLE}, #{height,jdbcType=DOUBLE}, ",
        "#{weight,jdbcType=DOUBLE}, #{bodyShape,jdbcType=INTEGER}, ",
        "#{stance,jdbcType=INTEGER}, #{shoulderShape,jdbcType=INTEGER}, ",
        "#{abdomenShape,jdbcType=INTEGER}, #{payment,jdbcType=INTEGER}, ",
        "#{invoice,jdbcType=VARCHAR})"
    })
    int insert(ASuitMeasurement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SUIT_MEASUREMENT
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Select({
        "select",
        "user_id, measure_date, contract_id, consultant_uid, collar, wrist, bust, shoulder_width, ",
        "mid_waist, waist_line, sleeve, hem, back_length, front_length, arm, forearm, ",
        "front_breast_width, back_width, pants_length, crotch_depth, leg_width, thigh, ",
        "lower_leg, height, weight, body_shape, stance, shoulder_shape, abdomen_shape, ",
        "payment, invoice",
        "from A_SUIT_MEASUREMENT",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and measure_date = #{measureDate,jdbcType=TIMESTAMP}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="measure_date", property="measureDate", jdbcType=JdbcType.TIMESTAMP, id=true),
        @Result(column="contract_id", property="contractId", jdbcType=JdbcType.INTEGER),
        @Result(column="consultant_uid", property="consultantUid", jdbcType=JdbcType.INTEGER),
        @Result(column="collar", property="collar", jdbcType=JdbcType.DOUBLE),
        @Result(column="wrist", property="wrist", jdbcType=JdbcType.DOUBLE),
        @Result(column="bust", property="bust", jdbcType=JdbcType.DOUBLE),
        @Result(column="shoulder_width", property="shoulderWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="mid_waist", property="midWaist", jdbcType=JdbcType.DOUBLE),
        @Result(column="waist_line", property="waistLine", jdbcType=JdbcType.DOUBLE),
        @Result(column="sleeve", property="sleeve", jdbcType=JdbcType.DOUBLE),
        @Result(column="hem", property="hem", jdbcType=JdbcType.DOUBLE),
        @Result(column="back_length", property="backLength", jdbcType=JdbcType.DOUBLE),
        @Result(column="front_length", property="frontLength", jdbcType=JdbcType.DOUBLE),
        @Result(column="arm", property="arm", jdbcType=JdbcType.DOUBLE),
        @Result(column="forearm", property="forearm", jdbcType=JdbcType.DOUBLE),
        @Result(column="front_breast_width", property="frontBreastWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="back_width", property="backWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="pants_length", property="pantsLength", jdbcType=JdbcType.DOUBLE),
        @Result(column="crotch_depth", property="crotchDepth", jdbcType=JdbcType.DOUBLE),
        @Result(column="leg_width", property="legWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="thigh", property="thigh", jdbcType=JdbcType.DOUBLE),
        @Result(column="lower_leg", property="lowerLeg", jdbcType=JdbcType.DOUBLE),
        @Result(column="height", property="height", jdbcType=JdbcType.DOUBLE),
        @Result(column="weight", property="weight", jdbcType=JdbcType.DOUBLE),
        @Result(column="body_shape", property="bodyShape", jdbcType=JdbcType.INTEGER),
        @Result(column="stance", property="stance", jdbcType=JdbcType.INTEGER),
        @Result(column="shoulder_shape", property="shoulderShape", jdbcType=JdbcType.INTEGER),
        @Result(column="abdomen_shape", property="abdomenShape", jdbcType=JdbcType.INTEGER),
        @Result(column="payment", property="payment", jdbcType=JdbcType.INTEGER),
        @Result(column="invoice", property="invoice", jdbcType=JdbcType.VARCHAR)
    })
    ASuitMeasurement selectByPrimaryKey(@Param("userId") Integer userId, @Param("measureDate") Date measureDate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SUIT_MEASUREMENT
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Select({
        "select",
        "user_id, measure_date, contract_id, consultant_uid, collar, wrist, bust, shoulder_width, ",
        "mid_waist, waist_line, sleeve, hem, back_length, front_length, arm, forearm, ",
        "front_breast_width, back_width, pants_length, crotch_depth, leg_width, thigh, ",
        "lower_leg, height, weight, body_shape, stance, shoulder_shape, abdomen_shape, ",
        "payment, invoice",
        "from A_SUIT_MEASUREMENT"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="measure_date", property="measureDate", jdbcType=JdbcType.TIMESTAMP, id=true),
        @Result(column="contract_id", property="contractId", jdbcType=JdbcType.INTEGER),
        @Result(column="consultant_uid", property="consultantUid", jdbcType=JdbcType.INTEGER),
        @Result(column="collar", property="collar", jdbcType=JdbcType.DOUBLE),
        @Result(column="wrist", property="wrist", jdbcType=JdbcType.DOUBLE),
        @Result(column="bust", property="bust", jdbcType=JdbcType.DOUBLE),
        @Result(column="shoulder_width", property="shoulderWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="mid_waist", property="midWaist", jdbcType=JdbcType.DOUBLE),
        @Result(column="waist_line", property="waistLine", jdbcType=JdbcType.DOUBLE),
        @Result(column="sleeve", property="sleeve", jdbcType=JdbcType.DOUBLE),
        @Result(column="hem", property="hem", jdbcType=JdbcType.DOUBLE),
        @Result(column="back_length", property="backLength", jdbcType=JdbcType.DOUBLE),
        @Result(column="front_length", property="frontLength", jdbcType=JdbcType.DOUBLE),
        @Result(column="arm", property="arm", jdbcType=JdbcType.DOUBLE),
        @Result(column="forearm", property="forearm", jdbcType=JdbcType.DOUBLE),
        @Result(column="front_breast_width", property="frontBreastWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="back_width", property="backWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="pants_length", property="pantsLength", jdbcType=JdbcType.DOUBLE),
        @Result(column="crotch_depth", property="crotchDepth", jdbcType=JdbcType.DOUBLE),
        @Result(column="leg_width", property="legWidth", jdbcType=JdbcType.DOUBLE),
        @Result(column="thigh", property="thigh", jdbcType=JdbcType.DOUBLE),
        @Result(column="lower_leg", property="lowerLeg", jdbcType=JdbcType.DOUBLE),
        @Result(column="height", property="height", jdbcType=JdbcType.DOUBLE),
        @Result(column="weight", property="weight", jdbcType=JdbcType.DOUBLE),
        @Result(column="body_shape", property="bodyShape", jdbcType=JdbcType.INTEGER),
        @Result(column="stance", property="stance", jdbcType=JdbcType.INTEGER),
        @Result(column="shoulder_shape", property="shoulderShape", jdbcType=JdbcType.INTEGER),
        @Result(column="abdomen_shape", property="abdomenShape", jdbcType=JdbcType.INTEGER),
        @Result(column="payment", property="payment", jdbcType=JdbcType.INTEGER),
        @Result(column="invoice", property="invoice", jdbcType=JdbcType.VARCHAR)
    })
    List<ASuitMeasurement> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_SUIT_MEASUREMENT
     *
     * @mbggenerated Mon Sep 05 15:00:17 CST 2016
     */
    @Update({
        "update A_SUIT_MEASUREMENT",
        "set contract_id = #{contractId,jdbcType=INTEGER},",
          "consultant_uid = #{consultantUid,jdbcType=INTEGER},",
          "collar = #{collar,jdbcType=DOUBLE},",
          "wrist = #{wrist,jdbcType=DOUBLE},",
          "bust = #{bust,jdbcType=DOUBLE},",
          "shoulder_width = #{shoulderWidth,jdbcType=DOUBLE},",
          "mid_waist = #{midWaist,jdbcType=DOUBLE},",
          "waist_line = #{waistLine,jdbcType=DOUBLE},",
          "sleeve = #{sleeve,jdbcType=DOUBLE},",
          "hem = #{hem,jdbcType=DOUBLE},",
          "back_length = #{backLength,jdbcType=DOUBLE},",
          "front_length = #{frontLength,jdbcType=DOUBLE},",
          "arm = #{arm,jdbcType=DOUBLE},",
          "forearm = #{forearm,jdbcType=DOUBLE},",
          "front_breast_width = #{frontBreastWidth,jdbcType=DOUBLE},",
          "back_width = #{backWidth,jdbcType=DOUBLE},",
          "pants_length = #{pantsLength,jdbcType=DOUBLE},",
          "crotch_depth = #{crotchDepth,jdbcType=DOUBLE},",
          "leg_width = #{legWidth,jdbcType=DOUBLE},",
          "thigh = #{thigh,jdbcType=DOUBLE},",
          "lower_leg = #{lowerLeg,jdbcType=DOUBLE},",
          "height = #{height,jdbcType=DOUBLE},",
          "weight = #{weight,jdbcType=DOUBLE},",
          "body_shape = #{bodyShape,jdbcType=INTEGER},",
          "stance = #{stance,jdbcType=INTEGER},",
          "shoulder_shape = #{shoulderShape,jdbcType=INTEGER},",
          "abdomen_shape = #{abdomenShape,jdbcType=INTEGER},",
          "payment = #{payment,jdbcType=INTEGER},",
          "invoice = #{invoice,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and measure_date = #{measureDate,jdbcType=TIMESTAMP}"
    })
    int updateByPrimaryKey(ASuitMeasurement record);
}