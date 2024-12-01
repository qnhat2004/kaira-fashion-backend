package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Category;
import service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController		// restful web service controller, ket hop voi @ResponseBody -> giup cac phuong thuc tra ve du lieu (JSON hoac XML) thay vi view (1 trang html) 
@RequestMapping("/api/categories")		// Anh xa cac request http toi controller
@CrossOrigin(origins = "http://localhost:3000")		// backend: 8080
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAllActiveCategories() {
		return categoryService.getAllActiveCategories();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {		// phan hoi http, bao gom ma trang thai, headers va body
		Optional<Category> category = categoryService.getCategoryById(id);
		return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());	// su dung phuong thuc map cua Optional de xem co Category hay khong, neu co tra ResponseEntity::ok ve voi status code 200 va body chua doi tuong Category, neu khong tra ve ResponseEntity.notFound().build() voi status 404 
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
		Category updated = categoryService.updateCategory(id, updatedCategory);
		if (updated == null) {
			return ResponseEntity.notFound().build();	
		}
		return ResponseEntity.ok(updated);	// neu tim thay tra ve status 200 ok voi body = updated
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> softDeleteCategoryById(@PathVariable int id) {
		categoryService.softDeleteCategory(id);
		return ResponseEntity.ok().build();
	}
}
