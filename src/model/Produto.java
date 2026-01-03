package model;

import java.io.Serializable;

public abstract class Produto implements Serializable {

    private String nome;
    private int quantidade;
    private double preco;

    //Classe Mãe
    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void removerQuantidade(int q) {
        this.quantidade -= q;
    }

    // POLIMORFISMO
    public abstract String getTipo();
    public abstract String getDescricaoTecnica();

    public void adicionarQuantidade(int quantidade) {
        if(quantidade > 0) {
            return;
        }
        this.quantidade += quantidade;
    }
}
