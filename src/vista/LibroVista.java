package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LibroVista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JLabel lblId;
    public JLabel lblTitulo;
    public JLabel lblAutor;
    public JLabel lblEditorial;
    public JLabel lblAnio;
    public JButton btnBuscar;
    public JButton btnRegistrar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiarDatos;
    public JTextField textFId;
    public JTextField textFTitulo;
    public JTextField textFAutor;
    public JTextField textFEditorial; 
    public JTextField textFAnio;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LibroVista frame = new LibroVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LibroVista() {
        setTitle("Gestión De Libros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblId.setBounds(30, 20, 40, 20);
        contentPane.add(lblId);

        textFId = new JTextField();
        textFId.setBounds(100, 20, 200, 20);
        contentPane.add(textFId);
        textFId.setColumns(10);

        lblTitulo = new JLabel("Título:");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTitulo.setBounds(30, 60, 50, 20);
        contentPane.add(lblTitulo);

        textFTitulo = new JTextField();
        textFTitulo.setColumns(10);
        textFTitulo.setBounds(100, 60, 200, 20);
        contentPane.add(textFTitulo);

        lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAutor.setBounds(30, 100, 50, 20);
        contentPane.add(lblAutor);

        textFAutor = new JTextField();
        textFAutor.setColumns(10);
        textFAutor.setBounds(100, 100, 200, 20);
        contentPane.add(textFAutor);

        lblEditorial = new JLabel("Editorial:");
        lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEditorial.setBounds(30, 140, 60, 20);
        contentPane.add(lblEditorial);

        textFEditorial = new JTextField();
        textFEditorial.setColumns(10);
        textFEditorial.setBounds(100, 140, 200, 20);
        contentPane.add(textFEditorial);

        lblAnio = new JLabel("Año:");
        lblAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAnio.setBounds(30, 180, 50, 20);
        contentPane.add(lblAnio);

        textFAnio = new JTextField();
        textFAnio.setColumns(10);
        textFAnio.setBounds(100, 180, 200, 20);
        contentPane.add(textFAnio);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(30, 220, 100, 25);
        contentPane.add(btnRegistrar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(140, 220, 100, 25);
        contentPane.add(btnBuscar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(250, 220, 100, 25);
        contentPane.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(30, 260, 100, 25);
        contentPane.add(btnEliminar);

        btnLimpiarDatos = new JButton("Limpiar");
        btnLimpiarDatos.setBounds(140, 260, 100, 25);
        contentPane.add(btnLimpiarDatos);
    }
}
