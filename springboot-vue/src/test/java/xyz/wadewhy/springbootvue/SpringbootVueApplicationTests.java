package xyz.wadewhy.springbootvue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import xyz.wadewhy.springbootvue.dao.BookDao;
import xyz.wadewhy.springbootvue.pojo.Book;

@SpringBootTest
class SpringbootVueApplicationTests {
@Autowired
private BookDao bookDao;
    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0, 6);

     Page<Book> page=   bookDao.findAll(pageRequest);

    }

}
