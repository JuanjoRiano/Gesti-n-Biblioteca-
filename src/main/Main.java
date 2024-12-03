package main;

import controlador.BibliotecaCTO;
import vista.BibliotecaVista;

public class Main {
    public static void main(String[] args) {
        BibliotecaCTO cBiblioteca = new BibliotecaCTO(new BibliotecaVista());
    }
}
