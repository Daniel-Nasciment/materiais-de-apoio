# Binary Tree - Estrutura de Dados

## Conceito

Uma **árvore binária (Binary Tree)** é uma estrutura de dados hierárquica onde cada nó pode ter no máximo dois filhos, geralmente denominados:

- **Left (esquerda)**: Subárvore à esquerda do nó.
- **Right (direita)**: Subárvore à direita do nó.

Cada nó em uma árvore binária contém:

1. **Dado** (valor armazenado no nó).
2. **Referência para o nó à esquerda (left)**.
3. **Referência para o nó à direita (right).**

A árvore é acessada a partir de um **head (raiz)**, que é o ponto inicial da estrutura.

## Tipos de Árvores Binárias

1. **Árvore Binária Completa**: Todos os níveis, exceto talvez o último, estão completamente preenchidos.
2. **Árvore Binária Cheia**: Cada nó tem exatamente 0 ou 2 filhos.
3. **Árvore Binária Perfeita**: Todos os nós internos têm dois filhos e todas as folhas estão no mesmo nível.
4. **Árvore Binária Balanceada**: Diferença entre a altura das subárvores esquerda e direita é no máximo 1.

## Operações Principais

1. **Inserção (Insert)**: Adiciona um novo nó na posição apropriada.
   - Complexidade: O(h), onde h é a altura da árvore.
2. **Busca (Search)**: Encontra um nó com um valor específico.
   - Complexidade: O(h).
3. **Percursos**:
   - **In-Order (Esquerda, Raiz, Direita)**: Produz os valores em ordem crescente.
   - **Pre-Order (Raiz, Esquerda, Direita)**.
   - **Post-Order (Esquerda, Direita, Raiz)**.

## Complexidade de Tempo

- **Melhor Caso (Árvore Balanceada)**: O(log n).
- **Pior Caso (Árvore Desbalanceada)**: O(n).

## Aplicações Comuns

1. **Sistemas de Arquivos**: Organização hierárquica de diretórios.
2. **Árvores de Expressão**: Representação de expressões matemáticas.
3. **Árvores de Decisão**: Usadas em inteligência artificial e aprendizado de máquina.
4. **Pesquisa e Ordenação**: Base para árvores de busca binária (BST).
