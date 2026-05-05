# Guia básico: Pandas + uso de LLM local com Python

---

## 📌 Pandas (manipulação de dados)

### Importação
A forma padrão (convenção da comunidade) é:

```python
import pandas as pd
```

---

### Criando um DataFrame a partir de uma lista de dicionários

Exemplo correto:

```python
meu_dict_list = [
    {"pergunta": "Pergunta 1", "resposta": "Resposta 1"},
    {"pergunta": "Pergunta 2", "resposta": "Resposta 2"}
]
```

Transformando em DataFrame:

```python
df = pd.DataFrame(meu_dict_list)
```

---

### Acessando colunas

```python
df["pergunta"]
```

---

### Valores únicos (tipo DISTINCT do SQL)

```python
df["pergunta"].unique()
```

Ou:

```python
set(df["pergunta"])
```

---

### Filtragem de dados

```python
df[df["coluna"] == "valor"]
```

Exemplo:

```python
df[df["pergunta"] == "Pergunta 1"]
```

---

### Dimensões do DataFrame

```python
df.shape
```

Retorna:

```
(linhas, colunas)
```

---

### `.loc` (busca por rótulo)

```python
df.loc[0]
df.loc[0, "resposta"]
```

Para usar texto como índice:

```python
df = df.set_index("produto")
df.loc["ps5"]
```

---

### `.iloc` (busca por posição)

```python
df.iloc[0]
df.iloc[0:10]
df.iloc[0, 1]
```

---

## 🤖 Rodando LLM local com Python

### Criar ambiente virtual

```bash
python -m venv .venv
```

Ativar:

Windows:
```bash
.venv\Scripts\activate
```

Linux/Mac:
```bash
source .venv/bin/activate
```

Desativar:

```bash
deactivate
```

---

### Instalar biblioteca OpenAI

```bash
pip install openai
```

---

### Exemplo de uso com modelo local (LM Studio)

```python
from openai import OpenAI

client = OpenAI(
    base_url="http://127.0.0.1:1234/v1",
    api_key="lm-studio-api-key"
)

response = client.chat.completions.create(
    model="google/gemma-3-4b",
    messages=[
        {"role": "system", "content": "Você é um assistente claro e objetivo."},
        {"role": "user", "content": "Olá, como você está?"}
    ],
    temperature=1
)

print(response.choices[0].message.content)
```

---

## 💡 Dica prática

- Use Pandas para organizar dados (CSV, JSON, etc)
- Use LLM para processar texto (respostas, resumos, classificação)
- Combine os dois para automações inteligentes
