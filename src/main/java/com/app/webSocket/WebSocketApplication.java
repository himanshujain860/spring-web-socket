package com.app.webSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class WebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketApplication.class, args);
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}

}

class Greeting{
	String body;

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return this.body;
	}

	public Greeting(){}

	public Greeting(String body){
		this.body = body;
	}
}

class HelloMessage{
	String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public HelloMessage(){}

	public HelloMessage(String name){
		this.name = name;
	}
}
