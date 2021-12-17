package model;

import java.util.ArrayList;

public class Projeto {

  private final String nome;
  private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

  public Projeto(String nome) {
    this.nome = nome;
  }

  // TODO: sobrecarregar o construtor para receber o nome do projeto e os devs

  public String getNome() {
    return nome;
  }

  public ArrayList<Desenvolvedor> getDesenvolvedores() {
    // FIXME: retornar um clone da lista para manter o encapsulamento
    return desenvolvedores;
  }

  public boolean podeAlocar(Desenvolvedor dev) {
    return ! this.desenvolvedores.contains(dev) && this.desenvolvedores.size() < 5;
  }

  public void alocarDev(Desenvolvedor dev) {
    if (this.podeAlocar(dev) && dev.podeSerAlocado(this)) {
      this.desenvolvedores.add(dev);
      // FIXME: não usar getProjetos de Desenvolvedor para adicionar-se à lista
      dev.getProjetos().add(this);
    }
  }

  @Override
  public String toString() {
    return "PROJ_" + this.nome;
  }

  public boolean hasDesenvolvedor(Desenvolvedor dev) {
    // TODO: Implementar retornando se o dev faz parte da equipe ou não
    return false;
  }
}
