# Design Pattern Decorator em Java

### 1. Introdução:
O Design Pattern Decorator é um padrão de design estrutural que permite adicionar comportamentos ou responsabilidades adicionais a objetos dinamicamente, sem alterar sua estrutura básica. Ele utiliza a composição em vez de herança para estender o comportamento de um objeto.

### 2. Exemplo de Código:
Imagine que temos uma cafeteria que serve diferentes tipos de café e queremos adicionar ingredientes extras, como leite, creme ou açúcar, a cada xícara de café. Podemos usar o padrão Decorator para adicionar esses ingredientes extras dinamicamente.

### Interface Base para Café:
```java
// Interface Componente
interface Cafe {
    String descricao();
    double preco();
}
```
### Implementação Concreta do Café:
```java
// Implementação concreta de Café
class CafeSimples implements Cafe {
    @Override
    public String descricao() {
        return "Café simples";
    }

    @Override
    public double preco() {
        return 1.0;
    }
}
```
### Decoradores para Adicionar Ingredientes Extras:
```java
// Decorador abstrato
abstract class CafeDecorator implements Cafe {
    protected Cafe cafeDecorado;

    public CafeDecorator(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }

    @Override
    public String descricao() {
        return cafeDecorado.descricao();
    }

    @Override
    public double preco() {
        return cafeDecorado.preco();
    }
}

// Decorador concreto para adicionar leite
class ComLeite extends CafeDecorator {
    public ComLeite(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public String descricao() {
        return cafeDecorado.descricao() + ", com leite";
    }

    @Override
    public double preco() {
        return cafeDecorado.preco() + 0.5; // Adiciona R$ 0.50 pelo leite
    }
}

// Decorador concreto para adicionar creme
class ComCreme extends CafeDecorator {
    public ComCreme(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public String descricao() {
        return cafeDecorado.descricao() + ", com creme";
    }

    @Override
    public double preco() {
        return cafeDecorado.preco() + 0.75; // Adiciona R$ 0.75 pelo creme
    }
}
```
### Exemplo de Uso:
``` java
public class Main {
    public static void main(String[] args) {
        // Pedindo um café simples
        Cafe cafe = new CafeSimples();
        System.out.println("Pedido: " + cafe.descricao());
        System.out.println("Preço: R$ " + cafe.preco());

        // Adicionando leite ao café
        cafe = new ComLeite(cafe);
        System.out.println("Pedido: " + cafe.descricao());
        System.out.println("Preço: R$ " + cafe.preco());

        // Adicionando creme ao café
        cafe = new ComCreme(cafe);
        System.out.println("Pedido: " + cafe.descricao());
        System.out.println("Preço: R$ " + cafe.preco());
    }
}
```
### 3. Observações:
* O padrão Decorator permite adicionar funcionalidades adicionais a objetos de forma flexível e dinâmica.
* Ele utiliza a composição para estender o comportamento de um objeto, ao invés de herança.
* É útil quando você precisa adicionar funcionalidades a um objeto de forma modular e sem alterar sua estrutura básica.
* Pode ser aplicado em várias situações, como na construção de interfaces gráficas, manipulação de streams de dados, ou na implementação de filtros em aplicativos.
