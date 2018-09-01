package pl.coderslab.Controller.Day2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.DTO.CategoryDTO;
import pl.coderslab.Service.ServiceDTO.CategoryServiceDTO;

@Controller
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryServiceDTO service;;

  @Autowired
  public CategoryController(CategoryServiceDTO service) {
    this.service = service;
  }

  @ModelAttribute("categories")
  private Collection<CategoryDTO> getCategories() {
    return service.getCategoryList();
  }
}
