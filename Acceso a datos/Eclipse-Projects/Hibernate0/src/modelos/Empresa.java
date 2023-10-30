package modelos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="persona")
public class Empresa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="nombre", length=45)
    private String nombre;

    @Column(name="direccion")
    private String direccion;

    @ManyToMany
    @JoinTable(name="persona_empresa", joinColumns = {@JoinColumn(name ="empresa_id")},
            inverseJoinColumns = {@JoinColumn(name ="persona_id")}
    )
    private List<Persona> personas;

    public int getId_persona() {
        return id;
    }

    public void setId_persona(int id_persona) {
        this.id = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Empresa(int id_persona, String nombre, String direccion) {
        this.id = id_persona;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public Empresa() {

    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id_persona=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }


}
