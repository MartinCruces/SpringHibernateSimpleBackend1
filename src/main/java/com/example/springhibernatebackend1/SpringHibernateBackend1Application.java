package com.example.springhibernatebackend1;

import com.example.springhibernatebackend1.KompisRESTAPI.Controllers.KompisController;
import com.example.springhibernatebackend1.KompisRESTAPI.Models.Kompis;
import com.example.springhibernatebackend1.KompisRESTAPI.Repos.KompisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateBackend1Application {

    private static final Logger log = LoggerFactory.getLogger(SpringHibernateBackend1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateBackend1Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(KompisRepository repository){
        return (args) ->{
            repository.save(new Kompis("Ivar Svensson", "Malmen 3", "070-9876543"));
            repository.save(new Kompis("Kalle Anka", "Ankeborg", "070-2345678"));
            repository.save(new Kompis("Mr.Walker", "Bengali", "070-3456789"));
            repository.save(new Kompis("Harald Blåtand", "Danmark", "070-4567890"));
            log.info("Bootstrap: Kompisar added");
        };

    }

}
