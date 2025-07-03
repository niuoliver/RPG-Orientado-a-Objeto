package rpg;
import java.util.Scanner;
import java.util.Random;

public class personagem {
    private String nome;
    private String gen;
    private String classe;
    private String[] equip;
    private int[] equipamento;
    private int tip_pocao;
    private int pocao;
    private int forca;
    private int dex;
    private int intel;
    private int feh;
    private int luck;
    private double hp;
    private boolean status; //vivo ou morto.

    //atributos de controle de uso de consumíveis.
    private boolean poc_ativa;
    private boolean item_ativa;
    
    //atributos de controle para emissão de mensagens.
    public int get_ataque(){
        return this.equipamento[0];
    }
    public int get_defesa(){
        return this.equipamento[3];
    }

    public int get_dinheiro(){
        return this.equipamento[5];
    }
    //------------------------------------------------

    Scanner scanner = new Scanner(System.in);

//MÉTODOS DO PERSONAGEM.-----------------------------------------------------------------------------------------------------------

    public void set_status(){ //seta o personagem com configurações iniciais.
        this.status = true;
        this.item_ativa = false;
        this.poc_ativa = false;
    }

    public void set_hp(){ //seta o personagem com a vida máxima.
        this.hp = 100;
    }

    public boolean get_item(){ //usado para cancelar os status negativos de fases, quando existir.
        return this.item_ativa;
    }

    public boolean get_status(){//retorna status do personagem
        if(this.status==true){
            return true;
        }
        else{
            return false;
        }
    }

    public double get_hp(){ //retorna a vida do persoanegm
        return this.hp;
    }

    public int get_luck(){ //retorna o atributo sorte do personagem
        return this.luck;
    }

    public String get_nome(){
        return this.nome;
    }

    public boolean usar_tocha(){ //inibe status de escuridão da fase
        boolean tocha=false;
        if(this.equipamento[6]>0){
            this.equipamento[6]-=1;
            tocha=true;
        }else{
            tocha=false;
        }
        return tocha;
    }

    public boolean usar_antidoto(){ //inibe status de veneno da fase
        boolean antidoto=false;
        if(this.equipamento[7]>0){
            this.equipamento[7]-=1;
            antidoto=true;
        }else{
            antidoto=false;
        }
        return antidoto;
    }

    public boolean usar_pocao() {
        boolean pocao;
        if (this.equipamento[4] != 0) {
            if (this.tip_pocao == 1) {
                set_hp();
                this.equipamento[4]=0;
                pocao = true;
            } else {
                pocao = true;
            }
        } else {
            pocao = false;
        }
        return pocao;
    }

    public void set_dano(double dano, boolean status_fase, int tipo_fase){ //dano tomado pelo personagem em combate.
        if(status_fase==true & tipo_fase==2){
            this.hp-=10;
            System.out.println("recebeu 10 de dano venenoso. A fase é venenosa.");
        }else{
            this.hp=this.hp*1;
        }
        //chance de miss.
        Random rand = new Random();
        int miss = rand.nextInt(5); //sorteio da chance de miss.
        int bet=this.dex*miss; //multiplicado pela destreza do personagem que recebe o golpe.
        if(bet>40){
            dano = 0;
            System.out.println("esquivou do ataque.");
        }else{
            if(this.poc_ativa==true & this.tip_pocao==3){
                dano-=this.equipamento[4];
                this.equipamento[4]=0;
            }else{
                dano=dano*1;
            } 
            
            if(dano<=this.equipamento[3]){
                dano=10;
            }else{
                dano-=this.equipamento[3];//estabelece relação entre dano e armadura.  
            }   
        }
        this.hp -= dano; 
        if(this.hp>0){ //confere se o personagem continua vivo para proseguir o combate.
            this.status = true;
            System.out.println(this.nome + " ainda está vivo.\nSaúde:" + get_hp() + " hp."); //()
        }
        else{
            this.status = false;
            System.out.println(this.nome + " está morto.\n");
        }
    }

