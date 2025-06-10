# 🔁 Como Inverter uma Lista Ligada — Entenda de Vez com Pilha de Cartas 🃏

## 🌟 Objetivo

Transformar essa estrutura:

```
A → B → C → D
```

Em:

```
D → C → B → A
```

Ou seja: inverter a direção das setas (ponteiros `.next`).

---

## 🧠 O Desafio

Cada nó (chamado `ListNode`) só conhece quem vem **depois** dele (`.next`).

Ele **não tem como olhar pra trás**. Logo, não conseguimos voltar.

### ✨ Solução:

Guardar o que vem depois antes de perder o acesso.

---

## 🧬 Os 3 Ponteiros Mágicos

1. `head`: o nó atual (a carta que você está segurando agora)
2. `next`: o próximo nó (pra não perder ele quando mudar a seta)
3. `newList`: o topo da nova lista invertida que você está formando

---

## 🃏 Analogia: Pilha de Cartas

Pense numa fileira de cartas na mesa:

```
A → B → C → D
```

A ideia é: pegar uma por uma da esquerda e empilhar numa nova pilha. Assim a ordem fica invertida.

---

## 🧃 Passo a Passo Visual

### ▶️ Etapa 1

* Pega o `A` (head)
* Guarda o `B` (next)
* Faz o `A` apontar pra `null` (newList ainda está vazia)
* `newList = A`
* `head = B`

```
newList: A
restante: B → C → D
```

---

### ▶️ Etapa 2

* Pega o `B`
* Guarda `C`
* `B.next = A`
* `newList = B`
* `head = C`

```
newList: B → A
restante: C → D
```

---

### ▶️ Etapa 3

* Pega `C`
* Guarda `D`
* `C.next = B`
* `newList = C`
* `head = D`

```
newList: C → B → A
restante: D
```

---

### ▶️ Etapa 4

* Pega `D`
* Guarda `null`
* `D.next = C`
* `newList = D`
* `head = null`

```
newList: D → C → B → A
restante: (vazia)
```

---

## 🎯 Truque Final

Você **nunca adiciona no fim da lista nova**, sempre adiciona **no topo**.

Por isso a ordem é invertida.

E antes de virar qualquer seta, você **guarda o que vem depois** usando `next`.

---

## 📌 Exemplo

```java
public static class Solution {
        public ListNode reverseList(ListNode nodeHead) {
            ListNode newNode = null;

            while (nodeHead != null) {
                ListNode nextNode = nodeHead.next;
                nodeHead.next = newNode;       
                newNode = nodeHead;            
                nodeHead = nextNode;             
            }

            return newNode;
        }
    }
```

## 📌 Recapitulando

* Cada nó só conhece o próximo.
* Você usa `next` pra guardar o futuro.
* Vira a seta com `head.next = newList`.
* Empilha o nó no topo com `newList = head`.
* Avança com `head = next`.

---

> ✨ "Não dá pra voltar, mas dá pra se preparar antes de seguir em frente."

Agora sim, quando você for olhar o código, tudo vai fazer sentido! 🚀
