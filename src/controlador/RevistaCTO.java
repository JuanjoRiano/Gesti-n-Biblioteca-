package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modeloDAO.RevistaDAO;
import modeloDTO.RevistaDTO;
import vista.RevistaVista;

public class RevistaCTO implements ActionListener {
    private RevistaVista vista;
    private RevistaDAO modelo;
    private RevistaDTO revista;

    public RevistaCTO(RevistaVista vista) {
        this.vista = vista;
        this.modelo = new RevistaDAO();
        vista.btnRegistrar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnLimpiarDatos.addActionListener(this);
        vista.setVisible(true);
    }

    public void limpiarDatos() {
        vista.textFId.setText("");
        vista.textFTitulo.setText("");
        vista.textFEditor.setText(""); 
        vista.textFAnio.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnRegistrar)) {
            revista = new RevistaDTO();
            try {
                revista.setCodigo(Integer.parseInt(vista.textFId.getText()));
                revista.setTitulo(vista.textFTitulo.getText());
                revista.setEditorial(vista.textFEditor.getText());  
                revista.setAnio(Integer.parseInt(vista.textFAnio.getText()));

                if (modelo.create(revista)) {
                    JOptionPane.showMessageDialog(null, "Revista registrada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar la revista.");
                }
                limpiarDatos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el ID y el año.");
            }
        }

        if (e.getSource().equals(vista.btnBuscar)) {
            try {
                revista = modelo.read(Integer.parseInt(vista.textFId.getText()));
                limpiarDatos();
                if (revista == null) {
                    JOptionPane.showMessageDialog(null, "Revista no encontrada.");
                } else {
                    vista.textFId.setText(String.valueOf(revista.getCodigo()));
                    vista.textFTitulo.setText(revista.getTitulo());
                    vista.textFEditor.setText(revista.getEditorial());  
                    vista.textFAnio.setText(String.valueOf(revista.getAnio()));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor válido para el ID.");
            }
        }

        if (e.getSource().equals(vista.btnModificar)) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de modificar?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (revista != null) {
                        revista.setCodigo(Integer.parseInt(vista.textFId.getText()));
                        revista.setTitulo(vista.textFTitulo.getText());
                        revista.setEditorial(vista.textFEditor.getText());  
                        revista.setAnio(Integer.parseInt(vista.textFAnio.getText()));

                        int index = modelo.buscarIndex(revista);
                        if (index != -1) {
                            modelo.update(index, revista);
                            JOptionPane.showMessageDialog(null, "Revista modificada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ha encontrado la revista para modificar.");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar la revista.");
                }
            }
            limpiarDatos();
        }

        if (e.getSource().equals(vista.btnEliminar)) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    if (revista != null && modelo.delete(revista)) {
                        JOptionPane.showMessageDialog(null, "Revista eliminada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar la revista.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar la revista.");
                }
            }
            limpiarDatos();
        }

        if (e.getSource().equals(vista.btnLimpiarDatos)) {
            limpiarDatos();
        }
    }

}
