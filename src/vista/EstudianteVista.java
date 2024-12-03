package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EstudianteVista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JLabel lblId;
    public JLabel lblNombre;
    public JLabel lblApellido;
    public JLabel lblCarrera;
    public JLabel lblEmail;
    public JButton btnBuscar;
    public JButton btnRegistrar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiarDatos;
    public JTextField textFId;
    public JTextField textFNombre;
    public JTextField textFApellido;
    public JTextField textFCarrera;
    public JTextField textFEmail;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EstudianteVista frame = new EstudianteVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EstudianteVista() {
        setTitle("Gestión De Estudiantes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblId = new JLabel("Id");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblId.setBounds(10, 11, 14, 14);
        contentPane.add(lblId);

        textFId = new JTextField();
        textFId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFId.setBounds(34, 10, 86, 20);
        contentPane.add(textFId);
        textFId.setColumns(10);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(130, 9, 89, 23);  
        contentPane.add(btnBuscar);

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(10, 36, 70, 14);
        contentPane.add(lblNombre);

        textFNombre = new JTextField();
        textFNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFNombre.setBounds(74, 35, 255, 20);
        contentPane.add(textFNombre);
        textFNombre.setColumns(10);

        lblApellido = new JLabel("Apellido");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblApellido.setBounds(10, 61, 70, 14);
        contentPane.add(lblApellido);

        textFApellido = new JTextField();
        textFApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFApellido.setBounds(90, 60, 255, 20);
        contentPane.add(textFApellido);
        textFApellido.setColumns(10);

        lblCarrera = new JLabel("Carrera");
        lblCarrera.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCarrera.setBounds(10, 86, 70, 14);
        contentPane.add(lblCarrera);

        textFCarrera = new JTextField();
        textFCarrera.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFCarrera.setBounds(90, 85, 255, 20);
        contentPane.add(textFCarrera);
        textFCarrera.setColumns(10);

        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmail.setBounds(10, 111, 70, 14);
        contentPane.add(lblEmail);

        textFEmail = new JTextField();
        textFEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFEmail.setBounds(90, 110, 255, 20);
        contentPane.add(textFEmail);
        textFEmail.setColumns(10);

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
