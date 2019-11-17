package com.meli.dna;

import com.meli.dna.model.Dna;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8
    );

    public static List<Dna> generateDnaList() {
        List<Dna> dnas = new ArrayList<>();
        Dna dna1 = new Dna();
        Dna dna2 = new Dna();
        Dna dna3 = new Dna();
        dna1.setSimian(true);
        dna2.setSimian(false);
        dna3.setSimian(false);
        dnas.add(dna1);
        dnas.add(dna2);
        dnas.add(dna3);

        return dnas;
    }
}
