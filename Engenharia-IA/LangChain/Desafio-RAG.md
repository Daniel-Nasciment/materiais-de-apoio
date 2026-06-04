# 📚 RAG com LangChain — Anotações de Estudo

## 🎯 Objetivo deste código

O objetivo deste código é permitir que uma LLM responda perguntas sobre um documento PDF.

Exemplo:

```text
PDF: agendamento.pdf

Pergunta:
"Para quando é o agendamento? E qual o nome do solicitante?"
```

A IA irá:

1. Ler o PDF
2. Encontrar os trechos mais relevantes
3. Enviar esses trechos para a LLM
4. Gerar a resposta

---

# 🧠 O que é RAG?

RAG significa:

```text
Retrieval Augmented Generation
```

Traduzindo:

```text
Recuperar informações + Gerar resposta
```

Fluxo:

```text
Pergunta
    ↓
Busca informações relevantes
    ↓
Monta contexto
    ↓
LLM responde
```

---

# 💡 Mentalidade para quem vem do Java

Sem RAG:

```java
String resposta = llm.perguntar(pergunta);
```

A LLM responde apenas com o conhecimento dela.

---

Com RAG:

```java
String contexto = buscarDocumentos(pergunta);

String resposta =
    llm.perguntar(pergunta, contexto);
```

A LLM responde usando os documentos.

---

# 🤖 Criando o modelo

```python
modelo = ChatOpenAI(
    model="google/gemma-3-4b",
    base_url="http://localhost:1234/v1",
    api_key="lm-studio"
)
```

Responsável por conectar o LangChain ao LM Studio.

Mentalidade Java:

```text
É equivalente a criar um Client ou Service
para consumir uma API externa.
```

---

# 🧠 O que são Embeddings?

Embeddings são representações numéricas de texto.

Exemplo:

```text
"telefone"

↓

[0.34, 0.12, 0.98, ...]
```

O computador não entende significado.

Ele entende números.

Por isso textos precisam ser convertidos em vetores.

---

# ⚙️ OpenAIEmbeddings

```python
embeddings = OpenAIEmbeddings(...)
```

Responsável por:

```text
Texto
 ↓
Vetor numérico
```

Sem embeddings:

```text
Não existe busca semântica.
```

---

# 📄 Carregando o PDF

```python
doc = PyPDFLoader(
    "agendamento.pdf"
).load()
```

Responsável por:

```text
PDF
 ↓
Document
```

O LangChain trabalha internamente com objetos `Document`.

---

# ✂️ Quebrando o PDF em chunks

```python
chunks = RecursiveCharacterTextSplitter(
    chunk_size=1000,
    chunk_overlap=200
).split_documents(doc)
```

---

## 📌 Por que quebrar?

LLMs possuem limite de contexto.

Então:

```text
PDF muito grande
↓
Quebra em pedaços menores
```

---

## 📌 chunk_size

```python
chunk_size = 1000
```

Define o tamanho máximo de cada chunk.

---

## 📌 chunk_overlap

```python
chunk_overlap = 200
```

Cria uma pequena repetição entre chunks.

Exemplo:

```text
Chunk 1:
"O solicitante é João da Silva"

Chunk 2:
"João da Silva comparecerá..."
```

Objetivo:

```text
Evitar perda de contexto.
```

---

# 🧠 O que é FAISS?

FAISS é um banco vetorial.

Instalação:

```bash
pip install faiss-cpu
```

---

Enquanto um banco SQL busca:

```text
Igualdade
```

O FAISS busca:

```text
Similaridade
```

---

# 📌 Similaridade Semântica

Busca por significado.

Não por palavras exatas.

Exemplo:

Pergunta:

```text
Qual o telefone do solicitante?
```

Documento:

```text
Número para contato: 99999-9999
```

Mesmo sem a palavra:

```text
telefone
```

o FAISS consegue encontrar.

---

# ⚙️ Criando a base vetorial

```python
db = FAISS.from_documents(
    chunks,
    embeddings
).as_retriever(
    search_kwargs={"k": 3}
)
```

Fluxo:

```text
Chunks
 ↓
Embeddings
 ↓
Vetores
 ↓
FAISS
```

---

# 📌 O que significa k?

```python
k = 3
```

Significa:

```text
Retorne os 3 chunks mais relevantes.
```

---

# 🧠 Criando o Prompt

```python
prompt = ChatPromptTemplate.from_messages([
    (
        "system",
        "Você é um assistente de agendamento de solicitação de passaporte."
    ),
    (
        "human",
        "{input} \\n\\n Contexto: {contexto}"
    )
])
```

---

## 📌 System

Define o comportamento da IA.

Equivalente a:

```text
Configuração global do assistente.
```

---

## 📌 Human

Recebe:

```python
{input}
```

Pergunta do usuário.

e

```python
{contexto}
```

Trechos encontrados pelo FAISS.

---

# 🔗 Criando a Chain

```python
chain = (
    prompt
    | modelo
    | StrOutputParser()
)
```

Fluxo:

```text
Prompt
 ↓
LLM
 ↓
Texto puro
```

---

# 🚀 Método responder()

```python
def responder(pergunta: str):
```

Esse método é o coração do RAG.

---

## Passo 1

```python
chunks = db.invoke(pergunta)
```

O que acontece?

```text
Pergunta
 ↓
Embedding
 ↓
Busca no FAISS
 ↓
Chunks relevantes
```

---

## Exemplo

Pergunta:

```text
Qual o nome do solicitante?
```

O FAISS procura:

```text
Trechos que falam sobre solicitante.
```

---

## Passo 2

```python
contexto = "\n".join(
    [chunk.page_content for chunk in chunks]
)
```

Junta todos os chunks encontrados.

Resultado:

```text
Chunk A

Chunk B

Chunk C
```

---

## Passo 3

```python
return chain.invoke({
    "input": pergunta,
    "contexto": contexto
})
```

Agora a LLM recebe:

```text
Pergunta
+
Contexto encontrado
```

E gera a resposta.

---

# 🔄 Fluxo completo do sistema

```text
PDF
 ↓
PyPDFLoader
 ↓
Document
 ↓
Chunks
 ↓
Embeddings
 ↓
FAISS
 ↓

Pergunta
 ↓
Embedding da pergunta
 ↓
Busca semântica
 ↓
Top 3 chunks
 ↓
Contexto
 ↓
Prompt
 ↓
LLM
 ↓
Resposta
```

---

# 📌 Resumo para lembrar rapidamente

| Conceito                       | Função                         |
| ------------------------------ | ------------------------------ |
| PyPDFLoader                    | Ler PDF                        |
| Document                       | Estrutura usada pelo LangChain |
| RecursiveCharacterTextSplitter | Quebrar documento              |
| chunk_size                     | Tamanho do chunk               |
| chunk_overlap                  | Sobreposição entre chunks      |
| OpenAIEmbeddings               | Converter texto em vetores     |
| FAISS                          | Banco vetorial                 |
| Similaridade Semântica         | Busca por significado          |
| Retriever                      | Recuperar contexto             |
| Prompt                         | Instruções para a LLM          |
| Chain                          | Pipeline de execução           |
| RAG                            | Buscar contexto + responder    |

---

# 🧠 Mentalidade Final

O RAG não ensina nem treina a LLM.

Ele apenas:

```text
Busca informações
+
Monta contexto
+
Envia para a LLM
```

A qualidade do RAG normalmente depende mais de:

```text
Recuperação dos documentos (Retrieval)
```

do que da própria geração da resposta.
