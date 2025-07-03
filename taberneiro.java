package rpg;

public class taberneiro extends npc{
    private String[] catalogo; //nomes dos itens vendidos.
    private int[] preco; //preços.

    public void set_catalogo(){ //declarar o tamanho dos arrays é necessário??

        this.preco = new int[3];
        this.catalogo = new String[3];

        this.catalogo[0] = "cerveja";
        this.catalogo[1] = "frango a passarinho";
        this.catalogo[2] = "palheiro";

        this.preco[0] = 5;
        this.preco[1] = 10;
        this.preco[2] = 2;
    }

    public void mostra_catalogo(){
        System.out.println("Opções à venda:\n" + "1."+ this.catalogo[0] + "- preço:" + this.preco[0] + " de ouro."  + "2." + this.catalogo[1] + "- preço:" + this.preco[1] + " de ouro." + "3." + this.catalogo[2] + "- preço:" + this.preco[2] + " de ouro.");
    }

    public int vender(int op){ //essa entrada será dada por um input em terminal no programa principal.
        int preco=0;
            
        if(op==1){
            preco=this.preco[0];
            //retorna preço da opção um.
        }else
        if(op==2){
            preco=this.preco[1];
            //retorna o preço da opção dois.
        }else
        if(op==3){
            preco=this.preco[2];
            //retorna o preço da opção três.
        }else{
            System.out.println("até logo!");
        }//O preço dos produtos será dado como parâmetro no métoco de compra na classe personagem.
        return preco;
    }
    
}
