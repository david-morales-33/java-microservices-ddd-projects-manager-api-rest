package com.microservice.server;

import com.microservice.media.post.domain.Post;
import com.microservice.media.post.domain.PostDTO;
import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDTO;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceDTO;
import com.microservice.media.user.domain.User;
import com.microservice.media.user.domain.UserDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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


            LocalSessionFactoryBean sessionFactoryBean = factory.sessionFactory("media", dataSource);
            sessionFactoryBean.afterPropertiesSet();
            SessionFactory sessionFactory = sessionFactoryBean.getObject();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
