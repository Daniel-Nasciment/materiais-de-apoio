# NGINX

### O que é ?
O Nginx é um servidor WEB. 

Ele usa um conseito de programaçao assíncrona.

#### Como funciona o nginx?

Ele cria um processo principal *Master process*.
E esse processo principal, cria alguns *Worker Process* baseado nos nucleos de processamento que a máquina possui. E cada worker proccess processa diversas requisiçoes. 

#### Caminho para encontrar arquivo Hosts
> C:\Windows\System32\Drivers\Etc\hosts

Esse arquivo informa ao sistema operacional que quando uma conexão for estabelecida usando algum nome, o IP correspondente deve ser usado. Para o nome localhost, temos o IP da nossa própria máquina.

### Start Nginx with Docker:
> docker run --name some-nginx -p 8080:80 -d nginx


### Comando para copiar arquivos do container para o host:
> docker cp some-nginx:/etc/nginx/nginx.conf c:/nginx/nginx.conf


#


## Entendendo neginx.config

***1º*** Sempre que houver modificaçao em algum arquivo ou a adiçao de um .conf, é necessário fazer o restart do servidor.
> nginx -s reload

Podemos também utilizar o ***nginx -h*** para vermos todos os comandos disponiveis na CLI do nginx.

Outro comando muito útil é o comando para verificar sintaxe dos arquivos .conf
> nginx -t

*worker_connections* : O limite de conxões que um worker pode fazer.


Criei um arquivo de configuração de um servidor na minha maquina host, e copiei o arquivo para dentro do meu container com o comando:
> docker cp ./nome-arquivo nome-container:path-container/nome-arquivo

A configuração criada foi no caminho do container:
> /etc/nginx/conf.d/arquivo-qualquer.conf

Com a seguinte configuração


```.conf
server {
    listen 8080;
    server_name localhost;

    location / {
        root /home;
        index index.html;
    }
}
```

### Configurando *error_page*:

O Nginx consegue indentificar o *HTTP_CODE*, e a partir da nossa configuraçao, podemos mandar para uma pagina de erro específica. A pagina de erro padrao do nginx acaba espondo informações o endereço do servidor, dessa forma é sempre recomendado configurarmos um retorno mais seguro.

```.conf
server {
    error_page 400 401 404 erro.html;
}
```

#

## Proxy reverso

### O que é um proxy?

Um proxy é algo que fica no lado do cliente interceptando pacotes de rede.

Simplificando bastante segue um exemplo:

Dado que estamos em uma rede corporativa, todas as requisiçoes que são feitas, pro exemplo, para *google.com*, antes dessa requisição ir para a internet, passa antes por esse servidor de proxy, onde pode ou não estar configurado.


### O que é um proxy reverso ?

Proxy reverso é o cara que fica a frente dos servidores de aplicação por exemplo. Então posso ter varios clientes fazendo requisições, ao em vez dessas requisições cairem diretamente no meu servidor de aplicação, as requisições vão para esse proxy reverso onde podemos fazer algumas configurações, por exemplo, balanciamento de carga, redirecionamento, etc. Chamamos de proxy reverso por ficar no lado do servidor.

Configurando proxy reverso:

```.conf
server {
    location / {
        proxy_pass http://localhost:8080;
    }
```

#

### Implementando configuraçao de gateway com nginx:

Basta criar outras configuraçoes de servers e seu respectivo location, feito isso, configuramos no "gatweay"
o roteamento para os outros servidores.

***Exemplo***

```.conf
server {
    
    location /servico1 {
        proxy_pass http://localhost:8001/;
    }


    location /servico2 {
        proxy_pass http://localhost:8002/;
    }

```
#

### Podemos configurar um loadbalancer com nginx da seguinte forma:

***Exemplo***

```.conf
upstream servicos {

    server localhost:8001;
    server localhost:8002;

}

server {
    
    listen 8003;
    server_name localhost;

    location / {
        proxy_pass http://servicos;
    }
}
```
OBS: Em *upstream* definimos servidores.

#

### Habilitando logs: 

Dentro da configuraçao do server, podemos habilitar o log do nginx, porém, como pré-requisitos, a pasta ja deve estar criada e de preferencia onde todos os usuarios tenham permissao de escrita e leitura.

```.conf

#access_log  /var/log/nginx/host.access.log  main;

```


Dentro do terminal, para ficar acompanhando os logs:
> tail -f arquivo.

#


### Passando um header personalizado:

* Lembrar de passar o *proxy_set_header* antes de redirecionar a requisiçao.

```.conf
server {
    
    listen 8080;
    server_name localhost;

    location / {
        proxy_set_header X-Real-IP $remote_addr;
        proxy_pass http://servicos;
    }
}
```

A configuraçao acima garante que consigamos identificar o ip real que disparou a requisiçao, e nao o nosso servidor.

