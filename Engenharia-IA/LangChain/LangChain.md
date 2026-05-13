
# 📚 LangChain — Guia de Estudos (Python para IA)

---

# 🚀 O que é o LangChain?

O LangChain é um framework usado para construir aplicações com IA generativa.

Ele ajuda a:

- 🔗 Orquestrar LLMs
- ⚙️ Criar pipelines de execução
- 🧠 Trabalhar com prompts
- 🧩 Estruturar outputs
- 🔄 Encadear fluxos complexos

💡 Mentalidade:
> Pense como um “pipeline builder” para aplicações de IA.

---

# 🔗 Chains (Cadeias)

As chains representam o fluxo da aplicação.

Fluxo básico:

```text
Input → Prompt → LLM → Parser → Resultado
```

Exemplo mental:

```text
Pergunta do usuário
        ↓
Construção do prompt
        ↓
Modelo gera resposta
        ↓
Parser transforma output
        ↓
Resultado final
```

---

# ⚙️ LCEL (LangChain Expression Language)

O LCEL é a forma moderna de montar chains.

Ele usa o operador `|` para conectar etapas:

```python
chain = prompt | modelo | parser
```

💡 Pense como:
- Java Streams
- Pipeline funcional
- Encadeamento de responsabilidades

Cada etapa recebe algo e transforma.

---

# 🤖 Criando um modelo (LLM)

## ChatOpenAI

Mesmo usando LM Studio localmente, o LangChain utiliza o cliente compatível da OpenAI.

```python
from langchain_openai import ChatOpenAI

modelo = ChatOpenAI(
    model="google/gemma-3-4b",
    base_url="http://localhost:1234/v1",
    api_key="lm-studio"
)
```

## 🧠 O que cada parâmetro faz?

| Parâmetro | Função |
|---|---|
| model | Modelo carregado |
| base_url | Endpoint do LM Studio |
| api_key | Obrigatório pela interface OpenAI |

---

# 📝 Trabalhando com PromptTemplate

O PromptTemplate permite criar prompts dinâmicos.

```python
from langchain_core.prompts import PromptTemplate

prompt = PromptTemplate(
    template="""
    Sugira um filme baseado em {filme}
    """,
    input_variables=["filme"]
)
```

---

# 🧩 StrOutputParser

O StrOutputParser transforma o output em texto puro.

Sem parser:
- retorna objeto complexo

Com parser:
- retorna apenas string

```python
from langchain_core.output_parsers import StrOutputParser

chain = prompt | modelo | StrOutputParser()
```

---

# 🔥 Executando uma chain

## invoke()

O invoke() executa a cadeia.

```python
resposta = chain.invoke({
    "filme": "Homem de ferro 1"
})
```

---

# 🧠 Trabalhando com JSON estruturado

Quando queremos respostas previsíveis, usamos parsers estruturados.

---

# 📦 JsonOutputParser

O JsonOutputParser força o LLM a devolver JSON válido.

```python
from langchain_core.output_parsers import JsonOutputParser
```

---

# 🏗️ Definindo estrutura com Pydantic

Usamos BaseModel para definir o formato esperado.

```python
from pydantic import BaseModel, Field

class Filme(BaseModel):
    filme_recomendado: str = Field(
        description="Nome do filme"
    )

    motivo_recomendacao: str = Field(
        description="Motivo da recomendação"
    )
```

💡 Mentalidade:
> Isso funciona quase como um DTO do Java.

---

# ⚙️ Criando o parser JSON

```python
parseador = JsonOutputParser(
    pydantic_object=Filme
)
```

---

# 🧠 Ensinando o modelo a responder corretamente

O parser consegue gerar instruções automáticas.

```python
prompt = PromptTemplate(
    template="""
    Sugira um filme baseado em {filme_assistido}

    {formato_saida}
    """,

    input_variables=["filme_assistido"],

    partial_variables={
        "formato_saida":
            parseador.get_format_instructions()
    }
)
```

## 🧠 O que é partial_variables?

São variáveis fixas do prompt.

Muito útil para:
- instruções
- contexto
- regras de output

---

# 🔥 Chain com JSON estruturado

```python
chain = prompt | modelo | parseador
```

Resultado:

```python
{
    "filme_recomendado": "...",
    "motivo_recomendacao": "..."
}
```

---

# 🐛 Depuração (Debug)

O LangChain permite visualizar o fluxo interno.

```python
from langchain_core.globals import set_debug

set_debug(True)
```

Isso mostra:
- prompts enviados
- execução das chains
- respostas do modelo
- transformação dos parsers

💡 Excelente para aprendizado.

---

# 🔄 Sequência de Chains

Uma chain pode alimentar outra.

Fluxo:

```text
Filme → Série relacionada
```

---

# 🧠 Primeira estrutura (Filme)

```python
class Filme(BaseModel):
    filme_recomendado: str
    motivo_recomendacao: str
```

---

# 📺 Segunda estrutura (Série)

```python
class Serie(BaseModel):
    nome_serie: str
    sinopse_serie: str
    quantidade_temporadas: str
```

---

# ⚙️ Criando os parsers

```python
parseador_filme = JsonOutputParser(
    pydantic_object=Filme
)

parseador_serie = JsonOutputParser(
    pydantic_object=Serie
)
```

---

# 📝 Criando prompts independentes

## Prompt do filme

```python
prompt_filme = PromptTemplate(
    template="""
    Sugira um filme baseado em
    {filme_assistido}

    {formato_saida}
    """,

    input_variables=["filme_assistido"],

    partial_variables={
        "formato_saida":
            parseador_filme.get_format_instructions()
    }
)
```

---

## Prompt da série

```python
prompt_serie = PromptTemplate(
    template="""
    Sugira uma série baseada
    no filme {filme_recomendado}

    {formato_saida}
    """,

    partial_variables={
        "formato_saida":
            parseador_serie.get_format_instructions()
    }
)
```

---

# 🔗 Criando chains independentes

```python
primeira_chain = (
    prompt_filme
    | modelo
    | parseador_filme
)

segunda_chain = (
    prompt_serie
    | modelo
    | parseador_serie
)
```

---

# 🚀 Encadeando múltiplas chains

```python
chain_principal = (
    primeira_chain
    | segunda_chain
)
```

💡 O output da primeira vira input da segunda.

---

# 🔥 Executando tudo

```python
resposta = chain_principal.invoke({
    "filme_assistido": "Homem de ferro 1"
})

print(resposta)
```

---

# 🧠 Resumo Geral

| Conceito | Objetivo |
|---|---|
| Chain | Pipeline |
| LCEL | Sintaxe moderna |
| PromptTemplate | Prompt dinâmico |
| ChatOpenAI | Comunicação com LLM |
| StrOutputParser | Texto puro |
| JsonOutputParser | JSON estruturado |
| Pydantic | Estrutura do output |
| invoke() | Executa chain |
| partial_variables | Variáveis fixas |
| set_debug() | Depuração |

---

# 🧠 Mentalidade Importante

Python + LangChain ≠ Java tradicional

Aqui:
- composição > herança pesada
- fluxo > arquitetura rígida
- pipelines > camadas excessivas

---

# 🚀 Próximos Passos Naturais

Depois disso, normalmente vem:

- 🧠 Memory
- 🛠️ Tools
- 🤖 Agents
- 📚 RAG
- 🔎 Embeddings
- 🗂️ Vector Databases

---

# 📈 Conclusão

Você já estudou:
- criação de prompts
- chains
- LCEL
- parsers
- JSON estruturado
- encadeamento de chains
- depuração

Isso já é a base real de aplicações modernas com LangChain 🚀
