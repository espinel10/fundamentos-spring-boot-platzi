package com.fundamentosplatzi.springboot.fundamentos.Configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:connection.properties")
public class GeneralConfiguration {



}
