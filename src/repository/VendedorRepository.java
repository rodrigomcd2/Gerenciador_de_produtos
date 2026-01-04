package repository;

import model.Vendedor;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorRepository {

    private static final String ARQUIVO = "vendedores.dat";

    private static List<Vendedor> vendedores = new ArrayList<>();
    private static Vendedor vendedorAtual;

    static {
        carregar();
    }

    public static Vendedor getVendedorAtual() {

        if (vendedorAtual != null) {
            return vendedorAtual;
        }

        String login = null;

        while (login == null || login.isBlank()) {
            login = JOptionPane.showInputDialog(
                    null,
                    "Digite seu login:",
                    "Login",
                    JOptionPane.QUESTION_MESSAGE
            );
        }

        // procura vendedor existente
        for (Vendedor v : vendedores) {
            if (v.getLogin().equalsIgnoreCase(login)) {
                vendedorAtual = v;
                return vendedorAtual;
            }
        }

        // caso não ache, procura outro
        vendedorAtual = new Vendedor(login, login, "123");
        vendedores.add(vendedorAtual);
        salvar();

        return vendedorAtual;
    }

    public static void salvar() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(vendedores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void carregar() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {
            vendedores = (List<Vendedor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Vendedor> getVendedores() {
        return vendedores;
    }
}
