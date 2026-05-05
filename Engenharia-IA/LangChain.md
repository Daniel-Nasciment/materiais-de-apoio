# 📚 Anotações LangChain (Guia Rápido e Prático)

## 🚀 O que é o LangChain?
O **LangChain** é um framework para construir aplicações com IA generativa.

👉 Ele permite:
- Orquestrar LLMs (modelos de linguagem)
- Criar fluxos (pipelines) de execução
- Usar o modelo certo para cada problema

💡 Pense como:
> Um “Spring Boot” + “pipeline builder” para IA

---

## 🔗 Conceito central: Cadeias (Chains)

As **chains** são pipelines de execução:

```
Pergunta → Prompt → LLM → Parser → Resultado
```

✔ Organiza o fluxo  
✔ Facilita manutenção  
✔ Permite compor soluções mais complexas  

---

## ⚙️ LCEL (LangChain Expression Language)

É a forma moderna de montar chains.

👉 Usa operador `|` (pipe), estilo funcional:

```python
chain = prompt | llm | parser
```

💡 Mentalidade:
- Parece stream do Java
- Cada etapa transforma o dado

---

## 🧩 Output Parser (StrOutputParser)

O `StrOutputParser` é o passo final da chain.

👉 Ele:
- Recebe a resposta do LLM
- Extrai só o texto puro

Sem ele:
- você recebe objeto com metadata

Com ele:
- você recebe `"string limpa"`

```python
chain = prompt | llm | StrOutputParser()
```

---

## 🧠 Exemplo 1: Prompt + LLM

```python
from langchain_openai import ChatOpenAI
from langchain_core.prompts import PromptTemplate

dias = 5
filhos = 2
atividade = "praia"

modeloPrompt = PromptTemplate(
    template = """
    Crie um roteiro de viagem, com 3 coisas para se fazer, 
    considerando que a viagem é de {numero_dias} dias, para uma familia com 
    {numero_filhos} filhos e que eles gostam de 
    atividades que envolvam {atividade_preferida}.
    Você deve ser sussinto, objetivo, e o output esperado é conforme o seguinte exemplo: 
    Atividade 1: Descrição da atividade (No maximo 1 linha de descrição)
    """
)

prompt = modeloPrompt.format(
    numero_dias = dias,
    numero_filhos = filhos,
    atividade_preferida = atividade
)

modelo = ChatOpenAI(
    model = "google/gemma-3-4b",
    base_url="http://localhost:1234/v1",
    api_key="lm-studio"
)
```

---

## 🔥 Exemplo 2: Chain completa com LCEL

```python
from langchain_openai import ChatOpenAI
from langchain_core.prompts import PromptTemplate
from langchain_core.output_parsers import StrOutputParser

mPrompt = PromptTemplate(
    template = """
    Sugira um ÚNICO filme, baseado no meu ultimo filme assistido que foi {filme}
    """,
    input_variables = ["filme"]
)

modelo = ChatOpenAI(
    model = "google/gemma-3-4b",
    base_url="http://localhost:1234/v1",
    api_key="lm-studio"
)

cadeia = mPrompt | modelo | StrOutputParser()

resposta = cadeia.invoke({"filme": "Homem de ferro 1"})
print(resposta)
```

---

## 🧠 Evolução (nível mais avançado)

Você pode:
- Encadear várias chains
- Usar outputs como input de outras
- Criar fluxos dinâmicos

Exemplo mental:

```
User Input
   ↓
Chain 1 (gera contexto)
   ↓
Chain 2 (refina resposta)
   ↓
Chain 3 (formata output)
```

---

## 💡 Resumo Final

- 🔗 Chain = pipeline
- ⚙️ LCEL = forma elegante de montar pipeline (`|`)
- 🧩 Parser = transforma output
- 🤖 LLM = motor de geração

---

## 🧠 Dica de Senior

Python + LangChain ≠ Java

👉 Aqui:
- composição > estrutura rígida
- fluxo > arquitetura pesada

---

## 🚀 Próximos passos

- Output estruturado (JSON)
- Agents
- Memory
- Tools (integração com APIs)

---

Feito com base nos seus estudos 📈
