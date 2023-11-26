package Modelos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id", nullable = false)
    private int genero_id;

    @Column(name = "nombre", length = 40)
    private String nombre;

    public Genero(int genero_id, String nombre) {
        this.genero_id = genero_id;
        this.nombre = nombre;
    }

    public Genero() {

    }

    public int getGenero_id() {
        return genero_id;
    }
    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}