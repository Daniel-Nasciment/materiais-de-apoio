# Big O Notation

Big O Notation é uma forma de descrever a **complexidade de um algoritmo**, medindo como o tempo ou espaço necessário para a execução do algoritmo cresce em relação ao tamanho do **input**. Ela é dividida em dois tipos principais:

- **Complexidade Temporal**: Mede o tempo de execução.
- **Complexidade Espacial**: Mede a memória utilizada.

## Tipos de Complexidade (Big O)

### 1. **O(1) - Constante**
- **Descrição**: O tempo de execução não muda, independentemente do tamanho do input.
- **Exemplo**: Acessar diretamente um índice de um array.
- **Visualização**:
  - Input: 10 → Tempo: 1 unidade
  - Input: 1.000 → Tempo: 1 unidade

---

### 2. **O(log n) - Logarítmica**
- **Descrição**: O tempo de execução cresce logaritmicamente. Isso significa que, à medida que o input aumenta, o tempo de execução cresce muito mais lentamente.
- **Exemplo**: Busca binária.
- **Visualização**:
  - Input: 10 → Tempo: 4 unidades
  - Input: 1.000 → Tempo: 10 unidades

---

### 3. **O(n) - Linear**
- **Descrição**: O tempo de execução cresce proporcionalmente ao tamanho do input.
- **Exemplo**: Percorrer todos os elementos de um array.
- **Visualização**:
  - Input: 10 → Tempo: 10 unidades
  - Input: 1.000 → Tempo: 1.000 unidades

---

### 4. **O(n log n) - Linear Logarítmica**
- **Descrição**: Algoritmos como o *Merge Sort* possuem essa complexidade. Eles combinam a eficiência da divisão e conquista (log n) com a necessidade de processar todos os elementos (n).
- **Exemplo**: Ordenação por *Merge Sort*.
- **Visualização**:
  - Input: 10 → Tempo: 40 unidades
  - Input: 1.000 → Tempo: 10.000 unidades

---

### 5. **O(n²) - Quadrática**
- **Descrição**: O tempo de execução cresce quadraticamente em relação ao tamanho do input, geralmente devido ao uso de dois loops aninhados (*nested loops*).
- **Exemplo**: Comparar todos os elementos de um array com todos os outros.
- **Visualização**:
  - Input: 10 → Tempo: 100 unidades
  - Input: 1.000 → Tempo: 1.000.000 unidades

---

### 6. **O(2ⁿ) - Exponencial**
- **Descrição**: O tempo de execução dobra a cada novo elemento no input.
- **Exemplo**: Resolver o problema da *torre de Hanói* ou gerar todas as combinações possíveis de um conjunto.
- **Visualização**:
  - Input: 10 → Tempo: 1.024 unidades
  - Input: 20 → Tempo: 1.048.576 unidades

---

### 7. **O(n!) - Fatorial**
- **Descrição**: O tempo de execução cresce de forma extremamente rápida, proporcional ao fatorial do tamanho do input. Frequentemente ocorre em problemas de permutação ou combinações de grande escala.
- **Exemplo**: Resolver o problema do caixeiro-viajante (*Travelling Salesman Problem*).
- **Visualização**:
  - Input: 5 → Tempo: 120 unidades
  - Input: 10 → Tempo: 3.628.800 unidades

---

## Resumo Visual

| Notação   | Nome                 | Exemplo                   | Crescimento         |
|-----------|----------------------|---------------------------|---------------------|
| O(1)      | Constante            | Acesso direto a um índice | Fixo                |
| O(log n)  | Logarítmica          | Busca binária             | Lento               |
| O(n)      | Linear               | Percorrer um array        | Proporcional        |
| O(n log n)| Linear Logarítmica   | Merge Sort                | Moderado            |
| O(n²)     | Quadrática           | Dois loops aninhados      | Rápido              |
| O(2ⁿ)     | Exponencial          | Problemas de combinação   | Muito rápido        |
| O(n!)     | Fatorial             | Permutação de elementos   | Extremamente rápido |

---

Entender Big O Notation ajuda a selecionar algoritmos mais eficientes para diferentes problemas e melhora a capacidade de otimizar código.
