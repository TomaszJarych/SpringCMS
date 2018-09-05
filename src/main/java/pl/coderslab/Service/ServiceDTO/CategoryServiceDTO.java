package pl.coderslab.Service.ServiceDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.coderslab.DAO.CategoryDAO;
import pl.coderslab.DTO.CategoryDTO;
import pl.coderslab.entity.Category;

@Service
public class CategoryServiceDTO {

  CategoryDAO dao;

  public CategoryServiceDTO(CategoryDAO dao) {
    this.dao = dao;
  }

  public CategoryDTO addCategory(CategoryDTO dto) {
    return dao.addCategory(toEntity(dto)).toDto();
  }

  public CategoryDTO getCategoryByID(Long id) {
    return dao.getCategoryByID(id).toDto();
  }

  public CategoryDTO updateCategory(CategoryDTO dto) {
    Category category = toEntity(dto);
    dao.updateCategory(category);
    return category.toDto();
  }

  public void deleteCategory(Long id) {
    dao.deleteCategory(dao.getCategoryByID(id));
  }

  public List<CategoryDTO> getCategoryList() {
    return dao.getCategoryList().stream().map(Category::toDto).collect(Collectors.toList());
  }

  private Category toEntity(CategoryDTO dto) {
    Category category;

    if (dto.getId() == null) {
      category = new Category(dto.getName(), dto.getDescription());
    } else {
      category = dao.getCategoryByID(dto.getId());
      category.setName(dto.getName());
      category.setDescription(dto.getDescription());
    }

    return category;
  }
}
