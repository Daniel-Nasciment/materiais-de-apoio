# 🚀 Escalabilidade de Sistemas Distribuídos  

## 🏗 3 Pilares da Escalabilidade  
### 🗂 Caching  
✔ Reduz a sobrecarga em serviços críticos.  
✔ Melhora o tempo de resposta armazenando dados frequentemente acessados.  
✔ Diminui a latência posicionando os dados próximos ao usuário.  

### 🔄 Processamento Assíncrono  
✔ Posterga tarefas não essenciais para execução posterior.  
✔ Libera recursos para operações imediatas, melhorando a capacidade do sistema.  

### ⚖ Balanceamento de Carga  
✔ Distribui requisições entre múltiplas instâncias, evitando gargalos.  
✔ Divide tarefas pesadas para otimizar recursos.  

⚠ **Sem boas práticas, os pilares não garantem escalabilidade!**  

---

## 📌 Construindo um Sistema Escalável  
🔹 A escalabilidade depende do contexto, requisitos e restrições do sistema.  

### 🔥 Desafios Críticos  
✅ **Latência**: Minimizar tempo de resposta de operações críticas.  
✅ **Throughput**: Aumentar requisições processadas por segundo.  
✅ **Sincronização Excessiva**: Reduzir dependência de processos síncronos para evitar bloqueios.  

---

## ❌ As 8 Falácias de Sistemas Distribuídos  
1. A rede é sempre confiável.  
2. A latência é zero.  
3. A largura de banda é infinita.  
4. A rede é segura.  
5. A topologia da rede nunca muda.  
6. Existe apenas um administrador.  
7. O transporte de dados é sempre confiável.  
8. A rede é homogênea.  

---

## ⚠ Modos de Falha em Sistemas Distribuídos  
Mesmo em sistemas simples, falhas são inevitáveis.  

🔹 **Chamadas Locais (Local Calls)**: Comunicação dentro da mesma aplicação.  
🔹 **Chamadas Remotas (Remote Calls)**: Comunicação via rede, sujeita a:  
✔ Perda de pacotes  
✔ Latência variável  
✔ Problemas de roteamento  

📌 **Falhas Sempre Ocorrem**:  
💀 Hardware falha (discos quebram, servidores caem).  
🐞 Software falha (bugs, deadlocks, vazamento de memória).  

🔹 **Bons arquitetos escolhem tecnologias conhecendo suas desvantagens.**  

---

## 🏗 Microsserviços: Mais que uma Solução Técnica  
✔ **Escalabilidade de times**  
✔ **Entrega contínua e independência de deploy**  
✔ **Melhor modularidade e manutenção**  

---

# 🌐 Arquitetura Web, Performance e Escalabilidade  

## 🚀 Fundamentos da Arquitetura Web  
1️⃣ Um servidor executa a aplicação.  
2️⃣ Um navegador faz requisições para o servidor web.  
3️⃣ O servidor processa a requisição, acessa o banco de dados e responde ao navegador.  

---

## 📌 Conceitos Essenciais  
| Conceito         | Definição |
|-----------------|-----------|
| **Performance** | Tempo de resposta (**latência**) |
| **Escalabilidade** | Quantidade de requisições processadas por segundo (**throughput**) |

✔ **Meta:** Aumentar throughput mantendo baixa latência.  

---

## 🔎 Como Melhorar o Throughput?  

### 📊 **Benchmarking e Teste de Carga**  
🔹 Descobrir limites do sistema.  
🔹 Identificar o **ponto de saturação** (onde throughput cai e latência aumenta).  

### ⚠ Otimizar para Latência vs. Throughput  

| Otimizar para Latência | Otimizar para Throughput |
|------------------------|-------------------------|
| Usar **menos recursos** | **Aumentar recursos** |
| Responder **mais rápido** | Processar **mais requisições** |
| **Liberar CPU** rapidamente | **Manter CPU ocupada** |

✔ **Sistemas distribuídos geralmente são limitados pela CPU**.  
✔ **Garbage Collector concorre com processamento da aplicação**.  
✔ **Otimizar para throughput** = Extrair máximo do poder computacional.  
✔ **Otimizar para latência** = Melhor gerenciar os recursos do servidor.  

---

## 🛠 Como Descobrir os Limites do Sistema?  

### 🔥 Ferramentas de Teste de Carga e Estresse  
✔ **Apache JMeter**  
✔ **Gatling**  
✔ **k6**  
✔ **Grafana**  
✔ **Prometheus**  


# 📊 Entendendo a Distribuição do Workload  

