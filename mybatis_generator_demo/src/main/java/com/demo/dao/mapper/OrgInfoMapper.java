package com.demo.dao.mapper;

import com.demo.dao.model.OrgInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrgInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_org_info
     *
     * @mbggenerated
     */
    @Delete({
        "delete from b_org_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_org_info
     *
     * @mbggenerated
     */
    @Insert({
        "insert into b_org_info (id, name, ",
        "code, pid, type, ",
        "desc, contacts, ",
        "phone, sort, status, ",
        "create_time, create_by, ",
        "update_time, update_by)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{pid,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{desc,jdbcType=VARCHAR}, #{contacts,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{sort,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=VARCHAR}, #{updateBy,jdbcType=VARCHAR})"
    })
    int insert(OrgInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_org_info
     *
     * @mbggenerated
     */
    int insertSelective(OrgInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_org_info
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, name, code, pid, type, desc, contacts, phone, sort, status, create_time, ",
        "create_by, update_time, update_by",
        "from b_org_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    OrgInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_org_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrgInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_org_info
     *
     * @mbggenerated
     */
    @Update({
        "update b_org_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "desc = #{desc,jdbcType=VARCHAR},",
          "contacts = #{contacts,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=VARCHAR},",
          "update_by = #{updateBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrgInfo record);
}