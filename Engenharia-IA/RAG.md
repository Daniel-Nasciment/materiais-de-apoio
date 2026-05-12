# 📚 RAG com LangChain

---

# 🚀 O que é RAG?

RAG significa:

```text
Retrieval Augmented Generation
```

Ou seja:

```text
Buscar informações + usar IA para responder
```

Fluxo mental:

```text
Pergunta
   ↓
Busca contexto relevante
   ↓
Envia contexto para LLM
   ↓
LLM responde
```

---

# 🤖 Modelo principal

```python
modelo = ChatOpenAI(
    model="google/gemma-3-4b",
    base_url="http://localhost:1234/v1",
    api_key="lm-studio"
)
```

Responsável por:
- conectar no LM Studio
- utilizar modelo local
- gerar respostas

---

# 📦 Libs utilizadas

```python
from langchain_openai import OpenAIEmbeddings
from langchain_community.document_loaders import TextLoader
from langchain_community.vectorstores import FAISS
from langchain_text_splitters import RecursiveCharacterTextSplitter
```

| Lib | Objetivo |
|---|---|
| OpenAIEmbeddings | Transformar texto em vetores |
| TextLoader | Ler arquivos |
| FAISS | Banco vetorial |
| RecursiveCharacterTextSplitter | Quebrar textos |

---

# ⚙️ Instalações necessárias

```bash
pip install langchain
pip install langchain-openai
pip install langchain-community
pip install faiss-cpu
```

---

# 🧠 Embeddings

Embeddings transformam texto em números.

Exemplo mental:

```text
"carro" → [0.12, 0.98, 0.55]
```

Isso permite:
- comparar significado
- buscar similaridade
- encontrar contexto relevante

---

# ⚙️ OpenAIEmbeddings

```python
embeddings = OpenAIEmbeddings(
    model="text-embedding-nomic-embed-text-v1.5@q6_k",
    base_url="http://localhost:1234/v1",
    api_key="lm-studio",
    check_embedding_ctx_length=False,
    chunk_size=1
)
```

## 📌 Parâmetros

| Parâmetro | Objetivo |
|---|---|
| model | Modelo de embedding |
| base_url | Endpoint do LM Studio |
| api_key | Compatibilidade OpenAI |
| check_embedding_ctx_length | Ignora validação de contexto |
| chunk_size | Quantidade enviada por vez |

---

# 📄 TextLoader

```python
document = TextLoader(
    "contato.txt",
    encoding="utf-8"
)
```

Responsável por:
- ler arquivos
- transformar em `Document`

---

# ✂️ RecursiveCharacterTextSplitter

LLMs possuem limite de contexto.

Por isso textos grandes precisam ser quebrados.

```python
pedacos = RecursiveCharacterTextSplitter(
    chunk_size=1000,
    chunk_overlap=100
).split_documents(document.load())
```

---

# 📌 chunk_size

```python
chunk_size = 1000
```

Define:
- tamanho máximo de cada trecho

---

# 📌 chunk_overlap

```python
chunk_overlap = 100
```

Cria repetição entre chunks para evitar perda de contexto.

Exemplo:

```text
Chunk 1:
"O número da seguradora é 4002"

Chunk 2:
"seguradora é 4002-8922"
```

💡 Sem overlap:
- frases poderiam ser cortadas
- contexto poderia se perder

---

# 🧠 FAISS

FAISS é um banco vetorial.

⚠️ Não busca igualdade.

Busca:

```text
similaridade semântica
```

---

# 📌 Similaridade semântica

Busca baseada em significado, não em texto idêntico.

Exemplo:

```text
"telefone da seguradora"
```

pode encontrar:

```text
"número para contato da empresa"
```

Mesmo sem usar as mesmas palavras.

---

# ⚙️ Criando banco vetorial

```python
dados_recuperados = FAISS.from_documents(
    pedacos,
    embeddings
).as_retriever(search_kwargs={"k":2})
```

Fluxo interno:

```text
Texto
 ↓
Embedding
 ↓
Vetores
 ↓
FAISS
```

---

# 🔍 as_retriever()

Transforma o FAISS em mecanismo de busca.

```python
search_kwargs={"k":2}
```

Significa:
- retornar os 2 trechos mais relevantes

---

# 🧠 Prompt do RAG

```python
prompt = ChatPromptTemplate.from_messages(
    [
        ("system",
         "Responda usando exclusivamente o conteúdo fornecido"),

        ("human",
         "{query}\\n\\nContexto:{contexto}\\n\\nResposta:")
    ]
)
```

💡 A IA recebe:
- pergunta
- contexto encontrado

---

# 🔗 Chain final

```python
cadeia = prompt | modelo | StrOutputParser()
```

Fluxo:

```text
Prompt + contexto
        ↓
LLM
        ↓
Texto puro
```

---

# 🚀 Método principal do RAG

```python
def responder(pergunta:str):
```

Esse método:
- busca contexto
- monta prompt
- chama LLM

---

# 🔍 Busca semântica

```python
trechos = dados_recuperados.invoke(pergunta)
```

O FAISS:
1. transforma pergunta em embedding
2. compara significado com vetores salvos
3. retorna textos semanticamente parecidos

---

# 💡 Exemplo mental

Pergunta:

```text
"Qual o telefone da seguradora?"
```

Texto salvo:

```text
"Para atendimento entre em contato no número 4002-8922"
```

Mesmo sem a palavra:
- "telefone"

O FAISS entende que:
- "telefone"
- "número para contato"

possuem significado parecido.

---

# 📄 Construindo contexto

```python
contexto = "\\n\\n".join(
    um_trecho.page_content
    for um_trecho in trechos
)
```

Junta:
- todos os trechos encontrados
- em uma única string

---

# 🤖 Executando cadeia

```python
return cadeia.invoke({
    "query": pergunta,
    "contexto": contexto
})
```

Agora a LLM recebe:

```text
Pergunta + contexto relevante
```

---

# 🔄 Fluxo completo

```text
Usuário faz pergunta
        ↓
Pergunta vira embedding
        ↓
FAISS busca similaridade
        ↓
Recupera trechos
        ↓
Monta contexto
        ↓
LLM responde
```

---

# 📌 Resumo Final

| Conceito | Objetivo |
|---|---|
| Embeddings | Transformar texto em vetores |
| TextLoader | Ler arquivos |
| TextSplitter | Quebrar textos |
| FAISS | Banco vetorial |
| Retriever | Buscar contexto |
| RAG | Buscar + responder |

---

# 🧠 Mentalidade Final

O RAG NÃO treina a IA.

Ele:
- busca contexto relevante
- injeta informações
- melhora resposta da LLM

💡 A inteligência continua no modelo.

O diferencial:
- é o contexto enviado.
