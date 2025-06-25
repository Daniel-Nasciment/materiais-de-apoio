🧍 Merge Sort

Merge Sort é aquele algoritmo que resolve os problemas como quem resolve um quebra-cabeça: separando as peças primeiro, depois montando com calma e na ordem certa. Ele é amigável com listas ligadas (linked lists), onde o acesso direto aos elementos não é tão simples quanto em arrays.

🌱 Quando usar Merge Sort

Linked List? Merge Sort manda muito bem.

Array? A estrela geralmente é o Quick Sort.

Por quê?

Em listas ligadas, o Merge Sort não depende de acesso aleatório rápido.

Em arrays, o Quick Sort geralmente ganha por usar menos memória e ter desempenho mais rápido na prática.

📈 Complexidade

Tempo: O(n log n) — divide e conquista!

Espaço: O(n) — porque precisa de memória extra pra fazer o merge.

🔍 O funcionamento (do meu jeito de entender)

🧠 Etapa 1: Dividir

A lista vai sendo quebrada no meio até que sobrem listas com apenas 1 nó (ou nenhum).

Isso é feito com dois ponteiros:

fast: anda 2 nós por vez

slow: anda 1 nó por vez

Quando o fast chega no fim, o slow está no meio

Assim consigo dividir a lista em duas partes.

ℹ️ Dica só pra quando vou cortar a lista:

Se quero só encontrar o meio, slow e fast começam do mesmo ponto.Mas se quero cortar a lista (como no merge sort),
✉️ o fast deve começar em head.next — isso ajuda o slow a parar exatamente antes da divisão, evitando problemas de recursão infinita.

🧠 Etapa 2: Recursão

Agora aplico o mergeSort() nessas duas metades

Isso se repete até tudo estar dividido ao máximo

🧠 Etapa 3: Juntar

Com duas metades já ordenadas, uso a função merge() pra juntar numa nova lista ordenada.

🛠️ Estrutura mental que me ajuda:

Começo simples: se a lista tem 0 ou 1 nó, ela já está ordenada. Retorna direto.

Divisão: usa slow e fast pra achar o meio. Depois separa com meio.proximo = null.

Recursão: chama mergeSort() pra cada metade.

Combinação: junta os resultados com o método merge().

🔗 Sobre o método merge

Ele junta duas listas já ordenadas.

Compara os valores de a e b e vai ligando o menor na nova lista.

Usa uma técnica com dois ponteiros:

dummy: um nó inicial fictício (ancora da nova lista)

atual: ponteiro que anda e constrói a nova lista

Importante:

Nunca mova o dummy. Ele é só a base. Sempre retorne dummy.proximo no final, porque o início real da nova lista começa ali.

🧠 Dica de ouro que me destravou:

Quando estou criando uma nova lista ligada, sempre preciso de dois nós:

Um fixo (ex: Node dummy = new Node(0);) que serve de âncora

Um ponteiro móvel (ex: Node atual = dummy;) que vai crescendo a nova lista

No final, eu retorno dummy.proximo, que é o começo real da nova lista.

💡 Etapas da implementação em Java

Encontrar o meio

Usa dois ponteiros (slow e fast)

Quando fast chega ao fim, slow aponta para o meio

Se for cortar, use fast = head.next e depois prev.next = null

Merge

Junta duas listas já ordenadas

Compara a.valor com b.valor

Vai ligando o menor na nova lista usando o atual

Merge Sort

Condição de parada: 0 ou 1 nó → retorna direto

Divide a lista

Chama mergeSort nas duas metades

Junta com merge()

🌟 Observações que me ajudam a lembrar

Merge Sort é estável (mantém a ordem de elementos iguais)

É ótimo pra listas ligadas, arquivos, streams — qualquer situação onde acesso aleatório é caro

Em arrays, nem sempre vale a pena por causa da memória extra

Recursão assusta no começo, mas fica natural quando eu penso passo a passo como no quebra-cabeça que mencionei lá no topo

Se eu precisar montar isso do zero:

Eu lembro que tudo começa dividindo

Confio que cada parte vai se ordenar sozinha por recursão

No final, só preciso saber juntar com merge()

É só isso. Nada mágico. Eu entendo melhor agora porque quebro o problema antes de montar a solução.

### Exemplo:
```java
class Node {
    int valor;
    Node next;

    Node(int valor) {
        this.valor = valor;
    }
}

public class Main {

    // Teste simples para demonstrar ordenação com Merge Sort em lista ligada
    public static void main(String[] args) {
        Node lista = new Node(5);
        lista.next = new Node(4);
        lista.next.next = new Node(1);
        lista.next.next.next = new Node(6);
        lista.next.next.next.next = new Node(9);
        lista.next.next.next.next.next = new Node(2);
        lista.next.next.next.next.next.next = new Node(3);

        System.out.println("Antes:");
        imprimir(lista);

        lista = mergeSort(lista);

        System.out.println("Depois:");
        imprimir(lista);
    }

    // Imprime os valores da lista ligada em sequência
    private static void imprimir(Node cabeca) {
        while (cabeca != null) {
            System.out.print(cabeca.valor + " ");
            cabeca = cabeca.next;
        }
        System.out.println();
    }

    // Algoritmo Merge Sort aplicado a listas ligadas
    private static Node mergeSort(Node head) {
        // Caso base: lista vazia ou com um único nó
        if (head == null || head.next == null) {
            return head;
        }

        // Encontra o meio para dividir a lista em duas metades
        Node midNode = findMid(head);
        Node right = midNode.next;
        midNode.next = null;  // separa a lista em duas partes

        // Ordena recursivamente as duas metades
        Node left = mergeSort(head);
        right = mergeSort(right);

        // Mescla as duas listas ordenadas
        return mergeNodes(left, right);
    }

    // Mescla duas listas ligadas ordenadas em uma única lista ordenada
    private static Node mergeNodes(Node left, Node right) {
        Node fakeNode = new Node(0);  // nó auxiliar para simplificar a lógica
        Node current = fakeNode;

        while (left != null && right != null) {
            if (left.valor < right.valor) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Anexa a parte restante da lista que não acabou
        current.next = (left != null) ? left : right;

        return fakeNode.next;  // retorna o início da lista mesclada
    }

    // Encontra o nó do meio da lista usando ponteiros lento e rápido
    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

```
