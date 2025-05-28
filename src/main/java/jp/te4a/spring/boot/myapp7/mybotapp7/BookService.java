package jp.te4a.spring.boot.myapp7.mybotapp7;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class BookService {
 @Autowired
 BookRepository bookRepository;
 public BookBean save(BookBean bookBean) {
    return bookRepository.save(bookBean);
    }
    public List<BookBean> findAll() {
    return bookRepository.findAll();
    }
   }