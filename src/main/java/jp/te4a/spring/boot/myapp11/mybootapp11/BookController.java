package jp.te4a.spring.boot.myapp11.mybootapp11;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;
    @ModelAttribute
    BookForm setUpForm() {
        return new BookForm();
    }
    @GetMapping
    String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }
    @PostMapping(path="create")
    String create(BookForm form, Model mode) {
        bookService.create(form);
        return "redirect:/books";
    }
    @PostMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id, BookForm form) {
        BookForm bookForm = bookService.findOne(id);
        BeanUtils.copyProperties(bookForm, form);
        return "books/edit";
    }
    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, BookForm form) {
        bookService.save(form);
        return "redirect:/books";
    }
    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        bookService.delete(id);
        return "redirect:/books";
    }
    @PostMapping(path = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/books";
    }
}