    //haverá no main a opção de coletar ou não o loot e para qual personagem enviar.
    public void coletar_loot(String nome, int atributo, int categoria, int raridadde){ //recebe atributos do loot gerado ou comprado e distribui no inventário do personagem.
        if(categoria==0){
            this.equipamento[0]=atributo; //armas
            this.equip[0]=nome;
        }else
        if(categoria==1){
            this.equipamento[1]=atributo; //catalisadores
            this.equip[1]=nome;
        }else
        if(categoria==2){
            this.equipamento[2]=atributo; //amuletos
            this.equip[2]=nome;
        }else
        if(categoria==7){
            this.equipamento[3]=atributo; //armaduras
            this.equip[3]=nome;
        }else
        if(categoria==3){
            this.equipamento[4]=atributo; //poções
            this.equip[4]=nome;
            this.tip_pocao=raridadde;
        }
        else
        if(categoria==4){
            this.equipamento[5]+=atributo; //ouro
        }else
        if(categoria==5){
            this.equipamento[6]+=atributo; //tocha
        }else
        if(categoria==6){
            this.equipamento[7]+=atributo; //antídoto
        }
    }
    
    //CRIAR MÉTODO PARA COMPRAR ITENS DOS n TIPOS DE NPCs.
    public boolean ctrl_compra(int preco, int op){
        boolean controle;
        if(preco>this.equipamento[5] || op==0){
            controle=false;
        }else{
           controle=true;
        }
        return controle;
    }
    public void comprar(int preco){
        if(preco>this.equipamento[5]){
            System.out.println("ouro insuficiente.");
        }else{
           this.equipamento[5]-=preco; 
           System.out.println("trato feito.");
        }   
    }
    //CRIAR MÉTODO PARA PAGAR IMPOSTO.
    public void pagar_imposto(int imposto){
        if(imposto>this.equipamento[5]){
            this.equipamento[5]=0;
            System.out.println("ele pegou todo seu ouro.");
        }else{
            this.equipamento[5]-=imposto;
            System.out.println("você pagou " + imposto + " de imposto.");
        }
    }
    
    //em sessões de combate: while(pn.get_status()==true){o pau come}
    
    public double combate(){
        double dano=1;
        int op;
        System.out.println("Escolha uma ação:\n[1].ataque físico.\n[2].ataque magico.\n[3].milagre.\n[4].usar poção.\n[5].usar tocha.\n[6].usar antídoto.");
        op=scanner.nextInt();
        
        if(op==1){
            dano = this.equipamento[0]+(this.forca*0.1); //ataque fisico
            if(this.poc_ativa==true & this.tip_pocao==2){
                dano=dano*this.equipamento[4];
                this.equipamento[4]=0;
            }
        }else
        if(op==2){
            dano = this.equipamento[1]+(this.intel*0.1); //ataque magico
            if(this.poc_ativa==true & this.tip_pocao==4){
                dano=dano*this.equipamento[4];
                this.equipamento[4]=0;
            }
        }else
        if(op==3){
            dano = this.equipamento[2]+(this.feh*0.1); // milagre
            if(this.poc_ativa==true & this.tip_pocao==4){
                dano=dano*this.equipamento[4];
                this.equipamento[4]=0;
            }
        }else
        if(op==4){ 
            this.poc_ativa = usar_pocao();   //usar poção
            if(this.poc_ativa==true){
                System.out.println("Usou poção.");
            }else{
                System.out.println("Sem uso de poção"); 
            }
            dano=0;
        }else 
        if(op==5){
            this.item_ativa=usar_tocha();  //uasar tocha 
            dano=0;
        }else
        if(op==6){
            this.item_ativa=usar_antidoto(); //usar antidoto
            dano=0;
        }/*else{
            System.out.println("passou o turno.");
            dano=0;
        }*/
        return dano;
    }

//CRIAÇÃO DE PERSONAGEM.------------------------------------------------------------------------------------------------------------
    void nome_genero(){//atribuir nome e gênero ao personagem.
        
        //entrada de dados para o nome do herói.
        System.out.println("Digite o nome do seu herói:\n");
        this.nome = scanner.nextLine();
        
        //entrada de dados para o gênero do herói.
        int op;
        System.out.println("Escolha o gênero do seu herói.\n[1].Masculino.\n[2].Feminino.\n");
        op = scanner.nextInt();

        if (op==1){
            this.gen = "masculino";
        }else
        if (op ==2){
            this.gen = "feminino";
        }
    }

