package pl.coderslab.Service;

import org.springframework.stereotype.Service;

import pl.coderslab.DAO.CategoryDAO;
import pl.coderslab.entity.Category;

@Service
public class CategoryService {
    
    CategoryDAO dao;

    public CategoryService(CategoryDAO dao) {
	this.dao = dao;
    }
    
    public Category addCategory(Category category) {
	dao.addCategory(category);
	return category;
    }

    public Category getCategoryByID(Long id) {
	return dao.getCategoryByID(id);
    }

    public void updateCategory(Category category) {
	dao.updateCategory(category);
    }

    public void deleteCategory(Category category) {
	dao.deleteCategory(category);
    }
}
