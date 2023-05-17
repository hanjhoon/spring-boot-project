package com.playdata.springbootproject.domain.hikers;
import com.playdata.springbootproject.domain.AuditingEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Hikers extends AuditingEntity {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id; // BIGINT
    private String userid;
    private String pw;
    private String firstname;
    private String lastname;
    private String ssn;
    private Integer age;
    private String sex;
    private String phone;

    @Builder
    public Hikers(Long id, String userid, String pw, String firstname, String lastname, String ssn, Integer age, String sex, String phone) {
        this.id=id;
        this.userid=userid;
        this.pw = pw;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }

    public void update(String pw, String firstname, String lastname, Integer age, String sex, String phone) {
        this.pw = pw;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }
}