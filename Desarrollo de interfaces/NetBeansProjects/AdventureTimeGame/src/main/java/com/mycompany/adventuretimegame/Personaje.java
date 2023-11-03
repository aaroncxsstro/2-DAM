package com.mycompany.adventuretimegame;

import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Personaje {
    
    private String nombre;

    private boolean j1;
    
    private Image sprite;

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
            break;
        case "jake": 
            this.setVida(3);
            this.setAtaque(4);
            break;          
        case "gunter": 
            this.setVida(3);
            this.setAtaque(4);
            break; 
        case "llama":
            this.setVida(2);
            this.setAtaque(5);
            break; 
        case "marceline":
            this.setVida(5);
            this.setAtaque(4);
            break;         
        case "reyHielo":
            this.setVida(2);
            this.setAtaque(3);
            break;             
        case "limoncio":
            this.setVida(1);
            this.setAtaque(3);
            break;      
            
        case "cake":
            this.setVida(4);
            this.setAtaque(3);
            break;   
            
        case "menta":
            this.setVida(4);
            this.setAtaque(2);
            break;             
                }
    }
    

    }

