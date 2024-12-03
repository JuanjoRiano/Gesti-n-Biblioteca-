package modeloDTO;

import java.io.Serializable;
import java.time.LocalDate;

public class PrestamoDTO implements Serializable {
    private int numero;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private LibroDTO libro;
    private EstudianteDTO estudiante;
    private boolean penalizacion;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LibroDTO getLibro() {
        return libro;
    }

    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(boolean penalizacion) {
        this.penalizacion = penalizacion;
    }
}
