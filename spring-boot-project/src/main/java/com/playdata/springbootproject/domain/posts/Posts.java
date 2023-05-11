package com.playdata.springbootproject.domain.posts;

import com.playdata.springbootproject.domain.AuditingEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends AuditingEntity {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id; // BIGINT
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;
    @Column(nullable = false)
    private String climbing_mountain;
    private Date climbing_date;
    @Builder
    public Posts(String title, String content, String author, String climbing_mountain, Date climbing_date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.climbing_mountain=climbing_mountain;
        this.climbing_date=climbing_date;
    }

    public void update(String title, String content, String climbing_mountain, Date climbing_date) {
        this.title = title;
        this.content = content;
        this.climbing_mountain=climbing_mountain;
        this.climbing_date=climbing_date;
    }
}
