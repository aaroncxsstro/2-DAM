package Modelos;

import javax.persistence.*;

@Entity
public class Autor {
    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor", nullable = false)
    private int id_autor;

    @Column(name = "nombre", length = 40)
    private String nombre;

    @Column(name = "nacionalidad", length = 40)
    private String nacionalidad;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
