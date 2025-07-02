# 🌳 DFS (Depth-First Search)

---

## 🚀 O que é?
DFS (Depth-First Search) é um algoritmo de **busca em profundidade** que percorre uma árvore ou grafo explorando **o máximo possível cada caminho antes de retroceder**.

---

## 🔄 Como funciona?
- Desce recursivamente por cada ramo até chegar no final (folha ou sem vizinhos).
- Depois **volta um nível (backtracking)** para explorar o próximo caminho.
- Repete até todos os caminhos serem explorados ou encontrar o que procura.

---

## ⚙️ Características
- Usa **stack (pilha)** implicitamente (pela recursão) ou explicitamente.
- Ótimo para:
  - Verificar existência de caminho.
  - Explorar todas as combinações ou possibilidades.
- Complexidade:
  - **Tempo:** O(N) para árvores (visita cada nó uma vez).
  - **Espaço:** O(H) na stack, H = altura da árvore.

---

## 💡 Essência
> **Explora profundamente primeiro, volta só quando não há mais pra onde ir.**
