package pl.coderslab.Service.Day4;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.DTO.CategoryDTO;
import pl.coderslab.Repository.CategoryRepository;
import pl.coderslab.entity.Category;

@Service
public class CategoryServiceDay4 {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryServiceDay4(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public CategoryDTO addCategory(CategoryDTO dto) {
    return categoryRepository.save(toEntity(dto)).toDto();
  }

  public CategoryDTO getCategoryByID(Long id) {
    return categoryRepository.findOne(id).toDto();
  }

  public CategoryDTO updateCategory(CategoryDTO dto) {
    Category category = toEntity(dto);
    return categoryRepository.save(category).toDto();
  }

  public void deleteCategory(Long id) {
    categoryRepository.delete(id);
  }

  public List<CategoryDTO> getCategoryList() {
    return categoryRepository.findAll().stream().map(Category::toDto).collect(Collectors.toList());
  }

  private Category toEntity(CategoryDTO dto) {
    Category category;

    if (dto.getId() == null) {
      category = new Category(dto.getName(), dto.getDescription());
    } else {
      category = categoryRepository.findOne(dto.getId());
      category.setName(dto.getName());
      category.setDescription(dto.getDescription());
    }

    return category;
  }
}
