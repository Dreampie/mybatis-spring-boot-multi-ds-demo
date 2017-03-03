package com.example.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by wangrenhui on 2017/2/16.
 */
@Configuration
@MapperScan(annotationClass = Mapper.class, basePackages = {"com.example.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    @Autowired
    MybatisConfigurationSupport mybatisConfigurationSupport;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        return mybatisConfigurationSupport.build(dataSource);
    }
}