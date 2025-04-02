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
