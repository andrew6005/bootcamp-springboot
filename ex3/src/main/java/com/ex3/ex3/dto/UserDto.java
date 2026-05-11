package com.ex3.ex3.dto;

public class UserDto {

    private Long id;

    private String name;

    private String username;

    private String email;

    // Empty constructor
    public UserDto() {
    }

    // All arguments constructor
    public UserDto(Long id,
                   String name,
                   String username,
                   String email) {

        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    // Getter methods
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
