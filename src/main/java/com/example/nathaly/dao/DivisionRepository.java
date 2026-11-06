package com.example.nathaly.dao;

import com.example.nathaly.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin

public interface DivisionRepository extends JpaRepository<Division,Long> {
}
