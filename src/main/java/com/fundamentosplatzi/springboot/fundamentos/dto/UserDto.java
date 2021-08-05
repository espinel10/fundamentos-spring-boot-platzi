package com.fundamentosplatzi.springboot.fundamentos.dto;

public class UserDto {
    private Long id;
    private String name;
    private String birthDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public UserDto(Long id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
