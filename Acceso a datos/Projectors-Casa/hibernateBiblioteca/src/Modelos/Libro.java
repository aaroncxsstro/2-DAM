package Modelos;



import javax.persistence.*;
import java.util.List;

@Entity

public class Libro {
	  @ManyToMany(mappedBy = "Libros")
	    private List<Genero> Generos;
	  
	  @ManyToOne
	    @JoinColumn(name = "id_autor") 
	    private Autor Autor;
	  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id", nullable = false)
    private int libro_id;
    @Column(name = "titulo", length = 200)
    private String titulo;
    @Column(name = "anio_publicacion", length = 4)
    private String anio_publicacion;

    public Genero getGenero() { return (Genero) Generos; }
    public Autor getAutor() { return (Autor) Autor; }
    
	public Libro(int libro_id, String titulo, String anio_publicacion) {
		this.libro_id = libro_id;
		this.titulo = titulo;
		this.anio_publicacion = anio_publicacion;
	}
	
	public Libro() {

	}
	
	public List<Genero> getGeneros() {
		return Generos;
	}
	public void setGeneros(List<Genero> generos) {
		Generos = generos;
	}
	public int getLibro_id() {
		return libro_id;
	}
	public void setLibro_id(int libro_id) {
		this.libro_id = libro_id;
	}
	public void setAutor(Autor autor) {
		Autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnio_publicacion() {
		return anio_publicacion;
	}
	public void setAnio_publicacion(String anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}
	
	



}