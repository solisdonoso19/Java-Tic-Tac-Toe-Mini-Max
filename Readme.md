# Tic Tac-Toe empleando algoritmo MinMax👾

_Sencillo programa del juego Tic Tac-Toe, Gato o Cruz y Cero de humano contra computadora, utilizando el algoritmo MinMax_

## Gameplay 🕹
![gameplay](imagengif/1.gif)

No es posible vencer a la IA cuando el nivel de profundidad de la busqueda en el arbol es alta, sin embargo cuando la profundidad es baja es posible ganarle, pero sigue siendo dificil. La mayoria de la veces termina en empate o la IA gana.

## Algoritmo MinMax ✅

En teoría de juegos, minimax es un método de decisión para minimizar la pérdida máxima esperada en juegos con adversario y con información perfecta. Minimax es un algoritmo recursivo.

El funcionamiento de minimax puede resumirse en cómo elegir el mejor movimiento para ti mismo suponiendo que tu contrincante escogerá el peor para ti.

John von Neumann es el creador del teorema minimax, quien dio la siguiente noción de lo que era un juego:

_Un juego es una situación conflictiva en la que uno debe tomar una decisión sabiendo que los demás también toman decisiones, y que el resultado del conflicto se determina, de algún modo, a partir de todas las decisiones realizadas._

También afirmó que:

_Siempre existe una forma racional de actuar en juegos de dos participantes, si los intereses que los gobiernan son completamente opuestos._

La demostración a esa afirmación se llama teoría minimax y surge en 1928.

Este teorema establece que en los juegos bipersonales de suma cero, donde cada jugador conoce de antemano la estrategia de su oponente y sus consecuencias, existe una estrategia que permite a ambos jugadores minimizar la pérdida máxima esperada. En particular, cuando se examina cada posible estrategia, un jugador debe considerar todas las respuestas posibles del jugador adversario y la pérdida máxima que puede acarrear. El jugador juega, entonces, con la estrategia que resulta en la minimización de su máxima pérdida. Tal estrategia es llamada óptima para ambos jugadores sólo en caso de que sus minimaxes sean iguales (en valor absoluto) y contrarios (en signo). Si el valor común es cero el juego se convierte en un sinsentido.

En los juegos de suma no nula, existe tanto la estrategia minimax como la maximin. La primera intenta minimizar la ganancia del rival, o sea busca que el rival tenga el peor resultado. La segunda intenta maximizar la ganancia propia, o sea busca que el jugador obtenga el mejor resultado.

### Pasos del algoritmo Minmax🔁

Pasos del algoritmo minimax:

* Generación del árbol de juego. Se generarán todos los nodos hasta llegar a un estado terminal.

* Cálculo de los valores de la función de utilidad para cada nodo terminal.

* Calcular el valor de los nodos superiores a partir del valor de los inferiores. Según nivel si es MAX o MIN se elegirán los valores mínimos y máximos representando los movimientos del jugador y del oponente, de ahí el nombre de minimax.

* Elegir la jugada valorando los valores que han llegado al nivel superior.

El algoritmo explorará los nodos del árbol asignándoles un valor numérico mediante una función de evaluación, empezando por los nodos terminales y subiendo hacia la raíz. La función de utilidad definirá lo buena que es la posición para un jugador cuando la alcanza. En el caso del ajedrez los posibles valores son (+1,0,-1) que se corresponden con ganar, empatar y perder respectivamente. En el caso del backgammon los posibles valores tendrán un rango de [+192,-192], correspondiéndose con el valor de las fichas. Para cada juego pueden ser diferentes.

Si minimax se enfrenta con el dilema del prisionero escogerá siempre la opción con la cual maximiza su resultado suponiendo que el contrincante intenta minimizarlo y hacernos perder.

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Minimax.svg/300px-Minimax.svg.png)

### Ejemplo 💻

En el siguiente ejemplo puede verse el funcionamiento de minimax en un árbol generado para un juego imaginario. Los posibles valores de la función de utilidad tienen un rango de [1-9]. En los movimientos del contrincante suponemos que escogerá los movimientos que minimicen nuestra utilidad, en nuestros movimientos suponemos que escogeremos los movimientos que maximizan nuestra utilidad.

El primer paso será calcular los nodos terminales, en verde. Posteriormente calcularemos el cuarto nivel, movimiento min, minimizando lo elegido (5, 2 y 1). Después podremos calcular el tercer nivel, movimiento max, maximizando la utilidad (5, 9). El segundo nivel es un movimiento min (5, 3 y 1). Finalmente llegamos al primer nivel, el movimiento actual, elegiremos el nodo que maximice nuestra utilidad (5).

