import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Biblioteca {
    ArrayList<Usuarios> usuarios;
    ArrayList<Libros> libros;

    public Biblioteca() {
        usuarios = new ArrayList<>();
        libros = new ArrayList<>();
    }

    public void agregarUsuario(Usuarios usuario) {
        usuarios.add(usuario);
    }

    public void agregarLibro(Libros libro) {
        libros.add(libro);
    }

    public void mostrarLibrosDisponibles() {
        JOptionPane.showMessageDialog(null, "Libros disponibles:\n");
        for (Libros libro : libros) {
            if (libro.isDisponibilidad() == true) {
                JOptionPane.showMessageDialog(null, libro.toString());
            }
        }
    }

    public void pedirLibro(Usuarios usuario, Libros libro) {
        if (libros.contains(libro)) {
            JOptionPane.showMessageDialog(null, usuario + " ha realizado el prestamo del libro: " + libro);
        } else {
            JOptionPane.showMessageDialog(null, "El libro no se encuentra disponible.");
        }
    }


    public void reservarLibro(Usuarios usuario, Libros libro) {
        usuario.agregarLibroReservado(libro);
        System.out.println(usuario + " ha reservado el libro: " + libro);
    }
}