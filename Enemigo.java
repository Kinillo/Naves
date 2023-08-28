public class Enemigo extends Nave {
    

    public Enemigo (int posicion, int sentido){
        super(posicion, sentido);
    }

    public boolean posibleDisparoEnemigo (int probabilidad){
        boolean disparo=false;
        if ((Math.random()*10)<probabilidad) disparo=true;
            else disparo=false;
        return disparo;
    }
}