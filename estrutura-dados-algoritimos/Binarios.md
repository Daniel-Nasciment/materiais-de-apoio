# Bitwise em Java - Guia Objetivo

## Representação Binária

Números são compostos por bits (0 e 1), cada um representando uma potência de 2. Da direita para a esquerda, cada bit vale o dobro do anterior.

## Bit de Sinal

Quando usado complemento de dois, o bit mais à esquerda indica o sinal:

* 0 = positivo
* 1 = negativo

## Par ou Ímpar

O bit menos significativo (o da extrema direita) indica:

* 0 = par
* 1 = ímpar

## Operadores de Deslocamento

### Left Shift `<<`

Desloca os bits para a esquerda. Cada deslocamento dobra o valor e adiciona 0 à direita.

### Right Shift `>>`

Desloca os bits para a direita. Remove bits da direita. O bit que entra pela esquerda replica o bit de sinal.

Muito usado como alternativa rápida para divisões inteiras por potências de dois. Exemplo:

* `n >> 1` equivale a `n / 2`
* `n >> 2` equivale a `n / 4`

Deve-se tomar cuidado com números negativos, pois o bit de sinal é mantido.

Para divisão sem sinal, usa-se `>>>`.

## Operadores Bitwise

### AND `&`

Retorna 1 apenas se ambos os bits forem 1.

Uso comum: verificar se um bit específico está ativado. Por exemplo, `n & 1` verifica se o número é par ou ímpar, analisando apenas o último bit.

### OR `|`

Retorna 1 se pelo menos um dos bits for 1.

### XOR `^`

Retorna 1 se os bits forem diferentes. Um valor XOR com ele mesmo resulta em 0.

**Propriedades importantes:**

* `a ^ a = 0` (anula o valor)
* `a ^ 0 = a` (preserva o valor)
* Ordem não importa (comutativo e associativo)
* Se um número aparece um número par de vezes, ele é cancelado; se aparece uma vez, ele permanece

Isso permite resolver problemas como encontrar um único número faltante ou detectar valores não duplicados em listas, sem precisar de ordenação ou estruturas extras.

### NOT `~`

Inverte todos os bits. Em tipos com sinal, o resultado é equivalente a `-(x + 1)`.

---

Bitwise é ideal para operações de baixo nível, manipulação de flags e otimizações com potências de dois. Também permite implementar algoritmos eficientes, especialmente com o uso de XOR para detectar padrões, diferenças e valores únicos em conjuntos de dados não ordenados.

Além disso, o uso de operadores como `&` e `>>` permite simplificar verificações e substituições de operações aritméticas, como `%` (módulo) e divisões, tornando o código mais rápido e eficiente em cenários específicos.


### Exemplo usando `XOR`
```java
private static void xor() {
    int[] ints = {3, 0, 1}; // Array com números (um da sequência de 0 a 3 está faltando)
    int x = 0; // Variável acumuladora com XOR

    for (int num : ints) {
        x ^= num; // Aplica XOR entre x e o valor atual do array

        for (int j = 0; j <= ints.length; j++) {
            x ^= j; // Aplica XOR entre x e os números de 0 até o tamanho do array (0 a 3)
        }
    }

    System.out.println(x); // Imprime o número que está faltando no array
}
```

### Exemplo usando `&`
```java
int n = 7;

if ((n & 1) == 0) {
    System.out.println("Par");
} else {
    System.out.println("Ímpar");
}

```

💡 Como funciona?
* 1 em binário: 0000 0001
* O operador & faz a verificação do último bit (bit menos significativo).
* Se o último bit for 1, o número é ímpar.
* Se for 0, é par.

### Exemplo usando `>>`
```java
int n = 40;
int resultado = n >> 1;

System.out.println(resultado); // Imprime 20
```

💡 Como funciona?
* Cada >> 1 divide o número por 2
* '>>' 2 divide por 4
* '>>' n divide por 2^n
* Exemplo visual (sem mostrar binário):
* 40 >> 1 → 20
* 40 >> 2 → 10
* 40 >> 3 → 5

⚠️ Importante:
* Se for número negativo, o bit de sinal permanece 1 (mantém o sinal).
* Para ignorar sinal (em int), use >>> (unsigned right shift).
