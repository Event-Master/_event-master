package com.jaforest.Event.Master;

import com.jaforest.Event.Master.gson.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventMasterApplication.class, args);
		App.addToJson();
	}


}
