package com.ta.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.util.Properties;
//import org.apache.commons.dbcp.BasicDataSource;


@Configuration
@EnableJpaRepositories(basePackages = {"com.ta.models"})
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/travelAgency");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                "com.ta.models");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty(
                "hibernate.current_session_context_class", "thread"
        );
//        hibernateProperties.setProperty("hibernate.show_sql", "true");
//        hibernateProperties.setProperty("hibernate.format_sql", "true");
        return hibernateProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}

/*
Компонент dataSource. В данном случае применяется встроенная база данных
Н2, объявленная, как пояснялось в главе 6.

Компонент sessionFactory. Этот компонент Spring Bean является самой
важной частью конфигурации, поскольку в нем определено немало свойств.
Во-первых, необходимо внедрить компонент источника данных в фабрику сеансов.
Во-вторых, библиотеке Hibernate предписывается просмотреть объекты
предметной области в пакете com.apress.prospringS.ch.entities.
И, в-третьих, свойство hibernateProperties предоставляет подробности
конфигурирования Hibemate. Имеется немало конфигурационных параметров,
но в данном случае определяются лишь несколько важных свойств, которые
должны предоставляться для каждого приложения.
 */