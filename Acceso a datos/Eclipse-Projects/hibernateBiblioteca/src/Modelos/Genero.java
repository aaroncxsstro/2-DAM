package Modelos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genero {
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "genero_libro",
            joinColumns = @JoinColumn(name = "id_genero"),
            inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private List<Libro> Libros;
    
	 @ManyToOne
	    @JoinColumn(name = "id_autor")
	    private Autor Autor;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id", nullable = false)
    private int genero_id;

    public List<Libro> getLibros() {
		return Libros;
	}
	public void setLibros(List<Libro> libros) {
		Libros = libros;
	}
	@Column(name = "nombre", length = 40)
    private String nombre;
    
    public Autor getAutor() { return (Autor) Autor; }
    public Libro getLibro() { return (Libro) Libros; }
    
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