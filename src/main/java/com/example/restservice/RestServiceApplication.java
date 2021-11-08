package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class RestServiceApplication {

	private int base = 10;
	private ArrayList<String> items = new ArrayList<String>();

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@GetMapping("/hello") //URL = http://localhost:8080/hello?name=Bryant
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/calculate") //URl = http://localhost:8080/calculate?number=88 //Returns 880
	public int calculate(@RequestParam(value = "number") int number) {
		return  this.base * number;
	}

	@GetMapping("/additem")
	public void addItem(@RequestParam(value="itemname") String itemname) {
		this.items.add(itemname);
	}

	@GetMapping("/getitems")
	public StringBuilder items(){
		StringBuilder itemlist = new StringBuilder();
		itemlist.append("Items that have been added: ");
		for (int i = 0; i < items.size(); i++){
			itemlist.append(items.get(i));
			itemlist.append("\n");
		}
		return itemlist;
	}


}
