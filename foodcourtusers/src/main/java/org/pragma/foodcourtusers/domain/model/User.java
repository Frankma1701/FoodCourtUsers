package org.pragma.foodcourtusers.domain.model;

import java.time.LocalDate;


public class User {

    private Long id;
    private String name;
    private String lastName;
    private String documentId;

    private String cellPhoneNumber;

    private LocalDate birthDate;
    private String email;
    private String password;
    private Long roleId;

    public User(Long id, String name, String lastName, String documentId, String cellPhoneNumber, LocalDate birthDate, String email, String password, Long roleId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentId = documentId;
        this.cellPhoneNumber = cellPhoneNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
