package com.boco.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @program:
 * @description: 源数据库配置
 **/
@Configuration
@MapperScan(basePackages = "com.boco.sourcemapper.**", sqlSessionFactoryRef = "sourceSqlSessionFactory")
public class SourceDatabaseConfig {
    @Value("${spring.datasource.source.driver-class-name}")
    String driverClass;
    @Value("${spring.datasource.source.jdbc-url}")
    String url;
    @Value("${spring.datasource.source.username}")
    String userName;
    @Value("${spring.datasource.source.password}")
    String passWord;

    @Primary
    @Bean(name = "sourceDataSource")
    @ConfigurationProperties("spring.datasource.source")
    public DataSource masterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        return dataSource;
    }

    @Bean(name = "sourceSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sourceDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mybatis/*.xml"));

        return sessionFactoryBean.getObject();
    }
    @Bean(name = "sourceSqlSessionFactory")
    public SqlSessionTemplate sqlSessionFactoryTemplate(@Qualifier("sourceSqlSessionFactory")SqlSessionFactory sqlSessionFactory ) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
