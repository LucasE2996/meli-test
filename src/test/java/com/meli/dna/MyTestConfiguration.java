package com.meli.dna;

import com.meli.dna.repository.DnaDAO;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class MyTestConfiguration {

    @Primary @Bean
    DnaDAO createDnaDAOMock() {
        return Mockito.mock(DnaDAO.class);
    }
}
