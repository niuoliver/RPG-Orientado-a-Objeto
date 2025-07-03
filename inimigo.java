package rpg;
import java.util.Random;

public class inimigo {
    private String nome;
    private int nivel;
    private double hp;
    private int armor;
    private double dano_base;
    private boolean status; //vivo ou morto; 0 = morto, 1 = vivo.

    //inimigos tmabém devem ter atributos de combate. ex; hp, resistência, multiplicador de dano. A SER DEFINIDO.

    public void set_hp(double hp){
        this.hp = hp; //inicializa o mob com hp cheio.
    }
    public double get_hp(){
        return this.hp;
    }
    public double get_dano(){
        return this.dano_base;
    }

    public int get_defesa(){
        return this.armor;
    }
//INICIALIZAÇÃO DE UM MOB.--------------------------------------------------------------------------------------------
    public void set_mob(String nome, int nivel, int armor, double dano){
        this.nome = nome;
        this.nivel = nivel;
        this.armor = armor;
        this.dano_base = dano;

    }

    public void set_status(){
        this.status = true;
    }

    public boolean get_status(){
        return this.status;
    }

    public String get_nome(){
        return this.nome;
    }

    public void reusmo(){
        System.out.println("informações do inimigo: " + this.nome + ", nivel " + this.nivel);
    }
//------------------------------------------------------------------------------------------------------------------

    public double ataque(){
        return this.dano_base*this.nivel;  //dano base setado na inicialização.
    }

    public void dano(double dano, int tipo_fase, boolean status_fase){ //recebe como parâmetro o dano sofrido, tipo de fase e status ativo.
        Random rand = new Random();
        int index;
        if(status_fase==true && tipo_fase==3){ //condicional para a chance de erro de ataques em fases escuras.
            index=rand.nextInt(4);
            if(index>2){
                dano = 0;
                System.out.println("Errou o atque por causa da escuridão.");
            }else{
                dano=(dano*0.9)-this.armor;
                System.out.println("Ataque não atingiu em cheio devido a escuridão.");
            }
        }else{
            dano-=this.armor;
        }
        if(dano>0){
            this.hp-=dano;
        }else{
            this.hp=this.hp*1;
        }
        if(this.hp>0){
            this.status=true;
            System.out.println("A criatura está viva.");
        }else{
            this.status = false;
            System.out.println("A criatura está morta");
        }
    }

    public class boss extends inimigo{
        private boolean passiva1;
        private boolean passiva2;

        public boolean get_passiva1(){
            if(this.get_hp()<=250){
                this.passiva1=true;
            }
            else{
                this.passiva1=false;
            }
            return this.passiva1;
        }

        public boolean get_passiva2(){
            if(this.get_hp()<=500){
                this.passiva2=true;
            }else{
                this.passiva2=true;
            }
            return this.passiva2;
        }

        public void cura(){
            if(get_passiva1()==true){
                this.set_hp(500);
                this.passiva1=false;
            }else{
                this.set_hp(this.get_hp());
            }
        }

        @Override
        public double ataque(){
            double dano;
            if(get_passiva2()==true){
                dano=this.get_dano()*1.5;
            }else{
                dano=this.get_dano();
            }
            return dano;
        }

    }

    //PASSIVAS DE CHEFE: ao chegar em 25% de vida, cura até 50% de vida. Com menos de 50% de vida aumenta o dano em 50%.
}

