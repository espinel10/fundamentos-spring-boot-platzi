package com.fundamentosplatzi.springboot.fundamentos.entity;


import javax.persistence.*;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post" , nullable = false , unique = true)
    private Long ig;
    @Column(name = "description",length = 255)
    private String description;

    @ManyToOne
    private User user;

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "ig=" + ig +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getIg() {
        return ig;
    }

    public void setIg(Long ig) {
        this.ig = ig;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }
}
