package rpg;

public class boss extends inimigo{
    private boolean passiva1;//cura
    private boolean passiva2;//aumento de dano
    
    int contador=0; //variável de uso geral interno da classe para limitar o número de vezes que o boss se cura.
    public boolean get_passiva1(){
        if(this.get_hp()<=250 & contador<=0){
            this.passiva1=true;
            contador++;
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
