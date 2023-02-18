# DOCKER

Link: para documentaçao dockerfile:
>https://docs.docker.com/engine/reference/builder/


# Containers

## Por que containers sao mais leves ?
O container é um processo dentro do sistema operacional original

#

## Como garantem o isolamento ?
Atravez de namespaces

#

## Como funcionam sem instalar um sistema operacional ?
Conforme o container é um processo, ele pega uma parte do kernel do sistem original. Sem necessariamente instalar um sistema operacional completo.

#

## Como fica a divisao de recursos do sistema ?
Atravez do cgroups

#

## O que o docker run faz pode baixo dos panos ?

Se nao tivermos a imagem local, o host vai até o docker hub, recupera a imagem e executa o nosso container com o command padrao **bash**

Com o comando de exemplo: 
> docker run ubuntu

#
#

# Comandos úteis

Exibe quais containers estao em execuçao
> docker ps OU docker container ls

Para saber se o *docker run* fez algo efetivamente
> docker ps -a OU docker container ls -a

Para parar um container específico
> docker stop id_container

Para reiniciar um container ja criado
> docker start id_container

Interagir com o container
> docker exec -it id_containner command

> EX: docker exec -it 83208d013130 bash

Criar container diretamente com interação
> EX: docker run -it ubuntu bash

Pausar - Despausar container
> docker pause id_container - docker unpause id_container

Remover container
> docker rm id_container

Parar e remover container de uma vez
> docker rm id_container --force

Executar imagem sem travar o terminal
> docker run -d imagem

Executar container com configuraçao de porta automatica
> docker run -d -P imagem

Ver portas mapeadas no container
> docker port id_container

Configurar porta diretamente no docker run

EX: 8080 -> **Porta Host** || 80 -> **Porta container**

> docker run -d -p 8080:80 imagem

Para ver imagens baixadas
> docker images

Para inspesionar detalhes da imagem
> docker inspect id_imagem

Ver camadas da imagem
> docker history id_imagem

Fazer build de uma imagem a partir do dockerfile
> docker build -t nome_imagem .

Parar varios containers de uma vez
> docker stop $(docker container ls -q)
OBS: *-q* pega somente os id's

Remover todas imagens de uma vez
> docker rmi image $(docker images -q)

Ver o size do container
> docker ps -s

OBS: Tamanho virtual vai ser o tamanho da imagem original que  compõe o container

Listagem dos volumes docker

> docker volume ls

Criar volume

> docker volume create nome_volume

# Docker hub 

Lá podemos encontrar algumas imagens docker

# Containers

## Commands

### bash 
O container é criado, executa o que tem que excutar e é finalizado.

### Sleep

Exemplo: 
> docker run ubunto sleep 1d

Esse comando vai segurar o container no ar durante um dia.

No momento que um container é criado, é adicionado uma capada de read/write baseado na imagem, ou seja, podemos ler e escrever nessa imagem temporariamente. Conforme o container for deletado, as modificaçoes também serao.

#

# Imagens

### O que sao ?

Um conjunto de camadas.

Caso o host tenha as camadas, o docker consegue reutilizar para compor a tal imagem, de forma que nao tenha conteúdo/camadas duplicadas

No momento que uma imagem é criada, ela é ***IMUTAVÉL***

Váriaveis de ambiente

## ARG
> Vai ser criado no momento de build da imagem

## ENV
> Vai ser utilizado dentro do container


# BIND MOUNTS

Basicamente é um ponto de montagem, onde podemos definir um caminho no nosso host onde sera salvo arquivos em determinado caminho dentro do container.

Comando de exemplo:

> docker run -it -v caminho_host:caminho_container ubuntu bash

Comando mais semantico:

> docker run -it --mount type=bind,source=C:/docker-volume,target=/app ubuntu bash

TMPFS está disponível somente no sistema linux



