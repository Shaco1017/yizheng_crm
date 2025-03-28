package org.shaco.yizheng_crm_back.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * MyBatisPuls的代码生成器
 */
public class MyFastGeneratorConfiguration {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/yizheng_crm?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true&nullCatalogMeansCurrent=true",
                        "root",
                        "Abc12345!"
                )
                .globalConfig(builder -> {
                    builder.author("shaco") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:/WorkSpace/FBYWorkSpace/yizheng_crm_back_output"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.shaco.yizheng_crm_back")  // 设置父包名
                            .moduleName("sys")  // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:/WorkSpace/FBYWorkSpace/yizheng_crm_back_output"));  // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user");  // 设置需要生成的表名
                    //.addTablePrefix("act_fo_")  // 设置过滤表前缀
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine()).execute();
    }
}