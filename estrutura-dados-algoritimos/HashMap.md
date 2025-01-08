# Hash Map

## Descrição
Um **HashMap** é uma estrutura de dados que armazena pares de chave e valor. Ele permite acesso rápido aos valores utilizando suas respectivas chaves, com um tempo de busca geralmente ótimo de **O(1)** (Big-O Notation).

## Características

### Hash Function
- A função hash transforma uma **chave** (key) em um **slot** de memória onde o valor correspondente será armazenado.
- **Como garantir desempenho O(1)?**
  - Considere o tamanho da chave (**key**) e o tamanho do mapa (**HashMap**).
  - Colisões podem ocorrer quando duas chaves diferentes geram o mesmo slot de memória.

### Load Factor (Fator de Carga)
- Refere-se à relação entre a quantidade de dados armazenados e o tamanho total da estrutura.
- Quando o fator de carga atinge **70%**, o HashMap cria um novo array maior e re-hash de todos os elementos.

### Colisões
- Quando duas ou mais chaves geram o mesmo slot de memória:
  - É criada uma subestrutura, normalmente uma **Linked List**, para armazenar os elementos que colidiram.
  - A busca em uma sublista tem custo **O(n)**, mas como ela é pequena, o impacto no desempenho é mínimo.

---

## Implementação em Java
O Java fornece a classe **HashMap** em `java.util`. Segue um exemplo de uso:

```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Inserir elementos
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Acessar um valor
        System.out.println("Idade de Alice: " + map.get("Alice"));

        // Verificar se uma chave existe
        if (map.containsKey("Bob")) {
            System.out.println("Bob está no mapa.");
        }

        // Iterar sobre o HashMap
        for (String key : map.keySet()) {
            System.out.println(key + " tem " + map.get(key) + " anos.");
        }
    }
}
```

---

## Dicas
1. **Evitar Colisões**:
   - Escolha uma função hash eficiente para distribuir uniformemente as chaves.
   - Use o tamanho do mapa para limitar colisões.
2. **Gerenciar o Load Factor**:
   - O fator de carga ideal é **0.7** (70%).
   - A classe **HashMap** automaticamente redimensiona e redistribui os elementos quando o fator de carga é atingido.
3. **Iteração**:
   - Use `keySet()` para iterar pelas chaves.
   - Use `entrySet()` para acessar pares chave-valor diretamente.

---

## Comportamento de Rehash
Quando o **load factor** atinge 70%, o HashMap:
1. Cria um novo array com o dobro do tamanho.
2. Recalcula as posições de todas as chaves (re-hash).
3. Move os elementos antigos para os novos slots.

Isso garante que o desempenho do HashMap permaneça eficiente com o crescimento de dados.

---