package com.example.H2Fullstack.Repository;

import com.example.H2Fullstack.Entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese, Long> {
}