package com.poly.app.controller;

import java.util.List;

import com.poly.app.Entity.Categories;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poly.app.service.CategoryService;


//@RestController
//@RequestMapping("/api/category") // Router Category
//public class CategoryController {
//	@Autowired
//	CategoryService categoryService;
//
//	@GetMapping("/list")
//	public ResponseEntity<List<Category>> listCate() {
//		return new ResponseEntity<List<Category>>(categoryService.listCate(), HttpStatus.OK);
//	}
//}

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping("/list")
	public ResponseEntity<List<Categories>> listCate() {
		List<Categories> categories = categoryService.listCate();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categories> getCategoryById(@PathVariable Long id) {
		Categories category = categoryService.getCategoryById(id);
		if (category != null) {
			return new ResponseEntity<>(category, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Categories> createCategory(@RequestBody Categories category) {
		Categories createdCategory = categoryService.createCategory(category);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories updatedCategory) {
		Categories updated = categoryService.updateCategory(id, updatedCategory);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
