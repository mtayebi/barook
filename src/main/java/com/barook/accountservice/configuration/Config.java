package com.barook.accountservice.configuration;

import com.barook.accountservice.model.Account;
import com.barook.accountservice.model.User;
import com.barook.accountservice.repository.AccountRepository;
import com.barook.accountservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.barook.accountservice")
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            User user = User.builder().name("test").build();
            Account account = Account.builder().balance("1000").user(user).build();

            accountRepository.save(account);
        };
    }

}
