package ar.edu.utn.fra.prog2.persistencia;

import ar.edu.utn.fra.prog2.modelo.Cuenta;
import java.io.*;
import java.util.HashMap;

/**
 *
 * @author Tobias
 */
public class PersistenciaDatos {
    public static final String ARCHIVO_CUENTAS = "cuentas.dat";

    public static void guardarCuentas(HashMap<String, Cuenta> cuentas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CUENTAS))) {
            oos.writeObject(cuentas);
        } catch(IOException ioe) {
            System.out.println("Error guardando cuentas: " + ioe.getMessage());
        }
    }

    public static HashMap<String, Cuenta> cargarCuentas() {
        File archivo = new File(ARCHIVO_CUENTAS);
        if (!archivo.exists()) {
            HashMap<String, Cuenta> cuentas = new HashMap<>();
            cuentas.put("admin", new Cuenta("admin", "admin"));
            return cuentas;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (HashMap<String, Cuenta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        HashMap<String, Cuenta> cuentas = new HashMap<>();
        cuentas.put("admin", new Cuenta("admin", "admin"));
        return cuentas;
    }
}
