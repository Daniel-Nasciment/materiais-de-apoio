# Exemplo:

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> pList = new LinkedList<>();
    Queue<TreeNode> qList = new LinkedList<>();

    pList.add(p);
    qList.add(q);

    while (!pList.isEmpty() && !qList.isEmpty()) {
        TreeNode poll = pList.poll();
        TreeNode poll2 = qList.poll();

        if (poll == null && poll2 == null) continue;
        if (poll == null || poll2 == null) return false;
        if (poll.val != poll2.val) return false;

        pList.add(poll.left);
        qList.add(poll2.left);

        pList.add(poll.right);
        qList.add(poll2.right);
    }

    return pList.isEmpty() && qList.isEmpty();
}
```
