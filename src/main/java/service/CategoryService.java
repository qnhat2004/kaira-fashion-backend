package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Category;
import repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllActiveCategories() {
		return categoryRepository.findByDeletedIsNull();
	}
	
	public void softDeleteCategory(int id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		
		category.setDeleted_at(LocalDateTime.now());
		categoryRepository.save(category);
	}
	
	// Optional giúp xử lý tình huống khi không có dữ liệu được tìm thấy
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);	// Trả về đối tượng đã được lưu (có thể là id sau khi thêm được tự động tăng)
	}
	
	public Category updateCategory(int id, Category updateCategory) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		if (!categoryOptional.isPresent()) {
			return null;
		}
		Category existingCategory = categoryOptional.get();
		existingCategory.setName(updateCategory.getName());
		existingCategory.setDescription(updateCategory.getDescription());
		return categoryRepository.save(existingCategory);
	}
	
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
}
