package com.playdata.springbootproject.domain.hikers;
import com.playdata.springbootproject.domain.AuditingEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Hikers extends AuditingEntity {
    @Id // PK
    private String id;
    private String pw;
    private String firstname;
    private String lastname;
    private String ssn;
    private int age;
    private String sex;
    private String phone;

    @Builder
    public Hikers(String id, String pw, String firstname, String lastname, String ssn, int age, String sex, String phone) {
        this.id=id;
        this.pw = pw;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }
    public void update(String pw, String firstname, String lastname, int age, String sex, String phone) {
        this.pw = pw;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
    }
}