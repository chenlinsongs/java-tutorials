package com.mybatis.example;

import org.apache.ibatis.io.ResolverUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

public class ResourceTest {
    public static void main(String[] args) throws IOException {
        ResourceTest test = new ResourceTest();
        ClassLoader classLoader = test.getClass().getClassLoader();
        ArrayList arrayList = Collections.list(Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF"));
        System.out.println(arrayList.size());
        Enumeration<URL> enumeration =  null;
        URL url = Thread.currentThread().getContextClassLoader().getResource("com/mybatis/example/mapper/BlogMapper.xml");
        System.out.println(url);
//        Enumeration<URL> enumeration = classLoader.getResources();

        System.out.println("==");
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<>();
        resolverUtil.find(new ResolverUtil.IsA(Object.class), "com.mybatis.example");
        Set<Class<? extends Class<?>>> typeSet = resolverUtil.getClasses();
        if (typeSet != null){
            typeSet.stream().forEach( t ->{
                System.out.println(t.getName());
            });
        }
    }
}
