
# 🧠 Histórico de Conversa (Memória) no LangChain

---

# 🚀 Objetivo

Permitir que a LLM lembre mensagens anteriores durante uma conversa.

Sem memória:

```text
Usuário: Qual melhor filme da Marvel?
IA: Homem de Ferro

Usuário: Quando foi feito?
IA: Quando o quê?
```

Com memória:

```text
Usuário: Qual melhor filme da Marvel?
IA: Homem de Ferro

Usuário: Quando foi feito?
IA: 2008
```

---

# 🧠 Conceito Principal

A LLM não possui memória automaticamente.

O LangChain precisa:
- armazenar mensagens
- reenviar o histórico
- associar isso a uma sessão

---

# 📦 Componentes utilizados

## Modelo

```python
from langchain_openai import ChatOpenAI
```

## Prompt de chat

```python
from langchain_core.prompts import ChatPromptTemplate
```

## Histórico em memória

```python
from langchain_core.chat_history import InMemoryChatMessageHistory
```

## Wrapper de memória

```python
from langchain_core.runnables.history import RunnableWithMessageHistory
```

---

# 🧠 Criando o Prompt com Histórico

```python
prompt_sugestao = ChatPromptTemplate.from_messages(
    [
        ("system", "Você é Jarvis"),

        ("placeholder", "{historico}"),

        ("human", "{query}")
    ]
)
```

---

# 🔥 Entendendo cada parte

| Tipo | Objetivo |
|---|---|
| system | Personalidade da IA |
| placeholder | Histórico da conversa |
| human | Pergunta atual |

---

# 🧠 Placeholder de histórico

```python
("placeholder", "{historico}")
```

Esse ponto é onde o LangChain injeta automaticamente:
- perguntas anteriores
- respostas anteriores

💡 Sem isso:
- a IA não lembra da conversa

---

# 🔗 Criando a chain

```python
cadeia = (
    prompt_sugestao
    | modelo
    | StrOutputParser()
)
```

---

# 🧠 Criando armazenamento de memória

```python
memoria = {}
```

Cada sessão terá seu próprio histórico.

---

# 🧠 Conceito de sessão

```python
sessao = "minha_session"
```

💡 Pense como:
- sessão web
- usuário logado
- conversa isolada

---

# ⚙️ Função responsável pela memória

```python
def historico_por_sessao(sessao: str):

    if sessao not in memoria:
        memoria[sessao] = InMemoryChatMessageHistory()

    return memoria[sessao]
```

---

# 🧠 O que essa função faz?

## Primeira vez

Se a sessão não existir:
- cria histórico vazio

```python
InMemoryChatMessageHistory()
```

## Próximas chamadas

Se já existir:
- reutiliza histórico anterior

---

# 💡 Mentalidade importante

Isso funciona parecido com:

```text
Map<String, ChatHistory>
```

No Java seria algo próximo de:

```java
Map<String, List<Message>>
```

---

# 🚀 Adicionando memória na chain

```python
cadeia_com_memoria = RunnableWithMessageHistory(
    cadeia,
    historico_por_sessao,
    input_messages_key="query",
    history_messages_key="historico"
)
```

---

# 🔥 Entendendo os parâmetros

| Parâmetro | Objetivo |
|---|---|
| cadeia | Chain original |
| historico_por_sessao | Busca memória |
| input_messages_key | Pergunta atual |
| history_messages_key | Placeholder do histórico |

---

# 🧠 Ligação importante

Esses dois precisam coincidir:

## Prompt

```python
("placeholder", "{historico}")
```

## RunnableWithMessageHistory

```python
history_messages_key="historico"
```

💡 O nome precisa ser igual.

---

# 🔥 Executando perguntas

```python
lista_perguntas = [
    "Qual melhor filme da marvel?",
    "Quando foi feito?"
]
```

---

# 🚀 invoke com sessão

```python
resposta = cadeia_com_memoria.invoke(
    {
        "query": pergunta
    },

    config={
        "session_id": sessao
    }
)
```

---

# 🧠 O que acontece internamente?

## Primeira pergunta

```text
Usuário: Qual melhor filme da marvel?
```

Histórico:
```text
vazio
```

---

## Segunda pergunta

```text
Usuário: Quando foi feito?
```

Histórico enviado automaticamente:

```text
Usuário: Qual melhor filme da marvel?
IA: Homem de Ferro
```

💡 Agora a IA entende o contexto.

---

# 🔄 Fluxo completo

```text
Usuário envia pergunta
        ↓
LangChain busca sessão
        ↓
Recupera histórico
        ↓
Adiciona no prompt
        ↓
LLM responde
        ↓
Nova resposta salva
```

---

# 📌 Resumo Final

| Conceito | Objetivo |
|---|---|
| ChatPromptTemplate | Prompt conversacional |
| placeholder | Local do histórico |
| InMemoryChatMessageHistory | Armazena conversa |
| RunnableWithMessageHistory | Injeta memória |
| session_id | Identifica conversa |
| invoke() | Executa interação |

---

# 🧠 Mentalidade Final

A memória no LangChain não é mágica.

Ela funciona porque:
- o histórico é salvo
- o histórico é reenviado
- o modelo recebe contexto anterior

💡 A LLM apenas lê novamente a conversa anterior.
