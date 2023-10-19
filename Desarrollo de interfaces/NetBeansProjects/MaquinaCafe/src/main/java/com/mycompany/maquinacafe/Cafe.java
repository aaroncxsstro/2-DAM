/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maquinacafe;

 
public class Cafe {


    String tipoCafe;
    String tamañoCafe;
    double precio;
    int cantidad;

    public String getTipoCafe() {
        return tipoCafe;
    }

    public void setTipoCafe(String tipoCafe) {
        this.tipoCafe = tipoCafe;
    }

    public String getTamañoCafe() {
        return tamañoCafe;
    }

    public void setTamañoCafe(String tamañoCafe) {
        this.tamañoCafe = tamañoCafe;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cafe(String tipoCafe, String tamañoCafe, int cantidad) {
        this.tipoCafe = tipoCafe;
        this.tamañoCafe = tamañoCafe;
        this.cantidad = cantidad;
    }
    
    public void calcularPrecio(){
        switch (this.tamañoCafe){
            case "Pequeño": this.precio=0.50*this.cantidad; break;
            case "Mediano": this.precio=1.0*this.cantidad; break;
            case "Grande": this.precio=1.50*this.cantidad; break;
                
    }
    }
    
}
