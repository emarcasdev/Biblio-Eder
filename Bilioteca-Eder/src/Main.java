import javax.swing.JOptionPane;

public class Main {
// comment
    static Usuarios user1 = new Usuarios("Juan", "Martinez", 952236589, "juanito20@gmail.com");
    static Usuarios user2 = new Usuarios("Marta", "Garcia", 950, "marttagar@gmail.com");
    static Usuarios user3 = new Usuarios("Alba", "Lopez", 955, "allopez@gmail.com");
    static Usuarios user4 = new Usuarios("Asier", "Moreno", 953347743, "moreno777@gmail.com");

    public static void main(String[] args) throws Exception {

        Biblioteca biblioteca = new Biblioteca();

        Libros libro1 = new Libros("Julio Verne e a vida secreta das mulleres planta", "Ledicia Costas", 978849121, true);
        Libros libro2 = new Libros("Dragon Ball 01", "Akira Toriyama", 978841341, true);
        Libros libro3 = new Libros("El gran grimorio", "Anonimo", 979887177, true);
        Libros libro4 = new Libros("El principito", "Antoine de Saint-Exupery", 978849838, true);
        Libros libro5 = new Libros("La Celestina", "Fernando de Rojas", 978846787, true);
        Libros libro6 = new Libros("El arte de la invisibilidad", "Kevin Mitnick", 978844154, true);
        Libros libro7 = new Libros("El asombroso Spiderman", "Stan Lee", 978841150, true);
        Libros libro8 = new Libros("Bat Pat 1: El tesoro del cementerio", "Roberto Pavanello", 978848441, true);

        biblioteca.agregarUsuario(user1);
        biblioteca.agregarUsuario(user2);
        biblioteca.agregarUsuario(user3);
        biblioteca.agregarUsuario(user4);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);
        biblioteca.agregarLibro(libro7);
        biblioteca.agregarLibro(libro8);

        int control = 0;

