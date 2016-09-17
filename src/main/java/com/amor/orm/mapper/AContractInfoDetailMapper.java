package com.amor.orm.mapper;

import com.amor.orm.model.AContractInfoDetail;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AContractInfoDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_CONTRACT_INFO_DETAIL
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    @Delete({
        "delete from A_CONTRACT_INFO_DETAIL",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_CONTRACT_INFO_DETAIL
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    @Insert({
        "insert into A_CONTRACT_INFO_DETAIL (id, contract_id, ",
        "item_type, item_code, ",
        "number, price)",
        "values (#{id,jdbcType=INTEGER}, #{contractId,jdbcType=INTEGER}, ",
        "#{itemType,jdbcType=INTEGER}, #{itemCode,jdbcType=VARCHAR}, ",
        "#{number,jdbcType=INTEGER}, #{price,jdbcType=DOUBLE})"
    })
    int insert(AContractInfoDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_CONTRACT_INFO_DETAIL
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    @Select({
        "select",
        "id, contract_id, item_type, item_code, number, price",
        "from A_CONTRACT_INFO_DETAIL",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="contract_id", property="contractId", jdbcType=JdbcType.INTEGER),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="item_code", property="itemCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE)
    })
    AContractInfoDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_CONTRACT_INFO_DETAIL
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    @Select({
        "select",
        "id, contract_id, item_type, item_code, number, price",
        "from A_CONTRACT_INFO_DETAIL"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="contract_id", property="contractId", jdbcType=JdbcType.INTEGER),
        @Result(column="item_type", property="itemType", jdbcType=JdbcType.INTEGER),
        @Result(column="item_code", property="itemCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE)
    })
    List<AContractInfoDetail> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_CONTRACT_INFO_DETAIL
     *
     * @mbggenerated Fri Sep 16 21:54:57 CST 2016
     */
    @Update({
        "update A_CONTRACT_INFO_DETAIL",
        "set contract_id = #{contractId,jdbcType=INTEGER},",
          "item_type = #{itemType,jdbcType=INTEGER},",
          "item_code = #{itemCode,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AContractInfoDetail record);
}