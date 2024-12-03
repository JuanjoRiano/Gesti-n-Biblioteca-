package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RevistaVista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JLabel lblId;
    public JLabel lblTitulo;
    public JLabel lblEditor;
    public JLabel lblAnio;
    public JButton btnBuscar;
    public JButton btnRegistrar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiarDatos;
    public JTextField textFId;
    public JTextField textFTitulo;
    public JTextField textFEditor;
    public JTextField textFAnio;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RevistaVista frame = new RevistaVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RevistaVista() {
        setTitle("Gestión De Revistas");
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

        lblTitulo = new JLabel("Título");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTitulo.setBounds(10, 36, 70, 14);
        contentPane.add(lblTitulo);

        textFTitulo = new JTextField();
        textFTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFTitulo.setBounds(74, 35, 255, 20);  
        contentPane.add(textFTitulo);
        textFTitulo.setColumns(10);

        lblEditor = new JLabel("Editor");
        lblEditor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEditor.setBounds(10, 61, 70, 14);
        contentPane.add(lblEditor);

        textFEditor = new JTextField();
        textFEditor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFEditor.setBounds(74, 60, 255, 20);  
        contentPane.add(textFEditor);
        textFEditor.setColumns(10);

        lblAnio = new JLabel("Año");
        lblAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAnio.setBounds(10, 86, 70, 14);
        contentPane.add(lblAnio);

        textFAnio = new JTextField();
        textFAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textFAnio.setBounds(74, 85, 255, 20);  
        contentPane.add(textFAnio);
        textFAnio.setColumns(10);

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
