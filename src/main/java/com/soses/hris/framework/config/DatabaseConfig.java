package com.soses.hris.framework.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.soses.hris.framework.property.DatabaseProperties;
import com.soses.hris.framework.property.HibernateProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    private HibernateProperties hbProperties;

    private DatabaseProperties dbProperties;

    @Autowired
	public void setHbProperties(HibernateProperties hbProperties) {
		this.hbProperties = hbProperties;
	}

    @Autowired
	public void setDbProperties(DatabaseProperties dbProperties) {
		this.dbProperties = dbProperties;
	}
    
    @Bean
    public DataSource dataSource() {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dbProperties.getDriverClassName());
        hikariConfig.setJdbcUrl("jdbc:mysql://" + dbProperties.getHost() + ":" + dbProperties.getPort() + "/"
                + dbProperties.getDbName());
        hikariConfig.setUsername(dbProperties.getUsername());
        hikariConfig.setPassword(dbProperties.getPassword());

        hikariConfig.setMaximumPoolSize(dbProperties.getMaxPoolSize());
        hikariConfig.setMinimumIdle(dbProperties.getMinimumIdle());
        hikariConfig.setIdleTimeout(dbProperties.getIdleTimeout());        
        hikariConfig.setConnectionTestQuery(dbProperties.getConnectionTestQuery());
        hikariConfig.setPoolName(dbProperties.getPoolName());

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", dbProperties.isCachePrepStmts());
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", dbProperties.getPrepStmtCacheSize());
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", dbProperties.getPrepStmtCacheSqlLimit());
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", dbProperties.isUseServerPrepStmts());

        return new HikariDataSource(hikariConfig);
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan(hbProperties.getPackagesToScan());

        entityManagerFactory.setPersistenceUnitName(hbProperties.getPersistenceUnitName());

        // Vendor adapter
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Hibernate properties.backend.usrmgmt
        final Properties additionalProperties = new Properties();
        additionalProperties.put("hibernate.dialect", hbProperties.getDialect());
        additionalProperties.put("hibernate.show_sql", hbProperties.isShowSql());
        additionalProperties.put("hibernate.hbm2ddl.auto", hbProperties.getHbm2DdlAuto());
        additionalProperties.put("hibernate.dialect.storage_engine", hbProperties.getStorageEngine());
        additionalProperties.put("hibernate.enable_lazy_load_no_trans", hbProperties.getEnableLazyLoadNoTrans());
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }
    
}
