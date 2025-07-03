package rpg;
import java.util.Random;
//O loot deverá ser ddefinido através de funções rand. A não ser em drops de chefe ou partes expecíficas do jogo
public class loot {
    private String descricao; //onde foi encontrado
    private String nome; //nome do item
    private int categoria; //tipo de item
    private int raridade;
    private int atributo;

    public int get_tipo(){
        return this.categoria;
    }

    public int get_valor(){
        return this.raridade;
    }

    public void iten_chefe(String nome, String descricao, int categoria, int raridade, int atributo){
        this.nome=nome;
        this.descricao=descricao;
        this.categoria=categoria;
        this.nome=nome;
        this.atributo=atributo;
    }
    
    public void gerar_loot(int sorte, String descricao){
        this.descricao=descricao; 
        Random rand = new Random();
        String[] names = new String[] {"machado", "espada de duas mãos", "espada de uma mão", "massa", "adaga", "arco", "catalisador", "amuleto", "poção", "ouro", "tocha", "antídoto","armadura"};
        int[] cat = new int[] {0, 1, 2, 3, 4, 5, 6, 7}; //0.armas, 1.catalisador, 2.amuleto, 3.poção, 4.ouro, 5.tocha, 6.antídoto, 7.armadura.
        int index=rand.nextInt(12);
        this.nome=names[index]; //estabelece qual será o iten gerado

        if(0<=index & index<=5){
            this.categoria=cat[0]; //armas

            index=rand.nextInt(3)+1; //sorteio de raridade

            if(index==1){
                this.raridade=1;
                this.atributo=index*sorte;
                this.nome+=" comum";
            }else
            if(index==2){
                this.raridade=2;
                this.atributo=index*sorte;
                this.nome+=" raro";
            }else
            if(index==3){
                this.raridade=3;
                this.atributo=index*sorte;
                this.nome+=" épico";
            }else
            if(index==4){
                this.raridade=4;
                this.atributo=index*sorte;
                this.nome+=" lendário";
            }else{
                this.nome+="";
            }
        }else
        if(index==6){
            this.categoria=cat[1];//catalisadores

            index=rand.nextInt(3)+1; //sorteio de raridade

            if(index==1){
                this.raridade=1;
                this.atributo=index*sorte;
                this.nome+=" comum";
            }else
            if(index==2){
                this.raridade=2;
                this.atributo=index*sorte;
                this.nome+=" raro";
            }else
            if(index==3){
                this.raridade=3;
                this.atributo=index*sorte;
                this.nome+=" épico";
            }else
            if(index==4){
                this.raridade=4;
                this.atributo=index*sorte;
                this.nome+=" lendário";
            }else{
                this.nome+="";
            }
        }else
        if(index==7){
            this.categoria=cat[2];//amuletos

            index=rand.nextInt(3)+1; //sorteio de raridade

            if(index==1){
                this.raridade=1;
                this.atributo=index*sorte;
                this.nome+=" comum";
            }else
            if(index==2){
                this.raridade=2;
                this.atributo=index*sorte;
                this.nome+=" raro";
            }else
            if(index==3){
                this.raridade=3;
                this.atributo=index*sorte;
                this.nome+=" épico";
            }else
            if(index==4){
                this.raridade=4;
                this.atributo=index*sorte;
                this.nome+=" lendário";
            }else{
                this.nome+="";
            }
        }else
        if(index==8){
            this.categoria=cat[3]; //poções

            index=rand.nextInt(3)+1; //sorteio de raridade

            if(index==1){
                this.raridade=1;
                this.atributo=1;
                this.nome+=" de cura";
            }else
            if(index==2){
                this.raridade=2;
                this.atributo=2;
                this.nome+=" de força";
            }else
            if(index==3){
                this.raridade=3;
                this.atributo=50;
                this.nome+=" de resistência";
            }else
            if(index==4){
                this.raridade=4;
                this.atributo=2;
                this.nome+=" de magia";
            }else{
                this.nome+="";
            }
        }else
        if(index==9){
            this.categoria=cat[4]; //ouro

            index=rand.nextInt(3)+1; //sorteio de raridade

            if(index==1){
                this.raridade=1;
                this.atributo=index*sorte;
                this.nome+=", pouco";
            }else
            if(index==2){
                this.raridade=2;
                this.atributo=index*sorte;
                this.nome+=", médio";
            }else
            if(index==3){
                this.raridade=3;
                this.atributo=index*sorte;
                this.nome+=", razoável";
            }else
            if(index==4){
                this.raridade=4;
                this.atributo=index*sorte;
                this.nome+=", MUITO";
            }else{
                this.nome+="";
            }
        }else
        if(index==10){
            this.categoria=cat[5]; //tocha

            index=rand.nextInt(3)+1; //sorteio de raridade

            if(index==1){
                this.raridade=1;
                this.atributo=index;
                this.nome+=" (1)";
            }else
            if(index==2){
                this.raridade=2;
                this.atributo=index;
                this.nome+=" (2)";
            }else
            if(index==3){
                this.raridade=3;
                this.atributo=index;
                this.nome+=" (3)";
            }else
            if(index==4){
                this.raridade=4;
                this.atributo=index;
                this.nome+=" (4)";
            }else{
                this.nome+="";
            }
        }else
        if(index==11){
            this.categoria=cat[6]; //antídoto

            index=rand.nextInt(3)+1; //sorteio de raridade

            if(index==1){
                this.raridade=1;
                this.atributo=index;
                this.nome+=" (1)";
            }else
            if(index==2){
                this.raridade=2;
                this.atributo=index;
                this.nome+=" (2)";
            }else
            if(index==3){
                this.raridade=3;
                this.atributo=index;
                this.nome+=" (3)";
            }else
            if(index==4){
                this.raridade=4;
                this.atributo=index;
                this.nome+=" (4)";
            }else{
                this.nome+="";
            }
        }else
        if(index==12){
            this.categoria=cat[7]; //armadura.

            index=rand.nextInt(3)+1; //sorteio de raridade.

            if(index==1){
                this.raridade = 1;
                this.atributo = this.raridade*sorte;
                this.nome = "armadura comum";
            }else
            if(index==2){
                this.raridade = 2;
                this.atributo = this.raridade*sorte;
                this.nome = "armadura rara";
            }else
            if(index==1){
                this.raridade = 3;
                this.atributo = this.raridade*sorte;
                this.nome = "armadura epica";
            }else
            if(index==4){
                this.raridade = 4;
                this.atributo = this.raridade*sorte;
                this.nome = "armadura lendaria";
            }
        }
    }

    public int get_atributo(){
        return this.atributo;
    }
    public int get_categoria(){
        return this.categoria;
    }
    public int get_raridade(){
        return this.raridade;
    }

    public String get_nome(){
        return this.nome;
    }

    public void resumo_item(){
        System.out.println("Item encontrado em " + this.descricao +": " + this.nome
         + "\n atributo:" + this.atributo);
    }
//ADICIONAR SETER DE LOOT PARA CRIAR LOOT ESCRIPTADO??
}
