package com.poly.app.service;

import java.util.List;

import com.poly.app.Entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.poly.app.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	public List<Categories> listCate(){
		return categoryRepo.findAll();
	}

	public Categories getCategoryById(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}

	public Categories createCategory(Categories category) {
		return categoryRepo.save(category);
	}

	public Categories updateCategory(Long id, Categories updatedCategory) {
		Categories existingCategory = categoryRepo.findById(id).orElse(null);
		if (existingCategory != null) {
			existingCategory.setName(updatedCategory.getName());

			return categoryRepo.save(existingCategory);
		}
		return null;
	}

	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
}