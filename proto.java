package rpg;
 
import java.util.Scanner;


public class proto {

    public static void main(String[] args){
        //INICIALIZAÇÃO DO BANCO DE DADOS---------------------------
        Scanner scan = new Scanner(System.in); 

        aux_func rotinas = new aux_func();
        
        //NPCs.
        npc didi = new npc();
        didi.set_npc("Didi Furlam", "transeunte", 5);
        //fala: "hmm, estranho isso daí."

        npc serjao = new npc();
        serjao.set_npc("Serjão Assembly", "transeunte", 5);
        //fala: "Ahhh...Então, pessoal."

        taberneiro zeca = new taberneiro();
        zeca.set_npc("Zeca", "taberneiro", 1);
        zeca.set_catalogo();
        //fala: "Como posso ajudar?"

        armeiro thomas = new armeiro();
        thomas.set_npc("Thomas Kadu", "armeiro", 2);
        //fala: "Coé, mano. O que vai ser?"

        vendedor da_luz = new vendedor();
        da_luz.set_npc("Cabo Da Luz", "vendedor", 3);
        da_luz.set_catalogo();
        //fala: "O que você quer?"

        nobre haddad = new nobre();
        haddad.set_npc("Fernando Haddad", "nobre", 4);
        //fala: "pague seus impostos!"

        //INIMIGOS.
        inimigo morto_vivo = new inimigo();
        morto_vivo.set_mob("Grande Morto-Vivo", 1, 20, 30);
        morto_vivo.set_hp(500);
        morto_vivo.set_status();

        inimigo capi = new inimigo();
        capi.set_mob("Capimera Gigante", 2, 40, 25);
        capi.set_hp(500);
        capi.set_status();

        inimigo drago = new inimigo();
        drago.set_mob("Dragão do Mago", 3, 50, 20);
        drago.set_hp(600);
        drago.set_status();

        //CHEFES.
        boss oil = new boss(); //o grande morto vivo, sherek, mago darcimus.
        oil.set_mob("Oil Man, o morto vivo", 1, 30, 35);
        oil.set_hp(1000);
        oil.set_status();

        boss shrk = new boss();
        shrk.set_mob("Sherek, o senhor do pântano", 1, 35, 45);
        shrk.set_hp(1000);
        shrk.set_status();

        boss darcimus = new boss();  
        darcimus.set_mob("Mago Darcimus", 1, 40, 70);
        darcimus.set_hp(1000);
        darcimus.set_status();

        //ITENS COLETAVEIS.
        loot item = new loot();

        loot armadura = new loot();
        armadura.iten_chefe("Armadura de Oil Man", "lendário", 7, 4, 99);

        loot clava = new loot();
        clava.iten_chefe("Clava de Sherek", "lendário", 0, 4, 99);

        loot cat_darc = new loot();
        cat_darc.iten_chefe("Catalisador de Darcimus", "lendário", 1, 4, 99);
        
        //FASES.
        fase bar_zeca = new fase();
        bar_zeca.set_fase("neutra","Bar do Zéca", "fase normal", 1, false);

        fase cidade = new fase();
        cidade.set_fase("facil","Cidade Velha", "fase normal", 1, false);

        fase pantano = new fase();
        pantano.set_fase("medio","Pântano Barigui", "fase venenosa", 2, true);

        fase tuiti = new fase();
        tuiti.set_fase("medio","Masmorra Tuiuti", "fase escura", 3, true);

        fase arena = new fase();
        arena.set_fase("dificil","Arena de Chefe", "fase normal", 1, false);

        //----------------------------------------------------------

        //CRIAÇÃO DOS PERSONAGENS-----------------------------------
       
        personagem p1 = new personagem(); //4 personagens.
        p1.nome_genero();
        p1.classe();
        p1.equipamento();
        p1.set_status(); //método de spawn do personagem.
        p1.set_hp();     //método de spawn do personagem.
        p1.resumo("OLIVER.");

        personagem p2 = new personagem();
        p2.nome_genero();
        p2.classe();
        p2.equipamento();
        p2.set_status();
        p2.set_hp();
        p2.resumo("LÉO.");

        personagem p3 = new personagem();
        p3.nome_genero();
        p3.classe();
        p3.equipamento();
        p3.set_status();
        p3.set_hp();
        p3.resumo("JOÃO.");

        personagem p4 = new personagem();
        p4.nome_genero();
        p4.classe();
        p4.equipamento();
        p4.set_status();
        p4.set_hp();
        p4.resumo("SAYMON.");

        //----------------------------------------------------------

        //progressão do jogo----------------------------------------

        int prog=1; //variável de controle para determinar em que etapa do jogo o usuário está.
        int ct=1; //variável que controla a entrada e saída do hub do jogo.

        while(prog<8){
//bar do zéca - hub do jogo------------------------------------------------------------------
            if(ct==1){

                System.out.println("Você entrou em " + bar_zeca.get_nome() + ", " + bar_zeca.get_descricao() + "\n Aqui você pode interagir com comerciantes e figuras notáveis.");
                new TelaNpc(bar_zeca, didi, serjao, haddad, thomas, da_luz, zeca, p1, p2, p3, p4);
                while(ct==1){
                    //menu com opções das ações possíveis dentro do hub.
                    System.out.println("O que deseja fazer?\n[1].Falar com Didi.\n[2].Falar com Serjão\n[3].Falar com o taberneiro\n[4].falar com o armeiro\n[5].falar com o vendedor\n[6].falar com o nobre.[7].sair da fase");
                    int op1;
                    int esc;
                    op1=scan.nextInt();
                    if(op1==1){
                        //falar com didi.
                        didi.resumo();
                        didi.fala("hmm, estranho isso daí.");
                    }else
                    if(op1==2){
                        //falar com serjão.
                        serjao.resumo();
                        serjao.fala("Ahhh...Então, pessoal.");
                    }else
                    if(op1==3){
                        //falar com taberneiro.
                        zeca.resumo();
                        zeca.fala("como posso ajudar?");
                        //menu com opções de escolha de personagem para a interação com o npc.
                        System.out.println("selecione quem irá interagir com o comerciante:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                        esc=scan.nextInt();
                        if(esc==1){
                            rotinas.taberneiro(zeca, p1);
                        }else                        
                        if(esc==2){
                            rotinas.taberneiro(zeca, p2);
                        }else
                        if(esc==3){
                            rotinas.taberneiro(zeca, p3);
                        }else
                        if(esc==4){
                            rotinas.taberneiro(zeca, p4);
                        }else{
                            System.out.println("nada aconteceu.");
                        }
                    
                    }else
                    if(op1==4){
                        //falar com o armeiro.
                        thomas.resumo();
                        thomas.set_catalogo();
                        thomas.fala("coé, mano. qual vai ser?");
                        //menu com opções de escolha de personagem para a interação com o npc.
                        System.out.println("selecione quem irá interagir com o comerciante:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                        esc=scan.nextInt();
                        if(esc==1){
                            rotinas.armeiro(thomas, p1);
                        }else
                        if(esc==2){
                            rotinas.armeiro(thomas, p2);
                        }else
                        if(esc==3){
                            rotinas.armeiro(thomas, p3);
                        }else
                        if(esc==4){
                            rotinas.armeiro(thomas, p4);
                        }else{
                            System.out.println("nada aconteceu.");
                        }
                    }else
                    if(op1==5){
                        //falar com o vendedor.
                        da_luz.resumo();
                        da_luz.fala("o que você quer?");
                        //menu com opções de escolha de personagem para a interação com o npc.
                        System.out.println("selecione quem irá interagir com o comerciante:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                        esc=scan.nextInt();
                        if(esc==1){
                            rotinas.vendedor(da_luz, p1);
                        }else
                        if(esc==2){
                            rotinas.vendedor(da_luz, p2);
                        }else
                        if(esc==3){
                            rotinas.vendedor(da_luz, p3);
                        }else
                        if(esc==4){
                            rotinas.vendedor(da_luz, p4);
                        }else{
                            System.out.println("nada aconteceu.");
                        }
                    }else
                    if(op1==6){
                        //falar com nobre.
                        haddad.resumo();
                        //menu com opções de escolha de personagem para a interação com o npc.
                        System.out.println("selecione quem irá interagir com o comerciante:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                        esc=scan.nextInt();
                        if(esc==1){
                            rotinas.nobre(haddad, p1);
                        }else
                        if(esc==2){
                            rotinas.nobre(haddad, p2);
                        }else
                        if(esc==3){
                            rotinas.nobre(haddad, p3);
                        }else
                        if(esc==4){
                            rotinas.nobre(haddad, p4);
                        }else{
                            System.out.println("nada aconteceu.");
                        }
                    }else{
                        //sair do hub.
                        System.out.println("saindo da fase.");
                        ct=0;
                    }
                } 
//cidade velha - sessão de combate------------------------------------------------------------------   
            }else
            if(prog==1 & ct!=1){
                //cidade velha - sessões de combate
                System.out.println("Você entrou em " + cidade.get_nome() + ", " + cidade.get_descricao() + 
                "\n Esse local antes foi habitável e próspero, mas agora só os mortos aqui residem.");

                morto_vivo.set_status();
                System.out.println("Inimigo encontrado:");
                morto_vivo.reusmo();
                while(morto_vivo.get_status()==true){//combate será dinâmico, mão pode ser função fixa.
                    System.out.println("escolha quem vai entrar em combate:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op2 = scan.nextInt();
                    
                    if(op2==1){
                        if(p1.get_status()==true){
                            rotinas.sec_cmbt(p1, morto_vivo, cidade,item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==2){
                        if(p2.get_status()==true){
                            rotinas.sec_cmbt(p2, morto_vivo, cidade, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==3){
                        if(p3.get_status()==true){
                            rotinas.sec_cmbt(p3, morto_vivo, cidade, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==4){
                        if(p4.get_status()==true){
                            rotinas.sec_cmbt(p4, morto_vivo, cidade, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else{
                        System.out.println("nada aconteceu.");
                    }
                    if(p1.get_status()==false & p2.get_status()==false & p3.get_status()==false & p4.get_status()==false){
                        System.out.println("todos os heróis foram derrotados.");
                        prog=1;
                        ct=1;
                        break;
                    }else{
                        System.out.println("continue.\n");

                    }   
                }
                //aqui deverá ser dropado o item.
                if(morto_vivo.get_status()==false){
                    System.out.println("selecione quem irá coletar o iten:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op3 = scan.nextInt();
                    if(op3==1){
                        rotinas.loot(p1, item, cidade, morto_vivo);
                    }else
                    if(op3==2){
                        rotinas.loot(p2, item, cidade, morto_vivo);
                    }else
                    if(op3==3){
                        rotinas.loot(p3, item, cidade, morto_vivo);
                    }else
                    if(op3==4){
                        rotinas.loot(p4, item, cidade, morto_vivo);
                    }else{
                        System.out.println("ninguém coletará o item.");
                    }
                    System.out.println("Deseja retornar ao Bar do Zeca?\n[1].sim\n[2].não");
                    int ret=scan.nextInt();
                    if(ret==1){
                        ct=1;
                    }else{
                        ct=0;
                    }
                    prog++;
                }else{
                    System.out.println("retorne ao Bar do Zeca.");
                }
                //reset
                rotinas.resset(p1, p2, p3, p4);   

//chefe - Oil Man, morto vivo------------------------------------------------------------------
            }else
            if(prog==2 & ct!=1){
                
                System.out.println("Você entrou em " + arena.get_nome() + ", " + arena.get_descricao() + 
                "\n Você está prestes a enfrenter um inimigo muito poderoso.");

                oil.set_status();
                System.out.println("Inimigo encontrado:");
                oil.reusmo();
                while(oil.get_status()==true){//combate será dinâmico, mão pode ser função fixa.
                    System.out.println("escolha quem vai entrar em combate:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op2 = scan.nextInt();
                    
                    if(op2==1){
                        if(p1.get_status()==true){
                            rotinas.boss_cmbt(oil, arena, p1, armadura);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==2){
                        if(p2.get_status()==true){
                            rotinas.boss_cmbt(oil, arena, p2, armadura);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==3){
                        if(p3.get_status()==true){
                            rotinas.boss_cmbt(oil, arena, p3, armadura);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==4){
                        if(p4.get_status()==true){
                            rotinas.boss_cmbt(oil, arena, p4, armadura);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else{
                        System.out.println("nada aconteceu.");
                    }
                    if(p1.get_status()==false & p2.get_status()==false & p3.get_status()==false & p4.get_status()==false){
                        System.out.println("todos os heróis foram derrotados, retorne ao bar do zéca.");
                        prog=1;
                        ct=1;
                        break;
                    }else{
                        System.out.println("continue.");
                    }
                }

                //aqui deverá ser dropado o item
                if(oil.get_status()==false){
                    System.out.println("selecione quem irá coletar o iten:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op4 = scan.nextInt();
                    if(op4==1){
                        rotinas.loot_chefe(p1, armadura, arena, oil);
                    }else
                    if(op4==2){
                        rotinas.loot_chefe(p2, armadura, arena, oil);
                    }else
                    if(op4==3){
                        rotinas.loot_chefe(p3, armadura, arena, oil);
                    }else
                    if(op4==4){
                        rotinas.loot_chefe(p4, armadura, arena, oil);
                    }else{
                        System.out.println("ninguém coletou o item.");
                    }
                    System.out.println("Deseja retornar ao Bar do Zeca?\n[1].sim\n[2].não");
                    int ret=scan.nextInt();
                    if(ret==1){
                        ct=1;
                    }else{
                        ct=0;
                    }
                    prog++;
                }else{
                    System.out.println("retorne ao Bar do Zeca.");
                }

                //reset
                rotinas.resset(p1, p2, p3, p4);
//pântano do barigui - sessão de combate------------------------------------------------------------------
            }else
            if(prog==3 & ct!=1){
                //pântano do barigui - sessões de combate
                System.out.println("Você entrou em " + pantano.get_nome() + ", " + pantano.get_descricao() + 
                "\n Esse local uma vez foi um belo jardim, mas hoje resta apenas um terrível pântano venenoso.");

                capi.set_status();
                System.out.println("Inimigo encontrado:");
                capi.reusmo();
                while(capi.get_status()==true){//combate será dinâmico, mão pode ser função fixa.
                    System.out.println("escolha quem vai entrar em combate:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome()  + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op2 = scan.nextInt();
                    
                    if(op2==1){
                        if(p1.get_status()==true){
                            rotinas.sec_cmbt(p1, capi, pantano, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==2){
                        if(p2.get_status()==true){
                             rotinas.sec_cmbt(p2, capi, pantano, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==3){
                        if(p3.get_status()==true){
                             rotinas.sec_cmbt(p3, capi, pantano, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==4){
                        if(p4.get_status()==true){
                             rotinas.sec_cmbt(p4, capi, pantano, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else{
                        System.out.println("nada aconteceu.");
                    }
                    if(p1.get_status()==false & p2.get_status()==false & p3.get_status()==false & p4.get_status()==false){
                        System.out.println("todos os heróis foram derrotados, retorne ao bar do zéca.");
                        prog=1;
                        ct=1;
                        break;
                    }else{
                        System.out.println("continue.\n");   
                    }
                }
                //aqui deverá ser dropado o item.
                if(capi.get_status()==false){
                    System.out.println("selecione quem irá coletar o iten:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op3 = scan.nextInt();
                    if(op3==1){
                       rotinas.loot(p1, item, pantano, capi);
                    }else
                    if(op3==2){
                        rotinas.loot(p2, item, pantano, capi);
                    }else
                    if(op3==3){
                        rotinas.loot(p3, item, pantano, capi);
                    }else
                    if(op3==4){
                        rotinas.loot(p4, item, pantano, capi);
                    }else{
                        System.out.println("ninguém coletará o item.");
                    }
                    System.out.println("Deseja retornar ao Bar do Zeca?\n[1].sim\n[2].não");
                    int ret=scan.nextInt();
                    if(ret==1){
                        ct=1;
                    }else{
                        ct=0;
                    }
                    prog++;
                }else{
                    System.out.println("retorne ao Bar do Zeca.");
                }
                //reset
                rotinas.resset(p1, p2, p3, p4);
//chefe - Sherek------------------------------------------------------------------
            }else
            if(prog==4 & ct!=1){
                 
                System.out.println("Você entrou em " + arena.get_nome() + ", " + arena.get_descricao() + 
                "\n Você está prestes a enfrenter um inimigo muito poderoso.");

                shrk.set_status();
                System.out.println("Inimigo encontrado:");
                shrk.reusmo();
                while(shrk.get_status()==true){//combate será dinâmico, mão pode ser função fixa.
                    System.out.println("escolha quem vai entrar em combate:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome()  + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op2 = scan.nextInt();
                    
                    if(op2==1){
                        if(p1.get_status()==true){
                            rotinas.boss_cmbt(shrk, arena, p1, clava);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==2){
                        if(p2.get_status()==true){
                            rotinas.boss_cmbt(shrk, arena, p2, clava);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==3){
                        if(p3.get_status()==true){
                            rotinas.boss_cmbt(shrk, arena, p3, clava);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==4){
                        if(p4.get_status()==true){
                            rotinas.boss_cmbt(shrk, arena, p4, clava);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else{
                        System.out.println("nada aconteceu.");
                    }
                    if(p1.get_status()==false & p2.get_status()==false & p3.get_status()==false & p4.get_status()==false){
                        System.out.println("todos os heróis foram derrotados, retorne ao bar do zéca.");
                        prog=1;
                        ct=1;
                        break;
                    }else{
                        System.out.println("continue.");                   
                    }
                }
                //aqui deverá ser dropado o item
                if(shrk.get_status()==false){
                    System.out.println("selecione quem irá coletar o iten:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op4 = scan.nextInt();
                    if(op4==1){
                        rotinas.loot_chefe(p1, clava, arena, shrk);
                    }else
                    if(op4==2){
                        rotinas.loot_chefe(p2, clava, arena, shrk);
                    }else
                    if(op4==3){
                        rotinas.loot_chefe(p3, clava, arena, shrk);
                    }else
                    if(op4==4){
                        rotinas.loot_chefe(p4, clava, arena, shrk);
                    }else{
                        System.out.println("ninguém coletou o item.");
                    }
                    System.out.println("Deseja retornar ao Bar do Zeca?\n[1].sim\n[2].não");
                    int ret=scan.nextInt();
                    if(ret==1){
                        ct=1;
                    }else{
                        ct=0;
                    }
                    prog++;
                }else{
                    System.out.println("retorne ao Bar do Zeca.");
                }
                //reset
                rotinas.resset(p1, p2, p3, p4);
//tuitas - sessão de combate------------------------------------------------------------------
            }else
            if(prog==5 & ct!=1){
                //tuiutas - sessões de combate
                System.out.println("Você entrou em " + tuiti.get_nome() + ", " + tuiti.get_descricao() + 
                "\n Esse local é a temida morada de Darcimus e de seu dragão de estimaçã.\nA escuridão aqui é muito densa, não da para enxergar nada.");

                drago.set_status();
                System.out.println("Inimigo encontrado:");
                drago.reusmo();
                while(drago.get_status()==true){//combate será dinâmico, mão pode ser função fixa.
                    System.out.println("escolha quem vai entrar em combate:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome()  + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op2 = scan.nextInt();
                    
                    if(op2==1){
                        if(p1.get_status()==true){
                            rotinas.sec_cmbt(p1, drago, tuiti, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==2){
                        if(p2.get_status()==true){
                            rotinas.sec_cmbt(p2, drago, tuiti, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==3){
                        if(p3.get_status()==true){
                            rotinas.sec_cmbt(p3, drago, tuiti, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==4){
                        if(p4.get_status()==true){
                            rotinas.sec_cmbt(p4, drago, tuiti, item);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else{
                        System.out.println("nada aconteceu.");
                    }
                    if(p1.get_status()==false & p2.get_status()==false & p3.get_status()==false & p4.get_status()==false){
                        System.out.println("todos os heróis foram derrotados, retorne ao bar do zéca.");
                        prog=1;
                        ct=1;
                        break;
                    }else{
                        System.out.println("continue.\n");                       
                    }
                }
                //aqui deverá ser dropado o item.
                if(drago.get_status()==false){
                    System.out.println("selecione quem irá coletar o iten:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op3 = scan.nextInt();
                    if(op3==1){
                        rotinas.loot(p1, item, tuiti, drago);
                    }else
                    if(op3==2){
                        rotinas.loot(p2, item, tuiti, drago);
                    }else
                    if(op3==3){
                        rotinas.loot(p3, item, tuiti, drago);
                    }else
                    if(op3==4){
                        rotinas.loot(p4, item, tuiti, drago);
                    }else{
                        System.out.println("ninguém coletará o item.");
                    }
                    System.out.println("Deseja retornar ao Bar do Zeca?\n[1].sim\n[2].não");
                    int ret=scan.nextInt();
                    if(ret==1){
                        ct=1;
                    }else{
                        ct=0;
                    }
                    prog++;
                }else{
                    System.out.println("retorne ao Bar do Zeca.");
                }
                //reset
                rotinas.resset(p1, p2, p3, p4);
//mago darcimus------------------------------------------------------------------
            }else
            if(prog==6 & ct!=1){
                
                System.out.println("Você entrou em " + arena.get_nome() + ", " + arena.get_descricao() + 
                "\n Você está prestes a enfrenter um inimigo muito poderoso.");
                
                darcimus.set_status();
                System.out.println("Inimigo encontrado:");
                darcimus.reusmo();
                while(darcimus.get_status()==true){//combate será dinâmico, mão pode ser função fixa.
                    System.out.println("escolha quem vai entrar em combate:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome()  + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op2 = scan.nextInt();
                    
                    if(op2==1){
                        if(p1.get_status()==true){
                            rotinas.boss_cmbt(darcimus, arena, p1, cat_darc);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==2){
                        if(p2.get_status()==true){
                            rotinas.boss_cmbt(darcimus, arena, p2, cat_darc);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==3){
                        if(p3.get_status()==true){
                            rotinas.boss_cmbt(darcimus, arena, p3, cat_darc);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else
                    if(op2==4){
                        if(p4.get_status()==true){
                            rotinas.boss_cmbt(darcimus, arena, p4, cat_darc);
                        }else{
                            System.out.println("fora de combate.");
                        }
                    }else{
                        System.out.println("nada aconteceu.");
                    }
                    if(p1.get_status()==false & p2.get_status()==false & p3.get_status()==false & p4.get_status()==false){
                        System.out.println("todos os heróis foram derrotados, retorne ao bar do zéca.");
                        prog=1;
                        ct=1;
                        break;
                    }else{
                        System.out.println("continue.");
                    }
                }

                //aqui deverá ser dropado o item
                if(darcimus.get_status()==false){        
                    System.out.println("selecione quem irá coletar o iten:\n[1]." + p1.get_nome() + "\n[2]." + p2.get_nome() + "\n[3]." + p3.get_nome() + "\n[4]." + p4.get_nome());
                    int op4 = scan.nextInt();
                    if(op4==1){
                        rotinas.loot_chefe(p1, cat_darc, arena, darcimus);
                    }else
                    if(op4==2){
                        rotinas.loot_chefe(p2, cat_darc, arena, darcimus);
                    }else
                    if(op4==3){
                        rotinas.loot_chefe(p3, cat_darc, arena, darcimus);
                    }else
                    if(op4==4){
                        rotinas.loot_chefe(p4, cat_darc, arena, darcimus);
                    }else{
                        System.out.println("ninguém coletou o item.");
                    }
                    prog++;
                }else{
                    System.out.println("volte ao Bar do Zeca.");
                }
                //reset
                rotinas.resset(p1, p2, p3, p4); 
//encerrar ou reiniciar------------------------------------------------------------------
            }else{
                System.out.println("Você chegou ao fim da sua jornada. Escolah o seu destino.\n[1].descansar\n[2].segunda jornada");
                boolean ctrl = false;
                while(ctrl==false){
                    int fim = scan.nextInt();
                    if(fim==1){
                        System.out.println("Bom descanso, heróis!");
                        prog++;
                        ctrl=true;
                    }else
                    if(fim==2){
                        System.out.println("Você manterá seus itens e atributos para reiniciar sua jornada.");
                        prog=1;
                        ct=1;
                        ctrl=true;
                    }else{
                        System.out.println("opção inválida.");
                    }
                }  
            }
//------------------------------------------------------------------
        }
       scan.close(); 
    }    
}