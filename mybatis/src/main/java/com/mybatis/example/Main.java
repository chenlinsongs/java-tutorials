package com.mybatis.example;

import com.mybatis.example.entity.Test;
import com.mybatis.example.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Test test = session.selectOne("com.mybatis.example.mapper.BlogMapper.selectBlog",1);
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Test blog = mapper.selectBlog(1);
            System.out.println(blog);
        }
    }

    public void test(){
    }
}