        while (control != 3) {
            try {
                System.out.println("1. Iniciar sesion");
                System.out.println("2. Registrarse");
                System.out.println("3. Salir");
                control = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menu: \n1. Iniciar sesion\n2. Registrarse\n3. Salir"));
            } catch (Exception e) {
                control = -1;
                JOptionPane.showMessageDialog(null, "Debes escribir un numero entre 1 al 3");
            }
            switch (control) {
                case 1:
                    // Iniciar Sesion
                    String nameUsuario = JOptionPane.showInputDialog(null, "Inserte el nombre del usuario: ");
                    System.out.println(biblioteca.usuarios);
                    for (Usuarios user : biblioteca.usuarios) { // preguntar por que funciona con Usuario
                        if (user.getNombre().equalsIgnoreCase(nameUsuario)) {
                            JOptionPane.showMessageDialog(null, "Usuario correcto");
                            String contrasenhaUser = JOptionPane.showInputDialog(null, "Inserte la contrasena de su usuario: ");
                            int contrasenhaFin = Integer.parseInt(contrasenhaUser);
                            if (user.getTelefono() == contrasenhaFin) {
                                JOptionPane.showMessageDialog(null, "Contrasena correcta");
                                JOptionPane.showMessageDialog(null, "Accediendo al menu...");
                                int menu = 0;
                                while (menu != 7) {
                                    try {
                                        System.out.println("1. Acceder a un usuario");
                                        System.out.println("2. Ver libros disponibles");
                                        System.out.println("3. Ver libros pendientes de devolver");
                                        System.out.println("4. Pedir un libro");
                                        System.out.println("5. Devolver un libro");
                                        System.out.println("6. Reservar un libro");
                                        System.out.println("7. Salir");
                                        // Aquí obtendremos la opción que se seleccione del menú.
                                        menu = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "Menu: \n1. Acceder a un usuario\n2. Ver libros disponibles\n3. Ver libros pendientes de devolver\n4. Pedir un libro\n5. Devolver un libro\n6. Reservar un libro\n7. Salir"));
                                    } catch (Exception e) {
                                        menu = -1;
                                        JOptionPane.showMessageDialog(null, "Debes escribir un numero entre 1 y el 7");
                                    }
                                    switch (menu) {
                                        case 1:
                                            accederUsers();
                                            break;
                                        case 2:
                                            biblioteca.mostrarLibrosDisponibles();
                                            break;
                                        case 3:
                                            String usuarioSeleccionado = JOptionPane.showInputDialog(null,
                                                    "Ingrese el nombre del usuario: ");
                                            for (Usuarios usuario : biblioteca.usuarios) {
                                                if (usuario.getNombre().equals(usuarioSeleccionado)) {
                                                    System.out.println(usuario.toString());
                                                    break;
                                                }
                                            }
                                            break;
                                        case 4:
                                            String Seleccionado = JOptionPane.showInputDialog(null,
                                                    "Ingrese el nombre del usuario: ");
                                            String libroPedido = JOptionPane.showInputDialog(null,
                                                    "Ingrese el titulo del libro: ");
                                            for (Usuarios usuario : biblioteca.usuarios) {
                                                if (usuario.getNombre().equals(Seleccionado)) {
                                                    for (Libros libro : biblioteca.libros) {
                                                        if (libro.toString().equals(libroPedido)) {
                                                            biblioteca.pedirLibro(usuario, libro);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        case 5:
                                            String userPedido = JOptionPane.showInputDialog(null,
                                                    "Ingrese el nombre del usuario: ");
                                            String libroSolicitado = JOptionPane.showInputDialog(null,
                                                    "Ingrese el titulo del libro: ");
                                            for (Usuarios usuario : biblioteca.usuarios) {
                                                if (usuario.getNombre().equals(userPedido)) {
                                                    for (Libros libro : usuario.getLibrosADevolver()) {
                                                        if (libro.toString().equals(libroSolicitado)) {
                                                            usuario.devolverLibro(libro);
                                                            libro.setDisponibilidad(true);
                                                            System.out.println(usuario + " ha devuelto " + libro);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;

                                        case 6:
                                            String usuarioReserva = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario: ");
                                            String libroReservado = JOptionPane.showInputDialog(null, "Ingrese el titulo del libro a reservar: ");
                                            for (Usuarios usuario : biblioteca.usuarios) {
                                                if (usuario.getNombre().equals(usuarioReserva)) {
                                                    for (Libros libro : biblioteca.libros) {
                                                        if (libro.toString().equals(libroReservado)) {
                                                            if (!libro.isDisponibilidad()) {
                                                                biblioteca.reservarLibro(usuario, libro);
                                                                libro.setDisponibilidad(true);
                                                                System.out.println(usuario + " ha reservado el libro: " + libro);
                                                            } else {
                                                                System.out.println("El libro " + libro + " ya esta disponible.");
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;

                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "La contrasena es incorrecta.");
                            }
                        }

                    }
                    break;
                case 2:
                    // Registrarse
                    JOptionPane.showMessageDialog(null, "Entrando al modo para añadir un usuario");
                    String nuevo_nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ");
                    String nuevo_apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido: ");
                    int nuevo_telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su telefono/contraseña: "));
                    String nuevo_email = JOptionPane.showInputDialog(null, "Ingrese su email: ");

                    Usuarios nuevo_usuario = new Usuarios(nuevo_nombre, nuevo_apellido, nuevo_telefono, nuevo_email);
                    biblioteca.agregarUsuario(nuevo_usuario);
                    break;
            }
        }

    }

    private static void accederUsers() {
        String[] opciones = { "1. Usuario Juan", "2. Usuario Marta", "3. Usuario Alba", "4. Usuario Asier" };
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un usuario", "Acceder a usuario",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (seleccion != null) {
            // Aquí obtenemos con charAt(0) el primer caracter del String que corresponde
            // con un número
            switch (seleccion.charAt(0)) {
                case '1':
                    JOptionPane.showMessageDialog(null, "Datos del usuario 1: \n" + user1.toString());
                    break;
                case '2':
                    JOptionPane.showMessageDialog(null, "Datos del usuario 2: \n" + user2.toString());
                    break;
                case '3':
                    JOptionPane.showMessageDialog(null, "Datos del usuario 3: \n" + user3.toString());
                    break;
                case '4':
                    JOptionPane.showMessageDialog(null, "Datos del usuario 4: \n" + user4.toString());
                    break;
                default:
                    break;
            }
        }
    }

}