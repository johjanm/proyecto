package com.jhojanmartinez.proyecto.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 60)
    private String name;
    private String surname;
    private int age;
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;
    private Boolean enabled;
    private long phone;
    @Column(name = "address", nullable = false, length = 50, unique = true)
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public long getPhone() {return phone;}

    public void setPhone(long phone) {this.phone = phone;}

    public String getAddress() {return address;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public void setAddress(String address) {this.address = address;}

}
