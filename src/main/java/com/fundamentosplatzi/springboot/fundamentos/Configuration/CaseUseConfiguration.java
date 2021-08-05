package com.fundamentosplatzi.springboot.fundamentos.Configuration;

import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUseImpl;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
@Bean
    GetUser getUser(UserService userService){
    return new GetUseImpl(userService);
}

}
