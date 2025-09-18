package com.javachatbot.javachatbot;

import java.util.Scanner;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class JavachatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavachatbotApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ChatClient.Builder builder) {
		    return _ -> {
			try {
					var chat = builder.build();
					try (var scanner = new Scanner(System.in)) {
						System.out.println("\nLet's chat!");
						while (true) {
							System.out.print("\nUSER: ");
							System.out.println("ASSISTANT: " +
									chat.prompt(scanner.nextLine()).call().content());
						}
					}
			} catch (Exception e) {
					System.out.println(e);
					throw e;
			}
        };
	}

}
