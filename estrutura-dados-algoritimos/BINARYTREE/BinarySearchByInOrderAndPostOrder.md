# 🌳 Como construir uma Binary Tree a partir de Inorder + Postorder

---

## 🚀 1. Identifique o root
- O **último elemento do postorder** é sempre o root da árvore (ou da subárvore atual).

---

## 🧭 2. Separe o inorder em esquerda e direita
- Localize o índice do root no inorder.
- Tudo à esquerda desse índice forma a **subárvore esquerda**.
- Tudo à direita forma a **subárvore direita**.

---

## 🔄 3. Construa recursivamente
- O postorder é estruturado como `[left subtree][right subtree][root]`.
- Ao percorrer **de trás pra frente**, o próximo root encontrado é o da **subárvore direita**.

Portanto:
- **Construa primeiro a subárvore direita**, avançando no postorder para trás.
- Depois construa a subárvore esquerda.

---

## ⏳ 4. Continue até não haver mais nós
- A recursão para quando o segmento do inorder fica vazio, indicando não há mais nós para aquela subárvore.

---

## ⚡ Dica final para eficiência
- Use um **HashMap** para mapear `valor -> índice no inorder`, evitando buscas O(N) e garantindo O(1) por acesso.

---

## 💡 Resumo
> Pegue o último do postorder como root →  
> separe inorder em esquerda/direita →  
> monte recursivamente **direita primeiro**, depois esquerda →  
> continue até os segmentos se esgotarem.

## 📝 Código Java

```java
public static TreeNode buildTree() {
    int[] inorder = new int[]{9,3,15,20,7};
    int[] postorder = new int[]{9,15,7,20,3};

    TreeNode treeNode = buildTreeRecursive(
        inorder,
        0,
        inorder.length - 1,
        postorder,
        postorder.length - 1
    );

    return treeNode;
}

private static TreeNode buildTreeRecursive(
    int[] inorder,
    int leftInorder,
    int rightInorder,
    int[] postorder,
    int indexNodeRootPostOrder
) {
    // Caso base: sem nós restantes para processar
    if (indexNodeRootPostOrder < 0) {
        return null;
    }

    // Se o inorder tem apenas um nó, cria e retorna direto
    if (inorder[leftInorder] == postorder[indexNodeRootPostOrder]) {
        return new TreeNode(postorder[indexNodeRootPostOrder]);
    }

    // O último nó do postorder é sempre o root do (sub)árvore atual
    TreeNode node = new TreeNode(postorder[indexNodeRootPostOrder]);

    // Localiza a posição do root no inorder
    int indexRootInorder = 0;
    for (int i = 0; i <= inorder.length - 1; i++) {
        if (inorder[i] == node.val) {
            indexRootInorder = i;
            break;
        }
    }

    // Calcula o offset para identificar o novo root da subárvore esquerda no postorder
    int indexStartBinaryLeft = rightInorder - indexRootInorder;

    // Monta recursivamente a subárvore direita
    node.right = buildTreeRecursive(
        inorder,
        indexRootInorder + 1,
        rightInorder,
        postorder,
        indexNodeRootPostOrder - 1
    );

    // Monta recursivamente a subárvore esquerda
    node.left = buildTreeRecursive(
        inorder,
        leftInorder,
        indexRootInorder - 1,
        postorder,
        indexNodeRootPostOrder - indexStartBinaryLeft - 1
    );

    return node;
}
```
