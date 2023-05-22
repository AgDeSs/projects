package com.example.Lab9.repo;

import com.example.Lab9.models.Book;
import com.example.Lab9.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT COUNT(b) FROM Book b ORDER BY b.issueDate")
    long countByOrderByIssueDate();

    List<Book> findByTitleContaining(String title);

    List<Book> findByPublisherContaining(String publisher);

    List<Book> findByIssueDate(String issueDate);

    List<Book> findByStudentNameContaining(String studentName);

    List<Book> findByDeliveryDate(String deliveryDate);
}
