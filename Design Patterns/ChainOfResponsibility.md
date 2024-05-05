# Design Pattern Chain of Responsibility em Java
### 1. Introdução:
O Design Pattern Chain of Responsibility é útil em situações onde várias entidades podem lidar com uma solicitação e a decisão sobre quem a processa é feita em tempo de execução. No contexto de jogos, pode ser usado para processar eventos do jogo, como comandos do jogador ou eventos de colisão.

### 2. Exemplo de Código:

```java
// Interface para os manipuladores de eventos de colisão
interface CollisionHandler {
    void handleCollision(GameObject gameObject);
    void setNextHandler(CollisionHandler nextHandler);
}

// Implementações concretas de CollisionHandler
class SoldierCollisionHandler implements CollisionHandler {
    private CollisionHandler nextHandler;

    @Override
    public void setNextHandler(CollisionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleCollision(GameObject gameObject) {
        if (gameObject instanceof Soldier) {
            System.out.println("Soldier collided with another soldier");
        } else if (nextHandler != null) {
            nextHandler.handleCollision(gameObject);
        }
    }
}

class VehicleCollisionHandler implements CollisionHandler {
    private CollisionHandler nextHandler;

    @Override
    public void setNextHandler(CollisionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleCollision(GameObject gameObject) {
        if (gameObject instanceof Vehicle) {
            System.out.println("Vehicle collided with another vehicle");
        } else if (nextHandler != null) {
            nextHandler.handleCollision(gameObject);
        }
    }
}

class ObstacleCollisionHandler implements CollisionHandler {
    @Override
    public void setNextHandler(CollisionHandler nextHandler) {
        // ObstacleCollisionHandler é o último na cadeia, então não há próximo manipulador
        throw new UnsupportedOperationException("ObstacleCollisionHandler não pode ter um próximo manipulador");
    }

    @Override
    public void handleCollision(GameObject gameObject) {
        if (gameObject instanceof Obstacle) {
            System.out.println("Obstacle collided with something");
        }
    }
}

// Classes de objetos do jogo
class GameObject {
    private CollisionHandler collisionHandler;

    public GameObject(CollisionHandler collisionHandler) {
        this.collisionHandler = collisionHandler;
    }

    public void collideWith(GameObject other) {
        collisionHandler.handleCollision(other);
    }
}

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
        CollisionHandler soldierHandler = new SoldierCollisionHandler();
        CollisionHandler vehicleHandler = new VehicleCollisionHandler();
        CollisionHandler obstacleHandler = new ObstacleCollisionHandler();

        soldierHandler.setNextHandler(vehicleHandler);
        vehicleHandler.setNextHandler(obstacleHandler);

        // Criação de objetos do jogo
        Soldier soldier = new Soldier(soldierHandler);
        Vehicle vehicle = new Vehicle(soldierHandler);
        Obstacle obstacle = new Obstacle(soldierHandler);

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
