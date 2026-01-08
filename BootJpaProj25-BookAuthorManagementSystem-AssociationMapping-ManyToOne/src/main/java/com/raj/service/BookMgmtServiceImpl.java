package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Author;
import com.raj.entity.Book;
import com.raj.repository.IAuthorRepository;
import com.raj.repository.IBookRepository;

@Service
public class BookMgmtServiceImpl implements IBookMgmtService {

	@Autowired
	private IBookRepository bookRepo;
	
	@Autowired
    private IAuthorRepository authorRepo;
	
	@Override
	public String addBook(Book book) {
		
		Integer bid = bookRepo.save(book).getBid();
		return "Book is added with Book ID: "+bid;
	}

	@Override
	public List<Book> showAllBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public String deleteBookById(int id) {
		
		bookRepo.deleteById(id);
		return "BOOK ID: "+id +" Book is deleted.";
	}

	@Override
	public Author saveAuthor(Author author) {
		
		 return authorRepo.save(author);
	}
}
