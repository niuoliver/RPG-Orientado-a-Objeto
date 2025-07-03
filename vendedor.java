package rpg;

import java.util.Random;

public class vendedor extends npc {
    Random rand = new Random();

    private String[] catalogo;
    private int[] preco;

    public void set_catalogo(){
        this.catalogo = new String[3];
        this.preco = new int[3];

        this.catalogo[0]="tocha(5)";
        this.catalogo[1]="antidoto(2)";
        this.catalogo[2]="poção misteriosa";

        this.preco[0]=5;
        this.preco[1]=10;
        this.preco[2]=30;
    }

    public void mostra_catalogo(){
        System.out.println("Opções a venda:\n" + "1." + this.catalogo[0] + " - preço:" + this.preco[0]
        + "2." + this.catalogo[1] + " - preço:" + this.preco[1]
        + "3." + this.catalogo[2] + " - preço:" + this.preco[2] + "\ndigite [0] para sair.");
    }

    public int vender(int op){ 
        int preco=0;
        if(op==1){
            preco=this.preco[0];
        }else
        if(op==2){
            preco=this.preco[1];
        }else
        if(op==3){
            preco=this.preco[2];
        }else{
            System.out.println("até logo!");
        }
        return preco;
    }

    //GETTER PARA NOME 
    public String nome(int op){
        String nome;
        if(op==1){
            nome = "tochas(5)";
        }else
        if(op==2){
            nome = "antidoto(2)";
        }else
        if(op==3){
            nome = "poção misteriosa";
        }else{
            nome="";
        }
        return nome;
    }

    //GETTER PARA CATERGORIA
    public int categoria(int op){
        int categoria;
        if(op==1){
            categoria=5;
        }else
        if(op==2){
            categoria=6;
        }else
        if(op==3){
            categoria=3;
        }else{
            categoria=0;
        }
        return categoria;
    }

    public int drop(int op){ //definir números das categorias de loot
        int drop=0;
        if(op==1){
            drop=5; //qtd - atributo
        }else
        if(op==2){
            drop=2; //qtd - atributo
        }else
        if(op==3){
            drop=1+rand.nextInt(3); //tipo de poção - raridade.
        }else{
            System.out.println("");
        }
        return drop;
    }
}
