package com.testbackend.apicrud.person;

import jakarta.persistence.*;

@Entity
public class Client extends Person {
    private Integer clientId;
    private String password;
    private Boolean estado;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
