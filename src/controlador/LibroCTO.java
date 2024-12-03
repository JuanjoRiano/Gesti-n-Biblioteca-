package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modeloDAO.LibroDAO;
import modeloDTO.LibroDTO;
import vista.LibroVista;

public class LibroCTO implements ActionListener {
    private LibroVista vista;
    private LibroDAO modelo;
    private LibroDTO libro;

    public LibroCTO(LibroVista vista) {
        this.vista = vista;
        this.modelo = new LibroDAO();
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnLimpiarDatos.addActionListener(this);
        this.vista.setVisible(true);
    }

    public void limpiarDatos() {
        vista.textFId.setText("");
        vista.textFTitulo.setText("");
        vista.textFAutor.setText("");
        vista.textFAnio.setText("");
        vista.textFEditorial.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnRegistrar)) {
            libro = new LibroDTO();
            try {
                libro.setCodigo(Integer.parseInt(vista.textFId.getText()));
                libro.setTitulo(vista.textFTitulo.getText());
                libro.setAutor(vista.textFAutor.getText());
                libro.setAnio(Integer.parseInt(vista.textFAnio.getText()));
                libro.setEditorial(vista.textFEditorial.getText());  

                if (modelo.create(libro)) {
                    JOptionPane.showMessageDialog(null, "Libro registrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el libro.");
                }
                limpiarDatos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el ID y el año.");
            }
        }

        if (e.getSource().equals(vista.btnBuscar)) {
            try {
                libro = modelo.read(Integer.parseInt(vista.textFId.getText()));
                limpiarDatos();
                if (libro == null) {
                    JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                } else {

                    vista.textFId.setText(String.valueOf(libro.getCodigo()));
                    vista.textFTitulo.setText(libro.getTitulo());
                    vista.textFAutor.setText(libro.getAutor());
                    vista.textFAnio.setText(String.valueOf(libro.getAnio()));
                    vista.textFEditorial.setText(libro.getEditorial());  
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor válido para el ID.");
            }
        }

        if (e.getSource().equals(vista.btnEliminar)) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (libro != null && modelo.delete(libro)) {
                        JOptionPane.showMessageDialog(null, "Libro eliminado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el libro.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el libro.");
                }
            }
            limpiarDatos();
        }

        if (e.getSource().equals(vista.btnModificar)) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (libro != null) {
                        libro.setCodigo(Integer.parseInt(vista.textFId.getText()));
                        libro.setTitulo(vista.textFTitulo.getText());
                        libro.setAutor(vista.textFAutor.getText());
                        libro.setAnio(Integer.parseInt(vista.textFAnio.getText()));
                        libro.setEditorial(vista.textFEditorial.getText());  

                        int index = modelo.buscarIndex(libro);
                        if (index != -1) {
                            modelo.update(index, libro);
                            JOptionPane.showMessageDialog(null, "Libro modificado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ha encontrado el libro para modificar.");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar el libro.");
                }
            }
            limpiarDatos();
        }

        if (e.getSource().equals(vista.btnLimpiarDatos)) {
            limpiarDatos();
        }
    }
}
