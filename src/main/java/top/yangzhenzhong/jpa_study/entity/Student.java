package top.yangzhenzhong.jpa_study.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_student")
@Data  //为lombok  不用写
@Entity
public class Student {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
//    PS:@GeneratedValue注解的strategy属性提供四种值:
//            AUTO主键由程序控制, 是默认选项 ,不设置就是这个
//            IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
//            SEQUENCE 通过数据库的序列产生主键, MYSQL  不支持
//            Table 提供特定的数据库产生主键, 该方式更有利于数据库的移植
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    private String gender;

    private String studentNo;

    private String banji;

    private String telephone;

    private String email;

    private String state;

    private String infos;

    private Date createDate;

    private Date updateDate;

    private String idCard;
}
