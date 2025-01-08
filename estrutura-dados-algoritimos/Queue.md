# Fila (Queue) e Deque

## Queue (Fila)

### Descrição
Uma fila é uma estrutura de dados que segue o princípio **FIFO** (First In, First Out - Primeiro a Entrar, Primeiro a Sair). Isso significa que o primeiro elemento adicionado à fila será o primeiro a ser removido.

### Características
- **FIFO**: O primeiro elemento a entrar é o primeiro a sair.
- **Referências**: Mantém referências para o **head** (início da fila) e **tail** (fim da fila).
- **Inserção e remoção**:
  - **Inserção** ocorre no final da fila (**tail**).
  - **Remoção** ocorre no início da fila (**head**).

### Implementação
1. **Lista Encadeada (Linked List)**: Uma maneira comum de implementar uma fila é usando uma lista encadeada, que permite inserções e remoções eficientes nas extremidades.

### Métodos Comuns em Java
Usando a interface `Queue` de `java.util`:
- `add(E e)` ou `offer(E e)`: Adiciona um elemento ao final da fila.
- `remove()` ou `poll()`: Remove o elemento no início da fila.
- `peek()`: Obtém (sem remover) o elemento no início da fila.

### Exemplo em Java
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Adicionar elementos
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Exibir o elemento no início
        System.out.println("Head: " + queue.peek());

        // Remover elementos
        System.out.println("Removido: " + queue.poll());

        // Exibir a fila restante
        System.out.println("Fila: " + queue);
    }
}
```

### Dicas
- Use **LinkedList** para uma implementação básica, pois suporta `Queue` e possui operações eficientes nas extremidades.
- **ArrayDeque** pode ser mais performático dependendo do caso de uso.

---

## Deque (Double-Ended Queue - Fila de Duas Pontas)

### Descrição
Uma fila de duas pontas (**Deque**) é uma estrutura de dados que permite inserções e remoções em ambas as extremidades, ou seja, no início (**head**) e no final (**tail**).

### Características
- Implementada com uma **lista duplamente encadeada**.
- Cada nó contém referências para o **próximo** e o **anterior**.
- Suporta operações de **fila** e **pilha**.

### Operações Comuns
1. **Inserção e Remoção**:
   - **Inserção no início**: `addFirst`
   - **Inserção no final**: `addLast`
   - **Remoção no início**: `removeFirst`
   - **Remoção no final**: `removeLast`

### Métodos Comuns em Java
Usando a interface `Deque` de `java.util`:
- `addFirst(E e)` / `addLast(E e)`: Adiciona elementos no início ou no final.
- `removeFirst()` / `removeLast()`: Remove elementos do início ou do final.
- `peekFirst()` / `peekLast()`: Obtém (sem remover) o elemento no início ou no final.

### Exemplo em Java
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // Adicionar elementos
        deque.addFirst("A");
        deque.addLast("B");

        // Exibir os elementos
        System.out.println("Deque: " + deque);

        // Remover do início e do final
        System.out.println("Removido do início: " + deque.removeFirst());
        System.out.println("Removido do final: " + deque.removeLast());

        // Verificar se está vazio
        System.out.println("Está vazio: " + deque.isEmpty());
    }
}
```

### Dicas
- Prefira **ArrayDeque** em vez de **LinkedList** para implementar um Deque em Java. É mais rápido e consome menos memória na maioria dos casos.
- Pode ser usado tanto como uma **pilha** (LIFO) quanto como uma **fila** (FIFO).

---

## Diferenças Entre Queue e Deque
| **Aspecto**          | **Queue (Fila)**                 | **Deque (Fila de Duas Pontas)**   |
|----------------------|----------------------------------|-----------------------------------|
| **Acesso**           | Apenas no início e no final      | Ambos os extremos                |
| **Flexibilidade**    | Restrito ao FIFO                 | Suporta FIFO e LIFO              |
| **Implementação**    | Lista Encadeada                 | Lista Duplamente Encadeada / ArrayDeque |

---