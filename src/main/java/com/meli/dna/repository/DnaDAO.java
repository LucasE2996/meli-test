package com.meli.dna.repository;

import com.meli.dna.Model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DnaDAO extends JpaRepository<Dna, Integer> {

    List<Dna> findAll();
    Dna findByDna(String[] dna);
}
