/*package com.example.Lab9.controllers;

import com.example.Lab9.models.Book;
import com.example.Lab9.repo.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChartController {

    private final BookRepository bookRepository;

    public ChartController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/chart")
    public String chart(Model model) {
        List<Book> books = bookRepository.findAll();
        Map<String, Integer> chartData = new LinkedHashMap<>();
        for (Book book : books) {
            String issueDate = book.getIssueDate();
            System.out.println(issueDate);
            chartData.putIfAbsent(issueDate, 0);
            chartData.put(issueDate, chartData.get(issueDate) + 1);
        }
        System.out.println(chartData);

        model.addAttribute("chartData", chartData);
        return "chart";
    }
}*/
