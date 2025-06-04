
# 📚 Sliding Window — Guia Prático

## 🚀 O que é Sliding Window?

**Sliding Window** (Janela Deslizante) é uma técnica de otimização muito comum em problemas que lidam com **arrays**, **strings** ou **subarrays**, especialmente quando a solução envolve encontrar um intervalo contínuo que satisfaça alguma condição.

Ela substitui soluções de força bruta que testariam todas as combinações possíveis, oferecendo uma abordagem eficiente com **complexidade O(n)** na maioria dos casos.

---

## 🔍 Quando Usar Sliding Window?

> Sempre que o problema envolver:
- **Subarrays**, **substrings** ou **intervalos contínuos**;
- Operações como: _"maior", "menor", "exatamente", "no máximo", "sem repetir", "com limite X"_ dentro de uma sequência.

**Exemplos de perguntas típicas:**
- ✅ Qual o maior subarray sem caracteres repetidos?
- ✅ Qual o menor subarray cuja soma seja maior que um valor X?
- ✅ Qual o número máximo de elementos distintos dentro de uma janela?

---

## 🛠️ Receita de Bolo — Estrutura Base

### 🏗️ Estrutura Padrão

1. **Inicializar os ponteiros da janela:**
   - `l = 0` (esquerda)
   - `r = 0` (direita)

2. **Expandir a janela:**  
   Enquanto `r < tamanho do array`:
   - Inclui o elemento na posição `r` na janela.
   - Atualiza o estado (frequência, soma, conjunto, etc.).
   - Avalia se a condição do problema ainda é satisfeita.

3. **Se violar a regra:**  
   Enquanto a condição não for mais válida:
   - Move `l` para frente (`l++`) → **janela se contrai pela esquerda**.
   - Atualiza o estado (remove o elemento na posição `l` da janela).

4. **Registrar resultados:**  
   - A cada iteração, verifica se a janela atual gera uma solução melhor (maior, menor, etc.).

5. **Avança o ponteiro da direita:**  
   - `r++`

---

## 🔑 Padrão Visual — Esqueleto da Lógica

```plaintext
Inicializa l = 0, r = 0

while r < tamanho:
    // Expande a janela para incluir o elemento r
    atualiza estado (ex: adiciona array[r])
    
    while condição inválida:
        // Contrai pela esquerda
        atualiza estado (remove array[l])
        l++
    
    // Atualiza resposta se necessário
    
    r++
```

---

## 🧠 Entendendo o Fluxo Mental

- 👉 **Expandir (`r++`)** → Sempre avança tentando incluir mais elementos na janela.
- 👉 **Contrair (`l++`)** → Se a janela não atende a regra, remove elementos da esquerda até que atenda.
- 🔁 Esse ciclo garante que você explore **todos os subarrays possíveis**, de forma eficiente.

---

## 🎯 Como Identificar que é Sliding Window?

- A solução envolve **intervalos contínuos**?
- Você pode usar dois ponteiros (`l` e `r`) para delimitar esse intervalo?
- O problema exige maximizar, minimizar, ou garantir alguma restrição dentro de um subarray?

Se a resposta é **sim**, provavelmente é um caso perfeito para Sliding Window.

---

## 🧠 Mentalidade: Problema de Sliding ou Não?

> 🔍 **Regra de ouro:**  
Se você não pode pular elementos (porque a solução precisa ser de um intervalo contínuo), e o problema é sobre otimizar algo dentro desse intervalo, então **é Sliding Window.**

---

## 🚦 Conclusão

Sliding Window é uma abordagem altamente previsível quando você percebe o padrão do problema. Com prática, você começa a identificar intuitivamente sempre que aparece um problema de **subarray, substring ou sequência contínua**.

> 🏗️ **Lembre-se:**  
Sliding não é só sobre movimentar ponteiros — é sobre **controlar o estado da janela** (frequência, soma, conjunto, etc.) para garantir que ela sempre respeite as regras do problema.
