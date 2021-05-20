package com.example.writereadrecyclerview;

public class person {
    String username,email,password;

    public person(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public person() {
    }

    public String getUsername() {
        return username;
    }



    public String getEmail() {
        return email;
    }



    public String getPassword() {
        return password;
    }

}
