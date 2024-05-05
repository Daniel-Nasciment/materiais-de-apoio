# Design Pattern Template Method em Java

### 1. Introdução:
O Design Pattern Template Method é um padrão de design comportamental que define a estrutura de um algoritmo em uma superclasse, mas permite que subclasses alterem partes específicas desse algoritmo sem modificar sua estrutura geral. Isso é útil quando você tem um algoritmo com etapas fixas, mas com variações nas implementações dessas etapas.

### 2. Exemplo de Código:

```java
// Classe abstrata representando o Template Method
abstract class Game {
    // Template Method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    // Métodos a serem implementados pelas subclasses
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}

// Implementação concreta do Template Method
class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

// Implementação concreta do Template Method
class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

// Exemplo de Uso
public class Main {
    public static void main(String[] args) {
        Game footballGame = new Football();
        footballGame.play();

        System.out.println();

        Game cricketGame = new Cricket();
        cricketGame.play();
    }
}

```

### 3. Identificando Oportunidades de Uso:
Você pode considerar o uso do padrão Template Method quando:

* Tem um algoritmo com etapas fixas, mas com variações nas implementações dessas etapas.
* Deseja evitar a duplicação de código em diferentes implementações do mesmo algoritmo.
* Precisa permitir que subclasses alterem partes específicas do algoritmo sem modificar sua estrutura geral.
