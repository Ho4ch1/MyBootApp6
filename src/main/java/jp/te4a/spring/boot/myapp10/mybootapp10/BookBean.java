package jp.te4a.spring.boot.myapp10.mybootapp10;

import lombok.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
    @Id
    @GeneratedValue
    private Integer id ;
    @Column(nullable = false)
    private String title;
    private String writter;
    private String publisher;
    private Integer price;
}