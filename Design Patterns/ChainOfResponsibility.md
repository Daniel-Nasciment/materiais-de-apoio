# Design Pattern Chain of Responsibility em Java
### 1. Introdução:
O Design Pattern Chain of Responsibility é útil em situações onde várias entidades podem lidar com uma solicitação e a decisão sobre quem a processa é feita em tempo de execução. No contexto de jogos, pode ser usado para processar eventos do jogo, como comandos do jogador ou eventos de colisão.

### 2. Exemplo de Código:

```java
// Interface Handler
interface GameObject {
    void handleEvent(GameEvent event);
}

// Implementações concretas de GameObject
class Player implements GameObject {
    @Override
    public void handleEvent(GameEvent event) {
        if (event.getType().equals("PlayerEvent")) {
            System.out.println("Player handled the event: " + event.getDescription());
        }
    }
}

class Enemy implements GameObject {
    @Override
    public void handleEvent(GameEvent event) {
        if (event.getType().equals("EnemyEvent")) {
            System.out.println("Enemy handled the event: " + event.getDescription());
        }
    }
}

// Classe de evento do jogo
class GameEvent {
    private String type;
    private String description;

    public GameEvent(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}

// Game class
public class Game {
    public static void main(String[] args) {
        GameObject player = new Player();
        GameObject enemy = new Enemy();

        // Configuração da cadeia
        player.handleEvent(new GameEvent("PlayerEvent", "Player's action"));
        enemy.handleEvent(new GameEvent("EnemyEvent", "Enemy's action"));
    }
}

```

### 3. Identificando Oportunidades de Uso:
O padrão Chain of Responsibility é útil em jogos quando:

* Diferentes entidades no jogo precisam responder a eventos de maneira dinâmica.
* A lógica para lidar com eventos pode variar entre diferentes entidades do jogo.
* Não se deseja acoplar explicitamente remetentes de eventos com destinatários.
