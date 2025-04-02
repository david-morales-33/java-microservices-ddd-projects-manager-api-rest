package com.microservice.server;

import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDTO;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.shared.infrastructure.hibernate.HibernateConfigurationFactory;
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
import java.util.HashMap;
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

            //SessionFactory sessionFactory = factory.sessionFactory("media", dataSource).getObject();

            LocalSessionFactoryBean sessionFactoryBean = factory.sessionFactory("media", dataSource);
            //System.out.println(factory.searchMappingFiles());
            sessionFactoryBean.afterPropertiesSet();
            SessionFactory sessionFactory = sessionFactoryBean.getObject();

            //System.out.println("sessionFactory = " + sessionFactory);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            /*Role role1 = Role.fromPrimitives(new RoleDTO("e5e040f2-11a1-4f2b-9270-4f2891541ef3", "Administrador", "permisos de sistemas"));
            Role role2 = Role.fromPrimitives(new RoleDTO("0ccc774a-782e-4c0f-8695-f0b78c900d34", "Invitado", "Usuario sin permisos"));
            Map<String, RoleDTO> roleList = new HashMap<>();
            roleList.put(role2.getId().value(), role2.toPrimitives());

            User user = User.fromPrimitives(new UserDTO(
                    UUID.randomUUID().toString(),
                    "Luisa Fernanda Gonzalez",
                    "Lu1235.45@gmail.com",
                    "Lu1235.45",
                    roleList
            ));
            User user = session.find(User.class, new UserId("1001c9a6-cc5b-4b89-a1ed-c60fa091cd22"));
            System.out.println(user.toPrimitives());*/
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
