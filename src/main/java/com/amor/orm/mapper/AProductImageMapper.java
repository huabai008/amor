package com.amor.orm.mapper;

import com.amor.orm.model.AProductImage;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AProductImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT_IMAGE
     *
     * @mbggenerated Sun Oct 23 14:40:44 CST 2016
     */
    @Delete({
        "delete from A_PRODUCT_IMAGE",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    @Delete({
    	"delete from A_PRODUCT_IMAGE",
        "where product_id = #{product_id,jdbcType=INTEGER}"
    })
    int deleteByProductId(Integer productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT_IMAGE
     *
     * @mbggenerated Sun Oct 23 14:40:44 CST 2016
     */
    @Insert({
        "insert into A_PRODUCT_IMAGE (id, product_id, ",
        "img_path, create_datetime)",
        "values (#{id,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{imgPath,jdbcType=VARCHAR}, #{createDatetime,jdbcType=TIMESTAMP})"
    })
    int insert(AProductImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT_IMAGE
     *
     * @mbggenerated Sun Oct 23 14:40:44 CST 2016
     */
    @Select({
        "select",
        "id, product_id, img_path, create_datetime",
        "from A_PRODUCT_IMAGE",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="img_path", property="imgPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_datetime", property="createDatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    AProductImage selectByPrimaryKey(Integer id);
    
    /**
     * This method was created by sicong.yang for select all the images of a specific product
     * This method corresponds to the database table A_PRODUCT_IMAGE
     *
     * @mbggenerated Sun Oct 23 14:40:44 CST 2016
     */
    @Select({
        "select",
        "id, product_id, img_path, create_datetime",
        "from A_PRODUCT_IMAGE",
        "where product_id = #{productId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="img_path", property="imgPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_datetime", property="createDatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AProductImage> selectByProductId(Integer product_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT_IMAGE
     *
     * @mbggenerated Sun Oct 23 14:40:44 CST 2016
     */
    @Select({
        "select",
        "id, product_id, img_path, create_datetime",
        "from A_PRODUCT_IMAGE"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="img_path", property="imgPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_datetime", property="createDatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AProductImage> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_PRODUCT_IMAGE
     *
     * @mbggenerated Sun Oct 23 14:40:44 CST 2016
     */
    @Update({
        "update A_PRODUCT_IMAGE",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "img_path = #{imgPath,jdbcType=VARCHAR},",
          "create_datetime = #{createDatetime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AProductImage record);
}