    void classe(){//Escolha da classe do herói e definição de seus atributos.
        //Entrada de dados para a escolha da classe do herói.
        int op;
        System.out.println("Escolha uma classe:\n[1].Guerreiro.\n[2].Cavaleiro.\n[3].Ranger.\n[4].Mago.\n[5].Sacerdote.\n[6].Bruxo.\n");
        op = scanner.nextInt();

        if (op == 1){
            this.classe = "Guerreiro";
            this.hp = 100;
            this.forca = 18;
            this.dex = 9;
            this.intel = 4;
            this.feh = 6;
            this.luck = 11;

        }else
        if (op == 2){
            this.classe = "Cavaleiro";
            this.hp = 100;
            this.forca = 13;
            this.dex =13;
            this.intel = 9;
            this.feh = 9;
            this.luck = 7;

        }else
        if (op == 3){
            this.classe = "Ranger";
            this.hp = 100;
            this.forca = 10;
            this.dex = 20;
            this.intel = 8;
            this.feh = 6;
            this.luck = 11;

        }else
        if (op == 4){
            this.classe = "Mago";
            this.hp = 100;
            this.forca = 7;
            this.dex = 12;
            this.intel = 18;
            this.feh = 6;
            this.luck = 12;

        }else
        if (op== 5){
            this.classe = "Sacerdote";
            this.hp = 100;
            this.forca = 12;
            this.dex = 8;
            this.intel = 7;
            this.feh = 18;
            this.luck = 13;

        }else
        if(op == 6){
            this.classe = "Bruxo";
            this.hp = 100;
            this.forca = 11;
            this.dex = 13;
            this.intel = 14;
            this.feh =14;
            this.luck = 6;
        }
        else{
            System.out.println("Opção inválida.");
        } 
    }

