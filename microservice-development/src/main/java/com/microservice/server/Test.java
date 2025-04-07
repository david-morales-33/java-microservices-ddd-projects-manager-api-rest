package com.microservice.server;

import com.microservice.development.card.domain.Card;
import com.microservice.development.card.domain.CardDTO;
import com.microservice.development.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import com.microservice.development.task.domain.Task;
import com.microservice.development.task.domain.TaskDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
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

            HashSet<TaskDTO> taskList = new HashSet<>();
            Task newTask = Task.fromPrimitives(new TaskDTO(
                    UUID.randomUUID().toString(),
                    "Desarrollar controlador",
                    "Desarrollar el controlador para solicitar lista de Tareas",
                    LocalDate.now().toString(),
                    true,
                    "dca2c5c6-398a-4f0a-a0a1-20fa3c498e4b"
            ));

            taskList.add(newTask.toPrimitives());

            Card card = Card.fromPrimitives(new CardDTO(
                    "3f4eeaee-e231-4a2c-b88a-a5df39bb320a",
                    "To-Do",
                    taskList
            ));

            session.merge(card);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
