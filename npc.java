package rpg;
//é interessante que essa clsse tenha heranças para poder diferencias os métodos de cada classe de npc.
/*
 1-taberneiro - vende comida (só meme). vv
 2-armeiro - vende armas e armadura. vv
 3-vendedor - vende tochas, poções e antídoto. vv
 4-nobre - cobra imposto. vv
 5-transeunte - fala. vv
 */
public class npc {
    private String nome;
    private String descricao;
    private int categoria;

    public void set_npc(String nome, String descricao, int categoria){
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String get_nome(){
        return this.nome;
    }

    public String get_descricao(){
        return this.descricao;
    }

    public int get_cat(){
        return this.categoria;
    }

    public void fala(String fala){
        System.out.println("- " + fala + ".");
    }

    public void resumo(){
        System.out.println("informações do npc:" + this.descricao + ", " + this.nome);
    }

}
//REVISAR PARA TENTAR ESTABELECER UMA RELAÇÃO DE HERANÇA MELHOR E RESCREVER OS MÉTODOS.