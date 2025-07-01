# Estruturas de Dados: Linked List e Array

## Linked List
Uma **Linked List** é uma estrutura de dados linear composta por nós conectados entre si. Cada nó contém dois elementos:
1. **Dado**: O valor armazenado.
2. **Ponteiro**: Referência ao próximo nó na lista (ou `null` no caso do último nó).

### Operações e Complexidade
| Operação  | Melhor Caso | Pior Caso | Descrição                                                                                 |
|-----------|-------------|-----------|-----------------------------------------------------------------------------------------|
| **Leitura**  | O(1)        | O(n)      | Acesso direto ao primeiro nó (melhor caso) ou percorrendo a lista para encontrar o nó (pior caso). |
| **Inserção** | O(1)        | O(n)      | Inserção no início da lista (melhor caso) ou no meio/final, onde é necessário percorrer a lista (pior caso). |
| **Remoção**  | O(1)        | O(n)      | Remoção no início da lista (melhor caso) ou no meio/final, onde é necessário percorrer a lista (pior caso). |

---

## Array
Um **Array** é uma estrutura de dados linear onde elementos são armazenados em posições contíguas de memória. Isso permite acesso rápido a qualquer posição, mas limita a flexibilidade para inserção e remoção.

### Operações e Complexidade
| Operação    | Complexidade | Descrição                                                                                 |
|-------------|--------------|-----------------------------------------------------------------------------------------|
| **Leitura**  | O(1)         | Acesso direto a qualquer posição com base no índice, constante para qualquer tamanho de array. |
| **Inserção** | O(n)         | Requer deslocar os elementos existentes para abrir espaço para o novo elemento, especialmente no início. |
| **Remoção**  | O(n)         | Após remover um elemento, é necessário deslocar todos os elementos subsequentes para preencher o espaço vazio. |

---

## Comparação Geral

| Estrutura   | Operação  | Melhor Caso | Pior Caso | Observação                                   |
|-------------|-----------|-------------|-----------|---------------------------------------------|
| **Linked List** | Leitura    | O(1)        | O(n)      | Acesso ao início é constante, mas é linear para outros nós. |
| **Linked List** | Inserção   | O(1)        | O(n)      | Rápida no início; lenta ao inserir em posições específicas. |
| **Linked List** | Remoção    | O(1)        | O(n)      | Rápida no início; lenta ao remover de posições específicas. |
| **Array**       | Leitura    | O(1)        | O(1)      | Sempre constante, já que o índice é diretamente acessível.  |
| **Array**       | Inserção   | O(n)        | O(n)      | Deslocar elementos é necessário, tornando-a linear.        |
| **Array**       | Remoção    | O(n)        | O(n)      | Remover exige realocação dos elementos subsequentes.        |

---

### Observações
- **Linked List**: Melhor para casos em que a inserção e remoção frequente são necessárias.
- **Array**: Ideal quando o acesso direto e a leitura rápida são prioritários.

Estudar ambas as estruturas é fundamental para entender quando usá-las e como otimizá-las em diferentes contextos.
