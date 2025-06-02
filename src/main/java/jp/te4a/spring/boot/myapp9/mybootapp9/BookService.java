package jp.te4a.spring.boot.myapp9.mybootapp9;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
   @Autowired
   BookRepository bookRepository;
   public void delete(Integer id) { 
      bookRepository.deleteById(id); 
   }
   public List<BookForm> findAll() {
      List<BookBean> beanList = bookRepository.findAllOrderByTitle();
      List<BookForm> formList = new ArrayList<>();
      for(BookBean bookBean: beanList) {
         BookForm bookForm = new BookForm();
         BeanUtils.copyProperties(bookBean, bookForm);
         formList.add(bookForm);
      }
      return formList;
   }
   public BookForm saveOrUpdate(BookForm bookForm) {
      BookBean bookBean = new BookBean();
      BeanUtils.copyProperties(bookForm, bookBean);
      bookRepository.save(bookBean);
      return bookForm;
  }
     
}