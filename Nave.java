public class Nave {
    final int TAM_HOR=30;
    final int TAM_VER=20;
    protected int posicion;
    protected int sentido; // 0 izquierda, 1 derecha
    

    public Nave (int posicion, int sentido){
        this.posicion=posicion;
        this.sentido=sentido;
    }

    public void moverNave (){
        if (sentido==1){
            if (posicion<TAM_HOR-1) posicion++;
                else sentido=0; //Si llega al borde cambia el sentido
        }
        if (sentido==0){
            if (posicion>0) posicion--;
                else sentido=1; //Si llega al borde cambia el sentido
        }
    }

    
    public int obtenerPosicionNave (){
        return posicion;
    }

    public void cambiarSentidoNave(){
        switch (sentido){
            case 0: sentido=1;
                    break;
            case 1: sentido=0;
                    break;
        }
    }
}