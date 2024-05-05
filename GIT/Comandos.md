# Comandos Git e Exemplos

1. **git remote -v**: Exibe os repositórios remotos atualmente configurados, juntamente com suas URLs.

   Exemplo:
origin https://github.com/seu-usuario/seu-repositorio.git (fetch)
origin https://github.com/seu-usuario/seu-repositorio.git (push)




2. **git log --graph**: Exibe o histórico de commits de forma gráfica, mostrando os diferentes ramos e suas interconexões.

Exemplo:
commit c1a2b3d (HEAD -> main)
| Author: Seu Nome seuemail@example.com
| Date: Tue May 4 12:00:00 2024 +0300
|
| Descrição do commit
|
commit b4e5f6c
| Author: Seu Nome seuemail@example.com
| Date: Mon May 3 12:00:00 2024 +0300
|
| Outra descrição de commit



3. **git checkout --arquivo**: Descarta as alterações não salvas em um arquivo, restaurando-o para o estado do último commit.

Exemplo:
git checkout -- index.html




4. **git revert hash**: Cria um novo commit que desfaz as alterações introduzidas por um commit específico.

Exemplo:
git revert c1a2b3d




5. **git stash**: Salva as alterações locais em um local temporário, permitindo alternar para outro ramo ou realizar outras operações sem comprometer as alterações.

Exemplo:
git stash




6. **git stash list**: Lista todas as entradas no stash, mostrando as alterações salvas temporariamente.

Exemplo:
stash@{0}: WIP on main: c1a2b3d Descrição do commit




7. **git stash pop**: Remove a última entrada do stash e aplica suas alterações no diretório de trabalho.

Exemplo:
git stash pop




8. **git checkout hash**: Move o HEAD para o commit especificado, colocando o repositório em um estado específico.

Exemplo:
git checkout c1a2b3d




9. **git diff hash..hash**: Mostra as diferenças entre dois commits, especificados por seus hashes.

Exemplo:
git diff b4e5f6c..c1a2b3d




10. **git diff**: Mostra as diferenças entre o diretório de trabalho e o índice (staging area).

 Exemplo:
 ```
 git diff
 ```

11. **git tag -a nome-tag -m "mensagem"**: Cria uma tag anotada em um commit específico, geralmente usada para marcar versões.

 Exemplo:
 ```
 git tag -a v1.0 -m "Versão inicial"
 ```

12. **git push nome-tag**: Envia uma tag específica para o repositório remoto.

 Exemplo:
 ```
 git push origin v1.0
 ```

13. **git restore --source hash ./arquivo**: Restaura um arquivo para um estado específico de um commit.

 Exemplo:
 ```
 git restore --source c1a2b3d index.html
 ```

14. **git cherry pick hash**: Aplica um commit específico em outro ramo.

 Exemplo:
 ```
 git cherry-pick b4e5f6c
 ```

15. **git rebase -I head~3/hash**: Reorganiza e combina commits, permitindo editar mensagens de commit, dividir commits, etc.

 Exemplo:
 ```
 git rebase -i HEAD~3
 ```

16. **git bisect start**: Inicia uma busca binária para encontrar um commit que introduziu um determinado problema.

 Exemplo:
 ```
 git bisect start
 ```

17. **git bisect bad head**: Marca o commit atual como ruim (contendo o problema).

 Exemplo:
 ```
 git bisect bad HEAD
 ```

18. **git bisect good hash**: Marca um commit como bom (não contendo o problema).

 Exemplo:
 ```
 git bisect good c1a2b3d
 ```

19. **git bisect bad/good**: Marca o commit atual como ruim ou bom, dependendo se o problema está presente ou não.

 Exemplo:
 ```
 git bisect bad
 ```

20. **git bisect reset**: Finaliza o processo de busca binária e retorna ao estado original.

 Exemplo:
 ```
 git bisect reset
 ```

21. **git show hash**: Exibe informações detalhadas sobre um commit específico.

 Exemplo:
 ```
 git show c1a2b3d
 ```

22. **git blame arquivo**: Exibe quem modificou cada linha de um arquivo, juntamente com o commit correspondente.

 Exemplo:
 ```
 git blame index.html
 ```
