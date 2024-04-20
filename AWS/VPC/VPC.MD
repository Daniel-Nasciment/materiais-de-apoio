 # Virtual private cloud

Nada mais é do que uma *rede*.

Tudo relacionado a rede e comunicação de serviços, vou utilzar a VPC.


* CIDR IPv4: ip da rede
* Subredes CIDR: range de ips dentro de uma rede


## Subrede

Por padrão, a rede vpc possui sub-redes para cada zona de disponibilidade da região a qual está criada.


Por exemplo:

VPC - Região us-east-1
Sub-rede - us-east-1a, us-east-1b...

Ferramenta para calcular IP: ipcalc


# Security Groups

São stateful - Permite que a conexão seja completada


É possivel comunicar componentes aws pelo grupo de segurança, desde que os componentes estejam nesse mesmo grupo.
Por exemplo, o security group default permite acesso liberado para qualquer ip e porta, desde que a origem tenha sido de um componente que está no mesmo security group.

Também é possivel adicionar regras de acesso, por exemplo: (Onde a máquina não tenha o security group default, se não ele permitirá todo e qualquer acesso entre esses componentes) A maquina 2 só pode ser acessada via SSH a partir da maquina 1.
Com isso basta criar um security group com a regra para ssh onde a origem seja o ip provado da máquina 1.

Configuração de segurança da rede
Os grupos de acesso tem como apenas *adicionar* alguma regra de permissão, não restringir 

Regras de entrada:
* SSH
* TCP
* ...


*Tipo de origem*: é de onde vai vir o acesso

#

Regras de saída:
Para acessar a internet

# ACL

Access control list, ficam na camada de sub-rede.

Funciona como um firewall da vida 

O ACL não é stateful, então é preciso configurar a entrada e a saída.


# Redes publicas e privadas

Sobre Gateway nat:
Caso precise que a sub-rede privada pricese acessar a internet (é cobrado por uso)

Rede publica:
Qualquer componente que estiver nessa rede, por exemplo um servidor WEB, pode ser acessado pela internet.

Rede privada:
Nâo pode ser acessada pela internet (até pode com algumas configurações, mas não é uma pratica recomendada)

# Internet Gateway vs NAT

"Portão" de aceeso a partir da internet para a sub-rede publica.

Se tivermos um internet gateway configurado para um sub-rede, ela se torna-se publica. Agora, caso minha sub-rede privada precise ter acesso a internet, por exemplo para baixar algum pacote, eu utilizo o nat gateway.

# Tabela de rotas

Serve para ver os mapeamentos de rotas, por exemplo, do internet gateway para sub-rede publica.
Caso eu fosse transformar a minha sub-rede privada, em publica, bastaria adicionar na tabela de rotas e associar a sub-rede privada.

# VPC Endpoint

Dado o seguinte cenário:

Preciso que meu ECS se conecte a um banco de dados ou um S3. Ambos estão localizados na AWS.
Da forma normal, ou seja, atribuindo o IAM function role para dar as devidas permissões ao ECS para ir ao RDS ou S3, por de baixo dos panos, ele vai para internet, volta e se conecta no RDS ou S3.
Esse tipo de caso, pode conter algum tipo de latencia de rede. 
Uma opção recomendada, seria utilizar o VPC endpoint.

Resumindo é uma espécie de conexão direta da VPC e algum recurso da aws.

Então criamos uma configuração de endpoint...
Selecionamos serviço AWS, e selecionamos o serviço localizado na região.

Com isso pode aparecer duas opções.
Gateway e interface, basicamente refere-se a forma que eu vou me conectar...
Basicamente, o tipo gateway usamos para s3 ou dynamo db, o restante usariamos interface.

Quando o VPC endpoint é criado, ele é adicionado a tabela de roteamento.

# Log de rede

Pode ser feito pelo Cloud Watch

Basta criar um grupo de logs.
Nesse caso, precisa ser criado uma nova role function, que será relacionado a um serviço aws.
Existe da documentação da aws, um json, basta utiliza-lo ao criar uma nova politica.
Após isso, basta associar um fluxo de log na VPC, sub-rede, etc...

# Bastion Host

É uma tecnica que serve como uma ponte, para conectar o mundo externo a uma VPC.

