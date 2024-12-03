package modeloDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modeloDTO.RevistaDTO;

public class RevistaDAO {
    private ArrayList<RevistaDTO> revistas;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String nombreArchivo = "revistas";

    public RevistaDAO() {
        File file = new File(nombreArchivo);
        if (file.isFile()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(nombreArchivo));
                revistas = (ArrayList<RevistaDTO>) entrada.readObject();
                entrada.close();
            } catch (Exception e) {
                revistas = new ArrayList<>();
                guardar();
            }
        } else {
            revistas = new ArrayList<>();
        }
    }

    public void guardar() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            salida.writeObject(revistas);
            salida.close();
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public boolean create(RevistaDTO revista) {
        revistas.add(revista);
        guardar();
        return true;
    }

    public RevistaDTO read(int codigo) {
        for (RevistaDTO revista : revistas) {
            if (revista.getCodigo() == codigo) {
                return revista;
            }
        }
        return null;
    }

    public void update(int index, RevistaDTO revista) {
        revistas.set(index, revista);
        guardar();
    }

    public boolean delete(RevistaDTO revista) {
        revistas.remove(revista);
        guardar();
        return true;
    }

    public List<RevistaDTO> readAll() {
        return revistas;
    }

    public int buscarIndex(RevistaDTO revista) {
        return revistas.indexOf(revista);
    }
}
