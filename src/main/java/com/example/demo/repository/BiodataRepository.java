package com.example.demo.repository;

import com.example.demo.model.Biodata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BiodataRepository extends JpaRepository<Biodata, Long> {
    Optional<Biodata> findByName(String name);
}
