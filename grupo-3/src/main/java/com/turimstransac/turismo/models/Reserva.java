package com.turimstransac.turismo.models;

import org.springframework.data.annotation.Id;


public class Reserva {
    @Id
    private String id;
    private String idplan;

    public Reserva(String id, String idplan) {
        this.id = id;
        this.idplan = idplan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }
}
