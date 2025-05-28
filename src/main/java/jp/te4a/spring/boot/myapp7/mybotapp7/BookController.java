package jp.te4a.spring.boot.myapp7.mybotapp7;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @RequestMapping("books/list")
    public String index(Model model) {
        model.addAttribute("msg", "this is setting message");
        return "books/list";
    }
    @RequestMapping(value="books/list", method=RequestMethod.POST)
    public ModelAndView postForm(@RequestParam("id") String id, 
    @RequestParam("title") String title, @RequestParam("writter") String writter, 
    @RequestParam("publisher") String publisher, @RequestParam("price") String price) {
        ModelAndView mv = new ModelAndView("books/list");
        bookService.save(new BookBean(Integer.valueOf(id), title, writter, publisher, 
        Integer.valueOf(price)));
        mv.addObject("books", bookService.findAll());
        return mv;
    }
}