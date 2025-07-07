# 🌐 BFS (Breadth-First Search) — Guia direto e prático

---

## 🚀 O que é?
BFS (**Breadth-First Search**) é um algoritmo de **busca em largura**, que percorre uma estrutura de dados (como árvore ou grafo) explorando **primeiro todos os vizinhos do nível atual antes de descer para o próximo nível**.

---

## 🎯 Para que serve?
- Encontrar o **caminho mais curto** (mínimo número de arestas) em grafos não ponderados.
- Explorar todos os nós a uma distância k antes de avançar.
- Resolver problemas em camadas, por exemplo:
  - Nível de parentesco em árvores genealógicas.
  - Propagação de sinais ou redes.
  - Encontrar componentes conexos.

---

## ⚙️ Como usar?
- Utiliza normalmente uma **fila (queue)** para manter a ordem FIFO, garantindo o processamento nível a nível.
- Ideal para cenários onde:
  - Você quer a **menor distância** até um alvo.
  - Precisa processar todos os nós a certa distância antes dos seguintes.

---

## ⏱ Complexidade
- **Tempo:** O(V + E)
  - V = número de vértices (nós)
  - E = número de arestas (ligações)
- **Espaço:** O(V)
  - Necessário para a fila e a estrutura de visitados (ou níveis).

---

✅ **Resumo em uma frase:**
> BFS explora largura primeiro, é excelente para encontrar distâncias mínimas e garante que o primeiro caminho encontrado para um nó é o mais curto.


### Exemplo:
```java
public static boolean BFS(TreeNode node, int targetNum) {

    if (node == null) {
        return false;
    }

    // Usamos uma fila para garantir o processamento em nível (BFS)
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
        // Remove o primeiro elemento da fila
        TreeNode current = queue.poll();

        // Se encontrou o valor, retorna true
        if (current.val == targetNum) {
            return true;
        }

        // Adiciona os filhos à fila para explorar depois
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }

    // Se percorreu toda a árvore e não encontrou, retorna false
    return false;
}

```
