# Use a imagem base do Nginx
FROM nginx:latest

# Copie o arquivo HTML para dentro da pasta raiz do Nginx
COPY index.html /usr/share/nginx/html/

# Exponha a porta 80 para o tráfego da web
EXPOSE 80

# Comando a ser executado quando o contêiner for iniciado
CMD ["nginx", "-g", "daemon off;"]