package com.booksApplication.project1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String name;
    private String author;
    private String price;

    // public Book() {

    // }
    
    // public Book( String name, String author, String price) {
    //     this.name = name;
    //     this.author = author;
    //     this.price = price;
    // }

    
    // public int getID() {
    //     return ID;
    // }
    // public void setID(int ID) {
    //    this.ID = ID;
    // }
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public String getAuthor() {
    //     return author;
    // }
    // public void setAuthor(String author) {
    //     this.author = author;
    // }
    // public String getPrice() {
    //     return price;
    // }
    // public void setPrice(String price) {
    //     this.price = price;
    // }
   
}
