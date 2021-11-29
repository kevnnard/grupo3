package com.turimstransac.turismo.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Plan {
    @Id
    private String planname;
    private String descripcion;
    private String lugar;
    private Integer precio;
    private  Date fecha;

    public Plan(String planname, String descripcion, String lugar, Integer precio, Date fecha) {
        this.planname = planname;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
