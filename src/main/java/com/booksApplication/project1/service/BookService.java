package com.booksApplication.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksApplication.project1.entity.Book;
import com.booksApplication.project1.repository.BookRepoInterface;

@Service
public class BookService {
    @Autowired
    private BookRepoInterface repo ;
     
    public void save(Book b){
        repo.save(b) ;
    }

    public List<Book> getAllBook(){
        return repo.findAll();
    }

    public Book getBookById(int id){
        return repo.findById(id).get();
    }
    public void deletemybook(int id){
        repo.deleteById(id);
        return ;
    }
    
}
