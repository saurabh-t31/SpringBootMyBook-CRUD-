package com.booksApplication.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booksApplication.project1.entity.Book;

@Repository
public interface BookRepoInterface extends JpaRepository<Book,Integer> {
 
    

}
