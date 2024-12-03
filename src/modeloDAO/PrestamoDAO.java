package modeloDAO;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modeloDTO.PrestamoDTO;

public class PrestamoDAO {
    private ArrayList<PrestamoDTO> prestamos;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String nombreArchivo;

    public PrestamoDAO() {
        this.nombreArchivo = "prestamos";
        File file = new File(nombreArchivo);
        if (file.isFile()) {
            try {
                this.entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
                this.prestamos = (ArrayList<PrestamoDTO>) entrada.readObject();
                this.entrada.close();
            } catch (Exception e) {
                prestamos = new ArrayList<>();
                System.out.println(e.getMessage());
                guardar();  
            }
        } else {
            prestamos = new ArrayList<>();
        }
    }

    public void guardar() {
        try {
            this.salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            this.salida.writeObject(prestamos);
            this.salida.close();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public boolean create(PrestamoDTO prestamo) {
        prestamos.add(prestamo);
        guardar(); 
        return true;
    }

    public PrestamoDTO read(int numero) {
        for (PrestamoDTO prestamo : prestamos) {
            if (prestamo.getNumero() == numero) {
                return prestamo;
            }
        }
        return null;  
    }

    public boolean delete(int numero) {
        PrestamoDTO prestamo = read(numero);
        if (prestamo != null) {
            prestamos.remove(prestamo);
            guardar(); 
            return true;
        }
        return false;
    }

    public List<PrestamoDTO> readAll() {
        return prestamos;  
    }

    public boolean update(PrestamoDTO prestamo) {
        return false;
    }
}
