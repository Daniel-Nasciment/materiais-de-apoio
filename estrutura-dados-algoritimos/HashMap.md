# HashMap

## O que é?

Um **HashMap** é uma estrutura de dados que armazena pares **chave → valor**, permitindo acesso super rápido ao valor por meio da chave. Na média, o tempo de acesso é de **O(1)** (tempo constante), o que significa que ele encontra a resposta rapidinho, independente do tamanho dos dados.

---

## Como funciona?

### 🎯 Função Hash (Hash Function)

- Uma **função hash** transforma uma **chave** em um número (índice), que aponta onde o valor correspondente será guardado na memória.
- A ideia é transformar diferentes chaves em índices diferentes (idealmente).
- **O(1)** é garantido quando:
  - A função hash é bem distribuída.
  - O número de colisões é baixo.
  - O tamanho do HashMap acompanha o crescimento dos dados.

### ⚠️ Colisões

- Acontece quando duas chaves diferentes viram o mesmo índice (slot).
- Nesses casos, o HashMap usa uma **estrutura auxiliar** (normalmente uma *LinkedList* ou *árvore*) para armazenar as múltiplas entradas naquele índice.
- A busca nesse caso pode cair pra **O(n)**, mas geralmente é insignificante, já que o número de colisões costuma ser pequeno.

---

## 📏 Load Factor (Fator de Carga)

- Representa o quão cheio o HashMap está.
- Exemplo: Um fator de carga de **0.7** significa que 70% dos espaços estão ocupados.
- Quando esse fator é atingido:
  - O HashMap **duplica de tamanho** internamente.
  - Faz o **re-hash**: recalcula os índices de todas as chaves.
  - Isso mantém o desempenho estável mesmo com muitos dados.

---

## 🔄 Comportamento de Rehash

Quando o HashMap "enche demais":
1. Um novo array interno é criado, com o dobro do tamanho.
2. Cada chave tem seu índice recalculado com base no novo tamanho.
3. Todos os pares são movidos para suas novas posições.

Esse processo é automático e invisível pra quem usa o HashMap.

---

## 💡 Dicas para usar HashMap com sabedoria

1. **Evite colisões**:
   - Use boas funções hash (não precisa se preocupar, Java cuida disso bem).
   - Mantenha o tamanho do HashMap proporcional ao número de itens.

2. **Gerencie bem o Load Factor**:
   - O padrão de 0.7 é eficiente.
   - Evite criar HashMaps muito pequenos se espera muitos dados.

3. **Iteração eficiente**:
   - `keySet()` → percorre só as chaves.
   - `entrySet()` → percorre pares (chave + valor).

---

## 🧩 Aplicações práticas em algoritmos (como no LeetCode)

O HashMap é:
- Às vezes, **a solução inteira**.
- Às vezes, **a ferramenta para montar outra lógica**.
- Às vezes, **a otimização** que tira o tempo de O(n²) pra O(n).

---

## 🧠 Exemplo de lógica com HashMap

📌 **Problema: encontrar o índice da primeira letra única em uma string.**

### Estratégia:

1. **Contar a frequência de cada caractere**:
   - Percorrer a string e registrar quantas vezes cada letra aparece.
   - Usar o caractere como chave e a quantidade como valor.

2. **Descobrir a primeira letra única**:
   - Percorrer a string novamente, na ordem original.
   - Quando encontrar a primeira letra com contagem 1, retornar o **índice** dela.

### Por que usar HashMap?

- Você consegue saber em O(1) quantas vezes viu uma letra.
- Evita fazer comparações desnecessárias.
- Garante que você percorre a string só duas vezes (O(n)), e não mais do que isso.

---

### Resolução

```java
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // String que será analisada
        String palavra = "LeetCode";

        // Criamos um LinkedHashMap para armazenar cada caractere e um array com:
        // [0] → posição da primeira ocorrência
        // [1] → quantidade de vezes que o caractere apareceu
        // Usamos LinkedHashMap para manter a **ordem de inserção** (importante para saber qual apareceu primeiro)
        Map<Character, int[]> map = new LinkedHashMap<>();

        // Percorremos todos os caracteres da palavra
        for (int i = 0; i <= palavra.length() - 1; i++) {

            char letra = palavra.charAt(i); // pegamos o caractere na posição i

            if (map.containsKey(letra)) {
                // Se a letra já está no mapa, recuperamos o array com posição e contagem
                int[] valores = map.get(letra);

                // Atualizamos a entrada: mantemos a posição original (valores[0]) e somamos +1 na contagem
                map.put(letra, new int[]{valores[0], valores[1] + 1});
            } else {
                // Se for a primeira vez que a letra aparece, adicionamos no mapa:
                // posição atual e contagem 1
                map.put(letra, new int[]{i, 1});
            }

        }

        // Agora percorremos o mapa em ordem de inserção
        // Procuramos o primeiro caractere que aparece **só uma vez**
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == 1) {
                System.out.println("Primeiro caractere que nao se repete: " +
                        entry.getKey() + " - Posição: " + entry.getValue()[0]);
                return; // assim que encontramos o primeiro único, saímos
            }
        }

    }
}
```
