package com.booksApplication.project1.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booksApplication.project1.entity.myBooks;

@Repository
public interface MyBookRepo extends JpaRepository<myBooks,Integer>{
    

}
