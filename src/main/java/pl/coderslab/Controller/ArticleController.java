package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.Service.ArticleService;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
@Controller
public class ArticleController {
    
    private final ArticleService service;

    public ArticleController(ArticleService service) {
	this.service = service;
    }
    
    @PostMapping("/addArticle")
    @ResponseBody
    public String addAtricle () {
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
    
    
}