## 🚀 O Que Analisar?  
🔹 O workload é mais de **leitura** ou **escrita**?  
🔹 O gargalo está na **CPU** ou no **I/O** (banco de dados, disco, rede)?  
🔹 O tráfego ocorre mais de **dia** ou **noite**?  
🔹 As requisições são **em tempo real** ou **processadas em lote**?  

---

## 📌 **Não Confie Apenas na Média!**  
✔ A média pode esconder padrões críticos de carga.  
✔ O uso de **histogramas** ajuda a visualizar a distribuição real do throughput ao longo do dia.  

---

# 🔥 Medindo a Qualidade das Requisições  

## ⚡ **Latência Não É Fixa!**  
A latência pode variar por vários motivos:  
✔ **Garbage Collector**  
✔ **Problemas de indexação no banco**  
✔ **Interrupções no sistema**  
✔ **Limpeza de cache**  
✔ **Congestionamento de rede**  

---

## 🎯 Percentis > Média  
🔹 **Percentis são mais úteis do que a média** para detectar gargalos.  
🔹 Um **histograma de latência** permite visualizar o comportamento real do sistema.  
🔹 Se o foco for otimização, os percentis indicam **onde atacar os gargalos**.  

---

## ⚠ **Taxa de Erro (Error Rate)**  
🔹 **Apenas throughput e latência não bastam!**  
🔹 Um **alto throughput** pode estar mascarando falhas na aplicação.  
🔹 **Monitorar taxa de erro** evita interpretações erradas sobre a qualidade do sistema.  

# 🚀 De Máquina Local para um Sistema Distribuído  

## 🔥 5 Passos Essenciais  

### 1️⃣ **Otimizar a Aplicação**  
✔ **Ajustar a JVM**:  
- Configurar **tamanho ideal de memória** (RAM).  
- Definir **mínimo e máximo de memória iguais** para evitar realocação dinâmica.  
- Escolher um **Garbage Collector eficiente** para a aplicação.  
- Para **Java 17+ em containers**, configurar `MaxRAMPercentage=75%` para evitar desperdício de memória.  

---

### 2️⃣ **Melhorar a Máquina**  
✔ **Scale Up** (aumentar recursos de uma máquina).  
⚠ **Limitação**: Crescimento não linear entre custo e performance.  

---

### 3️⃣ **Adicionar Mais Máquinas (Scale Out)**  
✔ **Balanceador de carga (NGINX, HAProxy, etc.)**  
✔ **Escala horizontalmente** (mais barato que Scale Up).  
⚠ **Problema: Sticky Session**  
- O balanceador mantém afinidade entre usuário e uma máquina específica.  
- Se essa máquina falhar, o usuário perde sua sessão.  

---

### 4️⃣ **Replicar Estado**  
✔ **Session Replication**:  
- As sessões são replicadas entre as máquinas do cluster.  
✔ **Alta disponibilidade** → Scale Out + Session Replication.  
⚠ **Custo alto**:  
- **Mais consumo de rede, memória e CPU** conforme o cluster cresce.  

---

### 5️⃣ **Remover Estado (Stateless Architecture)**  
✔ **Armazenar estado fora das máquinas do cluster** → **Cache distribuído (Redis, Memcached)**.  
✔ **Cada requisição pode ser atendida por qualquer máquina**.  
✔ **Melhor escalabilidade** e **menos dependência de replicação de sessão**.  
✔ Pode ser necessário um **cluster de Redis** para evitar pontos únicos de falha.  

# 🚀 Como Rastrear e Tratar Falhas em Sistemas Escaláveis

## 🔥 Os 20% que Explicam 80% das Falhas

### 1️⃣ Logs Estruturados e Centralizados
- ✔ Use **JSON** para facilitar análise e busca.
- ✔ Envie logs para uma ferramenta centralizada (**ELK Stack, Grafana Loki, Datadog**).
- ✔ Registre logs com **correlação de IDs** para rastrear requisições distribuídas.

---

### 2️⃣ Monitoramento Contínuo
- ✔ Utilize métricas (**Prometheus, Grafana, New Relic, Datadog**).
- ✔ Acompanhe **CPU, memória, latência, throughput e taxa de erro**.
- ✔ Configure **alertas** para anomalias.

---

### 3️⃣ Tracing Distribuído (Observabilidade)
- ✔ Ferramentas como **Jaeger, Zipkin, OpenTelemetry** ajudam a entender fluxos de requisição.
- ✔ **Adicione IDs únicos em cada requisição** para rastrear onde ocorrem gargalos.

---

