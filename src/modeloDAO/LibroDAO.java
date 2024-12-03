package modeloDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modeloDTO.LibroDTO;

public class LibroDAO {
    private ArrayList<LibroDTO> libros;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String nombreArchivo;

    public LibroDAO() {
        this.nombreArchivo = "libros";
        File file = new File(nombreArchivo);
        if (file.isFile()) {
            try {
                this.entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
                this.libros = (ArrayList<LibroDTO>) entrada.readObject();
                this.entrada.close();
            } catch (Exception e) {
                libros = new ArrayList<>();
                System.out.println(e.getMessage());
                guardar();
            }
        } else {
            libros = new ArrayList<>();
        }
    }

    public void guardar() {
        try {
            this.salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            this.salida.writeObject(libros);
            this.salida.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean create(LibroDTO libro) {
        libros.add(libro);
        guardar();
        return true;
    }

    public LibroDTO read(int codigo) {
        for (LibroDTO libro : libros) {
            if (libro.getCodigo() == codigo) {
                return libro;
            }
        }
        return null;
    }

    public void update(int index, LibroDTO libro) {
        libros.set(index, libro);
        guardar();
    }

    public boolean delete(LibroDTO libro) {
        libros.remove(libro);
        guardar();
        return true;
    }

    public List<LibroDTO> readAll() {
        return libros;
    }

    public int buscarIndex(LibroDTO libro) {
        return libros.indexOf(libro);
    }
}
