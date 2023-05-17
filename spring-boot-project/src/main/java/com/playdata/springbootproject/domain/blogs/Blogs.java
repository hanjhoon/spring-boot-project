package com.playdata.springbootproject.domain.blogs;
import com.playdata.springbootproject.domain.AuditingEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Blogs extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id; // BIGINT
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column
    private String userid;
    private String pmntnsn;

    @Builder
    public Blogs(String title, String content, String userid, String pmntnsn) {
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.pmntnsn = pmntnsn;
    }

    public void update(String title, String content, String userid, String pmntnsn) {
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.pmntnsn = pmntnsn;
    }
}