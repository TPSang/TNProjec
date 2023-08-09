package com.poly.app.repo;

import com.poly.app.Entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepo extends JpaRepository<Categories, Long> {

}


