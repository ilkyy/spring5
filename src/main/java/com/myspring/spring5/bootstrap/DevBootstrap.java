package com.myspring.spring5.bootstrap;

import com.myspring.spring5.model.Author;
import com.myspring.spring5.model.Book;
import com.myspring.spring5.model.Publisher;
import com.myspring.spring5.repository.AuthorRepository;
import com.myspring.spring5.repository.BookRepository;
import com.myspring.spring5.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {



    public AuthorRepository authorRepository;

    public BookRepository bookRepository;

    public PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Author author1 = new Author("author1Name","author1lastName");

        Publisher publisher1 = new Publisher("book1Publisher","book1PublisherAdress");
        Book book1 = new Book("book1Name","book1Isbn",publisher1);
        //author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        publisherRepository.save(publisher1);
        authorRepository.save(author1);
        bookRepository.save(book1);


        Author author2 = new Author("author2Name","author2lastName");

        Publisher publisher2 = new Publisher("book2Publisher","book2PublisherAdress");
        Book book2 = new Book("book2Name","book2Isbn",publisher2);
        book2.getAuthors().add(author2);

        publisherRepository.save(publisher2);
        authorRepository.save(author2);
        bookRepository.save(book2);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
