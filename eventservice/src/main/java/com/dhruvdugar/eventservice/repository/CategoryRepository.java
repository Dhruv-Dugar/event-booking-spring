package com.dhruvdugar.eventservice.repository;


import com.dhruvdugar.eventservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
