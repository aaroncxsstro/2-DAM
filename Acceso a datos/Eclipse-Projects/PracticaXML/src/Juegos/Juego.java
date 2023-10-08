package Juegos;

public class Juego {
    private String titulo;
    private String genero;
    private String plataforma;
    private String fechaLanzamiento;

    public Juego(String titulo, String genero, String plataforma, String fechaLanzamiento) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nGénero: " + genero + "\nPlataforma: " + plataforma +
                "\nFecha de lanzamiento: " + fechaLanzamiento;
    }
}
