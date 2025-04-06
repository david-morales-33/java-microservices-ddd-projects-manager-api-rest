package com.microservice.server;

import com.microservice.development.role.domain.Role;
import com.microservice.development.role.domain.RoleDTO;
import com.microservice.development.shared.domain.RoleId;
import com.microservice.development.shared.domain.TeamId;
import com.microservice.development.shared.domain.UserId;
import com.microservice.development.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import com.microservice.development.team.domain.Team;
import com.microservice.development.user.domain.User;
import com.microservice.development.user.domain.UserDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
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

/*
            Role role = Role.fromPrimitives(new RoleDTO(
                    "b1cd4460-920f-4a7b-bd91-491d2147d635",
                    "Admin",
                    "Administrador de sistemas"
            ));
            HashMap<String, RoleDTO> roleList = new HashMap<>();
            roleList.put(role.getId().value(), role.toPrimitives());
            User user = User.fromPrimitives(new UserDTO(
                    "b1cd4460-920f-4a7b-bd91-491d2147d635",
                    "Luis Villa",
                    "Luis.Vill45@gmail.com",
                    "Luis.Vill45",
                    roleList
            ));
*/
            Team team = session.find(Team.class, new TeamId("65c29076-9f9d-4365-b05b-d76d511e7bfa"));
            User user = session.getReference(User.class, new UserId("a69ef755-7d10-44bf-a384-ca75665c255e"));
            team.addUser(user);
            session.persist(team);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
