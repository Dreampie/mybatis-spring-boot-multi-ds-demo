package com.example;

import com.example.mapper.ETLTodoMapper;
import com.example.mapper.TodoMapper;
import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class MybatisDemoApplication {
    @Autowired
    private TodoMapper todoMapper;
    @Autowired
    private ETLTodoMapper etlTodoMapper;


    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner excute() {
        return args -> {
            System.out.println(todoMapper + "/" + etlTodoMapper);

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

            System.out.println("----ds2-----");

            Todo newETLTodo = new Todo();
            newTodo.setTodoTitle("Dinner");
            newTodo.setDetails("Ginza 19:00");

            etlTodoMapper.insert(newETLTodo);

            Todo loadedETLTodo = etlTodoMapper.select(newETLTodo.getTodoId());
            System.out.println("ID       : " + loadedETLTodo.getTodoId());
            System.out.println("TITLE    : " + loadedETLTodo.getTodoTitle());
            System.out.println("DETAILS  : " + loadedETLTodo.getDetails());
            System.out.println("FINISHED : " + loadedETLTodo.isFinished());
        };
    }

}
