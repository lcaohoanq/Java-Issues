package com.lcaohoanq.advanced.orm.associations.src.main.java.many_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create authors
        Author author1 = new Author("Author One");
        Author author2 = new Author("Author Two");

        // Create books
        Book book1 = new Book("Book One");
        Book book2 = new Book("Book Two");

        // Set up relationships
        book1.getAuthors().add(author1);
        book1.getAuthors().add(author2);
        book2.getAuthors().add(author1);

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author2.getBooks().add(book1);

        // Persist authors (and books via cascade)
        em.persist(author1);
        em.persist(author2);

        em.getTransaction().commit();

        // Fetch and print data
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        for (Book book : query.getResultList()) {
            System.out.println("Book: " + book.getTitle());
            for (Author author : book.getAuthors()) {
                System.out.println("  Author: " + author.getName());
            }
        }

        em.close();
        emf.close();
    }
}