### 4️⃣ Retries e Circuit Breakers
- ✔ Use **retries** com **exponential backoff** para falhas temporárias.
- ✔ **Circuit Breaker** (**Resilience4j, Hystrix**) impede sobrecarga em serviços instáveis.

---

### 5️⃣ Fallbacks e Graceful Degradation
- ✔ Se um serviço falhar, forneça **dados cacheados** ou uma **resposta alternativa**.
- ✔ Em **falhas parciais**, degrade funcionalidades sem impactar toda a aplicação.

---

### 6️⃣ Testes de Resiliência
- ✔ Simule falhas com **Chaos Engineering** (**Chaos Monkey, Gremlin**).
- ✔ Realize **Testes de Carga** para encontrar pontos de saturação antes que ocorra um problema real.

---

📌 **Sistemas escaláveis não evitam falhas, mas as tratam da forma menos impactante possível!**

# Definição de Workload de uma Aplicação

Existem várias formas de definir o **workload** de uma aplicação. Duas principais categorias são:

## I/O Bound vs CPU Bound

### ⚡ I/O Bound
- **Definição:** Grande parte do tempo de execução é gasto esperando por operações de **I/O** (como comunicação em rede, acesso ao banco de dados, leitura de disco, interação com sistemas externos, etc).
- **Características:** 
  - Sistemas distribuídos geralmente se encaixam aqui.
  - A performance é frequentemente limitada pela **I/O**.
  - A tunagem de **I/O** pode melhorar significativamente a performance.

### 💻 CPU Bound
- **Definição:** A maior parte do tempo de execução é usada pela **CPU**, com pouco tempo gasto em I/O.
- **Características:**
  - A performance da aplicação é limitada pela capacidade de processamento da **CPU**.

---

# Gargalos de Performance na Camada de Persistência

A maioria dos gargalos de performance estão relacionados à camada de persistência. Por isso, investir tempo na otimização dessa camada é crucial.

## Transação com o Banco de Dados

### ⏳ 1. Tempo para Adquirir Conexão
- **Importante:** Não podemos permitir que a aplicação abra conexões de forma descontrolada.
- **Solução:** Configurar o pool de conexões (mínimo e máximo) para otimizar o uso de conexões.
  - **Benefício:** Evita abertura e fechamento desnecessário de conexões, o que acelera a comunicação.
  - **Dica:** Quando o banco responde mais rápido, o throughput aumenta. Portanto, um pool de conexões menor é muitas vezes mais eficiente.
  - **Observação:** Não há mágica aqui; é necessário mensurar e testar para definir o tamanho adequado do pool.

### 🔄 2. Tempo de Requisição com o Banco
- **Solução:** Habilitar **batch size** e realizar operações em lote.
  - **Benefício:** Menos round trips e menor tempo de resposta.

### 🛠️ 3. Tempo de Execução no Banco
- **Otimizações recomendadas:**
  - Otimizar **queries**.
  - Utilizar ferramentas como **EXPLAIN ANALYZE** e **buffer** para analisar a performance de consultas.
  - **Buscas indexadas** são essenciais para melhorar o tempo de execução.
  - **Dica:** Utilize o índice para acelerar as buscas.
  - **Use funções de janela** (**window functions**) para otimizar o processamento de dados no banco.
  - **Levar o processamento para perto dos dados** (como procedures) pode reduzir a latência, embora haja controvérsias sobre a centralização das regras de negócio.

### ⏱️ 4. Tempo de Resposta do Banco
- **Soluções recomendadas:**
  - Use **consultas planejadas** (projection) para limitar os dados retornados.
  - **Evite o problema de N+1 queries** (select N+1).
  - Configure o relacionamento **um para muitos** como **eager loading** (se a entidade filha for necessária e não impactar outros casos de uso).
  - Implemente **paginação** nas consultas para diminuir a quantidade de dados recuperados.

  **Benefício:** Menos dados retornados resultam em um tempo de resposta mais rápido.

### 💤 5. Tempo que a Transação Fica Ociosa
- **Dica:** O **transaction response time** (considerando as otimizações acima) deve ser o menor possível para aumentar o throughput.
- **Nota importante:** Criar novas conexões com o banco de dados é uma operação cara. Portanto, o pool de conexões deve ser otimizado para evitar criação excessiva de conexões.

---

# Resumo de Melhores Práticas para Otimização

