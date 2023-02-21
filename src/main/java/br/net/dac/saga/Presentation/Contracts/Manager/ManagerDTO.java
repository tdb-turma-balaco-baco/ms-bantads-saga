package br.net.dac.saga.Presentation.Contracts.Manager;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class ManagerDTO {
    private Long id;
    @NotEmpty
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2})")
    private String cpf;
    @Pattern(regexp = "^[(][0-9]{2}[)][\s]?[0-9]{5,6}[-][0-9]{4}$")
    private String phone;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
