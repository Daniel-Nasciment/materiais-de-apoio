# Design Pattern Command e Command Handler em Java
### 1. Introdução:
O Design Pattern Command é um padrão de design comportamental que encapsula uma solicitação como um objeto, permitindo que você parametrize clientes com operações, filas de solicitações ou registre solicitações, e suporte operações desfazer. Por outro lado, o Command Handler é uma extensão do padrão Command que gerencia e executa os comandos. A principal diferença é que o Command Handler centraliza o processamento de comandos e pode oferecer funcionalidades adicionais, como rastreamento de comandos, manipulação de erros, etc.

### 2. Exemplo de Código:
Implementação do Command:
``` java
// Interface Command
interface Command {
    void execute();
}

// Implementações concretas de Command
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
```
### Implementação do Command Handler:
``` java
// Interface Command Handler
interface CommandHandler {
    void addCommand(Command command);
    void executeCommands();
}

// Implementação concreta de Command Handler
class RemoteControl implements CommandHandler {
    private List<Command> commands = new ArrayList<>();

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
```
### Exemplo de Uso:
``` java
// Criando objetos de comandos
Light light = new Light();
Command lightOn = new LightOnCommand(light);
Command lightOff = new LightOffCommand(light);

// Criando o Command Handler
CommandHandler remoteControl = new RemoteControl();

// Adicionando comandos ao handler
remoteControl.addCommand(lightOn);
remoteControl.addCommand(lightOff);

// Executando os comandos
remoteControl.executeCommands();
```
### 3. Por que essa variação?
A variante com Command Handler adiciona uma camada de abstração entre os comandos e quem os executa. Isso permite a centralização da lógica de execução de comandos, facilitando a gestão e a execução de vários comandos. Além disso, fornece um ponto único de extensão para adicionar novos tipos de comandos ou funcionalidades adicionais, como desfazer, repetir, rastreamento de comandos, etc. Esta abordagem é especialmente útil em sistemas mais complexos, onde a gestão de comandos se torna mais elaborada.
