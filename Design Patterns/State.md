# Design Pattern State em Java


### 1. Introdução:
O Design Pattern State é um padrão de design comportamental que permite que um objeto altere seu comportamento quando seu estado interno muda. Ele encapsula estados diferentes em classes separadas e permite que o objeto altere de estado em tempo de execução, sem alterar sua implementação.

### 2. Exemplo de Código:
```java
// Interface representando os diferentes estados
interface State {
    void handleRequest();
}

// Implementações concretas de diferentes estados
class StateA implements State {
    @Override
    public void handleRequest() {
        System.out.println("State A: Handling request.");
    }
}

class StateB implements State {
    @Override
    public void handleRequest() {
        System.out.println("State B: Handling request.");
    }
}

// Contexto que mantém uma referência para o estado atual
class Context {
    private State currentState;

    public Context() {
        // Define o estado inicial
        currentState = new StateA();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        // Delega o pedido para o estado atual
        currentState.handleRequest();
    }
}

// Exemplo de Uso
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        // Execução com o estado A
        context.request();

        // Altera para o estado B e executa
        context.setState(new StateB());
        context.request();
    }
}
```
### 3. Identificando Oportunidades de Uso:
Você pode considerar o uso do padrão State quando:

* Um objeto pode mudar de comportamento dependendo de seu estado interno.
* Há múltiplos estados que afetam o comportamento do objeto de maneira diferente.
* As transições entre os estados precisam ser gerenciadas de forma flexível e sem alterar o código do contexto.
