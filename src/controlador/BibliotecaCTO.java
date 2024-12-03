package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.BibliotecaVista;
import vista.EstudianteVista;
import vista.LibroVista;
import vista.RevistaVista;
import vista.PrestamoVista;

public class BibliotecaCTO implements ActionListener {
    private BibliotecaVista vista;

    public BibliotecaCTO(BibliotecaVista vista) {
        this.vista = vista;

        this.vista.btnEstudiantes.addActionListener(this);
        this.vista.btnLibros.addActionListener(this);
        this.vista.btnRevistas.addActionListener(this);
        this.vista.btnPrestamos.addActionListener(this);
        
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnEstudiantes)) {
            EstudianteCTO cEstudiantes = new EstudianteCTO(new EstudianteVista());
        }

        if (e.getSource().equals(vista.btnLibros)) {
            LibroCTO cLibros = new LibroCTO(new LibroVista());
        }

        if (e.getSource().equals(vista.btnRevistas)) {
            RevistaCTO cRevistas = new RevistaCTO(new RevistaVista());
        }

        if (e.getSource().equals(vista.btnPrestamos)) {
            PrestamoCTO cPrestamos = new PrestamoCTO(new PrestamoVista());
        }
    }
}