![img](https://upload.wikimedia.org/wikipedia/commons/d/d6/Minimax2.png)

### Optimización📊

En la práctica el método minimax es impracticable excepto en supuestos sencillos. Realizar la búsqueda completa requerirían cantidades excesivas de tiempo y memoria.

Claude Shannon en su texto sobre ajedrez de 1950 (Programming a Computer for Playing Chess) propuso limitar la profundidad de la búsqueda en el árbol de posibilidades y determinar su valor mediante una función heurística.

Para optimizar minimax puede limitarse la búsqueda por nivel de profundidad o por tiempo de ejecución. Otra posible técnica es el uso de la poda alfa-beta. Esta optimización se basa en evitar el cálculo de ramas cuya evaluación final no va a poder superar los valores previamente obtenidos.

### Poda Alfa-Beta

El problema de la búsqueda Minimax es que el número de estados a explorar es exponencial al número de movimientos. Partiendo de este hecho, la técnica de poda alfa-beta trata de eliminar partes grandes del árbol, aplicándolo a un árbol Minimax estándar, de forma que se devuelva el mismo movimiento que devolvería este, gracias a que la poda de dichas ramas no influye en la decisión final.

La búsqueda minimax es primero en profundidad, por ello en cualquier momento sólo se deben considerar los nodos a lo largo de un camino en el árbol.

La poda alfa-beta toma dicho nombre de la utilización de dos parámetros que describen los límites sobre los valores hacia atrás que aparecen a lo largo de cada camino.

*α es el valor de la mejor opción hasta el momento a lo largo del camino para MAX, esto implicará por lo tanto la elección del valor más alto

*β es el valor de la mejor opción hasta el momento a lo largo del camino para MIN, esto implicará por lo tanto la elección del valor más bajo.

Esta búsqueda alfa-beta va actualizando el valor de los parámetros según se recorre el árbol. El método realizará la poda de las ramas restantes cuando el valor actual que se está examinando sea peor que el valor actual de α o β para MAX o MIN, respectivamente.

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/AB_pruning.svg/400px-AB_pruning.svg.png)

## Detalles a Tomar en Cuenta

### La Técnica Poda Alfa - Beta tiene un problema ❗

Hay veces en la que la IA hace un movimiento no adecuado como se muestra continuación: 

![gameplay](imagengif/2.gif)

Como podemos ver la IA escogio un movimiento que no resulto en victoria a pesar de que la victoria estaba garantizada, aunque inevitablemente termina como ganadora como se ve en el ejemplo mostrado arriba.
La tecnica poda alfa-beta juega movimientos perfectos aunque en ocaciones elige una "victoria mas lenta". Esto se puede solucionar modificando un poco el algoritmo incluyendo la profundidad actual en las evaluacion de jugadas.

![gameplay](imagengif/3.gif)

Aqui esta la misma jugada pero con el algoritmo ligeramente modificado.

### Cantidades de Evaluación 🔢
Hay 255,168 jugadas posibles de Tic-tac-toe excluyendo la simetría. El primer jugador gana 131,184 de estos, el segundo jugador gana 77,904 juegos y los 46,080 restantes son empates.

Cuando se utiliza Minimax normal, la IA evalua 59,704 combinaciones posibles en su primer movimiento(este numero disminuye a lo largo de la partida a medida de que hay menos celdas disponibles). Con la técnica Poda Alfa-Beta este número disminuye a 2,337 pero al agregar el ajuste para la solución del problema mencionado arriba, este número aumenta ligeramente a 2,787. Es un aumento sumamente pequeño en comparación con las ventajas que el algoritmo brinda.


## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de aprendizaje, desarrollo y pruebas._

### Pre-requisitos 📋

_Para poder probar el programa necesitas:_

```
Tener Java Development Kit (JDK)
```

### Instalación y Probando el Código🔧

_Descarga el .zip del codigo en la parte superior de esta pagina_

_Descomprime el codigo, y luego con el uso de la terminal accede a la carpeta donde descomprimiste el codigo_

```
C:\User\docs\> cd "carpeta"
```

_Luego ejecuta los comando de compilación y ejecución del JDK_

```
javac Main.java
```

```
java Main
```

_Finaliza con un ejemplo de cómo obtener datos del sistema o como usarlos para una pequeña demo_

## Construido con 🛠️

_El lenguaje de programación utilizado_

* [Java](https://www.java.com/es/) - Lenguaje de programación orientado a objetos

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Carlos Iván Solís Donoso** - *Desarrollo / Investigación* - [solisdonoso19](https://github.com/solisdonoso19)
* **Juan Tylor** - *Front-End* - [JuanJTR](https://github.com/JuanJTR)

## Referencias Infográficas 📃

_Para el desarrollo del algoritmo se consulto lo siguiente_

* [El algoritmo Minimax y su aplicación en un juego - devcode.la](https://devcode.la/tutoriales/algoritmo-minimax/)
* [Minimax - Wikipedia.org](https://devcode.la/tutoriales/algoritmo-minimax/)
* [Algoritmo Minimax en 4 minutos - Youtube](https://devcode.la/tutoriales/algoritmo-minimax/)
* [Minimax: Juegos Con Adversario - cs.us.es](http://www.cs.us.es/~fsancho/?e=107)
* [Introduction to Minimax Algorithm with a Java Implementation - baeldung.com](https://www.baeldung.com/java-minimax-algorithm)
* [Minimax Algorithm in Game Theory | Set 3 (Tic-Tac-Toe AI – Finding optimal move) - geeksforgeeks.org](https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-3-tic-tac-toe-ai-finding-optimal-move/)

## Expresiones de Gratitud 🎁

* Gracias a [JuanJTR](https://github.com/JuanJTR) por la ayuda en el front-end del programa📢
* Gracias al profesor Manuel Florez de la Universidad Tecnologíca de Panamá (UTP) por brindarnos su conocimiento y motivación para el desarrollo de este programa para fines academicos📚. 
* Gracias a todos por leer y probar el codígo, espero sea de ayuda e interés 🤓.




---
⌨️ con ❤️ por [solisdonoso19](https://github.com/solisdonoso19) 😊