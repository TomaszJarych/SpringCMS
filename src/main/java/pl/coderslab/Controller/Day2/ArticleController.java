package pl.coderslab.Controller.Day2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.DTO.ArticleDTO;
import pl.coderslab.DTO.AuthorDTO;
import pl.coderslab.DTO.CategoryDTO;
import pl.coderslab.Service.ServiceDTO.ArticleServiceDTO;
import pl.coderslab.Service.ServiceDTO.AuthorServiceDTO;
import pl.coderslab.Service.ServiceDTO.CategoryServiceDTO;

@Controller
@RequestMapping("/articles")
public class ArticleController {

  private final ArticleServiceDTO articleServic;
  private final AuthorServiceDTO authorService;
  private final CategoryServiceDTO categoryService;

  @Autowired
  public ArticleController(
      ArticleServiceDTO articleServic,
      AuthorServiceDTO authorService,
      CategoryServiceDTO categoryService) {
    this.articleServic = articleServic;
    this.authorService = authorService;
    this.categoryService = categoryService;
  }

  @RequestMapping(path = "", method = RequestMethod.GET)
  public String showArticles() {

    return "articlesList";
  }
  
  @RequestMapping(path = "/add", method = RequestMethod.GET)
  public String addNewArticle() {

    return "***";
  }

  
  
  
  @ModelAttribute("articles")
  public Collection<ArticleDTO> getAllArticles() {

    return articleServic.getAllArticles();
  }

  @ModelAttribute("authors")
  private Collection<AuthorDTO> getAuthors() {
    return authorService.getAuthors();
  }

  @ModelAttribute("categories")
  private Collection<CategoryDTO> getCategories() {
    return categoryService.getCategoryList();
  }
}
