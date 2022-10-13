package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.training.config.MyConfiguration;
import com.training.model.Book;
import com.training.repo.BookRepo;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Autowired
	private MyConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("message:"+ config.getMessage());
		
	//	System.out.println(bookRepo.findByTitle("CSharp"));
		
	//	System.out.println(bookRepo.findByTitleLike("%C%"));
		
//		System.out.println(bookRepo.getBooksTitlePattern("%Cp%"));
		System.out.println(bookRepo.updateBooksStockTitle("%C%", 100l));
		
	}
	
	@Autowired
	private BookRepo bookRepo;
	
	@PostConstruct
	public void init()
	{
		bookRepo.save(new Book(1234l,"C",150.25,100l));
		bookRepo.save(new Book(4567l,"CPlus",175.25,100l));
		bookRepo.save(new Book(9756l,"Python",250.25,100l));
		
	}
	

}
