public class Libros {
    private String titulo;
    private String autor;
    private long ISBN;
    private boolean disponibilidad;

    public Libros(String titulo, String autor, long ISBN, boolean disponibilidad){
        this.titulo=titulo;
        this.autor=autor;
        this.ISBN=ISBN;
        this.disponibilidad = disponibilidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    // comment
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setISBN(long iSBN) {
        ISBN = iSBN;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    @Override
    public String toString() {
        return "Titulo: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Disponibilidad: " + (disponibilidad ? "Disponible" : "No disponible");
    }
}
