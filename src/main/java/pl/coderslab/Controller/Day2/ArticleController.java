package pl.coderslab.Controller.Day2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

  private final ArticleServiceDTO articleService;
  private final AuthorServiceDTO authorService;
  private final CategoryServiceDTO categoryService;

  @Autowired
  public ArticleController(
      ArticleServiceDTO articleServic,
      AuthorServiceDTO authorService,
      CategoryServiceDTO categoryService) {
    this.articleService = articleServic;
    this.authorService = authorService;
    this.categoryService = categoryService;
  }

  @RequestMapping(path = "", method = RequestMethod.GET)
  public String showArticles() {

    return "articlesList";
  }
  
  @RequestMapping(path = "/add", method = RequestMethod.GET)
  public String addNewArticle(Model model) {
      
      model.addAttribute("article", new ArticleDTO());

    return "articleForm";
  }
  
  @RequestMapping(path="/add", method=RequestMethod.POST)
  public String processArticleForm(@ModelAttribute("article")ArticleDTO dto) {
      
      articleService.addArticle(dto);
      
      return "redirect:/articles";
  }
  
  @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
  public String editArticle(@PathVariable("id")Long id, Model model) {
      
      model.addAttribute("article", articleService.getArticleByID(id));

    return "articleForm";
  }
  
  @RequestMapping(path="/update/**", method=RequestMethod.POST)
  public String processUpdateArticleForm(@ModelAttribute("article")ArticleDTO dto) {
      
      articleService.updateArticle(dto);
      
      return "redirect:/articles";
  }
  
  @RequestMapping(path="/delete/{id}", method=RequestMethod.GET)
  public String deleteArticle(@PathVariable("id")Long id) {
      
      articleService.deleteArticle(id);
      
      return "redirect:/articles";
  }

  
  
  
  @ModelAttribute("articles")
  public Collection<ArticleDTO> getAllArticles() {

    return articleService.getAllArticles();
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