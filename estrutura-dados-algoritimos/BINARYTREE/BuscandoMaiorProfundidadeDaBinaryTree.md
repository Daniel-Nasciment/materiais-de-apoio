# Exemplo:

```java
public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int alturaEsq = maxDepth(root.left);
        int alturaDir = maxDepth(root.right);
        return 1 + Math.max(alturaEsq, alturaDir);
    }
```
