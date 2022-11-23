package com.application.dao;

import com.application.domain.csdnInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface csdnInfoDao {
    @Insert("insert into csdntable (title, author, url, daytime, Detail) VALUES (#{title},#{author},#{url},#{dayTime},#{Detail})")
       void InsertBlog(csdnInfo csdnInfo);
}
