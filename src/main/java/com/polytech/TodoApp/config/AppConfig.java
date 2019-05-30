package com.polytech.TodoApp.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.TodoApp.business.*;
import com.polytech.TodoApp.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/polytask");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    TaskRepository taskRepository() {
        // Pas besoin d'avoir un parametre DataSource, la reference se fait automatiquement
//        return new InMemoryTaskRepository();
        return new JpaTaskRepository();
    }

    @Bean
    TaskService taskService() {
        return new TaskServiceImpl(taskRepository());
    }


}

