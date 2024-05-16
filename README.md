# Falkens Maze editor
## Jesus Ballesta Bernabe 1ºDAM

## Descripcion
Este proyecto es un editor de laberintos el cual permite crear, editar, guardar y cargar laberintos personalizados.

## Funcionamiento
El editor esta formado por interfaz gráfica que muestra un tablero de laberinto donde puedes colocar bloques y diseñar tu propio laberinto. También ofrece opciones de menú para crear un nuevo laberinto, guardar y cargar laberintos desde archivos, ajustar configuraciones como el tamaño del tablero y el tiempo límite, y asignar un sonido al laberinto.

- La clase Principal es la clase principal que inicializa la interfaz gráfica del editor. Utiliza JavaFX para crear la ventana principal y agregar los componentes necesarios, como el tablero del laberinto y los paneles de bloques.

- El tablero del laberinto está representado por la clase MazeCanvas, que utiliza un lienzo de JavaFX para dibujar el laberinto y los bloques en pantalla. Esta clase maneja la lógica para dibujar y actualizar el tablero.

- La clase Block representa un bloque individual en el laberinto. Tiene un atributo value que puede ser utilizado para representar diferentes tipos de bloques, como paredes, caminos, etc.

- La clase Size representa las dimensiones del laberinto. Es utilizada para especificar el tamaño del tablero y para calcular las posiciones de los bloques en el lienzo.

- La interfaz IBlockListener define métodos para escuchar eventos de clic en los bloques del laberinto. Esto permite que otros componentes respondan a las interacciones del usuario con los bloques.

Además de la estructura del código, el editor ofrece una interfaz gráfica intuitiva donde los usuarios pueden interactuar con el tablero del laberinto. Ofrece opciones para crear nuevos laberintos, guardar y cargar laberintos desde archivos, ajustar configuraciones como el tamaño del tablero y el tiempo límite, y asignar un sonido al laberinto.



## Inicializando el Programa
Desde un terminal situandonos en los archivos del proyecto con el comando mvn javafx:run ejecutaremos el programa y asi seria la primera vista:
![imagen](https://github.com/jesusbb69/Trabajos-PR/assets/158313943/ca45bbc7-8893-44cb-b6db-b11741d0b5ac)

## Caracteristica para aumentar el tablero
Con esta caracteristica podremos aumentar de tamaño el tablero para el laberinto
![imagen](https://github.com/jesusbb69/Trabajos-PR/assets/158313943/dcaa832c-d4e9-429f-ab44-e5cdab8c3c80)

## Prueba de creacion de Laberinto
![imagen](https://github.com/jesusbb69/Trabajos-PR/assets/158313943/e0902ea3-6ac1-4fbd-8bb0-2676e3e9d643)
