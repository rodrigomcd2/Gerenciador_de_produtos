package persistence;

import model.Vendedor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorArquivo {

    private static final String ARQ = "dados.dat";

    public static void salvar(List<Vendedor> vendedores) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ARQ))) {
            oos.writeObject(vendedores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Vendedor> carregar() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(ARQ))) {
            return (List<Vendedor>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
