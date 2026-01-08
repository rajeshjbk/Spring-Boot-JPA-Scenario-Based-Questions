package com.raj.service;

import java.util.List;

import com.raj.entity.Author;
import com.raj.entity.Book;

public interface IBookMgmtService {

	Author saveAuthor(Author author);
	
	String addBook(Book book);
	List<Book> showAllBooks();
	String deleteBookById(Integer id);
}
