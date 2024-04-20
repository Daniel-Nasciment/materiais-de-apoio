# Elastic Container Service

* Container Definition: 
    Configuração geral do container


* Task Definition:
    Configuração de um conjunto de containers


* Service:
    O que controla as tarefas


* Cluster:
    Onde tudo isso vai ser executado


### Definição de tarefa

Definir o nome da tarefa.
Podemos ter varias revisões de uma tarefa.

Toda tarefa precisa ter um container essencial. Caso ele fique down, todo o restante vai ficar down também.

### Tamanho da tarefa

Se for em fargate, eu defino o vCPU e Memória que a AWS vai reservar para a tarefa.
No caso do EC2 é o limite para a tarefa dentro da instancia, ou seja, deve ser menor do que o limite de recursos da instancia.


### FARGATE

Delega a gestão de infra a AWS (Servless), ou seja, será cobrado pela utilização.


### EC2

Nós mesmos criamos a instancia, definimos as configurações de rede, etc.


## Load Balancer

Criamos um load balancer para ele ser direcionado ao service do cluster ECS.

## Service

Dentro dele definimos a familia de tarefa que criamos anteriormente, como vamos utilizar um load balancer, foi necessário criar uma nova revisão dessa definição de tarefa, para que a porta do host fique vazia. Pois quem vai cuidar disso vai ser o LB.


#

## Auto Scaling 

Ao parar uma tarefa (container), por padrão a aws sobe outra tarefa.


### Pontos importantes

Ao criar uma nova tag de uma imagem Docker e enviar a AWS, a tarefa (container) não será reiniciado automaticamente.
Com isso podemos usar o github actions.


## ECR

Comando utilizados para subir uma imagem do nginx (Exemplo AWS)

1º 
> aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 309630397374.dkr.ecr.us-east-1.amazonaws.com

2º
> docker build -t nginx .

3º 
> docker tag nginx:latest 309630397374.dkr.ecr.us-east-1.amazonaws.com/nginx:latest

4º
> docker push 309630397374.dkr.ecr.us-east-1.amazonaws.com/nginx:latest

#

### Politicas de imagem no ECR

Podemos definir regras para apagar imagens que não estão sendo utilizadas.
Por exemplo apagar imagens mais velhas do que 1 mês. Se houver mais de 5 imagens com o prefixo *v* ele mantém somente o que eu definir, etc. Visa manter o registry organizado.
