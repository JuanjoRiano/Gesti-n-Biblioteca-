package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import modeloDAO.PrestamoDAO;
import modeloDTO.EstudianteDTO;
import modeloDTO.LibroDTO;
import modeloDTO.PrestamoDTO;
import vista.PrestamoVista;

public class PrestamoCTO implements ActionListener {
    private PrestamoVista vista;
    private PrestamoDAO modelo;
    private PrestamoDTO prestamo;

    public PrestamoCTO(PrestamoVista vista) {
        this.vista = vista;
        this.modelo = new PrestamoDAO();
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnLimpiarDatos.addActionListener(this);
        this.vista.setVisible(true);
    }

    public void limpiarDatos() {
        vista.textFId.setText("");
        vista.textFEstudiante.setText("");
        vista.textFLibro.setText("");
        vista.textFFechaPrestamo.setText("");
        vista.textFFechaDevolucion.setText("");
    }

    private boolean validarFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnRegistrar)) {
            prestamo = new PrestamoDTO();
            try {
                prestamo.setNumero(Integer.parseInt(vista.textFId.getText()));
                
                String nombreEstudiante = vista.textFEstudiante.getText();
                if (nombreEstudiante.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del estudiante.");
                    return;
                }
                EstudianteDTO estudiante = new EstudianteDTO();
                estudiante.setNombre(nombreEstudiante);
                prestamo.setEstudiante(estudiante);

                String tituloLibro = vista.textFLibro.getText();
                if (tituloLibro.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el título del libro.");
                    return;
                }
                LibroDTO libro = new LibroDTO();
                libro.setTitulo(tituloLibro);
                prestamo.setLibro(libro);

                String fechaPrestamo = vista.textFFechaPrestamo.getText();
                String fechaDevolucion = vista.textFFechaDevolucion.getText();

                if (!validarFecha(fechaPrestamo)) {
                    JOptionPane.showMessageDialog(null, "La fecha de préstamo no tiene un formato válido. Debe ser 'yyyy-MM-dd'.");
                    return;
                }

                if (!validarFecha(fechaDevolucion)) {
                    JOptionPane.showMessageDialog(null, "La fecha de devolución no tiene un formato válido. Debe ser 'yyyy-MM-dd'.");
                    return;
                }

                prestamo.setFechaPrestamo(LocalDate.parse(fechaPrestamo));
                prestamo.setFechaEntrega(LocalDate.parse(fechaDevolucion));

                if (modelo.create(prestamo)) {
                    JOptionPane.showMessageDialog(null, "Préstamo registrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el préstamo.");
                }

                limpiarDatos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el ID.");
            }
        }

        if (e.getSource().equals(vista.btnBuscar)) {
            try {
                int idPrestamo = Integer.parseInt(vista.textFId.getText());
                PrestamoDTO prestamoBuscado = modelo.read(idPrestamo);
                if (prestamoBuscado != null) {
                    vista.textFEstudiante.setText(prestamoBuscado.getEstudiante().getNombre());
                    vista.textFLibro.setText(prestamoBuscado.getLibro().getTitulo());
                    vista.textFFechaPrestamo.setText(prestamoBuscado.getFechaPrestamo().toString());
                    vista.textFFechaDevolucion.setText(prestamoBuscado.getFechaEntrega().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un préstamo con ese ID.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el ID.");
            }
        }

        if (e.getSource().equals(vista.btnModificar)) {
            try {
                int idPrestamo = Integer.parseInt(vista.textFId.getText());
                PrestamoDTO prestamoExistente = modelo.read(idPrestamo);
                if (prestamoExistente != null) {
                    String nombreEstudiante = vista.textFEstudiante.getText();
                    String tituloLibro = vista.textFLibro.getText();
                    String fechaPrestamo = vista.textFFechaPrestamo.getText();
                    String fechaDevolucion = vista.textFFechaDevolucion.getText();

                    if (!validarFecha(fechaPrestamo) || !validarFecha(fechaDevolucion)) {
                        JOptionPane.showMessageDialog(null, "Las fechas deben ser válidas en el formato 'yyyy-mm-dd'.");
                        return;
                    }

                    prestamoExistente.getEstudiante().setNombre(nombreEstudiante);
                    prestamoExistente.getLibro().setTitulo(tituloLibro);
                    prestamoExistente.setFechaPrestamo(LocalDate.parse(fechaPrestamo));
                    prestamoExistente.setFechaEntrega(LocalDate.parse(fechaDevolucion));

                    modelo.guardar();
                    JOptionPane.showMessageDialog(null, "Préstamo actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un préstamo con ese ID.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el ID.");
            }
        }

        if (e.getSource().equals(vista.btnEliminar)) {
            try {
                int idPrestamo = Integer.parseInt(vista.textFId.getText());
                if (modelo.delete(idPrestamo)) {
                    JOptionPane.showMessageDialog(null, "Préstamo eliminado correctamente.");
                    limpiarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un préstamo con ese ID.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el ID.");
            }
        }

        if (e.getSource().equals(vista.btnLimpiarDatos)) {
            limpiarDatos();
        }
    }

}
