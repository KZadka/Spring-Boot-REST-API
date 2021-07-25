package com.example.library.book;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            Book theGreenMile = new Book(
                    "Stephen King",
                    "The Green Mile",
                    LocalDate.ofYearDay(1996, 1)
            );

            Book twentyThousandLeaguesUnderTheSeas = new Book(
                    "Jules Verne",
                    "Twenty Thousand Leagues Under the Seas",
                    LocalDate.ofYearDay(1872, 1)
            );

            repository.saveAll(
                    List.of(theGreenMile, twentyThousandLeaguesUnderTheSeas)
            );
        };
    }
}
