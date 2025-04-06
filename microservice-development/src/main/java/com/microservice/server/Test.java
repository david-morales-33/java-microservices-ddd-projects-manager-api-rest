package com.microservice.server;

import com.microservice.development.role.domain.Role;
import com.microservice.development.role.domain.RoleDTO;
import com.microservice.development.shared.domain.RoleId;
import com.microservice.development.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.UUID;

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


            LocalSessionFactoryBean sessionFactoryBean = factory.sessionFactory("development", dataSource);
            sessionFactoryBean.afterPropertiesSet();
            SessionFactory sessionFactory = sessionFactoryBean.getObject();

            assert sessionFactory != null;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Role role = Role.fromPrimitives(new RoleDTO(
                    UUID.randomUUID().toString(),
                    "Admin",
                    "Administrador de sistemas"
            ));
            session.persist(role);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
