FROM ubuntu:22.10
RUN apt-get update
RUN apt-get install nginx -y

VOLUME ["/var/www/html"]

WORKDIR "/var/www/html/"

COPY "index.html" "index.html"

ADD "https://images.pexels.com/photos/1521304/pexels-photo-1521304.jpeg" "foto.jpeg"

# Como baixamos o arquivo precisamos alterar a 
# permissão para que seja possível acessá-lo
RUN chmod 644 foto.jpeg

ENTRYPOINT ["/usr/sbin/nginx", "-g", "daemon off;"]

EXPOSE 80