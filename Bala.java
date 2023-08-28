
public class Bala {
    final int TAM_HOR=30;
    final int TAM_VER=20;
    final int MAX_BALAS=5;
    protected int yPropia=0;
    protected int yEnemigo=20;
    //protected int tipo; //1 propia 2 enemigo
    protected int posiciones[][];
    // La matriz de posiciones es una representacion de la pantalla
    // Tendrá un 0 si no hay bala, un 1 si la bala es propia y un 2 si
    // es una bala enemiga


    public Bala (){ //El constructor inicializa la matriz a 0;
        this.posiciones=new int[TAM_HOR][TAM_VER];
        for (int i=0;i<TAM_HOR;i++){
            for (int j=0;j<TAM_VER;j++){
                this.posiciones[i][j]=0;
            }
        }
    }

    public void disparoPropio (int posicion){ //se pasa la posicion
        if (cuentaBalasPropias()<MAX_BALAS)
        this.posiciones[posicion][yPropia+1]=1;

       
    }

    public void disparoEnemigo (int posicion){ //se pasa la posicion
        if (cuentaBalasEnemigo()<MAX_BALAS)
        posiciones[posicion][yEnemigo-1]=2;
    }

    public int cuentaBalasPropias (){
        int numBalas=0;
        for (int i=0;i<TAM_HOR;i++){
            for (int j=0;j<TAM_VER;j++){
                if (posiciones[i][j]==1) numBalas++;
            }
        }
        return numBalas;
    }

    public int cuentaBalasEnemigo (){
        int numBalas=0;
        for (int i=0;i<TAM_HOR;i++){
            for (int j=0;j<TAM_VER;j++){
                if (posiciones[i][j]==2) numBalas++;
            }
        }
        return numBalas;
    }

    public void moverBalas (){
        for (int i=0;i<TAM_HOR;i++){
            for (int j=0;j<TAM_VER;j++){
                switch (posiciones[i][j]){
                    case 1: if (j<(TAM_VER-1)){ //Si la bala es propia
                                posiciones[i][j+1]=1;
                                posiciones[i][j]=0;
                                j++;
                            } else posiciones[i][j]=0;
                            break;
                    case 2: if (j>0){ //Si la bala es enemiga
                                posiciones[i][j-1]=2;
                                posiciones[i][j]=0;
                            } else posiciones[i][j]=0;
                            break;
                    case 0: break;
                }
            }
        }
        

    }

    public int compruebaDerribo (int xPropia, int xEnemigo){
        //devuelve un 1 si me han derribado, un 2 si he derribado a
        //un enemigo y un 0 si no hay derribo
        int tipo_derribo=0;
        if (posiciones[xPropia][yPropia+1]==2) tipo_derribo=1;
        if (posiciones[xEnemigo][yEnemigo-1]==1) tipo_derribo=2;
        return tipo_derribo;        
           
    }

    public int[][] obtenerBalas (){
        return posiciones;
    }

}