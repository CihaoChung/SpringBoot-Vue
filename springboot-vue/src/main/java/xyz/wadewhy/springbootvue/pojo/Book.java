package xyz.wadewhy.springbootvue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springbootvue.pojo
 * @NAME: Book
 * @Author: 钟子豪
 * @DATE: 2020/3/24
 * @MONTH_NAME_FULL: 三月
 * @DAY: 24
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: springboot-vue
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    //@Id表示主键
    //@GeneratedValue(strategy = GenerationType.IDENTITY)自动增长
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Double price;
//    private Integer bookcaseid;
//    private Integer abled;
}
