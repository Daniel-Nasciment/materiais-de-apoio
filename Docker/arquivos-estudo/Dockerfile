FROM node:14
WORKDIR /app-exemplo
ARG PORT_BUILD=6000 
ENV PORT=$PORT_BUILD
EXPOSE $PORT_BUILD
COPY ./app-exemplo .
RUN npm install
ENTRYPOINT npm start