package interacaoentreclasses.outros;

import javax.swing.JOptionPane;

public class Exemplo {

    String nome;
    String funcao;
    String tipo_dano;

    void funcao(int funcao) {
        switch (funcao) {
            case 0:
                this.funcao = "Nenhuma função declarada!";
                break;
            case 1:
                this.funcao = "Tanque";
                break;
            case 2:
                this.funcao = "Lutador";
                break;
            case 3:
                this.funcao = "Mago";
                break;
            case 4:
                this.funcao = "Assasino";
                break;
            case 5:
                this.funcao = "Atirador";
                break;
            case 6:
                this.funcao = "Suporte";
                break;
        }
    }

    void tipo_dano(int tipo_dano) {
        if (tipo_dano == 1) {
            this.tipo_dano = "AP";
        } else {
            this.tipo_dano = "AD";
        }
    }

    void nome(String nome) {
        this.nome = nome;
        //nome = JOptionPane.showInputDialog("Qual o nome do Campeão?");
    }

    public static void main(String[] args) {
        Exemplo exemplo = new Exemplo();
        exemplo.funcao(1);
        System.out.println(exemplo.funcao);
        exemplo.tipo_dano(0);
        System.out.println(exemplo.tipo_dano);
        exemplo.nome("Annie");
        System.out.println(exemplo.nome);
    }
}
