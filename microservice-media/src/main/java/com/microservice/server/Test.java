package com.microservice.server;

import com.microservice.media.post.domain.Post;
import com.microservice.media.post.domain.PostDTO;
import com.microservice.media.role.domain.Role;
import com.microservice.media.role.domain.RoleDTO;
import com.microservice.media.shared.domain.SpaceId;
import com.microservice.media.shared.domain.TeamId;
import com.microservice.media.shared.domain.UserId;
import com.microservice.media.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import com.microservice.media.space.domain.Space;
import com.microservice.media.space.domain.SpaceDTO;
import com.microservice.media.team.domain.Team;
import com.microservice.media.team.domain.TeamDTO;
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

            //SessionFactory sessionFactory = factory.sessionFactory("media", dataSource).getObject();

            LocalSessionFactoryBean sessionFactoryBean = factory.sessionFactory("media", dataSource);
            //System.out.println(factory.searchMappingFiles());
            sessionFactoryBean.afterPropertiesSet();
            SessionFactory sessionFactory = sessionFactoryBean.getObject();

            //System.out.println("sessionFactory = " + sessionFactory);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
/*
            Role role2 = Role.fromPrimitives(new RoleDTO("0ccc774a-782e-4c0f-8695-f0b78c900d34", "Invitado", "Usuario sin permisos"));

            Map<String, RoleDTO> roleList = new HashMap<>();
            roleList.put(role1.getId().value(), role1.toPrimitives());
            roleList.put(role2.getId().value(), role2.toPrimitives());

            User user = User.fromPrimitives(new UserDTO(
                    "dca2c5c6-398a-4f0a-a0a1-20fa3c498e4b",
                    "Luisa Fernanda Gonzalez",
                    "Lu1235.45@gmail.com",
                    "Lu1235.45",
                    roleList
            ));

            HashSet<UserDTO> memberList = new HashSet<>();
            memberList.add(user.toPrimitives());

            HashMap<String, PostDTO> postList = new HashMap<>();

            Post newPost = Post.fromPrimitives(new PostDTO(
                    UUID.randomUUID().toString(),
                    "Error",
                    "El test no ha pasado",
                    LocalDate.now().toString(),
                    "9b0b97b7-bba6-4ed7-962f-b43f4379c053",
                    user.toPrimitives()
            ));

            postList.put(newPost.getId().value(), newPost.toPrimitives());

            Space space = session.find(Space.class, new SpaceId("9b0b97b7-bba6-4ed7-962f-b43f4379c053"));
            System.out.println(space.toPrimitives().postList());
            Role role2 = Role.fromPrimitives(new RoleDTO("e5e040f2-11a1-4f2b-9270-4f2891541ea4", "Desarrollador (Front-End)", "Developer software"));
            Role role4 = Role.fromPrimitives(new RoleDTO("e5e040f2-11a1-4f2b-9270-4f2891541ec6", "Administrador", "Project manager"));
            Role role1 = Role.fromPrimitives(new RoleDTO("e5e040f2-11a1-4f2b-9270-4f2891541ef3", "Desarrollador (Back-End)", "Developer software"));
            Map<String, RoleDTO> roleList = new HashMap<>();
            roleList.put(role3.getId().value(), role3.toPrimitives());


            */
            User user = User.fromPrimitives(new UserDTO(
                    "dca2c5c6-398a-4f0a-a0a1-20fa3c498b4a",
                    "Luisa Fernanda Torres",
                    "lu2014.214@gmail.com",
                    "lu2014.214",
                    new HashMap<>()
            ));
            Role role3 = Role.fromPrimitives(new RoleDTO("e5e040f2-11a1-4f2b-9270-4f2891541eb5", "Desarrollador (Tester)", "QA"));
            HashSet<UserDTO> memberList = new HashSet<>();
            memberList.add(user.toPrimitives());

            HashMap<String, PostDTO> postList = new HashMap<>();

            Space space = Space.fromPrimitive(new SpaceDTO(
                    "9b0b97b7-bba6-4ed7-962f-b43f4379a784",
                    "Autenticacion",
                    LocalDate.now().toString(),
                    "dca2c5c6-398a-4f0a-a0a1-20fa3c498e4b",
                    postList,
                    memberList,
                    0,
                    0
            ));

            HashMap<String, SpaceDTO> spaceList = new HashMap<>();
            HashMap<String, UserDTO> userList = new HashMap<>();

            spaceList.put(space.getId().value(), space.toPrimitives());
            userList.put(user.getId().value(), user.toPrimitives());

            Team team = Team.fromPrimitives(new TeamDTO(
                    "36479f04-dcb1-4fe4-8d4e-67184ca9b90c",
                    "Back-end",
                    0,
                    0,
                    LocalDate.now().toString(),
                    true,
                    role3.toPrimitives(),
                    userList,
                    spaceList
            ));

            session.merge(team);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
