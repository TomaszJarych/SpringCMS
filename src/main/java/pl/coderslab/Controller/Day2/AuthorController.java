package pl.coderslab.Controller.Day2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.DTO.AuthorDTO;
import pl.coderslab.Service.ServiceDTO.AuthorServiceDTO;

@Controller
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorServiceDTO authorServiceDTO;

  @Autowired
  public AuthorController(AuthorServiceDTO authorServiceDTO) {
    this.authorServiceDTO = authorServiceDTO;
  }

  @RequestMapping(path = "/list", method = RequestMethod.GET)
  public String showAuthorsList() {

    return "authors";
  }

  @RequestMapping(path = "/add", method = RequestMethod.GET)
  public String addAuthorForm(Model model) {

    model.addAttribute("author", new AuthorDTO());

    return "authorForm";
  }

  @RequestMapping(path = "/add", method = RequestMethod.POST)
  public String processAddForm(@ModelAttribute("author") AuthorDTO dto) {

    authorServiceDTO.addAuthor(dto);

    return "redirect:/authors/list";
  }
  
  @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
  public String updateAuthorForm(@PathVariable("id")Long id, Model model) {
      
      model.addAttribute("author", authorServiceDTO.getAuthorByID(id));
      
      return "authorForm";

  }
  
  @RequestMapping(path = "/update/**", method = RequestMethod.POST)
  public String updateAuthorForm(@ModelAttribute("author") AuthorDTO dto) {

      authorServiceDTO.updateAuthor(dto);
      
    return "redirect:/authors/list";
  }

  @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
  public String deleteAuthor(@PathVariable("id")Long id) {
      
      
      authorServiceDTO.deleteAuthor(id);
      
      return "redirect:/authors/list";
      
  }

  @ModelAttribute("authors")
  private Collection<AuthorDTO> getAuthors() {
    return authorServiceDTO.getAuthors();
  }
}
