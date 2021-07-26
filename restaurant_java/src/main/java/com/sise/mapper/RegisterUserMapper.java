package com.sise.mapper;

import com.sise.entity.Employee;
import com.sise.entity.RegisterUser;
import com.sise.entity.RegisterUserExample;
import com.sise.mapper.providers.RegisterUserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegisterUserMapper {

    @Select("select * from register_user ORDER BY id desc")
    @Results(id = "registerUser", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "status_", column = "status_")
    })
    public List<RegisterUser> findAll();

    @Select("select * from register_user where username like #{username}")
    List<RegisterUser> findUserNameLike(String username);

    @SelectProvider(type=RegisterUserSqlProvider.class, method="countByExample")
    int countByExample(RegisterUserExample example);

    @DeleteProvider(type=RegisterUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(RegisterUserExample example);

    @Delete({
        "delete from register_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into register_user (username, avatar, ",
        "sex, email, phone, ",
        "area, openid)",
        "values (#{username,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=TINYINT}, #{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=VARCHAR}, #{openid,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(RegisterUser record);

    @InsertProvider(type=RegisterUserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(RegisterUser record);

    @SelectProvider(type=RegisterUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR)
    })
    List<RegisterUser> selectByExample(RegisterUserExample example);

    @Select({
        "select",
        "id, username, avatar, sex, email, phone, area, openid",
        "from register_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR)
    })
    RegisterUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=RegisterUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RegisterUser record, @Param("example") RegisterUserExample example);

    @UpdateProvider(type=RegisterUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RegisterUser record, @Param("example") RegisterUserExample example);

    @UpdateProvider(type=RegisterUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RegisterUser record);

    @Update({
        "update register_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=TINYINT},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "area = #{area,jdbcType=VARCHAR},",
          "openid = #{openid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RegisterUser record);

    @Select("select * from register_user where id = #{id}")
    RegisterUser findById(Long id);

    @Update("update register_user set status_ = 1 where id = #{id}")
    void updateStatus(Long id);

    @Update("update register_user set status_ = 0 where id = #{id}")
    void unBlock(Long id);
}