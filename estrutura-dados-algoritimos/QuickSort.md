# Quick Sort

## 🧠 Conceito

Quick Sort é um algoritmo de ordenação baseado na técnica de **dividir para conquistar**.  
A ideia é pegar um problema grande (ordenar um array inteiro) e quebrá-lo em pedaços menores e mais fáceis de resolver, aplicando recursivamente a mesma lógica.

O grande charme do Quick Sort está na **escolha de um pivô**. Esse pivô serve como referência para dividir o array em dois grupos:
- Elementos menores que o pivô
- Elementos maiores que o pivô

O processo se repete para cada um desses grupos até que todo o array esteja ordenado.

---

## 🧮 Complexidade Temporal

| Cenário       | Tempo de Execução |
|---------------|-------------------|
| Melhor caso   | O(n log n)        |
| Caso médio    | O(n log n)        |
| Pior caso     | O(n²)             |

> 💡 **Obs.**: O pior caso geralmente acontece quando o pivô escolhido é sempre o menor ou o maior elemento do array, o que gera partições desbalanceadas (um lado gigante, outro vazio).

---

## 🧠 Complexidade Espacial

| Cenário        | Espaço Consumido |
|----------------|------------------|
| Melhor / Médio | O(log n)         |
| Pior caso      | O(n)             |

> Isso está diretamente ligado à profundidade da recursão.  
> No pior cenário, onde o array vai sendo particionado de forma desbalanceada, a pilha de chamadas recursivas pode crescer bastante.

---

## 🔁 Como Funciona

1. Escolhe-se um **pivô**.
2. Reorganiza-se o array para que todos os elementos **menores que o pivô fiquem à esquerda**, e os **maiores à direita**.
3. Aplica-se o **Quick Sort recursivamente** à esquerda e à direita do pivô.
4. Quando os subarrays tiverem um ou nenhum elemento, o array já está ordenado.

---

## 💡 Otimizações

- Uma das otimizações clássicas do Quick Sort é evitar a criação de subarrays.  
  Ao invés de criar novas cópias dos arrays divididos, usamos **índices (ponteiros)** para marcar o início e fim de cada "subarray virtual".
- Isso evita um crescimento desnecessário da complexidade espacial — muito parecido com a ideia por trás de algoritmos como a **Exponential Search**, que trabalham com posições ao invés de alocações.

---

## 🧠 Considerações Finais

- É um dos algoritmos de ordenação **mais rápidos na prática** para dados em memória.
- Não é **estável** (a ordem dos elementos iguais pode mudar).
- Muito utilizado em bibliotecas padrão (por exemplo, o `.sort()` em várias linguagens costuma ser uma versão otimizada de Quick Sort ou introsort).


## Exemplo

```java

public class Main {

    public static void main(String[] args) {
        int[] array = { 10, 7, 8, 9, 1, 5 };

        quickSort(array, 0, array.length - 1);

        // Imprime o array ordenado
        for (int valor : array) {
            System.out.print(valor + " ");
        }
    }

    /**
     * Aplica o algoritmo Quick Sort recursivamente.
     *
     * @param array Array a ser ordenado
     * @param inicio Índice inicial do subarray
     * @param fim Índice final do subarray
     */
    private static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(array, inicio, fim);

            // Ordena os elementos à esquerda do pivô
            quickSort(array, inicio, indicePivo - 1);

            // Ordena os elementos à direita do pivô
            quickSort(array, indicePivo + 1, fim);
        }
    }

    /**
     * Rearranja os elementos ao redor do pivô.
     *
     * Elementos menores que o pivô vão para a esquerda,
     * maiores vão para a direita.
     *
     * @param array Array em que será feita a partição
     * @param inicio Índice inicial do subarray
     * @param fim Índice final do subarray (pivô)
     * @return Índice final do pivô após a partição
     */
    private static int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int indiceMenor = inicio - 1;

        for (int indiceAtual = inicio; indiceAtual < fim; indiceAtual++) {
            if (array[indiceAtual] < pivo) {
                indiceMenor++;
                trocar(array, indiceMenor, indiceAtual);
            }
        }

        // Coloca o pivô na posição correta
        indiceMenor++;
        trocar(array, indiceMenor, fim);
        return indiceMenor;
    }

    /**
     * Troca dois elementos de posição no array.
     *
     * @param array Array onde ocorre a troca
     * @param i Índice do primeiro elemento
     * @param j Índice do segundo elemento
     */
    private static void trocar(int[] array, int i, int j) {
        int temporario = array[i];
        array[i] = array[j];
        array[j] = temporario;
    }
}

```
