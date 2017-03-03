package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(annotationClass = ETLMapper.class, basePackages = {"com.example.mapper"}, sqlSessionFactoryRef = "etlSqlSessionFactory")
public class ETLDataSourceConfig {

    @Autowired
    MybatisConfigurationSupport mybatisConfigurationSupport;

    @Bean(name = "etlDataSource")
    @ConfigurationProperties(prefix = "spring.etl.datasource")
    public DataSource etlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "etlSqlSessionFactory")
    public SqlSessionFactory etlSqlSessionFactory(DataSource etlDataSource) throws Exception {
        return mybatisConfigurationSupport.build(etlDataSource);
    }
}