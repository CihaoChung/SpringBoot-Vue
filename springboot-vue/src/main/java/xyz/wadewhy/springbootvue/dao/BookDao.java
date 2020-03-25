package xyz.wadewhy.springbootvue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wadewhy.springbootvue.pojo.Book;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springbootvue.dao
 * @NAME: BookDao
 * @Author: 钟子豪
 * @DATE: 2020/3/24
 * @MONTH_NAME_FULL: 三月
 * @DAY: 24
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: springboot-vue
 **/
//JpaRepository<Book,Integer>第一个表示实体类的类型，第二个表示主键的类型
public interface BookDao  extends JpaRepository<Book,Integer> {

}
