package ro.mpp2025.domain;

import java.util.Stack;

public class Tourist extends Entity<Integer> {
    private String name;
    private String email;
    private String phone;

    public Tourist(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

