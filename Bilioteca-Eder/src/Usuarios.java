import java.util.ArrayList;

import javax.swing.JOptionPane;
// comment
public class Usuarios {
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private ArrayList<Libros> librosADevolver = new ArrayList<>();
    private ArrayList<Libros> librosReservados = new ArrayList<>();

    public Usuarios(String nombre, String apellido, int telefono, String email){
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.email=email;

    }

    public ArrayList<Libros> getLibrosADevolver() {
        return librosADevolver;
    }

    public void setLibrosADevolver(ArrayList<Libros> librosADevolver) {
        this.librosADevolver = librosADevolver;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarLibrosADevolver() {
        JOptionPane.showMessageDialog(null, "Libros pendientes de devolver por " + nombre + ":");
        for (Libros libro : librosADevolver) {
            JOptionPane.showMessageDialog(null, libro.toString());
        }
    }
    public void agregarLibroPendiente(Libros libro) {
        librosADevolver.add(libro);
    }

    public void devolverLibro(Libros libro) {
        librosADevolver.remove(libro);
    }

    public void agregarLibroPrestado(Libros libro) {
        librosADevolver.add(libro);
    }

    public void agregarLibroReservado(Libros libro) {
        librosReservados.add(libro);
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido + '\n' +
                "Telefono: " + telefono + '\n' +
                "Correo electronico: " + email + '\n' +
                "Libros pendientes a devolver: " + librosADevolver;
    }

}
