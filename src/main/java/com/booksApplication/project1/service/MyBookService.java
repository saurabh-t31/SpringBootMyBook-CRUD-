package com.booksApplication.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksApplication.project1.entity.myBooks;
import com.booksApplication.project1.repository.MyBookRepo;

@Service
public class MyBookService {
    
    @Autowired
    private MyBookRepo repo ;

    public void saveMybook(myBooks book){
        
           repo.save(book);

    }
    public List<myBooks> getallmybooks(){
         List<myBooks> mb = repo.findAll();
        return mb;
    }
    public void deletemybook(int id){
        repo.deleteById(id);
        return ;
    }

}
