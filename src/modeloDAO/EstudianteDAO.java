package modeloDAO;

import java.io.*;
import java.util.ArrayList;
import modeloDTO.EstudianteDTO;

public class EstudianteDAO {
    private ArrayList<EstudianteDTO> listaEstudiantes;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String nombreArchivo;

    public EstudianteDAO() {
        this.nombreArchivo = "estudiantes";
        File file = new File(nombreArchivo);
        if (file.isFile()) {
            try {
                this.entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
                this.listaEstudiantes = (ArrayList<EstudianteDTO>) entrada.readObject();
                this.entrada.close();
            } catch (Exception e) {
                listaEstudiantes = new ArrayList<>();
                System.out.println(e.getMessage());
                guardar();
            }
        } else {
            listaEstudiantes = new ArrayList<>();
        }
    }

    public void guardar() {
        try {
            this.salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            this.salida.writeObject(listaEstudiantes);
            this.salida.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean create(EstudianteDTO estudiante) {
        listaEstudiantes.add(estudiante);
        guardar();
        return true;
    }

    public EstudianteDTO read(String id) {
        for (EstudianteDTO estudiante : listaEstudiantes) {
            if (estudiante.getId().equals(id)) {
                return estudiante;
            }
        }
        return null;
    }

    public boolean update(int index, EstudianteDTO estudiante) {
        if (index >= 0 && index < listaEstudiantes.size()) {
            listaEstudiantes.set(index, estudiante);
            guardar();
            return true;
        }
        return false;
    }

    public boolean delete(EstudianteDTO estudiante) {
        listaEstudiantes.remove(estudiante);
        guardar();
        return true;
    }

    public int buscarIndex(EstudianteDTO estudiante) {
        return listaEstudiantes.indexOf(estudiante);
    }

    public ArrayList<EstudianteDTO> readAll() {
        return listaEstudiantes;
    }
}
