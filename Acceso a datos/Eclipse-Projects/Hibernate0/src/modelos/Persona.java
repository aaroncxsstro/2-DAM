package modelos;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id_persona;
    @Column(name="nombre", length=45)
    private String nombre;
    @Column(name="edad")
    private int edad;

    @ManyToMany(mappedBy = "personas")
    private List<Empresa> empresas;

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_persona=" + id_persona +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public Persona(int id_persona, String nombre, int edad) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Persona() {
    }

}
