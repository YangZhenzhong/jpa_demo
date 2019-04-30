package top.yangzhenzhong.jpa_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.*;
import top.yangzhenzhong.jpa_study.controller.common.ResultEntity;
import top.yangzhenzhong.jpa_study.dao.StudentRepository;
import top.yangzhenzhong.jpa_study.entity.Student;
import top.yangzhenzhong.jpa_study.util.ResultUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping(value = "/user")
    public List<Student> getStudent(){
      List<Student> list =  studentRepository.findAll();
      return list;
    }
    @GetMapping(value = "/students")
    public ResultEntity<Page<Student>> pageStudent(@RequestParam(value="start",defaultValue="0") int start,
                                    @RequestParam(value = "size", defaultValue="3") int size){
        List<Order> orders=new ArrayList< Order>();
        orders.add( new Order(Sort.Direction. ASC, "banji"));
        orders.add( new Order(Sort.Direction. DESC, "id"));
        Pageable pageAble = new PageRequest(start,size,new Sort(orders));
        Page<Student> page= studentRepository.findAll(pageAble);
        return ResultUtil.success(page);
     }
    @GetMapping(value="/students/{id}")
    public ResultEntity<Student> getById(@PathVariable("id") Integer id){
        return ResultUtil.success(studentRepository.getOne(id));
    }
    @PostMapping(value="/students")
    public void addStudent(){
        Student s = new Student();
        s.setTelephone("15565605846");
        s.setEmail("156@qq.com");
        s.setBanji("2");
        studentRepository.save(s);
    }
}
