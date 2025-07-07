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
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]

public static boolean DFS(TreeNode node, int targetSum) {

    // Se o nó atual for nulo, não há o que verificar
    if (node == null) {
        return false;
    }

    // Se for folha e o target bater, encontrou o caminho
    if (node.left == null && node.right == null && targetSum == node.val){
        return true;
    }

    // Continua buscando nos filhos (esquerda e direita)
    // Subtrai o valor atual do target, mantendo o resto da soma a ser encontrado
    return DFS(node.left, targetSum - node.val) 
           || DFS(node.right, targetSum - node.val);
}
```
