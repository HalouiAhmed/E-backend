package com.ThinkIT.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class UserDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @NotBlank(message = "enter your name")
    private String fullName;
    @NotBlank
    @Email(message = "email not valid")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String email;
    @NotBlank
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    private boolean agreeToTermes;
    private String country;
    private String companyName;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ fullName: ").append(this.fullName).append(",\n  email: ").append(this.email)
                .append(",\n  password: ").append(this.password).append(",agreeToTerme").append(this.agreeToTermes).append(",coutry").append(this.country).append(" }");
        return sb.toString();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public boolean isAgreeToTermes() {
        return agreeToTermes;
    }

    public void setAgreeToTermes(boolean agreeToTermes) {
        this.agreeToTermes = agreeToTermes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
