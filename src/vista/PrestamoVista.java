package vista;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class PrestamoVista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JLabel lblId;
    public JLabel lblFechaPrestamo;
    public JLabel lblFechaDevolucion;
    public JLabel lblEstudiante;
    public JLabel lblLibro;
    public JButton btnBuscar;
    public JButton btnRegistrar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiarDatos;
    public JTextField textFId;
    public JTextField textFFechaPrestamo;
    public JTextField textFFechaDevolucion;
    public JTextField textFEstudiante;
    public JTextField textFLibro;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrestamoVista frame = new PrestamoVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PrestamoVista() {
        setTitle("Gestión De Préstamos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);  
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblId = new JLabel("Id");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblId.setBounds(10, 11, 70, 14);
        contentPane.add(lblId);

        textFId = new JTextField();
        textFId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFId.setBounds(74, 10, 255, 20);  
        contentPane.add(textFId);
        textFId.setColumns(10);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(340, 9, 89, 23);  
        contentPane.add(btnBuscar);

        lblFechaPrestamo = new JLabel("Fecha Préstamo");
        lblFechaPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFechaPrestamo.setBounds(10, 36, 100, 14);
        contentPane.add(lblFechaPrestamo);

        textFFechaPrestamo = new JTextField();
        textFFechaPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFFechaPrestamo.setBounds(120, 35, 255, 20);  
        contentPane.add(textFFechaPrestamo);
        textFFechaPrestamo.setColumns(10);

        lblFechaDevolucion = new JLabel("Fecha Devolución");
        lblFechaDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFechaDevolucion.setBounds(10, 61, 120, 14);
        contentPane.add(lblFechaDevolucion);

        textFFechaDevolucion = new JTextField();
        textFFechaDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFFechaDevolucion.setBounds(140, 60, 235, 20);  
        contentPane.add(textFFechaDevolucion);
        textFFechaDevolucion.setColumns(10);

        lblEstudiante = new JLabel("Estudiante");
        lblEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEstudiante.setBounds(10, 86, 80, 14);
        contentPane.add(lblEstudiante);

        textFEstudiante = new JTextField();
        textFEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFEstudiante.setBounds(100, 85, 255, 20);  
        contentPane.add(textFEstudiante);
        textFEstudiante.setColumns(10);

        lblLibro = new JLabel("Libro");
        lblLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLibro.setBounds(10, 111, 80, 14);
        contentPane.add(lblLibro);

        textFLibro = new JTextField();
        textFLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFLibro.setBounds(100, 110, 255, 20);  
        contentPane.add(textFLibro);
        textFLibro.setColumns(10);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(10, 145, 89, 23);  
        contentPane.add(btnRegistrar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(109, 145, 89, 23);  
        contentPane.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(208, 145, 89, 23);  
        contentPane.add(btnEliminar);

        btnLimpiarDatos = new JButton("Limpiar Datos");
        btnLimpiarDatos.setBounds(307, 145, 124, 23);  
        contentPane.add(btnLimpiarDatos);
    }
}