- 📊 **Mensure e teste** as configurações de pool de conexões.
- 🛠️ **Prefira operações em lote** para reduzir o número de round trips.
- 🔍 **Otimize as queries** com ferramentas como **EXPLAIN ANALYZE** e **índices**.
- 🔄 **Utilize window functions** e mantenha o processamento próximo aos dados.
- 📝 **Use consultas planejadas**, **eager loading** e **paginação** para otimizar o tempo de resposta do banco.
- ⚡ **Reduza o transaction response time** para aumentar o throughput e minimizar a ociosidade das transações.


# Cache no Hibernate e Spring Boot

## 📌 First Level Cache (Cache de Primeiro Nível)
- Gerenciado pelo **EntityManager**.
- Armazena entidades dentro do **contexto da transação**.
- Se a mesma busca for feita várias vezes dentro da mesma transação, os dados são buscados do cache ao invés do banco.

## 📌 Second Level Cache (Cache de Segundo Nível)
- Gerenciado pelo **EntityManagerFactory**.
- Cache compartilhado entre diferentes transações.
- **Habilitação no Spring Boot**:
  1. Configurar o Hibernate no `application.properties`.
  2. Anotar as entidades com `@Cacheable` para habilitar o cache.
  3. Cachear relacionamentos se necessário.

**⚠️ Apenas isso não basta! Precisamos de um Fine Tuning.**

---

## 🎯 Estratégias de Cache no Hibernate
O Hibernate permite escolher a estratégia de cache conforme a necessidade:

| Estratégia | Uso recomendado |
|------------|----------------|
| `read-only` | Melhor para objetos imutáveis (mais rápido e eficiente). |
| `non-strict-read-write` | Para dados não críticos, onde a consistência pode ser menor. |
| `read-write` | Mantém consistência com locks, mas é mais lento. |

---

## 🔧 Configuração do Cache
Além de ativar e anotar as entidades, é necessário **configurar corretamente o provedor de cache**:

1. **Definir o provedor de cache**  
   - Exemplo: `EhcacheCachingProvider`.
   
2. **Configurar regiões de memória**  
   - Usando `JCacheRegionFactory`.

3. **Especificar o arquivo de configuração do EhCache**  
   - Definir políticas de cache no arquivo XML (`ehcache.xml`).

4. **Configuração por entidade**  
   - No arquivo `ehcache.xml`, configurar regras individuais para cada entidade cacheada.

---

## 🚀 Benefícios do Cache
Atacamos diretamente o **Response Time**, melhorando:
- **Tempo de Requisição**
- **Tempo de Execução**
- **Tempo de Resposta**

Isso resulta em uma grande melhoria na **latência** e no **throughput**.

---

## 🛠️ Cache no Spring Boot REST API
Também podemos usar cache em APIs REST, por exemplo, em **controllers**, com a anotação:

```java
@Cacheable("usuarios")
public Usuario getUsuario(Long id) {
    return usuarioRepository.findById(id).orElseThrow();
}
```

# 🚀 Processamento Assíncrono e Gerenciamento de Carga

## ⏳ Não processe hoje o que você pode processar amanhã
- Processamentos que envolvem escrita e operações pesadas são **custosos**.
- Se um processamento é custoso, ele pode se tornar um **gargalo** no sistema.
- A solução para isso é o **processamento assíncrono**.

---

## ⚙️ Uso do `@Async` no Spring
- O Spring oferece a anotação `@Async`, permitindo a execução assíncrona de métodos.
- Para cada requisição anotada com `@Async`, o Spring cria uma nova **thread** para processá-la.
- Devemos decidir se otimizamos o **pool de threads** para **latência** ou **throughput**, conforme a necessidade.

 ```java
@Async
public void processarPedido(Long pedidoId) {
    // Processamento assíncrono aqui
}
```

---

## 🧵 Thread Pool Executor
- O `ThreadPoolExecutor` gerencia chamadas assíncronas enfileirando processos e alocando-os em **threads específicas**.
- Durante **picos de carga**, um pool de threads pode não ser suficiente, causando:
  - **Excesso de processos pendentes**
  - **Falta de memória (`OutOfMemoryError`)**
  - **Reinicialização da aplicação**
  - **Perda de itens na fila do pool de threads**

---

## 🛠️ Solução: Uso de Filas e Brokers
- Para lidar com **picos de carga**, precisamos de **filas mais robustas e duráveis**.
- Aqui entram os **brokers**, que atuam como **gerenciadores de fila**.

### 📌 Substituindo `@Async` por consumidores de fila:
- Em vez de `@Async`, podemos utilizar **consumidores de fila**, como `@JmsListener` ou `@KafkaListener`.
- As **filas absorvem os picos de carga**.
- Os **consumers processam mensagens na taxa que conseguem suportar**.
- Esse mecanismo permite que o próprio **consumer



