package Modelos;

import java.util.List;

import javax.persistence.*;

@Entity
public class Pokemon {

	@ManyToOne
    @JoinColumn(name = "id")
    private Entrenador entrenador;

	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "pokemon_movimientos",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "movimiento_id")
    )
	
    private List<Movimiento> Movimientos;
    
    public Movimiento getMovimiento() { return (Movimiento) Movimientos; }
    public Entrenador getEntrenador() { return (Entrenador) entrenador; }
    
    public List<Movimiento> getMovimientos() {
		return Movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		Movimientos = movimientos;
	}

    public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "pokemon_id", nullable = false)
    private int pokemon_id;

    @Column(name = "habilidad", length = 45)
    private String habilidad;

    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @Column(name = "tipo", length = 45)
    private String tipo;

	public Pokemon() {
		
	}


	public int getPokemon_id() {
		return pokemon_id;
	}

	public void setPokemon_id(int pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
	
    
    
    


}
