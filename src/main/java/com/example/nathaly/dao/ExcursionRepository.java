package com.example.nathaly.dao;

import com.example.nathaly.entities.Excursion;
import com.example.nathaly.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin

public interface ExcursionRepository extends JpaRepository<Excursion,Long> {
}
