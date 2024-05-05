## Design Pattern Strategy em Java

### 1. Introdução:
O Design Pattern Strategy é um padrão de design comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Isso permite que o cliente escolha o algoritmo a ser utilizado dinamicamente. O padrão Strategy promove o princípio do open/closed (aberto/fechado), onde as classes são abertas para extensão, mas fechadas para modificação.

### 2. Exemplo de Código:

```java
// Interface Strategy
interface PaymentStrategy {
    void pay(double amount);
}

// Implementações concretas de Strategy
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using Credit Card.");
        // Lógica para processar o pagamento com cartão de crédito
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal.");
        // Lógica para processar o pagamento com PayPal
    }
}

// Contexto que utiliza a Strategy
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Exemplo de Uso
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Define a estratégia de pagamento como Cartão de Crédito
        cart.setPaymentStrategy(new CreditCardPayment("1234 5678 9012 3456", "12/24", "123"));

        // Realiza o pagamento
        cart.checkout(100.0);

        // Define a estratégia de pagamento como PayPal
        cart.setPaymentStrategy(new PayPalPayment("example@example.com", "password123"));

        // Realiza o pagamento
        cart.checkout(50.0);
    }
}
```

### 3. Identificando Oportunidades de Uso:
Você pode considerar o uso do padrão Strategy quando:

* Há a necessidade de suportar diferentes variações de um algoritmo dentro de uma classe.
* Os algoritmos podem ser classificados em uma família e encapsulados.
* É necessário evitar uma explosão de subclasses para cada variação de algoritmo.
* Os clientes precisam ser independentes das implementações específicas dos algoritmos.
