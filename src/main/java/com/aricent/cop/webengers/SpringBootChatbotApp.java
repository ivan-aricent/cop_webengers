package com.aricent.cop.webengers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot entry-point class for chatbot
 *
 */
@SpringBootApplication(scanBasePackages={"com.aricent.cop.webengers"})
public class SpringBootChatbotApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! Welcome to webengers chatbot." );
        SpringApplication.run(SpringBootChatbotApp.class, args);
    }
}
