package com.example.Lab9.controllers;

import com.example.Lab9.models.Book;
import com.example.Lab9.models.Language;
import com.example.Lab9.models.SearchOptions;
import com.example.Lab9.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BookController {

    public static String lang = "Russian";
    @Autowired
    private BookRepository bookRepository;

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

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String buttonSortEng = "Sorting";
        String buttonDetailsEng = "Details";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarSettingsRus = "Настройки";
        String navbarHistRus = "Гистограмма";
        String buttonSortRus = "Сортировка";
        String buttonDetailsRus = "Детальнее";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("buttonSort", buttonSortRus);
            model.addAttribute("buttonDetails", buttonDetailsRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("buttonSort", buttonSortEng);
            model.addAttribute("buttonDetails", buttonDetailsEng);
        }

        model.addAttribute("chartData", chartData);
        return "chart";
    }

    @GetMapping("/")
    public String bookMain(Model model) {

        Iterable<Book> books = bookRepository.findAll();

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String buttonSortEng = "Sorting";
        String buttonDetailsEng = "Details";
        String labelNameEng = "Books";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarSettingsRus = "Настройки";
        String navbarHistRus = "Гистограмма";
        String buttonSortRus = "Сортировка";
        String buttonDetailsRus = "Детальнее";
        String labelNameRus = "Книги";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("buttonSort", buttonSortRus);
            model.addAttribute("buttonDetails", buttonDetailsRus);
            model.addAttribute("labelName", labelNameRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("buttonSort", buttonSortEng);
            model.addAttribute("buttonDetails", buttonDetailsEng);
            model.addAttribute("labelName", labelNameEng);
        }
        model.addAttribute("books", books);
        return "book-main";
    }

    @GetMapping("/add")
    public String bookAdd(Model model) {

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String labelNameEng = "Add book";
        String buttonAddEng = "Add book";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarHistRus = "Гистограмма";
        String navbarSettingsRus = "Настройки";
        String labelNameRus = "Добавление книги";
        String buttonAddRus = "Добавить книгу";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("labelName", labelNameRus);
            model.addAttribute("buttonAdd", buttonAddRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("labelName", labelNameEng);
            model.addAttribute("buttonAdd", buttonAddEng);
        }

        return "book-add";
    }

    @PostMapping("/add")
    public String bookPostAdd(@ModelAttribute("Language") Language language,
                              @RequestParam String title,
                              @RequestParam String publisher,
                              @RequestParam String issueDate,
                              @RequestParam String studentName,
                              @RequestParam String deliveryDate,
                              Model model) {
        Book book = new Book(title, publisher, issueDate, studentName, deliveryDate);
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String bookDetails(@PathVariable(value = "id") Long id, Model model) {
        if(!bookRepository.existsById(id)) {
            return "redirect:/";
        }
        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String buttonSortEng = "Sorting";
        String buttonDetailsEng = "Details";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarHistRus = "Гистограмма";
        String navbarSettingsRus = "Настройки";
        String buttonSortRus = "Сортировка";
        String buttonDetailsRus = "Детальнее";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("buttonSort", buttonSortRus);
            model.addAttribute("buttonDetails", buttonDetailsRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("buttonSort", buttonSortEng);
            model.addAttribute("buttonDetails", buttonDetailsEng);
        }

        return "book-details";
    }

    @GetMapping("/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") Long id, Model model) {
        if(!bookRepository.existsById(id)) {
            return "redirect:/";
        }
        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String buttonSortEng = "Sorting";
        String buttonDetailsEng = "Details";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarHistRus = "Гистограмма";
        String navbarSettingsRus = "Настройки";
        String buttonSortRus = "Сортировка";
        String buttonDetailsRus = "Детальнее";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("buttonSort", buttonSortRus);
            model.addAttribute("buttonDetails", buttonDetailsRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("buttonSort", buttonSortEng);
            model.addAttribute("buttonDetails", buttonDetailsEng);
        }

        return "book-edit";
    }

    @PostMapping("/{id}/edit")
    public String bookPostUpdate(@RequestParam String title,
                              @RequestParam String publisher,
                              @RequestParam String issueDate,
                              @RequestParam String studentName,
                              @RequestParam String deliveryDate,
                              Model model, @PathVariable(value = "id") Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setIssueDate(issueDate);
        book.setStudentName(studentName);
        book.setDeliveryDate(deliveryDate);
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String bookPostDelete(Model model, @PathVariable(value = "id") Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String bookSearch(Model model) {
        model.addAttribute("searchOptions", new SearchOptions());

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String changeFieldEng = "Select a field:";
        String changeValueEng = "Select a value:";
        String titleEng = "Title";
        String publisherEng = "Publisher";
        String issueDateEng = "Issue date";
        String studentNameEng = "Student name";
        String deliveryDateEng = "Delivery date";
        String buttonAddEng = "Search";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarHistRus = "Гистограмма";
        String navbarSettingsRus = "Настройки";
        String changeFieldRus = "Выберите поле:";
        String changeValueRus = "Напишите значение:";
        String titleRus = "Название";
        String publisherRus = "Издательство";
        String issueDateRus = "Дата выдачи";
        String studentNameRus = "Имя студента";
        String deliveryDateRus = "Дата сдачи";
        String buttonAddRus = "Поиск";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("changeField", changeFieldRus);
            model.addAttribute("changeValue", changeValueRus);
            model.addAttribute("title", titleRus);
            model.addAttribute("publisher", publisherRus);
            model.addAttribute("issueDate", issueDateRus);
            model.addAttribute("studentName", studentNameRus);
            model.addAttribute("deliveryDate", deliveryDateRus);
            model.addAttribute("buttonAdd", buttonAddRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("changeField", changeFieldEng);
            model.addAttribute("changeValue", changeValueEng);
            model.addAttribute("title", titleEng);
            model.addAttribute("publisher", publisherEng);
            model.addAttribute("issueDate", issueDateEng);
            model.addAttribute("studentName", studentNameEng);
            model.addAttribute("deliveryDate", deliveryDateEng);
            model.addAttribute("buttonAdd", buttonAddEng);
        }

        return "book-search";
    }

    @PostMapping("/search")
    public String bookPostSearch(@ModelAttribute("searchOptions") SearchOptions searchOptions, Model model) {
        List<Book> book;
        switch (searchOptions.getField()) {
            case "title":
                book = bookRepository.findByTitleContaining(searchOptions.getValue());
                break;
            case "publisher":
                book = bookRepository.findByPublisherContaining(searchOptions.getValue());
                break;
            case "issueDate":
                book = bookRepository.findByIssueDate(searchOptions.getValue());
                break;
            case "studentName":
                book = bookRepository.findByStudentNameContaining(searchOptions.getValue());
                break;
            case "deliveryDate":
                book = bookRepository.findByDeliveryDate(searchOptions.getValue());
                break;
            default:
                book = new ArrayList<>();
        }
        model.addAttribute("book", book);
        return "book-show";
    }

    @GetMapping("/sort")
    public String booksSort(Model model) {
        List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.ASC, "issueDate"));
        model.addAttribute("books", books);

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String buttonSortEng = "Sorting";
        String buttonDetailsEng = "Details";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarHistRus = "Гистограмма";
        String navbarSettingsRus = "Настройки";
        String buttonSortRus = "Сортировка";
        String buttonDetailsRus = "Детальнее";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("buttonSort", buttonSortRus);
            model.addAttribute("buttonDetails", buttonDetailsRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("buttonSort", buttonSortEng);
            model.addAttribute("buttonDetails", buttonDetailsEng);
        }

        return "book-main";
    }

    @GetMapping("/count")
    public String countBook(Model model) {
        long bookCount = bookRepository.countByOrderByIssueDate();
        model.addAttribute("bookCount", bookCount);

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String countRus = "Количество книг:";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarHistRus = "Гистограмма";
        String navbarSettingsRus = "Настройки";
        String countEng = "Number of books:";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("count", countRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("count", countEng);
        }

        return "book-count";
    }

    @PostMapping("/settings")
    public String changeLanguagePost(@ModelAttribute("Language") Language language, Model model) {
        switch (language.getLanguage()) {
            case "Russian":
                lang = language.getLanguage();
                break;
            case "English":
                lang = language.getLanguage();
                break;
            default:
                lang = language.getLanguage();
        }

        return "redirect:/";
    }

    @GetMapping("/settings")
    public String settingsGet(Model model) {

        String navbarBookEng = "Books";
        String navbarAddBookEng = "Add";
        String navbarSearchBookEng = "Search book";
        String navbarCountBooksEng = "Count books";
        String navbarHistEng = "Hist";
        String navbarSettingsEng = "Settings";
        String contentEn = "Library";
        String buttonSortEng = "Sorting";
        String buttonDetailsEng = "Details";

        String contentRus = "Библиотека";
        String navbarBookRus = "Книги";
        String navbarAddBookRus = "Добавить книгу";
        String navbarSearchBookRus = "Найти книгу";
        String navbarCountBooksRus = "Счетчик книг";
        String navbarHistRus = "Гистограмма";
        String navbarSettingsRus = "Настройки";
        String buttonSortRus = "Сортировка";
        String buttonDetailsRus = "Детальнее";

        if(lang.equals("Russian")) {
            model.addAttribute("content", contentRus);
            model.addAttribute("navbarBook", navbarBookRus);
            model.addAttribute("navbarAddBook", navbarAddBookRus);
            model.addAttribute("navbarSearchBook", navbarSearchBookRus);
            model.addAttribute("navbarCountBooks", navbarCountBooksRus);
            model.addAttribute("navbarHist", navbarHistRus);
            model.addAttribute("navbarSettings", navbarSettingsRus);
            model.addAttribute("buttonSort", buttonSortRus);
            model.addAttribute("buttonDetails", buttonDetailsRus);
        } else if (lang.equals("English")) {
            model.addAttribute("content", contentEn);
            model.addAttribute("navbarBook", navbarBookEng);
            model.addAttribute("navbarAddBook", navbarAddBookEng);
            model.addAttribute("navbarSearchBook", navbarSearchBookEng);
            model.addAttribute("navbarCountBooks", navbarCountBooksEng);
            model.addAttribute("navbarHist", navbarHistEng);
            model.addAttribute("navbarSettings", navbarSettingsEng);
            model.addAttribute("buttonSort", buttonSortEng);
            model.addAttribute("buttonDetails", buttonDetailsEng);
        }

        return "settings";
    }
}
