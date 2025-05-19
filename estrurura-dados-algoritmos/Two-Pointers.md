# 🧠 Técnicas de Algoritmos: Two Pointers

## 🧩 O que é?

A técnica **Two Pointers** (Dois Ponteiros) é uma abordagem comum para resolver problemas que envolvem **arrays ou strings**, onde dois índices percorrem a estrutura de dados de forma coordenada.

## ✅ Quando usar?

- Quando você precisa **navegar por pares de elementos**.
- Para **reduzir a complexidade** comparado a soluções com duplo `for`.
- Útil em problemas de:
  - Inversão de strings/arrays
  - Busca de pares com certa propriedade
  - Particionamento de arrays
  - Remoção de duplicatas ordenadas

## 🛠️ Como funciona?

Dois ponteiros (`start` e `end`) percorrem a estrutura:
- Um começa do início, o outro do fim (ex: inversão).
- Ambos podem começar do início e se moverem sob alguma condição.
- O movimento de cada ponteiro depende da lógica do problema.

## 🧪 Exemplo: Inverter palavras em um array de caracteres

```java
List<Character> arr = new ArrayList<>(Arrays.asList('O', 'l', 'á', ' ', 'M', 'u', 'n', 'd', 'o'));
int i = 0;

while (i < arr.size()) {
    if (arr.get(i) != ' ') {
        int start = i;
        while (i < arr.size() && arr.get(i) != ' ') {
            i++;
        }
        int end = i - 1;

        // Aplica técnica Two Pointers para inverter a palavra
        while (start < end) {
            char temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    } else {
        i++; // pula espaço
    }
}
System.out.println(arr); // Output: [á, l, O,  , o, d, n, u, M]
```
## 🧠 Entendimento do Fluxo

- Ponteiro `i`: percorre o array procurando palavras.
- Quando encontra uma palavra (não é espaço), define o ponteiro `start`.
- Avança até o final da palavra para definir o ponteiro `end`.
- Usa dois ponteiros (`start`, `end`) para inverter a palavra **in-place**.

## 💡 Dicas Mentoria

- Pratique com problemas como:
  - Verificar se um array é palíndromo.
  - Remover duplicatas de um array ordenado.
  - Encontrar dois elementos que somam um valor (`Two Sum` com array ordenado).
- Sempre pergunte:
  - Posso resolver com dois ponteiros e evitar `for` aninhado?
  - Como posso mover cada ponteiro de forma eficiente?

## 📚 Problemas para praticar (LeetCode)

- [Reverse String](https://leetcode.com/problems/reverse-string/)
- [Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
- [Move Zeroes](https://leetcode.com/problems/move-zeroes/)
- [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
