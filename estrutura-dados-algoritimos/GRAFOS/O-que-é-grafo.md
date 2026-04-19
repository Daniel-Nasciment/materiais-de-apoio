# 🌐 Grafos - Conceito, Utilidade e Mindset

## 🚀 O que é um grafo?
- Uma estrutura de dados para **representar relações** entre coisas.
- Formado por:
  - **Nódulos (nós ou vértices)** → o que está sendo conectado.
  - **Arestas** → como estão conectados.

## 🎯 Para que serve?
- Qualquer problema que envolva **conexões ou relações** pode virar um grafo.
- Exemplos:
  - Rede social (pessoas + amizades)
  - GPS / mapas (lugares + estradas)
  - Tarefas dependentes (tarefas + precedências)
  - Rede elétrica, internet, etc.

## 🧠 Mindset para resolver problemas com grafos
### 🔑 A chave está em 3 perguntas:
1. **Quem são os nós?**
   - O que estou conectando? Pessoas, cidades, tarefas...  
2. **Como estão conectados?**
   - Existe peso (custo, tempo, distância)?
   - É só ida ou tem volta (direcionado ou não)?
3. **O que quero descobrir?**
   - Existe caminho?
   - Qual o caminho mais curto?
   - Tudo está conectado?
   - Tem ciclos?

Se você responder isso, já sabe:
- Como montar o grafo,
- E qual algoritmo usar (BFS, DFS, Dijkstra, etc).

---

✅ **Resumo prático:**
| Conceito   | Significado                          |
|------------|-------------------------------------|
| Nós        | O que está sendo conectado          |
| Arestas    | Como estão conectados               |
| Peso       | Custo ou distância da conexão       |
| Direção    | Se a conexão é só ida ou ida-e-volta|

---

> 🎯 **Mindset final:**  
> Sempre pense:  
> ➡ **O que estou conectando?**  
> ➡ **Como estão conectados?**  
> ➡ **O que quero descobrir sobre essas conexões?**  
>  
> Isso resolve 90% do problema de grafos antes mesmo do código.
