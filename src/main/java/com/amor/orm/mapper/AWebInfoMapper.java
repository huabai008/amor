package com.amor.orm.mapper;

import com.amor.orm.model.AWebInfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AWebInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_WEB_INFO
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Delete({
        "delete from A_WEB_INFO",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_WEB_INFO
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Insert({
        "insert into A_WEB_INFO (id, parent_id, ",
        "type, name, path, ",
        "file_name, status)",
        "values (#{id,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{path,jdbcType=VARCHAR}, ",
        "#{fileName,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER})"
    })
    int insert(AWebInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_WEB_INFO
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, parent_id, type, name, path, file_name, status",
        "from A_WEB_INFO",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    AWebInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_WEB_INFO
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Select({
        "select",
        "id, parent_id, type, name, path, file_name, status",
        "from A_WEB_INFO"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<AWebInfo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table A_WEB_INFO
     *
     * @mbggenerated Fri Sep 16 21:54:58 CST 2016
     */
    @Update({
        "update A_WEB_INFO",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "file_name = #{fileName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AWebInfo record);
}