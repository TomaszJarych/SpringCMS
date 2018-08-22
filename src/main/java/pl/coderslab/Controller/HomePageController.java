package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.ArticleService;
import pl.coderslab.Service.CategoryService;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

@Controller
public class HomePageController {

    private final ArticleService service;
    private final CategoryService categoryService;

    public HomePageController(ArticleService service, CategoryService categoryService) {
	this.service = service;
	this.categoryService = categoryService;
    }

    @PostMapping("/addArticle")
    @ResponseBody
    public String addAtricle() {
	Category category = new Category("programming", "IT Stuff");
	Category category2 = new Category("Advanced programming", "IT better stuff");
	Author author = new Author("Jan", "Kowalski");
	Article article = new Article("Regex", "Very boring stuff");

	article.addCategory(category);
	article.addCategory(category2);
	article.setAuthor(author);

	service.addArticle(article);

	return "Dodano artykuł";
    }
   
    @GetMapping("/articles")
    public String getArticlesList(Model model) {
	model.addAttribute("list", service.getList());
	model.addAttribute("categoires", categoryService.getCategoryList());
	return"articles";
	
    }
    @GetMapping("/articlesByCategory/{id}")
    public String getArticlesByCategory(@PathVariable("id")Long id, Model model) {
	model.addAttribute("list", service.getListByCategory(id));
	return "articles";
    } 
    
    @GetMapping("/articlesById/{id}")
    public String getArticlesByID(@PathVariable("id")Long id, Model model) {
	model.addAttribute("article", service.getArticleByID(id));
	return "articleDetail";
    }
    
    @GetMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id")Long id) {
	Article article = service.getArticleByID(id);
	service.deleteArticle(article);
	return "forward:/articles";
    } 

}
