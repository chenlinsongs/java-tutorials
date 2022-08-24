package com.mybatis.example.mapper;

import com.mybatis.example.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

public interface BlogMapper {

    Test selectBlog(@Param(value = "id") Integer id);
}
