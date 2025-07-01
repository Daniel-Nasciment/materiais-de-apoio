# 🌳 Binary Tree

## ✅ O que é?

Uma **Binary Tree** (árvore binária) é uma estrutura de dados hierárquica onde:

- Cada nó armazena um valor.
- Cada nó pode ter no máximo **dois filhos**: esquerdo e direito.

---

## ✅ Para que serve?

Serve para **organizar dados de forma eficiente**, garantindo que:

- Buscas, inserções e deleções sejam rápidas (tipicamente O(log n) se a árvore estiver balanceada).

Usada em:

- Implementação de bancos de dados e índices.
- Estruturas de busca rápida como sets e maps.
- Problemas de ordenação e navegação hierárquica.

---

## ✅ Regras da Binary Search Tree (BST)

- Valores **menores que o nó atual** ficam à esquerda.
- Valores **maiores ou iguais ao nó atual** ficam à direita.
- Isso garante uma **ordem natural**, permitindo busca eficiente.

---

## ✅ Resumo em uma frase

> Uma Binary Tree organiza dados em forma de galhos e nós, facilitando buscas, inserções e comparações rápidas, especialmente quando os dados precisam manter uma ordem.

## ✅ Exemplo:
```java
// Representa um nó de árvore binária
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

// Representa a árvore binária em si
class BinaryTree {
    Node root;

    // Insere um novo nó na árvore
    public void insert(Node node) {
        if (root == null) {
            this.root = node;
        } else {
            insertRecursive(root, node);
        }
    }

    // Regras de inserção: menor vai à esquerda, maior ou igual à direita
    private void insertRecursive(Node nodeRef, Node node) {
        if (node.value < nodeRef.value) {
            if (nodeRef.left == null) {
                nodeRef.left = node;
            } else {
                insertRecursive(nodeRef.left, node);
            }
        } else {
            if (nodeRef.right == null) {
                nodeRef.right = node;
            } else {
                insertRecursive(nodeRef.right, node);
            }
        }
    }

    // Busca um valor na árvore
    public boolean contains(Node nodeSearch) {
        if (this.root == null) return false;
        if (this.root.value == nodeSearch.value) return true;
        return containsRecursive(root, nodeSearch);
    }

    // Navega recursivamente para esquerda ou direita conforme o valor
    private boolean containsRecursive(Node nodeRef, Node nodeSearch) {
        if (nodeRef == null) return false;
        if (nodeRef.value == nodeSearch.value) return true;
        else if (nodeSearch.value < nodeRef.value)
            return containsRecursive(nodeRef.left, nodeSearch);
        else
            return containsRecursive(nodeRef.right, nodeSearch);
    }
}

```
