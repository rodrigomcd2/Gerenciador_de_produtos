package model;
// usa classe de outro package
import repository.VendedorRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
// transforma os dados para serem salvos depois
public class Vendedor implements Serializable { 
    private static final long serialVersionUID = 1L; // compara os dados serializados no arquivo


    private String nome;
    private String login;

    private List<Produto> produtos;
    private List<String> historico;

    public Vendedor(String nome, String login) {
        this.nome = nome;
        this.login = login;
        this.produtos = new ArrayList<>();
        this.historico = new ArrayList<>();
    }


    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<String> getHistorico() {
        return historico;
    }


    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        historico.add("Adicionado: " + produto.getNome());
        VendedorRepository.salvar();
    }

    public void removerQuantidade(Produto produto, int quantidade) {
        if (quantidade <= 0) return;

        produto.removerQuantidade(quantidade);

        if (produto.getQuantidade() <= 0) {
            produtos.remove(produto);
            historico.add("Produto removido" + produto.getNome());
        } else {
            historico.add("Removido " + quantidade + " de " + produto.getNome());
        }
        VendedorRepository.salvar();
    }
}
