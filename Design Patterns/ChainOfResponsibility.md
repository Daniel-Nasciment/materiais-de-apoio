# Design Pattern Chain of Responsibility em Java
### 1. Introdução:
O Design Pattern Chain of Responsibility é útil em situações onde várias entidades podem lidar com uma solicitação e a decisão sobre quem a processa é feita em tempo de execução. No contexto de jogos, pode ser usado para processar eventos do jogo, como comandos do jogador ou eventos de colisão.

### 2. Exemplo de Código:

```java
// Interface para os manipuladores de eventos de colisão
interface CollisionHandler {
    void handleCollision(GameObject gameObject);
}

// GameObjects que podem colidir
class GameObject {
    private CollisionHandler collisionHandler;

    public GameObject(CollisionHandler collisionHandler) {
        this.collisionHandler = collisionHandler;
    }

    public void collideWith(GameObject other) {
        collisionHandler.handleCollision(other);
    }
}

// Implementações concretas de CollisionHandler
class SoldierCollisionHandler implements CollisionHandler {
    @Override
    public void handleCollision(GameObject gameObject) {
        if (gameObject instanceof Soldier) {
            System.out.println("Soldier collided with another soldier");
        } else if (gameObject instanceof Vehicle) {
            System.out.println("Soldier collided with a vehicle");
        } else {
            System.out.println("Soldier collided with an obstacle");
        }
    }
}

class VehicleCollisionHandler implements CollisionHandler {
    @Override
    public void handleCollision(GameObject gameObject) {
        if (gameObject instanceof Soldier) {
            System.out.println("Vehicle collided with a soldier");
        } else if (gameObject instanceof Vehicle) {
            System.out.println("Vehicle collided with another vehicle");
        } else {
            System.out.println("Vehicle collided with an obstacle");
        }
    }
}

// Classes de objetos do jogo
class Soldier extends GameObject {
    public Soldier(CollisionHandler collisionHandler) {
        super(collisionHandler);
    }
}

class Vehicle extends GameObject {
    public Vehicle(CollisionHandler collisionHandler) {
        super(collisionHandler);
    }
}

class Obstacle extends GameObject {
    public Obstacle(CollisionHandler collisionHandler) {
        super(collisionHandler);
    }
}

// Exemplo de Uso
public class CallOfDuty {
    public static void main(String[] args) {
        // Configuração das colisões
        CollisionHandler soldierCollisionHandler = new SoldierCollisionHandler();
        CollisionHandler vehicleCollisionHandler = new VehicleCollisionHandler();

        // Criação de objetos do jogo
        Soldier soldier = new Soldier(soldierCollisionHandler);
        Vehicle vehicle = new Vehicle(vehicleCollisionHandler);
        Obstacle obstacle = new Obstacle(soldierCollisionHandler);

        // Simulação de colisões
        soldier.collideWith(vehicle);
        vehicle.collideWith(obstacle);
    }
}

```

### 3. Identificando Oportunidades de Uso:
O padrão Chain of Responsibility é útil em jogos quando:

* Diferentes entidades no jogo precisam responder a eventos de maneira dinâmica.
* A lógica para lidar com eventos pode variar entre diferentes entidades do jogo.
* Não se deseja acoplar explicitamente remetentes de eventos com destinatários.