    void equipamento(){ //Inicializa o inventário base de cada personegem.
        this.equip = new String[8];
        this.equipamento = new int[8];
        /*Guia de indicies do inventário:
        cada slot do inventário armazena o valor do atributo básico do item armazenado nesse slot.
         0 - arma(ataque físico), 1- catalisador(magia), 2- amuleto(milagres), 3- armadura, 4- poção, 5- ouro, 6- tocha, 7- antidoto.
        */

        if(this.classe=="Guerreiro"){
            this.equip[0]="machado comum";
            this.equip[1]="sem catalisador";
            this.equip[2]="sem amuleto";
            this.equip[3]="armadura de couro pesada comum"; //{"Machado comum, armadura de couro pesada comum."};
            this.equip[5]="ouro";
            this.equip[6]="tochas";
            this.equip[7]="antidoto";
            this.equipamento[0]=80;
            this.equipamento[1]=0;
            this.equipamento[2]=0;
            this.equipamento[3]=50;
            this.equipamento[5]=10;
            this.equipamento[6]=5;
            this.equipamento[7]=1;
            
        }else
        if(this.classe=="Cavaleiro"){
            this.equip[0]="espada de duas mãos comum";
            this.equip[1]="sem catalisador";
            this.equip[2]="sem amuleto";
            this.equip[3]="armadura de cavaleiro pesada comum";//"Armadura de cavaleiro pesada comum, espada de duas mãos comum.";
            this.equip[5]="ouro";
            this.equip[6]="tochas";
            this.equip[7]="antidoto";
            this.equipamento[0]=70;
            this.equipamento[1]=0;
            this.equipamento[2]=0;
            this.equipamento[3]=70;
            this.equipamento[5]=10;
            this.equipamento[6]=5;
            this.equipamento[7]=1;
            
        }else
        if(this.classe=="Ranger"){
            this.equip[0]="arco de ranger comum";
            this.equip[1]="sem catalisador";
            this.equip[2]="sem amuleto";
            this.equip[3]="vestes de ranger comum";//"Vestes de ranger comum, arco de ranger comum.";
            this.equip[5]="ouro";
            this.equip[6]="tochas";
            this.equip[7]="antidoto";
            this.equipamento[0]=60;
            this.equipamento[1]=0;
            this.equipamento[2]=0;
            this.equipamento[3]=20;
            this.equipamento[5]=10;
            this.equipamento[6]=5;
            this.equipamento[7]=1;
            
        }else
        if(this.classe=="Mago"){
            this.equip[0]="adaga comum";
            this.equip[1]="catalisador de mago comum";
            this.equip[2]="sem amuleto";
            this.equip[3]="túnicas de mago comum";//"Túnicas de mago comum, adaga de prata comum , catalisador de mago comum.";
            this.equip[5]="ouro";
            this.equip[6]="tochas";
            this.equip[7]="antidoto";
            this.equipamento[0]=30;
            this.equipamento[1]=80;
            this.equipamento[2]=0;
            this.equipamento[3]=10;
            this.equipamento[5]=10;
            this.equipamento[6]=5;
            this.equipamento[7]=1;
            
        }else
        if(this.classe=="Sacerdote"){
            this.equip[0]="massa comum";
            this.equip[1]="sem catalisador";
            this.equip[2]="amuleto comum";
            this.equip[3]="tunicas de sacerdote comum";//"Túnicas de sacerdorte comum, estrela da manha comum, amuleto de sacerdote comum.";
            this.equip[5]="ouro";
            this.equip[6]="tochas";
            this.equip[7]="antidoto";
            this.equipamento[0]=40;
            this.equipamento[1]=0;
            this.equipamento[2]=80;
            this.equipamento[3]=20;
            this.equipamento[5]=10;
            this.equipamento[6]=5;
            this.equipamento[7]=1;
            
        }else
        if(this.classe=="Bruxo"){
            this.equip[0]="espada de uma mão comum";
            this.equip[1]="catalisador de prata comum";
            this.equip[2]="amuleto de prata comum";
            this.equip[3]="armadura de couro comum";//"Armadura de couro leve comum, espada de uma mão comum, catalisador de prata comum, amuleto de prata comum.";
            this.equip[5]="ouro";
            this.equip[6]="tochas";
            this.equip[7]="antidoto";
            this.equipamento[0]=60;
            this.equipamento[1]=40;
            this.equipamento[2]=40;
            this.equipamento[3]=30;
            this.equipamento[5]=10;
            this.equipamento[6]=5;
            this.equipamento[7]=1;
            
        }else{
            this.equip[0]="sem arma";
            this.equip[1]="sem catalisador";
            this.equip[2]="sem amuleto";
            this.equip[3]="sem armadura";
        }

        //menu com condicionais para a escolha da poção inicial.
        int op;
        System.out.println("Escolha uma poção inicial:\n[1].poção de cura\n[2].poção de força\n[3].poção de resistência\n[4].poção de magia.");
        op = scanner.nextInt();
        if (op == 1){
            this.tip_pocao =1; //enche a vida do personagem.
            this.pocao = 1;
            this.equipamento[4]=this.pocao;
            this.equip[4]="pocao de cura";
        }
        else
        if(op == 2){
            this.tip_pocao = 2; //dobra o ataque físico 
            this.pocao = 2;
            this.equipamento[4]=this.pocao;
            this.equip[4]="pocao de forca";
        }
        else
        if(op == 3){
            this.tip_pocao = 3; //aumenta em 50 a armadura
            this.pocao = 50;
            this.equipamento[4]=this.pocao;
            this.equip[4] ="pocao de resistencia";
        }
        else
        if(op == 4){
            this.tip_pocao = 4; //dobra o ataque mágico
            this.pocao = 2;
            this.equipamento[4]=this.pocao;
            this.equip[4] ="pocao de magia";
        }else{
            System.out.println("Sem poção inicial.");
            this.equipamento[4]=0;
        }
    }
    
    public void resumo(String user){
        System.out.println("informações do personagem:\nusuário: " + user
        + "\nnome:" + this.nome + "\ngênero:" + this.gen + "\nclasse:" + this.classe
        + "\n\tatributos" 
        + "\nvigor:" + this.hp
        + "\nforça:" + this.forca 
        + "\ndestreza:" + this.dex 
        + "\ninteligência:" + this.intel 
        + "\nfé:" + this.feh 
        + "\nsorte:" + this.luck);

        System.out.println("inventário:\n"); 
        for(int i=0; i<=7; i++){
            System.out.println(this.equipamento[i] + ", " + this.equip[i] + "\n");
        }
    }
}