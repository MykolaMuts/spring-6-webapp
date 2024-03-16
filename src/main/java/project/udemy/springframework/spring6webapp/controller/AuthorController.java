package project.udemy.springframework.spring6webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.udemy.springframework.spring6webapp.service.AuthorService;

@Controller
public class AuthorController {

    public final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors",authorService.findAll());

        return "authors";
    }
}
