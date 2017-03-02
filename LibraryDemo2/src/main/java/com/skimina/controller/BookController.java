package com.skimina.controller;

import com.skimina.entity.Book;
import com.skimina.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class BookController {
    
   @Autowired
   private BookService  bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooksPage(Model model) {

        List<Book> bookList = bookService.findAll();

        model.addAttribute("bookList", bookList);

        return "books";
    }

    @RequestMapping(value = "/book/create", method = RequestMethod.GET)
    public String getCreateBookForm(Model model) {

        model.addAttribute("book", new Book());

        return "book-create";
    }

    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public String getEditBookForm(Model model, @PathVariable Long id) {

        Book book = bookService.findOne(id);

        model.addAttribute("book", book);

        return "book-create"; 
    }

    @RequestMapping(value = "/book/save", method = RequestMethod.POST)
    public String postCreateBook(@ModelAttribute @Valid Book book, BindingResult result) {

        if (result.hasErrors()) {
            return "book-create";
        }

        bookService.save(book);

        return "redirect:/books"; 
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.POST)
    public String postDeleteBook(@PathVariable Long id) {

    	bookService.delete(id);

        return "redirect:/books";  
    }

    
}
