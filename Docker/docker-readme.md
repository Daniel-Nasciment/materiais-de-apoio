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


# REDES

Podemos comunicar entre containers na mesma rede.

Comando para listar as redes
> docker network ls


Para comunicar containers pelo host name é necessário criar nossa propria rede com o seguinte comando:

> docker network create --driver bridge nome-rede

E para definir a rede e hostname no momento de criaçao do container, usamos o seguinte comando:

> docker run -it --name nome-container --network nome-rede ubunto bash

Para conectar rede em um container em execução:
> docker network connect minha-rede meu-container

## BRIDGE

A rede bridge criada pelo usuário, prove uma comunicação automatica via DNS

## NONE

A grosso modo, quando criamos um container com a network *none*, estamos dizendo que o container nao tera nenhum driver de rede vinculado a ele. Ele fica completamente isolado.

## HOST

Com esse netowork *host* tiramos qualquer isolamento de rede, por exemplo, um container que executa uma aplicaçao na porta 8080, significa que atravez do meu host na porta 8080 eu consigo acessar o container, sem qualquer isolamento de rede. (Somente para linux)

#

# DOCKER COMPOSE

O docker compose é uma ferramenta de coordenaçao de containers.

comando para executar:

OBS: É necessário estar no diretório do docker-compose.yaml

> docker-compose up

Ver serviços que foram criados pelo docker compose

> docker-compose ps

Derrubar os serviços do docker-compose

> docker-compose down


### DEPENDS_ON

Podemos definir dependencia de um serviço para outro, dessa forma definimos a order dos containers a serem executados.
Isso nao significa que, o docker vai esperar a aplicaçao dentro do container estar pronta, mas sim, o container estar up.

#

### CMD e ENTRYPOINT

*CDM* é um comando que será executado no container que poderá ser sobrescrito.

Já o *ENTRYPOINT* não pode, uma vez definido, será executado.


#

### ADD e COPY 

São basicamente a mesma coisa,  unica diferença é que o *ADD* possui mais funcionalidades, como Baixar arquivo de alguma url ou extrair arquivos de forma automatica que estejam no formato ***.tar***

#

## TAG 

Login:
> docker login

Criar tag da imagem:
> docker tag nome_imagem usuarioDockerHub/nome_imagem_docker_hub

Enviar para o docker Hub
> docker push

#

## Start Na AWS:

> sudo yum update -y

> sudo yum -y install docker

> sudo service docker start

> sudo usermod -a -G docker ec2-user

> sudo chmod 666 /var/run/docker.sock

> docker version
