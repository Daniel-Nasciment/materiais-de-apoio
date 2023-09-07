import requests

# URL de acesso ao Elasticsearch
elasticsearch_url = "http://elasticsearch:9200"

# Consulta Elasticsearch para obter todos os dados
response = requests.get(elasticsearch_url + "/_search")

# Verifique se a resposta é válida
if response.status_code == 200:
    # Imprima os dados retornados pelo Elasticsearch
    print(response.json())
else:
    # Imprima uma mensagem de erro
    print("Erro ao obter dados do Elasticsearch")