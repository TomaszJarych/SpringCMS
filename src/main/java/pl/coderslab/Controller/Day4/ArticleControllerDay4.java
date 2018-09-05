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

import pl.coderslab.DTO.ArticleDTO;
import pl.coderslab.DTO.AuthorDTO;
import pl.coderslab.DTO.CategoryDTO;
import pl.coderslab.Service.Day4.ArticleServiceDay4;
import pl.coderslab.Service.Day4.AuthorServiceDay4;
import pl.coderslab.Service.Day4.CategoryServiceDay4;
import pl.coderslab.Service.ServiceDTO.ArticleServiceDTO;
import pl.coderslab.Service.ServiceDTO.AuthorServiceDTO;
import pl.coderslab.Service.ServiceDTO.CategoryServiceDTO;

@Controller
@RequestMapping("/day4/article")
public class ArticleControllerDay4 {

  private final ArticleServiceDay4 articleService;
  private final AuthorServiceDay4 authorService;
  private final CategoryServiceDay4 categoryService;

  @Autowired
  public ArticleControllerDay4(
      ArticleServiceDay4 articleServic,
      AuthorServiceDay4 authorService,
      CategoryServiceDay4 categoryService) {
    this.articleService = articleServic;
    this.authorService = authorService;
    this.categoryService = categoryService;
  }

  @RequestMapping(path = "/list", method = RequestMethod.GET)
  public String showArticles() {

    return "articlesList";
  }

  @RequestMapping(path = "/add", method = RequestMethod.GET)
  public String addNewArticle(Model model) {

    model.addAttribute("article", new ArticleDTO());

    return "articleForm";
  }

  @RequestMapping(path = "/add", method = RequestMethod.POST)
  public String processArticleForm(
      @Valid @ModelAttribute("article") ArticleDTO dto, BindingResult result) {

    if (result.hasErrors()) {

      return "articleForm";

    } else {
      articleService.addArticle(dto);
      return "redirect:/articles";
    }
  }

  @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
  public String editArticle(@PathVariable("id") Long id, Model model) {

    model.addAttribute("article", articleService.getArticleByID(id));

    return "articleForm";
  }

  @RequestMapping(path = "/update/**", method = RequestMethod.POST)
  public String processUpdateArticleForm(
      @Valid @ModelAttribute("article") ArticleDTO dto, BindingResult result) {
    if (result.hasErrors()) {

      return "articleForm";

    } else {
      articleService.updateArticle(dto);
      return "redirect:/articles";
    }
  }

  @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
  public String deleteArticle(@PathVariable("id") Long id) {

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
