package Modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Movimiento {
	
	  @ManyToMany(mappedBy = "Pokemon")
	    private List<Pokemon> Pokemons;
	  
	  
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	    @Column(name = "movimiento_id", nullable = false)
	    private int movimiento_id;
	  
	    @Column(name = "nombre", length = 45)
	    private String nombre;
	    
	    @Column(name = "poder", length = 45)
	    private String poder;

	    @Column(name = "precision_movimiento")
	    private int precision_movimiento;
	    
	    @Column(name = "tipo", length = 45)
	    private int tipo;
	    
	    
	    public Movimiento() {
	    	
		}

		public Pokemon getPokemon() { return (Pokemon) Pokemons; }

		public List<Pokemon> getPokemons() {
			return Pokemons;
		}

		public void setPokemons(List<Pokemon> pokemons) {
			Pokemons = pokemons;
		}

		public int getMovimiento_id() {
			return movimiento_id;
		}

		public void setMovimiento_id(int movimiento_id) {
			this.movimiento_id = movimiento_id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getPoder() {
			return poder;
		}

		public void setPoder(String poder) {
			this.poder = poder;
		}

		public int getPrecision_movimiento() {
			return precision_movimiento;
		}

		public void setPrecision_movimiento(int precision_movimiento) {
			this.precision_movimiento = precision_movimiento;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}
	    
	    
}
