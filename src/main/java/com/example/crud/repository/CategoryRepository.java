package com.example.crud.repository;
import com.example.crud.model.Category;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CategoryRepository extends CrudRepository<Category, Long> {
  public ArrayList<Category> findByName(String name);
  public void deleteById(Long id);

}
