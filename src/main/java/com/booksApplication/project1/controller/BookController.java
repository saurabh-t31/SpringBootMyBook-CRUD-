package com.booksApplication.project1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.booksApplication.project1.entity.Book;
import com.booksApplication.project1.entity.myBooks;
import com.booksApplication.project1.service.BookService;
import com.booksApplication.project1.service.MyBookService;

@Controller
public class BookController {

@Autowired
private BookService service;

@Autowired
private MyBookService myBookService;

    @GetMapping("/")
    public String home(){
      return "home";
    }

    @GetMapping("/bookregister")
    public String bookRegister(){

      return "bookRegister";
    }

    @GetMapping("/avalaible_books")
    public ModelAndView BooksAvalaible(){
      List<Book> list = service.getAllBook();
        //  ModelAndView m = new ModelAndView();
        //  m.setViewName("booksAvalaible");
        //  m.addObject("book", list);
         return new ModelAndView("booksAvalaible","book",list);

    }

    @PostMapping("/save")

    //@ModelAttribute Book b binds form data from the request to an instance of the Book class. This means that if your form fields are named name, author, and price, these values are automatically set in the Book object.
    public String addBook (@ModelAttribute Book b){
  
        service.save(b);
        return "redirect:/avalaible_books";
        /*
        This indicates a redirect to the client (browser). Spring tells the browser to make a new request to /avalaible_books. This results in a new HTTP request being made, and the URL in the browser changes to /avalaible_books.
        It's commonly used after processing forms, so the browser doesn't resubmit the form when refreshed (Post/Redirect/Get pattern).
        If you want the user to be redirected to another URL (i.e., the browser's URL should change), you should use redirect:/avalaible_books. If you just want to render a specific view without changing the URL, use return "/avalaible_books";. 
        */
    }

    @GetMapping("/booklist")
    public ModelAndView getmyBooks(){
    
    List<myBooks> ls = myBookService.getallmybooks( );               
    return new ModelAndView("myBooks","book",ls);

    }

    @RequestMapping("/myList/{id}")
    public String addToMyList(@PathVariable("id") int id) {
        // Retrieve the book by ID
        Book book = service.getBookById(id);

        // Create a new myBooks instance
        myBooks myBooks = new myBooks();
        myBooks.setID(book.getID());
        myBooks.setName(book.getName());
        myBooks.setAuthor(book.getAuthor());
        myBooks.setPrice(book.getPrice());

        // Save the myBooks instance
        myBookService.saveMybook(myBooks);

        // Redirect to the book list
        return "redirect:/booklist";
    }
    
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
     Book b = service.getBookById(id);
     model.addAttribute("book",b);
      return "bookEdit";
    }
    @RequestMapping("/deletebook/{id}")
    public String deletemybook(@PathVariable("id") int id ){
          service.deletemybook(id);
          return "redirect:/avalaible_books";
    }
}
