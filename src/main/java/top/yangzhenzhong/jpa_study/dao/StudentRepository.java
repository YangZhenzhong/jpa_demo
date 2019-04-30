package top.yangzhenzhong.jpa_study.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import top.yangzhenzhong.jpa_study.entity.Student;

public interface StudentRepository  extends JpaRepository<Student,Integer> {


}
