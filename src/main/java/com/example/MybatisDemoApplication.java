package com.example;

import com.example.mapper.ETLTodoMapper;
import com.example.mapper.TodoMapper;
import com.example.model.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class MybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner ds1(TodoMapper todoMapper) {
        return args -> {

            System.out.println("----ds1-----");

            Todo newTodo = new Todo();
            newTodo.setTodoTitle("Dinner");
            newTodo.setDetails("Ginza 19:00");

            todoMapper.insert(newTodo);

            Todo loadedTodo = todoMapper.select(newTodo.getTodoId());
            System.out.println("ID       : " + loadedTodo.getTodoId());
            System.out.println("TITLE    : " + loadedTodo.getTodoTitle());
            System.out.println("DETAILS  : " + loadedTodo.getDetails());
            System.out.println("FINISHED : " + loadedTodo.isFinished());

        };
    }

    @Bean
    CommandLineRunner ds2(ETLTodoMapper todoMapper) {
        return args -> {
            System.out.println("----ds2-----");

            Todo newTodo = new Todo();
            newTodo.setTodoTitle("Dinner");
            newTodo.setDetails("Ginza 19:00");

            todoMapper.insert(newTodo);

            Todo loadedTodo = todoMapper.select(newTodo.getTodoId());
            System.out.println("ID       : " + loadedTodo.getTodoId());
            System.out.println("TITLE    : " + loadedTodo.getTodoTitle());
            System.out.println("DETAILS  : " + loadedTodo.getDetails());
            System.out.println("FINISHED : " + loadedTodo.isFinished());
        };
    }

}
