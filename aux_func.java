package rpg;

import java.util.Scanner;

public class aux_func {
    Scanner scan = new Scanner(System.in);
    //aqui serão implementadas as funções auxiliares ao program principal.

    //reset de personagens jogáveis após o combate.
    public void resset(personagem p1, personagem p2, personagem p3, personagem p4){
        p1.set_hp();
        p1.set_status();

        p2.set_hp();
        p2.set_status();

        p3.set_hp();
        p3.set_status();

        p4.set_hp();
        p4.set_status();
    }

    //drop de iten coletável de inimigos comuns
    public void loot(personagem p, loot item, fase f, inimigo i){
        new TelaInformacoes(p, f, i, item);
        item.gerar_loot(p.get_luck(), "enocntrado no cadaver de um inimigo morto.");
        item.resumo_item();

        int op;
        System.out.println("Deseja coletar o item:\n[1].sim\t[2].não");
        op = scan.nextInt();
        if(op==1){
            p.coletar_loot(item.get_nome(), item.get_atributo(), item.get_categoria(), item.get_raridade());
        }else{
            System.out.println("Item deixado para trás");
        }
    }

    //drop de itens de chefes
    public void loot_chefe(personagem p, loot item, fase f, boss i){
        new TelaInformacoes(p, f, i, item);
        item.resumo_item();

        int op;
        System.out.println("Deseja coletar o item:\n[1].sim\t[2].não\nFORTEMENTE RECOMENDADO QUE SIM.");
        op = scan.nextInt();
        if(op==1){
            p.coletar_loot(item.get_nome(), item.get_atributo(), item.get_categoria(), item.get_raridade());
        }else{
            System.out.println("Item deixado para trás");
        }
    }

    //seções de combate
    public void sec_cmbt(personagem p, inimigo mob, fase f, loot item){ //combate adapatável com inimigos comuns e chefes.
        new TelaInformacoes(p, f, mob, item);
        if(p.get_status()==true){
            while(p.get_status()==true){
                //p luta
                double Pdano=p.combate();
                System.out.println("Dano dado:" + Pdano);
                mob.dano(Pdano, 1, f.get_status(p.get_item()));
                System.out.println("Vida do inimigo:" + mob.get_hp());
                if(mob.get_status()==false){
                    break;
                }else{
                    double Mdano=mob.ataque();
                    System.out.println("Dano recebido:" + Mdano);
                    p.set_dano(Mdano, f.get_status(p.get_item()), 1);
                }
            }
        }else{
            System.out.println("fora de combate.");
        }
    }

    //seções de combate com chefe
    public void boss_cmbt(boss boss, fase arena, personagem p, loot item){
        new TelaInformacoes(p, arena, boss, item);
        while(p.get_status()==true){
                //p1 luta
                double Pdano=p.combate();
                System.out.println("Dano dado:" + Pdano);
                boss.dano(Pdano, 1, arena.get_status(p.get_item()));
                System.out.println("Vida do inimigo:" + boss.get_hp());
                boss.cura();
                if(boss.get_status()==false){
                    break;
                }else{
                    double Mdano=boss.ataque();
                    System.out.println("Dano recebido:" + Mdano);
                    p.set_dano(Mdano, arena.get_status(p.get_item()), 1);
                }
        }
    }

    //interação com taberneiro
    public void taberneiro(taberneiro zeca, personagem p ){
        zeca.mostra_catalogo();
        int compra=scan.nextInt();
        p.comprar(zeca.vender(compra));
    }

    //interação com o armeiro
    public void armeiro(armeiro thomas, personagem p){
        thomas.mostra_catalogo();
        int compra=scan.nextInt();
        if(p.ctrl_compra(thomas.vender(compra),compra)==true){
            p.comprar(thomas.vender(compra));
            p.coletar_loot(thomas.nome(compra), thomas.atributo(compra), thomas.categoria(compra), 1);
        }else{
            thomas.fala("pobre!");
        }
    }

    //interação com o vendedor
    public void vendedor(vendedor da_luz, personagem p){
        da_luz.mostra_catalogo();
        int compra=scan.nextInt();
        if(p.ctrl_compra(da_luz.vender(compra),compra)==true){
            p.comprar(da_luz.vender(compra));
            p.coletar_loot(da_luz.nome(compra), da_luz.drop(compra), da_luz.categoria(compra), da_luz.drop(compra));
        }else{
            da_luz.fala("arrego!");
        }
    }

    //interação com o nobre
    public void nobre(nobre haddad, personagem p){
        haddad.fala("pague seus impostos!");
        p.pagar_imposto(haddad.cobrar_impostos());
    }
}
