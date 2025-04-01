package com.microservice.server;

import com.microservice.media.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        try {
            ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

            HibernateConfigurationFactory factory = new HibernateConfigurationFactory(resourceResolver);

            DataSource dataSource = factory.dataSource(
                    "localhost",
                    5432,
                    "management_projects_msvc",
                    "admin",
                    "Sistemas-2020"
            );

            //SessionFactory sessionFactory = factory.sessionFactory("media", dataSource).getObject();

            LocalSessionFactoryBean sessionFactoryBean = factory.sessionFactory("media", dataSource);
            sessionFactoryBean.afterPropertiesSet();
            SessionFactory sessionFactory = sessionFactoryBean.getObject();

            //System.out.println("sessionFactory = " + sessionFactory);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(factory.searchMappingFiles("media"));
        }
    }
}
