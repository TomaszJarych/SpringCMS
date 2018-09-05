package pl.coderslab.Controller.Day4;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.DTO.CategoryDTO;
import pl.coderslab.Service.Day4.CategoryServiceDay4;
import pl.coderslab.Service.ServiceDTO.CategoryServiceDTO;

@Controller
@RequestMapping("/day4/category")
public class CategoryControllerDay4 {

  private final CategoryServiceDay4 service;

  @Autowired
  public CategoryControllerDay4(CategoryServiceDay4 service) {
    this.service = service;
  }

  @RequestMapping(path = "", method = RequestMethod.GET)
  public String getCategoriesList() {

    return "categories";
  }

  @RequestMapping(path = "/add", method = RequestMethod.GET)
  public String addNewCategory(Model model) {

    model.addAttribute("category", new CategoryDTO());

    return "categoryForm";
  }

  @RequestMapping(path = "/add", method = RequestMethod.POST)
  public String processCategoryForm(
      @Valid @ModelAttribute("category") CategoryDTO dto, BindingResult result, Model model) {
    if (result.hasErrors()) {
      //	  model.addAttribute("category", dto);
      return "categoryForm";

    } else {
      service.addCategory(dto);
      return "redirect:/categories";
    }
  }

  @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
  public String updateCategoryForm(@PathVariable("id") Long id, Model model) {

    model.addAttribute("category", service.getCategoryByID(id));

    return "categoryForm";
  }

  @RequestMapping(path = "/update/**", method = RequestMethod.POST)
  public String processUpdateCategoryForm(
      @Valid @ModelAttribute("category") CategoryDTO dto, BindingResult result) {
    if (result.hasErrors()) {
      return "categoryForm";

    } else {
      service.updateCategory(dto);
      return "redirect:/categories";
    }
  }

  @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
  public String deleteCategory(@PathVariable("id") Long id) {

    service.deleteCategory(id);

    return "redirect:/categories";
  }

  @ModelAttribute("categories")
  private Collection<CategoryDTO> getCategories() {
    return service.getCategoryList();
  }
}
