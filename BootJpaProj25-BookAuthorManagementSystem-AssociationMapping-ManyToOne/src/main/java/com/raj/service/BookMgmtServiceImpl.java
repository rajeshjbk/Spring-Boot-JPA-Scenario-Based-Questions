package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Author;
import com.raj.entity.Book;
import com.raj.repository.IAuthorRepository;
import com.raj.repository.IBookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookMgmtServiceImpl implements IBookMgmtService {

	@Autowired
	private IBookRepository bookRepo;
	
	@Autowired
    private IAuthorRepository authorRepo;
	
	@Override
	public Author saveAuthor(Author author) {
		
		 return authorRepo.save(author);
	}
	
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
	@Transactional
    public String deleteBookById(Integer bookId) {

        // 1️. Get book
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Integer authorId = book.getAuthor().getAid();

        // 2️. Delete book
        bookRepo.deleteById(bookId);

        // 3️. Check remaining books of author
        long remainingBooks = bookRepo.countByAuthorAid(authorId);

        System.out.println("Remaining book: "+remainingBooks);
        // 4️. If no books left → delete author
        if (remainingBooks == 0) {
            
        	authorRepo.deleteById(authorId);
        	System.out.println("Book Id: "+bookId+" is deleted");
        	
            return "Author Also deleted as no books remain";  
            
        }else {
        	 return "Book Id: "+bookId+" is deleted";
        }
        
       
    }
	
}
