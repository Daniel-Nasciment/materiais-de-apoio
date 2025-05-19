# 🧠 Binary Search

## 📌 O que é?

Binary Search (Busca Binária) é uma técnica usada para **encontrar um elemento em uma lista ordenada** de forma eficiente.  
Ela funciona reduzindo o espaço de busca pela metade a cada passo.

---

## ✅ Pré-requisitos

- **A lista deve estar ordenada**.
- Funciona em arrays, listas ou qualquer estrutura **indexada e ordenada**.

---

## 🔍 Como funciona?

1. Começamos com dois ponteiros: início e fim do array.
2. Calculamos o **índice do meio** entre início e fim.
3. Verificamos:
   - Se o valor do meio é o que estamos procurando, retornamos.
   - Se o valor do meio é **maior**, descartamos a **metade direita**.
   - Se for **menor**, descartamos a **metade esquerda**.
4. Repetimos até encontrar o valor ou esgotar o intervalo.

> ⚙️ A ideia é simples: **dividir para conquistar**.

---

## 📈 Complexidade

- **Tempo**: `O(log n)`  
  Cresce lentamente mesmo que a entrada dobre.
- **Espaço**: `O(1)`  
  Utiliza apenas algumas variáveis auxiliares (ponteiros).

---

## 💡 Intuição

Imagine uma lista de números de 1 a 100. Se quero saber se o número 73 está na lista, em vez de olhar um por um, olho o número do meio:
- É 50? Não.  
  73 é maior, então descarto tudo à esquerda de 50.
- Agora o meio da nova parte... e assim por diante.

Você **reduz o problema pela metade a cada tentativa**, o que é extremamente eficiente.

---

## 🧪 Exemplo de código

```java
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
                                   11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21);

int inicio = 0;
int fim = nums.size() - 1;
int steps = 0;

int numeroSorte = 3;

while (inicio <= fim) { // Continua enquanto houver intervalo válido

    steps += 1;

    int meio = (inicio + fim) / 2; // Ponto central da busca

    if (nums.get(meio).equals(numeroSorte)) { // Valor encontrado
        System.out.println(steps);
        return;
    }

    if (numeroSorte > nums.get(meio)) {
        inicio = meio + 1; // Descarta metade esquerda
    } else {
        fim = meio - 1; // Descarta metade direita
    }
}
```
