package vista;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;

public class BibliotecaVista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JButton btnEstudiantes;
    public JButton btnLibros;
    public JButton btnRevistas;
    public JButton btnPrestamos;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BibliotecaVista frame = new BibliotecaVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BibliotecaVista() {
        setTitle("Gestión De Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);  
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(new GridLayout(2, 2, 20, 20));  

        btnEstudiantes = new JButton("Estudiantes");
        btnEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 18));  
        btnEstudiantes.setFocusPainted(false);  
        contentPane.add(btnEstudiantes);

        btnLibros = new JButton("Libros");
        btnLibros.setFont(new Font("Tahoma", Font.PLAIN, 18));  
        btnLibros.setFocusPainted(false);  
        contentPane.add(btnLibros);

        btnRevistas = new JButton("Revistas");
        btnRevistas.setFont(new Font("Tahoma", Font.PLAIN, 18));  
        btnRevistas.setFocusPainted(false);  
        contentPane.add(btnRevistas);

        btnPrestamos = new JButton("Préstamos");
        btnPrestamos.setFont(new Font("Tahoma", Font.PLAIN, 18));  
        btnPrestamos.setFocusPainted(false);  
        contentPane.add(btnPrestamos);
    }
}
