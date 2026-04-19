### Conetando com GEMINI

#### Usando Models

```python
import os
from google.colab import userdata
from google import genai

os.environ["GOOGLE_API_KEY"] = userdata.get('API_KEY')
client = genai.Client()

resposta = client.models.generate_content(model="gemini-2.5-flash", contents="O que é uma IA?")
print(resposta.text)
```

#### Usando CHAT
```python
import os
from google.colab import userdata
from google import genai

os.environ["GOOGLE_API_KEY"] = userdata.get('API_KEY')
client = genai.Client()

chat = client.chats.create(model="gemini-2.5-flash")
respostaChat = chat.send_message("Quando foi lançado o ChatGPT ?")
print(respostaChat.text)

print(chat.get_history())
```
