package br.net.dac.saga.Presentation.Contracts.Client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ClientDTO {
    
    @NotEmpty
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2})")
    private String cpf;

    @Pattern(regexp = "^[(][0-9]{2}[)][\s]?[0-9]{5,6}[-][0-9]{4}$")
    private String phone;

    @Min(1)
    private Double wage;

    @NotNull
    @Valid
    private AddressDTO address;
    
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

    public AddressDTO getAddress() {
        return address;
    }
    public void setAddress(AddressDTO address) {
        this.address = address;
    }
    public Double getWage() {
        return wage;
    }
    public void setWage(Double wage) {
        this.wage = wage;
    }

    
}
