package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.CollectManage;

@Mapper
public interface CollectManageDao {

    @Select("select * from collect_manage t where t.id = #{id}")
    CollectManage getById(Long id);

    @Delete("delete from collect_manage where id = #{id}")
    int delete(Long id);

    int update(CollectManage collectManage);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into collect_manage(collect_name, collect_code, collect_address, collect_account, collect_password, collect_isAuth, collect_api, collect_data, collect_state) values(#{collectName}, #{collectCode}, #{collectAddress}, #{collectAccount}, #{collectPassword}, #{collectIsAuth}, #{collectApi}, #{collectData}, #{collectState})")
    int save(CollectManage collectManage);
    
    int count(@Param("params") Map<String, Object> params);

    List<CollectManage> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
