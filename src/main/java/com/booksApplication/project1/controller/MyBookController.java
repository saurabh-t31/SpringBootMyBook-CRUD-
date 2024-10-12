package com.booksApplication.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booksApplication.project1.service.MyBookService;

@Controller
public class MyBookController {
    
    @Autowired
    private MyBookService service;

    @RequestMapping("/deletemybook/{id}")
    public String deletemybook(@PathVariable("id") int id ){
          service.deletemybook(id);
          return "redirect:/booklist";
    }
}
