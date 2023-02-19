package br.net.dac.saga.Presentation.Contracts.Client;

import jakarta.validation.constraints.NotEmpty;

public class AddressDTO {
    @NotEmpty
    private String type;
    @NotEmpty
    private String street;
    @NotEmpty
    private String number;
    
    private String complement;
    @NotEmpty
    private String cep;
    @NotEmpty
    private String city;
    @NotEmpty
    private String state;
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    
}

