# Design Pattern Observer em Java

### 1. Introdução:
O Design Pattern Observer é um padrão de design comportamental que define uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente. Isso é útil quando você precisa manter a consistência entre objetos relacionados, garantindo que mudanças em um objeto sejam refletidas em outros objetos dependentes.

### 2. Exemplo de Código:
Implementação do Observer:

```java 
import java.util.ArrayList;
import java.util.List;

// Interface Observador
interface Observador {
    void atualizar(String mensagem);
}

// Implementação concreta de Observador
class Usuario implements Observador {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu a mensagem: " + mensagem);
    }
}

// Interface Sujeito
interface Sujeito {
    void anexar(Observador observador);
    void desanexar(Observador observador);
    void notificarObservadores(String mensagem);
}

// Implementação concreta de Sujeito (Canal de Comunicação)
class CanalComunicacao implements Sujeito {
    private List<Observador> observadores = new ArrayList<>();

    @Override
    public void anexar(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void desanexar(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String mensagem) {
        for (Observador observador : observadores) {
            observador.atualizar(mensagem);
        }
    }

    // Método para postar uma nova mensagem no canal
    public void postarMensagem(String mensagem) {
        System.out.println("Nova mensagem postada: " + mensagem);
        notificarObservadores(mensagem);
    }
}

// Exemplo de Uso
public class Principal {
    public static void main(String[] args) {
        // Criando observadores (usuários)
        Observador usuario1 = new Usuario("Alice");
        Observador usuario2 = new Usuario("Bob");

        // Criando o canal de comunicação (Sujeito)
        CanalComunicacao canal = new CanalComunicacao();

        // Inscrevendo observadores para receber notificações do canal
        canal.anexar(usuario1);
        canal.anexar(usuario2);

        // Postando uma nova mensagem no canal
        canal.postarMensagem("Olá, pessoal!");

        // Removendo um observador (usuário)
        canal.desanexar(usuario2);

        // Postando outra mensagem no canal
        canal.postarMensagem("Até logo!");
    }
}


```
### 3. Observações:
* O padrão Observer é útil quando você tem objetos que precisam ser atualizados automaticamente quando o estado de outro objeto muda.
* Ele promove a desacoplação entre os objetos observadores e o sujeito observado, permitindo fácil adição e remoção de observadores.
* É amplamente utilizado em implementações de UI, sistemas de eventos e distribuição de mensagens.
