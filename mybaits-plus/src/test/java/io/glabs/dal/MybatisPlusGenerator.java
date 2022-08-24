package io.glabs.dal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

public class MybatisPlusGenerator {

    public static void main(String[] args) throws InterruptedException {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/glabs" +
                "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false" +
                "&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("chenlinsong") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("./glabs-dal/src/test/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("io.glabs.dal") // 设置父包名
                            .moduleName("store") // 设置父包模块名
                            .entity("entity")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "./glabs-dal/src/test/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix("gl") // 设置过滤表前缀
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("is_delete")
                            .addTableFills(new Column("createAt", FieldFill.INSERT))
                            .addTableFills(new Column("updateAt", FieldFill.UPDATE))
                            .controllerBuilder()
                            .enableRestStyle();
                })
                .templateConfig(builder -> {
                    builder.entity("/templates/entity.java");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
