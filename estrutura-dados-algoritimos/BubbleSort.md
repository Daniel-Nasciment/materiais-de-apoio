# 🫧 Bubble Sort

**Bubble Sort** é um dos algoritmos de ordenação mais simples de todos os tempos. Simples *até demais* — e justamente por isso, nem sempre é a melhor escolha quando o assunto é performance. Mas ele tem seus momentos de glória.

## 📈 Complexidade

- **Pior caso (e também caso médio):** O(n²)  
- **Melhor caso:** O(n)  
- **Complexidade espacial:** O(1)  

## 🧠 Como funciona?

Ele compara elementos adjacentes e os troca de lugar se estiverem fora de ordem. A cada iteração, o maior elemento “borbulha” até a posição correta no final do array — daí o nome "Bubble" (bolha).

## ✅ Vantagens

- Implementação fácil de entender
- Sem estrutura auxiliar
- Boa escolha para arrays pequenos (10 a 100 elementos)
- Possibilidade de detectar ordenação e parar mais cedo

## ❌ Desvantagens

- Extremamente ineficiente em grandes volumes de dados
- Realiza muitas trocas, o que pode ser custoso dependendo do contexto

## Exemplo de código
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Lista mutável (Arrays.asList cria uma lista fixa internamente, o que pode gerar problemas em métodos que alteram a estrutura)
        List<Integer> numeros = Arrays.asList(1, 3, 2, 4, 5);

        // Bubble sort com otimização: repete o processo até não haver trocas
        for (int j = 0; j < numeros.size() - 1; j++) {

            boolean ordenado = true; // Flag para verificar se houve troca nessa iteração

            for (int i = 0; i < numeros.size() - 1 - j; i++) {
                Integer n1 = numeros.get(i);
                Integer n2 = numeros.get(i + 1);

                if (n1 > n2) {
                    // Troca os elementos fora de ordem
                    numeros.set(i, n2);
                    numeros.set(i + 1, n1);
                    ordenado = false;
                }
            }

            // Mostra o estado do array a cada passada
            System.out.println(numeros);

            // Se nenhuma troca foi feita, o array já está ordenado
            if (ordenado) break;
        }
    }
}
```
