package pl.coderslab.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Category;

@Component
@Transactional
public class CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Category addCategory(Category category) {
	entityManager.persist(category);
	return category;
    }

    public Category getCategoryByID(Long id) {
	return entityManager.find(Category.class, id);
    }

    public void updateCategory(Category category) {
	entityManager.merge(category);
    }

    public void deleteCategory(Category category) {
	entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }
    
    public List<Category> getCategoryList() {
	Query query = entityManager.createQuery(" SELECT c FROM Category c");
	List<Category> categories = query.getResultList();
	return categories;
    }
}
