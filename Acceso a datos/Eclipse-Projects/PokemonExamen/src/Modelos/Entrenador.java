package Modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Entrenador {

	 @OneToMany(mappedBy="Pokemon")
     private List<Pokemon> pokemons = new ArrayList<Pokemon>();
	 
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	    @Column(name = "id", nullable = false)
	    private int id;
	  
	    @Column(name = "ciudad", length = 15)
	    private String ciudad;
	    
	    @Column(name = "edad")
	    private int edad;

	    @Column(name = "nombre", length = 45)
	    private String nombre;

	    
		public Entrenador() {
			
		}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

	    
}
