package com.meli.dna;

import com.meli.dna.repository.DnaDAO;
import com.meli.dna.service.DnaAnalyzer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.meli.dna.TestUtil.APPLICATION_JSON_UTF8;
import static com.meli.dna.TestUtil.generateDnaList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(value = MyTestConfiguration.class)
public class DnaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    DnaAnalyzer dnaAnalyzer;

    @Autowired
    DnaDAO dnaDAO;

    @Test
    public void simianTest() throws Exception {
        when(dnaDAO.findByDna(new String[]{"CTGA", "ATGC", "AAAA", "GGGG"})).thenReturn(null);

        mockMvc.perform(post("/simian")
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\"dna\": [\"CTGA\", \"ATGC\", \"AAAA\", \"GGGG\"]}"))
                .andExpect(status().isOk());
    }

    @Test
    public void statsTest() throws Exception {
        when(dnaDAO.findAll()).thenReturn(generateDnaList());

        mockMvc.perform(get("/stats"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }
}
