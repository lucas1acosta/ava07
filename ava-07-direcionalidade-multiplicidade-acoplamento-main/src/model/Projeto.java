package model;

import java.util.ArrayList;

public class Projeto {

  private final String nome;
  private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

  public Projeto(String nome) {
    this.nome = nome;
  }

  public Projeto(String nome, ArrayList<Desenvolvedor> devs){
          this.nome = nome;
          this.desenvolvedores = devs;
  }


  public String getNome() {
    return nome;
  }

  public ArrayList<Desenvolvedor> getDesenvolvedores() {
    ArrayList<Desenvolvedor> temp1 = this.desenvolvedores;
    return temp1;
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
    for (Desenvolvedor desenvolvedor : desenvolvedores) {
        if(dev.getNome().equals(desenvolvedor.getNome())){
          return true;
        }
    }
    return false;
  }
}
