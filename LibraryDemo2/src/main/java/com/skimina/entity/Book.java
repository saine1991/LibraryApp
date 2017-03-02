package com.skimina.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 255, message = "Podaj dlugosc od {min} do {max}")
    private String author;

    @NotNull
    @Length(min = 3, max = 255)
    private String title;

    @Min(0)
    private Integer available;

    public Book() {
    }

    public Book(String author, String title, Integer available) {
        this.author = author;
        this.title = title;
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public void decrementQuantity() {
        available--;
    }

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", available=" + available + "]";
	}
    
}
