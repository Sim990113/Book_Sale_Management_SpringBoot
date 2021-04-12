package com.book.controller;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin //解决跨域问题
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findBooks")

    public List<Book> findBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/findBooks/{page}/{size}")

    public Page<Book> findBooks(@PathVariable("page")Integer page,@PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/addbook")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{book_id}")
    public Book findById(@PathVariable("book_id") Integer book_id){
        return bookRepository.findById(book_id).get();
    }


    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("deleteById/{book_id}")
    public void deleteById(@PathVariable("book_id") Integer book_id){
        bookRepository.deleteById(book_id);
    }

    @ResponseBody
    @GetMapping("/findNewBooks")
    public List<Book> findNewBooks(){
        return bookRepository.findNewBooks();
    }

    @ResponseBody
    @GetMapping("/findDayBooks/{day}")
    public List<Book> findDayBooks(@PathVariable("day") Integer day){
        return bookRepository.findDayBooks(day);
    }

    @ResponseBody
    @GetMapping("/findDayDiscountBooks/{day}")
    public List<Book> findDayDiscountBooks(@PathVariable("day") Integer day){
        return bookRepository.findDayDiscountBooks(day);
    }

    @ResponseBody
    @GetMapping("/findLowPrice")
    public List<Book> findLowPrice(){
        return bookRepository.findLowPrice();
    }

    @ResponseBody
    @GetMapping("/findHighBooks")
    public List<Book> findHighBooks(){
        return bookRepository.findHighBooks();
    }

    @ResponseBody
    @GetMapping("/findHotBooks")
    public List<Book> findHotBooks(){
        return bookRepository.findHotBooks();
    }

    @ResponseBody
    @GetMapping("/findEconomicHotBook")
    public List<Book> findEconomicHotBook(){
        return bookRepository.findEconomicHotBook();
    }

    @ResponseBody
    @GetMapping("/findLiteratureHotBook")
    public List<Book> findLiteratureHotBook(){
        return bookRepository.findLiteratureHotBook();
    }

    @ResponseBody
    @GetMapping("/findArtHotBook")
    public List<Book>  findArtHotBook(){
        return bookRepository. findArtHotBook();
    }

    @ResponseBody
    @GetMapping("/findHistoricHotBook")
    public List<Book> findHistoricHotBook(){
        return bookRepository.findHistoricHotBook();
    }

    @ResponseBody
    @GetMapping("/findByType/{book_type}")
    public List<Book> findByType(@PathVariable("book_type") String book_type){ return bookRepository.findByType(book_type); }

    @ResponseBody
    @GetMapping("/findByType_5/{book_type}")
    public List<Book> findByType_5(@PathVariable("book_type") String book_type){ return bookRepository.findByType_5(book_type); }

    @ResponseBody
    @GetMapping("/searchByAuthor/{name}")
    public List<Book> searchByAuthor(@PathVariable("name") String name){ return bookRepository.searchByAuthor(name); }

    @ResponseBody
    @GetMapping("/searchByName/{book_name}")
    public List<Book> searchByName(@PathVariable("book_name") String book_name){ return bookRepository.searchByName(book_name); }

    @ResponseBody
    @GetMapping("/searchByPublish/{name}")
    public List<Book> searchByPublish(@PathVariable("name") String name){ return bookRepository.searchByPublish(name); }

    @ResponseBody
    @GetMapping("/searchByAll/{name}")
    public List<Book> searchByAll(@PathVariable("name") String name){ return bookRepository.searchByAll(name); }

}