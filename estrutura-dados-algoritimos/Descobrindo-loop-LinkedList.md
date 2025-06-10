# 🌀 Detectando Loop em uma Linked List

A detecção de loops (ou ciclos) em uma linked list é uma técnica clássica e muito importante, especialmente quando lidamos com estruturas dinâmicas em memória.

## 🤹‍♂️ Conceito Intuitivo

Imagine que você está em uma pista de corrida circular. Dois corredores partem do mesmo ponto: um caminha devagar (o ponteiro `slow`) e o outro corre mais rápido (o ponteiro `fast`).  
Se a pista for circular (ou seja, existir um loop), eventualmente o corredor rápido vai alcançar o devagar — mesmo que ele esteja uma ou mais voltas atrás!

## 🧠 A Lógica Por Trás

Utilizamos dois ponteiros:

- `slow`: avança um nó por vez.
- `fast`: avança dois nós por vez.

Ambos começam do início da lista.  
Se existir um loop, esses dois ponteiros inevitavelmente vão se encontrar dentro dele, pois o ponteiro rápido “dá voltas” até alcançar o ponteiro lento.

Se **não houver ciclo**, o ponteiro rápido eventualmente alcança o fim da lista (`null`), e a busca termina sem detecção de ciclo.

## ⚠️ Cuidado com a Confusão!

Apesar de parecer semelhante à lógica de encontrar o **meio** de uma linked list (também usamos `slow` e `fast`), o objetivo aqui é outro:

- **Encontrar o meio**: quando o `fast` chega no fim, o `slow` estará no meio.
- **Detectar ciclo**: verificamos se `slow` e `fast` colidem **antes** do `fast` chegar ao fim.

## 🧠 Exemplo de código
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;

    }
}
```

## ✅ Resumo Divertido

Dois ponteiros: um corre e o outro anda.  
Se houver loop, os dois vão se trombar!  
Se não houver, o veloz vai embora e nada acontece.  

E não, isso não é feitiçaria — é **algoritmo**!
