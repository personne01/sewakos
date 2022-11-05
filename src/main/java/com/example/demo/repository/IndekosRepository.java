package com.example.demo.repository;

import com.example.demo.model.Indekos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndekosRepository extends JpaRepository<Indekos, Long> {

}
