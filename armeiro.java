package rpg;

import java.util.Random;

public class armeiro extends npc{
    private String[] catalogo;
    private int[] cat;
    private int[] preco;

    public void set_catalogo(){ //se a herança vier de taberneiro, deve usar @Override?
        Random rand  = new Random();

        this.catalogo = new String[4];
        this.cat = new int[4];
        this.preco = new int[4];

        this.catalogo[0] = "arma";
        this.catalogo[1] = "catalisador";
        this.catalogo[2] = "amuleto";
        this.catalogo[3] = "armadura";

        this.cat[0] = 20+rand.nextInt(60);
        this.cat[1] = 20+rand.nextInt(60);
        this.cat[2] = 20+rand.nextInt(60);
        this.cat[3] = 20+rand.nextInt(60);

        this.preco[0] = 40;
        this.preco[1] = 60;
        this.preco[2] = 55;
        this.preco[3] = 50;
    }

    public void mostra_catalogo(){
        System.out.println("Opções a venda:\n" + "1." + this.catalogo[0] + " - atriburo:" + this.cat[0] + " - preço:" + this.preco[0] + " de ouro." 
        + "2." + this.catalogo[1] + " - atriburo:" + this.cat[1] + " - preço:" + this.preco[1] + " de ouro."
        + "3." + this.catalogo[2] + " - atriburo:" + this.cat[2] + " - preço:" + this.preco[2] + " de ouro."
        + "4." + this.catalogo[3] + " - atriburo:" + this.cat[3] + " - preço:" + this.preco[3] + " de ouro.\ndigite [0] para sair.");
    }

    public int vender(int op){ //retorna preço do item comprado.
        int preco=0;
        if(op==1){
            preco = this.preco[0];
        }else
        if(op==2){
            preco = this.preco[1];
        }else
        if(op==3){
            preco = this.preco[2];
        }else
        if(op==4){
            preco = this.preco[3];
        }else{
            System.out.println("até logo!");
        }
        return preco;
    }

    public int atributo(int op){ //retorna atributo do item comprado. definir categorias dos itens comprado
        int atributo=0;
        if(op==1){
            atributo = this.cat[0];
        }else
        if(op==2){
            atributo = this.cat[1];
        }else
        if(op==3){
            atributo = this.cat[2];
        }else
        if(op==4){
            atributo = this.cat[3];
        }else{
            atributo=0;
        }
        return atributo;
    }
    public int categoria(int op){
        int categoria=0;
        if(op==1){
            categoria = 0;
        }else
        if(op==2){
            categoria = 1;
        }else
        if(op==3){
            categoria = 2;
        }else
        if(op==4){
            categoria = 7;
        }else{
            categoria=0;
        }
        return categoria;
    }

    public String nome(int op){
        String nome;
        if(op==1){
            nome="arma";
        }else
        if(op==2){
            nome="catalisador";
        }if(op==3){
            nome="amuleto";
        }else
        if(op==4){
            nome="armadura";
        }else{
            nome="";
        }
        return nome;
    }
}
