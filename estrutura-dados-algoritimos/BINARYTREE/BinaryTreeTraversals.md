# 🌳 Binary Tree Traversal

Existem 3 formas clássicas de percorrer (traversar) uma Binary Tree (árvore binária). Cada uma segue uma ordem diferente para visitar os nós. Isso impacta diretamente na ordem dos dados gerados.

---

## 🚀 Preorder Traversal

Visita o **root** primeiro, depois vai para a subárvore esquerda e só então para a direita.

- **Ordem:** `Root → Left → Right`
- Costuma ser usada para clonar ou exportar a estrutura de uma árvore (por exemplo, salvar em disco).
- A implementação recursiva é bem natural: processa o nó antes de fazer as chamadas recursivas.

💡 **Detalhe importante:**  
Não é bem “busca a ordem da binary partindo da esquerda”. Na verdade, ela prioriza o **root**, só depois vai para a esquerda.

---

## 📝 Inorder Traversal

Visita primeiro todos os nós da subárvore esquerda, depois o **root**, e finalmente os nós da subárvore direita.

- **Ordem:** `Left → Root → Right`
- Se a árvore é uma **Binary Search Tree (BST)**, o inorder traversal retorna os valores em ordem crescente.

💡 **Pequena correção:**  
Mesmo se a BST estiver desbalanceada, o inorder traversal ainda garante os dados em ordem crescente. O desbalanceamento afeta a **performance**, não a ordenação.

---

## 🔥 Postorder Traversal

Visita primeiro a subárvore esquerda, depois a direita, e só

### 💡 Exemplo
```java
static class TreeNode {

    Node root;

    // Insere um novo nó na árvore binária (BST)
    public void insert(Node node) {
        if (root == null) {
            this.root = node;
        } else {
            insertRecursive(root, node);
        }
    }

    // Verifica se a árvore contém um determinado valor
    public boolean contains(Node nodeSearch) {
        if (this.root.value == nodeSearch.value) {
            return true;
        } else {
            return containsRecursive(root, nodeSearch);
        }
    }

    // ------------------------------
    // POSTORDER: Left -> Right -> Root
    // Útil para liberar recursos ou deletar a árvore
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        return postOrderRecursive(this.root, result);
    }

    private List<Integer> postOrderRecursive(Node node, List<Integer> result) {
        if (node == null) {
            return result;
        }

        postOrderRecursive(node.left, result);
        postOrderRecursive(node.right, result);
        result.add(node.value); // Root no final

        return result;
    }

    // ------------------------------
    // INORDER: Left -> Root -> Right
    // Em uma BST, retorna valores em ordem crescente
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        return inorderRecursive(this.root, result);
    }

    private List<Integer> inorderRecursive(Node node, List<Integer> result) {
        if (node == null) {
            return result;
        }

        inorderRecursive(node.left, result);
        result.add(node.value); // Root no meio
        inorderRecursive(node.right, result);

        return result;
    }

    // ------------------------------
    // PREORDER: Root -> Left -> Right
    // Útil para clonar ou exportar a estrutura da árvore
    public List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        return preorderRecursive(this.root, result);
    }

    private List<Integer> preorderRecursive(Node node, List<Integer> result) {
        if (node == null) {
            return result;
        }

        result.add(node.value); // Root primeiro
        preorderRecursive(node.left, result);
        preorderRecursive(node.right, result);

        return result;
    }

    // ------------------------------
    // Auxiliares para contains e insert

    private boolean containsRecursive(Node nodeRef, Node nodeSearch) {
        if (nodeRef == null) {
            return false;
        }
        if (nodeRef.value == nodeSearch.value) {
            return true;
        } else if (nodeSearch.value < nodeRef.value) {
            return containsRecursive(nodeRef.left, nodeSearch);
        } else {
            return containsRecursive(nodeRef.right, nodeSearch);
        }
    }

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
}

```
