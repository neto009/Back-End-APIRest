package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	TodoListRepository todolistRepository;

	@Autowired
	TodoListItemRespository todolistitemRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception{
		TodoList c1 = new TodoList(null, "alimentos");

		TodoListItem i1 = new TodoListItem(null, "bolacha", c1);
		TodoListItem i2 = new TodoListItem(null, "arroz", c1);
		TodoListItem i3 = new TodoListItem(null, "feijao", c1);
		TodoListItem i4 = new TodoListItem(null, "pão", c1);

		todolistRepository.save(c1);

		todolistitemRepository.save(i1);
		todolistitemRepository.save(i2);
		todolistitemRepository.save(i3);
		todolistitemRepository.save(i4);
	}

}
