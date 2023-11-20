package com.mycompany.adventuretimegame;

import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Personaje {
    
    private String nombre;

    private boolean j1;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isJ1() {
        return j1;
    }

    public void setJ1(boolean j1) {
        this.j1 = j1;
    }
    
    private Image sprite;

    private double tiempoAtaque;
    
    private int suerte;

    public int getSuerte() {
        return suerte;
    }

    public void setSuerte(int suerte) {
        this.suerte = suerte;
    }
    
    private double vidaTotal=1;

    public double getVidaTotal() {
        return vidaTotal;
    }

    public void setVidaTotal(double vidaTotal) {
        this.vidaTotal = vidaTotal;
    }

    public double getTiempoAtaque() {
        return tiempoAtaque;
    }

    public void setTiempoAtaque(double tiempoAtaque) {
        this.tiempoAtaque = tiempoAtaque;
    }
    
    private double tiempoSuper;

    public double getTiempoSuper() {
        return tiempoSuper;
    }

    public void setTiempoSuper(double tiempoSuper) {
        this.tiempoSuper = tiempoSuper;
    }

    public double getTiempoDashAtaque() {
        return tiempoDashAtaque;
    }

    public void setTiempoDashAtaque(double tiempoDashAtaque) {
        this.tiempoDashAtaque = tiempoDashAtaque;
    }

    public double getTiempoDashSuper() {
        return tiempoDashSuper;
    }

    public void setTiempoDashSuper(double tiempoDashSuper) {
        this.tiempoDashSuper = tiempoDashSuper;
    }
    
    private double tiempoDashAtaque;
    
    private double tiempoDashSuper;
        
    
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    private int vida;
    
    private int ataque;
   
    
    public Personaje(String nombre, boolean j1, Image sprite) {
        this.nombre = nombre;
        this.j1 = j1;
        this.sprite = sprite;
    }
    
    public void atributos(){
    
    switch(this.nombre){
        case "finn": 
            this.setVida(3);
            this.setAtaque(3);
            this.setSuerte(3);
            this.setTiempoAtaque(0.6);
            this.setTiempoSuper(0.9);
            this.setTiempoDashAtaque(1.7);
            this.setTiempoDashSuper(1.5);
            break;
        case "jake": 
            this.setVida(3);
            this.setAtaque(4);
             this.setSuerte(2);
            this.setTiempoAtaque(1);
            this.setTiempoSuper(1);
            this.setTiempoDashAtaque(1.5);
            this.setTiempoDashSuper(2.0);          
            break;          
        case "gunter": 
            this.setVida(3);
            this.setAtaque(4);
             this.setSuerte(2);
            this.setTiempoAtaque(1);
            this.setTiempoSuper(1.2);          
            this.setTiempoDashAtaque(2.0);
            this.setTiempoDashSuper(2.1);
            break; 
        case "llama":
            this.setVida(2);
            this.setAtaque(5);
             this.setSuerte(3);
            this.setTiempoAtaque(0.5);
            this.setTiempoSuper(1.6);
            this.setTiempoDashAtaque(2.3);
            this.setTiempoDashSuper(2.8);
            break; 
        case "marceline":
            this.setVida(5);
            this.setAtaque(4);
             this.setSuerte(1);
            this.setTiempoAtaque(0.8);
            this.setTiempoSuper(2.1);
            this.setTiempoDashAtaque(1.9);
            this.setTiempoDashSuper(2.8);
            break;         
        case "reyHielo":
            this.setVida(2);
            this.setAtaque(3);
             this.setSuerte(3);
            this.setTiempoAtaque(0.4);
            this.setTiempoSuper(0.9);
            this.setTiempoDashAtaque(1.2);
            this.setTiempoDashSuper(1.5);
            break;             
        case "limoncio":
            this.setVida(2);
            this.setAtaque(3);
             this.setSuerte(5);
            this.setTiempoAtaque(0.6);
            this.setTiempoSuper(0.6);
            this.setTiempoDashAtaque(1.1);
            this.setTiempoDashSuper(0.8);
            break;      
            
        case "cake":
            this.setVida(4);
            this.setAtaque(3);
             this.setSuerte(3);
            this.setTiempoAtaque(1.1);
            this.setTiempoSuper(1.8);
            this.setTiempoDashAtaque(1.7);
            this.setTiempoDashSuper(1.5);
            break;   
            
        case "menta":
            this.setVida(4);
            this.setAtaque(2);
             this.setSuerte(4);
            this.setTiempoAtaque(0.7);
            this.setTiempoSuper(0.6);
            this.setTiempoDashAtaque(1.2);
            this.setTiempoDashSuper(1.1);
            break;             
                }
    }
    

    }

