package rpg;

public class fase {
    private String nome;
    private String descricao;
    private String dificuldade;
    private int tipo; //1-normal, 2-venenosa, 3-escura.
    private boolean status;

    //ex; escuridão - aumenta a chance de errar ataques, obriga o jogadpr a gastar um item "tocha" para mitigar o status negativo.*/
    //    veneno - a cada turno os jogadores perdem uma certa quantidade de vida.

    public void set_fase(String dificuldade, String nome, String descricao, int tipo, boolean status){
        this.dificuldade = dificuldade;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.status = status;
    }

    public String get_dificuldade(){
        return this.dificuldade;
    }

    public String get_nome(){
        return this.nome;
    }

    public String get_descricao(){
        return this.descricao;
    }

    public int get_tipo(){
        return this.tipo;
    }

    public boolean get_status(boolean item){ //recebe como entreta o valor que o personagem gera ao usar ou não um item.
        if(item==true){
            this.status=false;
        }else{
            this.status=true;
        }
        return this.status;
    }

    public void resumo(){
        System.out.println("informações da fase:" + this.nome + ", tipo " + this.descricao);
    }

}    
