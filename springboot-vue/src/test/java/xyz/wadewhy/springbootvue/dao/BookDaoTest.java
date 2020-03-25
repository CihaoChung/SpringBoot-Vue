package xyz.wadewhy.springbootvue.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Test
    void finAll() {
        System.err.println(bookDao.findAll());
    }
}