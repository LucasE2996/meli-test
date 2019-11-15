package com.meli.dna.controller;

import com.meli.dna.model.Dna;
import com.meli.dna.repository.DnaDAO;
import com.meli.dna.service.DnaAnalyzer;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
public class DnaController {

    private final DnaAnalyzer dnaAnalyzer;
    private final DnaDAO dnaDAO;

    public DnaController(DnaAnalyzer dnaAnalyzer, DnaDAO dnaDAO) {
        this.dnaAnalyzer = dnaAnalyzer;
        this.dnaDAO = dnaDAO;
    }

    @PostMapping(value = "/simian", consumes = "application/json")
    public ResponseEntity<?> analyse(@RequestBody Map<String, String[]> request) {
        JSONObject json  = new JSONObject();
        String[] rawDna = request.get("dna");

        Dna dnaExists = dnaDAO.findByDna(rawDna);

        if (dnaExists != null) {
            json.put("error", "This DNA already exists");
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }

        Dna dna = new Dna(rawDna);

        if (!dna.isDnaValid()) {
            json.put("error", "DNA is not valid");
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }

        String[][] matrix = dna.buildDnaMatrix();

        if (!dna.isMatrixSquare(matrix)) {
            json.put("error", "Matrix size is not valid");
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }

        boolean isSimian = dnaAnalyzer.isSimian(matrix);

        dna.setSimian(isSimian);

        dnaDAO.save(dna);

        json.put("is_simian", isSimian);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping(value = "/stats", produces = "application/json")
    public ResponseEntity<?> stats() {
        JSONObject json  = new JSONObject();
        List<Dna> dnaList = dnaDAO.findAll();

        if (dnaList.size() <= 0) {
            json.put("error", "There is no data for status");
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }

        int simians = dnaAnalyzer.getNumberOfSimians(dnaList);
        int humans = dnaList.size() - simians;
        float ratio = dnaAnalyzer.calcRatio(dnaList);

        json.put("count_simian_dna", simians);
        json.put("count_human_dna", humans);
        json.put("ratio", ratio);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
