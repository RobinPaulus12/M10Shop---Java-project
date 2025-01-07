package com.spring.henallux.javaProjectB3.model;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.validation.constraints.*;
import java.time.LocalDate;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private Integer id;

    @Email
    @NotBlank
    private String email;

    @Size(min=4, max=30)
    @NotBlank
    private String username;

    @Size(min=8, max=72)
    @NotBlank
    private String password;

    @Transient
    private String confirmPassword;

    @Transient
    private String currentPassword;

    @Transient
    @Size(min = 8, max = 72)
    private String newPassword;

    @Transient
    private String confirmNewPassword;

    @Size(min=2, max=50)
    @NotBlank
    private String firstName;

    @Size(min=2, max=50)
    @NotBlank
    private String lastName;

    @Past
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    @NotNull
    private java.util.Date dateOfBirth;

    @Nullable
    @Size(min = 6, max = 15)
    @Pattern(regexp = "^[+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
    private String telephone;

    @Size(min=15, max=255)
    @NotBlank
    private String address;

    private String authorities;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    @Min(value = 0)
    private Double totalInvoice;

    public User(Integer id, String email, String username, String password, String firstName, String lastName, java.util.Date dateOfBirth, String telephone, String address, String authorities, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.address = address;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public User() {
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (authorities != null && !authorities.isEmpty()) {
            String[] authoritiesAsArray = authorities.split(",");

            for (String authority : authoritiesAsArray) {
                if (authority != null && !authority.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }
        return grantedAuthorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail () {
            return email;
        }

    public void setEmail (String email){
        this.email = email;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username){
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public String getConfirmPassword() {
    return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName){
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName){
        this.lastName = lastName;
    }

    public java.util.Date getDateOfBirth () {
        return dateOfBirth;
    }

    public void setDateOfBirth (java.util.Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone () {
        return telephone;
    }

    public void setTelephone (String telephone){
        this.telephone = telephone;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address){
        this.address = address;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }


    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    // methode test
    public void totalInvoices(Double totalInvoice) {
        this.totalInvoice = totalInvoice;
    }
    }
