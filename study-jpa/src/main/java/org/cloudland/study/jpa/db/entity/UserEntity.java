package org.cloudland.study.jpa.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "T_USER")
public class UserEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id", nullable = true, length = 32, unique = true)
    private String id;

    @Column(name = "user_name", nullable = true, length = 32, unique = true)
    private String name;

    @Column(name = "user_age", nullable = true)
    private int age;

    @Column(name = "create_time", nullable = true, length = 32)
    private Date createTime;

    public UserEntity(String id, String name, int age, Date createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createTime = createTime;
    }
}
