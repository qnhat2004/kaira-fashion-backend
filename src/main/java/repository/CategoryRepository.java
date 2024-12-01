package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	// JpaRepository<entity, ID type>
    // Các phương thức CRUD cơ bản được cung cấp sẵn như findAll(), save(), deleteById(), ...
	// Ưu điểm: tiết kiệm thời gian không cần viết sql thủ công cho các thao tác cơ bản
	List<Category> findByDeletedIsNull();
}
