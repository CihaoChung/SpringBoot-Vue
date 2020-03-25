package xyz.wadewhy.springbootvue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import xyz.wadewhy.springbootvue.dao.BookDao;
import xyz.wadewhy.springbootvue.pojo.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springbootvue.controller
 * @NAME: BookController
 * @Author: 钟子豪
 * @DATE: 2020/3/24
 * @MONTH_NAME_FULL: 三月
 * @DAY: 24
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: springboot-vue
 **/
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size
    ){
        PageRequest pageRequest= PageRequest.of(page, size);
      return  bookDao.findAll(pageRequest);
    }
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody Book book){
        Book result = bookDao.save(book);
        Map<String,Object> ret = new HashMap<>();
        if (result!=null){
            ret.put("code", "success");
            ret.put("msg", "添加成功!");
        }else {
            ret.put("code", "error");
            ret.put("msg", "添加失败!");
        }
        return ret;
    }
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        //.get
        return  bookDao.findById(id).get();
    }
    @PutMapping("/update")
    public Map<String,Object> update(@RequestBody Book book){
        Book result = bookDao.save(book);
        Map<String,Object> ret = new HashMap<>();
        if (result!=null){
            ret.put("code", "success");
            ret.put("msg", "修改成功!");
        }else {
            ret.put("code", "error");
            ret.put("msg", "修改失败!");
        }
        return ret;
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookDao.deleteById(id);
    }
}
