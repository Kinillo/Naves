Proyecto Naves, creado por Joaquin Belmonte.
El proyecto consiste en una sencilla aplicacion para la consola escrita en Java.
Es un sencillo juego tipo arcade donde dos naves se enfrentan disparandose entre si.
Cada una de las naves puede tener a la vez en la pantalla un maximo de 5 balas.
Cada 5 movimientos se le preguntará al usuario que quiere hacer, disparar o
cambiar de sentido el movimiento de la nave.
El ganador sera el que derribe al contrario.
Los archivos incluidos en el proyecto Naves son:
Naves.java --> incluye el main, contiene el cuerpo principal de la aplicación.
Nave.java --> contiene la clase Nave, en el main se hace una instancia a esta clase
	para crear nuestra nave.
Enemigo.java --> Hereda de la clase Nave, incorpora un metodo adicional para la
	probabilidad del disparo enemigo.
Balas.java --> contiene la clase Balas, esta contiene los metodos para dar los movimientos
	a las balas por la pantalla y controla si alguna toca alguna nave. Controla tambien
	los disparos.