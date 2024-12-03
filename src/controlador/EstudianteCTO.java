package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modeloDAO.EstudianteDAO;
import modeloDTO.EstudianteDTO;
import vista.EstudianteVista;

public class EstudianteCTO implements ActionListener {
    private EstudianteVista vista;
    private EstudianteDAO modelo;
    private EstudianteDTO estudiante;

    public EstudianteCTO(EstudianteVista vista) {
        this.vista = vista;
        this.modelo = new EstudianteDAO();
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnLimpiarDatos.addActionListener(this);
        this.vista.setVisible(true);
    }

    public void limpiarDatos() {
        vista.textFId.setText("");
        vista.textFNombre.setText("");
        vista.textFApellido.setText("");
        vista.textFCarrera.setText("");
        vista.textFEmail.setText(""); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnRegistrar)) {
            estudiante = new EstudianteDTO();
            try {
                estudiante.setId(vista.textFId.getText());
                estudiante.setNombre(vista.textFNombre.getText());
                estudiante.setApellido(vista.textFApellido.getText());
                estudiante.setCarrera(vista.textFCarrera.getText());
                estudiante.setEmail(vista.textFEmail.getText());

                if (modelo.create(estudiante)) {
                    JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el estudiante.");
                }
                limpiarDatos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al registrar el estudiante.");
            }
        }

        if (e.getSource().equals(vista.btnBuscar)) {
            try {
                estudiante = modelo.read(vista.textFId.getText());  
                limpiarDatos();
                if (estudiante == null) {
                    JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                } else {
                    vista.textFId.setText(estudiante.getId());
                    vista.textFNombre.setText(estudiante.getNombre());
                    vista.textFApellido.setText(estudiante.getApellido());
                    vista.textFCarrera.setText(estudiante.getCarrera());
                    vista.textFEmail.setText(estudiante.getEmail());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
            }
        }

        if (e.getSource().equals(vista.btnEliminar)) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (estudiante != null && modelo.delete(estudiante)) {
                        JOptionPane.showMessageDialog(null, "Estudiante eliminado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el estudiante.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el estudiante.");
                }
            }
            limpiarDatos();
        }

        if (e.getSource().equals(vista.btnModificar)) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (estudiante != null) {
                        estudiante.setNombre(vista.textFNombre.getText());
                        estudiante.setApellido(vista.textFApellido.getText());
                        estudiante.setCarrera(vista.textFCarrera.getText());
                        estudiante.setEmail(vista.textFEmail.getText());
                        
                        int index = modelo.buscarIndex(estudiante);
                        modelo.update(index, estudiante);
                        JOptionPane.showMessageDialog(null, "Estudiante modificado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el estudiante para modificar.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar el estudiante.");
                }
            }
            limpiarDatos();
        }

        if (e.getSource().equals(vista.btnLimpiarDatos)) {
            limpiarDatos();
        }
    }
}
