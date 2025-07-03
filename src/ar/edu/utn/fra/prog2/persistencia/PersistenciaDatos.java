package ar.edu.utn.fra.prog2.persistencia;

import ar.edu.utn.fra.prog2.modelo.Pelicula;
import ar.edu.utn.fra.prog2.modelo.Sala;
import ar.edu.utn.fra.prog2.modelo.Cuenta;
import ar.edu.utn.fra.prog2.modelo.Entrada;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersistenciaDatos {
    public static final String ARCHIVO_CUENTAS = "cuentas.dat";
    public static final String ARCHIVO_SALAS = "salas.dat";
    public static final String ARCHIVO_ENTRADAS = "entradas.dat";
    
    public static void guardarTodo(HashMap<String, Cuenta> cuentas, 
                                 List<Sala> salas, 
                                 List<Entrada> entradas) {
        guardarCuentas(cuentas);
        guardarSalas(salas);
        guardarEntradas(entradas);
    }
    
    public static void guardarCuentas(HashMap<String, Cuenta> cuentas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CUENTAS))) {
            oos.writeObject(cuentas);
        } catch(IOException ioe) {
            System.out.println("Error guardando cuentas: " + ioe.getMessage());
        }
    }
    
    public static void guardarSalas(List<Sala> salas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_SALAS))) {
            oos.writeObject(salas);
        } catch(IOException ioe) {
            System.out.println("Error guardando salas: " + ioe.getMessage());
        }
    }
    
    public static void guardarEntradas(List<Entrada> entradas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ENTRADAS))) {
            oos.writeObject(entradas);
        } catch(IOException ioe) {
            System.out.println("Error guardando entradas: " + ioe.getMessage());
        }
    }
    
    public static HashMap<String, Cuenta> cargarCuentas() {
        File archivo = new File(ARCHIVO_CUENTAS);
        if (!archivo.exists()) {
            HashMap<String, Cuenta> cuentas = new HashMap<>();
            cuentas.put("admin", new Cuenta("admin", "Administrador"));
            return cuentas;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CUENTAS))) {
            return (HashMap<String, Cuenta>) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error cargando cuentas: " + ioe.getMessage());
            return new HashMap<>();
        }
    }
    
    public static List<Sala> cargarSalas() {
        File archivo = new File(ARCHIVO_SALAS);
        if (!archivo.exists()) {
            List<Sala> salas = new ArrayList<>();
            // Crear algunas salas de ejemplo
            Pelicula p1 = new Pelicula("Avengers: Endgame", "Acción", 180);
            Pelicula p2 = new Pelicula("The Batman", "Acción", 176);
            salas.add(new Sala(1, p1, 50));
            salas.add(new Sala(2, p2, 40));
            return salas;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_SALAS))) {
            return (List<Sala>) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error cargando salas: " + ioe.getMessage());
            return new ArrayList<>();
        }
    }
    
    public static List<Entrada> cargarEntradas() {
        File archivo = new File(ARCHIVO_ENTRADAS);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_ENTRADAS))) {
            return (List<Entrada>) ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error cargando entradas: " + ioe.getMessage());
            return new ArrayList<>();
        }
    }
}