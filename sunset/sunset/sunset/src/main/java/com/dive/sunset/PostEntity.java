package com.dive.sunset;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private int password;
    private int postcondition;


    // Getter, Setter 생략

    public String getTitle() {
        return title;
    }
    public int getPassword() {
        return password;
    }
    public String getContent() {
        return content;
    }
    public int getCondition() {
        return postcondition;
    }

    public int getPostId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCondition(int condition) {
        this.postcondition = condition;
    }
}
