package model;

public class microcontrolador extends Produto{
  public class Microcontrolador(String nome, int quantidade, double preco) {
    super(nome, quantidade, preco);
  } 
  public String getTipo(){
  return "Microcontrolador";
  }

  public String getDescricaoTecnica(){
  return " Unidade de controle programavel para sistemas embarcados.";
  }
}
