import java.util.Scanner;

public class Naves {
    /* Juego para la consola de Java creado por Joaquín Belmonte
    El Juego consiste en pilotar una nave e ir disparando a naves enemigas
    hasta eliminarlas a todas. Para disparar hay que presionar Enter y
    para cambiar el sentido de la nave pulsaremos "a"+Enter.
    Entre cada entrada por consola de teclas se producirán una serie
    de movimientos de naves y disparos. Solo se permiten 3 balas a
    la vez en la pantalla */

    static final int PASOS=5; //Numero de movimientos hasta q hace un Scanner
    static final int TAM_VER=20;
    static final int TAM_HOR=30;
    public static void main(String[] args) throws InterruptedException {
        
        String control="";
        boolean termina=false;
        Enemigo enemigo=new Enemigo(15, 1); //enemigo en posicion 15
                                          //moviendose a la derecha
        Nave nave=new Nave(15,0); //Mi nave en posicion 15 a la izquierda
        Bala balas=new Bala();
        int i=0;
        int derribo=0;
        int probabilidad=2; // De 0 a 10, probabilidad de disparo enemigo
        while (termina!=true){
            for (i=0;i<PASOS&&termina==false;i++){
            System.out.print("\033[H\033[2J");
            if (enemigo.posibleDisparoEnemigo(probabilidad))
                balas.disparoEnemigo(enemigo.obtenerPosicionNave());
            dibujarPantalla(nave.obtenerPosicionNave(),
                enemigo.obtenerPosicionNave(), balas.obtenerBalas());

                derribo=balas.compruebaDerribo(nave.obtenerPosicionNave(),
                enemigo.obtenerPosicionNave());
            if (derribo==1) {
                System.out.println("\nTe han derribado"); 
                termina=true;
            } 
            if (derribo==2){
                System.out.println("\nHas ganado");
                termina=true;
            } 
            Thread.sleep(100);
            nave.moverNave();
            enemigo.moverNave();
            balas.moverBalas();
             
            }
            if (termina==false){
            System.out.print("\nPulsa q+Enter para disparar o a+Enter para"+
                " cambiar de sentido: ");
            Scanner sc=new Scanner (System.in);
            control=sc.nextLine();
            if (control.equals("a")) nave.cambiarSentidoNave();
            if (control.equals("q")) balas.disparoPropio(nave.obtenerPosicionNave());
            }
        }

        

    }

    static void dibujarPantalla (int posNave, int posEne, int [][] matrizBalas){
        int puntos=10;
        int [][] terreno;
        String cad="";
        terreno=new int [TAM_HOR][TAM_VER];
        //Volcamos la matriz de balas en la matriz terreno
        for (int i=0;i<TAM_VER;i++){
            for (int j=0;j<TAM_HOR;j++){
                terreno[j][i]=matrizBalas[j][i];
            }
        }
        //Incluimos en la matriz terreno las naves 3 Propia 4 Enemigo
        terreno[posNave][0]=3;
        terreno[posEne][TAM_VER-1]=4;
        System.out.print("\033[H\033[2J");
        System.out.print("***** Score: "+puntos+" *****");
        System.out.print("\n********************************");
        //System.out.print(dibujaEnemigo (posEne));
        for (int i=TAM_VER-1;i>=0;i--){
            cad="\n*";
            for (int j=0;j<TAM_HOR;j++){
                switch (terreno[j][i]){
                    case 0: cad=cad+" ";
                            break;
                    case 1: cad=cad+"·";
                            break;
                    case 2: cad=cad+"*";
                            break;
                    case 3: cad=cad+"H";
                            break;
                    case 4: cad=cad+"Y";
                            break;
                }
            }
            cad=cad+"*";
            System.out.print(cad);
        }
        System.out.print("\n********************************");


    }

    
}