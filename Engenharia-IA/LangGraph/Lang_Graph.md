# 📚 LangGraph + Fluxos Assíncronos em Python

---

# 🚀 O que este código faz?

O código cria um fluxo inteligente usando LangGraph.

Esse fluxo:

1. recebe uma pergunta
2. identifica qual armadura deve responder
3. direciona a execução
4. executa a IA correta
5. retorna a resposta final

---

# 🧠 O que é um grafo?

Um grafo é uma estrutura baseada em fluxo.

Pense como:

```text
Entrada
   ↓
Decisão
 ↙     ↘
Fluxo A  Fluxo B
```

---

# 💡 Mentalidade simples

Imagine um sistema de atendimento:

```text
Cliente fala
      ↓
Sistema entende intenção
      ↓
Encaminha setor correto
```

O LangGraph faz exatamente isso.

---

# 📦 Componentes principais

| Conceito | Objetivo |
|---|---|
| Node | Etapa do fluxo |
| Edge | Ligação entre etapas |
| State | Dados compartilhados |
| Router | Decide caminho |
| START | Início do fluxo |
| END | Final do fluxo |

---

# 🤖 Criando o modelo

```python
modelo = ChatOpenAI(
    model="google/gemma-3-4b",
    base_url="http://localhost:1234/v1",
    api_key="lm-studio"
)
```

Aqui estamos:
- conectando no LM Studio
- usando um modelo local
- preparando o LLM

---

# 🧠 Criando especialistas

## Jarvis

```python
prompt_jarvis
```

Responsável:
- mark_40
- armadura sem escudo

---

## Sexta Feira

```python
prompt_sexta_feira
```

Responsável:
- mark_42
- armadura com escudo

---

# 🔗 Criando chains

```python
jarvis_chain = (
    prompt_jarvis
    | modelo
    | StrOutputParser()
)
```

```python
sexta_feira_chain = (
    prompt_sexta_feira
    | modelo
    | StrOutputParser()
)
```

Cada chain:
- recebe pergunta
- envia ao modelo
- retorna texto puro

---

# 🧠 TypedDict

```python
class Armadura(TypedDict):
    mark: Literal["mark_40", "mark_42"]
```

TypedDict define estrutura de dados.

💡 Pense como:
- DTO do Java
- contrato de dados

---

# 🔥 Literal

```python
Literal["mark_40", "mark_42"]
```

Limita os valores possíveis.

A IA só pode retornar:
- mark_40
- mark_42

---

# 🧠 Criando o roteador

```python
prompt_roteador = ChatPromptTemplate.from_messages(
    [
        ("system",
        "Responda apenas com: 'mark_40' ou 'mark_42'."),
        
        ("human", "{query}")
    ]
)
```

O roteador decide:
- qual fluxo executar

---

# ⚙️ with_structured_output

```python
modelo.with_structured_output(Armadura)
```

Força:
- resposta estruturada
- validação automática
- objeto tipado

---

# 🔗 Chain do roteador

```python
roteador_chain = (
    prompt_roteador
    | modelo.with_structured_output(Armadura)
)
```

Resultado esperado:

```python
{
    "mark": "mark_40"
}
```

---

# 🧠 State (Estado compartilhado)

```python
class Estado(TypedDict):
    query: str
    armadura: Armadura
    resposta: str
```

O State representa:
- os dados do fluxo
- informações compartilhadas entre nodes

---

# 💡 Mentalidade importante

Cada node:
- recebe estado atual
- modifica parte dele
- devolve novo estado

---

# ⚡ Funções assíncronas

## async

```python
async def no_roteador(...)
```

Define função assíncrona.

---

# 🧠 O que significa assíncrono?

Permite:
- esperar respostas
- sem travar aplicação

Muito usado em:
- APIs
- banco de dados
- chamadas HTTP
- LLMs

---

# ⚡ await

```python
await roteador_chain.ainvoke(...)
```

O await:
- aguarda resposta
- sem bloquear execução

---

# 🚀 ainvoke

```python
await chain.ainvoke(...)
```

Versão assíncrona do invoke().

---

# 🧠 Node roteador

```python
async def no_roteador(...)
```

Responsabilidade:
- analisar pergunta
- descobrir armadura correta

Retorno:

```python
{
    "armadura": ...
}
```

---

# 🤖 Node Jarvis

```python
async def no_jarvis(...)
```

Responsável:
- responder usando mark_40

---

# 🤖 Node Sexta Feira

```python
async def no_sexta_feira(...)
```

Responsável:
- responder usando mark_42

---

# 🔀 Escolhendo caminho

```python
def escolher_no(estado: Estado)
```

Decide:
- qual node executar

---

# 🔥 Regra do fluxo

```python
return "mark_40"
```

ou

```python
return "mark_42"
```

---

# 🧠 Criando o grafo

```python
grafo = StateGraph(Estado)
```

Inicia construção do fluxo.

---

# ⚙️ Adicionando nodes

```python
grafo.add_node("roteador", no_roteador)
```

```python
grafo.add_node("mark_40", no_jarvis)
```

```python
grafo.add_node("mark_42", no_sexta_feira)
```

---

# 🔗 Criando conexões

## Fluxo inicial

```python
grafo.add_edge(START, "roteador")
```

Fluxo:

```text
START → roteador
```

---

# 🔀 Fluxo condicional

```python
grafo.add_conditional_edges(
    "roteador",
    escolher_no
)
```

Agora o roteador:
- decide caminho dinamicamente

---

# 🏁 Finalizando fluxo

```python
grafo.add_edge("mark_40", END)
```

```python
grafo.add_edge("mark_42", END)
```

---

# 🧠 Fluxo completo

```text
Usuário
   ↓
Roteador
 ↙      ↘
Jarvis  Sexta Feira
   ↓        ↓
  END      END
```

---

# 🚀 Compilando o grafo

```python
app = grafo.compile()
```

Transforma:
- definição do fluxo
- em aplicação executável

---

# ⚡ Função principal assíncrona

```python
async def main():
```

Função principal da aplicação.

---

# 🚀 Executando fluxo

```python
resposta = await app.ainvoke({
    "query": "Quero uma armadura sem escudo."
})
```

Fluxo interno:

```text
Pergunta
   ↓
Roteador identifica mark_40
   ↓
Jarvis executa
   ↓
Resposta final
```

---

# ⚡ asyncio.run

```python
asyncio.run(main())
```

Responsável por:
- iniciar execução assíncrona
- executar funções async

---

# 📌 Resumo Final

| Conceito | Objetivo |
|---|---|
| LangGraph | Criar fluxos inteligentes |
| Node | Etapa do fluxo |
| Edge | Ligação |
| Router | Decide caminho |
| State | Dados compartilhados |
| async | Função assíncrona |
| await | Espera sem bloquear |
| ainvoke | Execução assíncrona |
| START | Início |
| END | Final |

---

# 🧠 Mentalidade Final

O LangGraph permite criar:
- fluxos inteligentes
- múltiplos caminhos
- decisões dinâmicas
- pipelines baseados em contexto

Neste código:
- o roteador decide
- o fluxo muda dinamicamente
- cada node possui responsabilidade específica

💡 Isso transforma chains simples em aplicações inteligentes com múltiplos comportamentos.
