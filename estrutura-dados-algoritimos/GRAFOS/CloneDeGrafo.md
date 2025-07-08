## Exemplo:

```java
public static Node cloneGraph(Node node) {
    if (node == null) return null;

    // Mapeia valor do nó original -> clone do nó
    Map<Integer, Node> map = new HashMap<>();
    // Fila para BFS
    Queue<Node> queue = new LinkedList<>();

    // Inicializa
    queue.add(node);
    map.put(node.val, new Node(node.val, new ArrayList<>()));

    // Começa BFS
    while (!queue.isEmpty()) {
        Node current = queue.poll();
        Node currentClone = map.get(current.val);

        for (Node neighbor : current.neighbors) {
            // Se ainda não clonou o vizinho
            if (!map.containsKey(neighbor.val)) {
                map.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
                queue.add(neighbor);
            }

            // Adiciona o vizinho clonado na lista do clone atual
            currentClone.neighbors.add(map.get(neighbor.val));
        }
    }

    return map.get(node.val);
}
```
