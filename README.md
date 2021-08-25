# Lab 2 - Paketera tjänster

## Syfte
Syftet med denna lab är att få en återblick i hur man paketerar en tjänst med hjälp av docker samt hur man kan starta flera saker samtidigt med hjälp av docker compose.

## Övergripande målbild
Efter slutförd lab ska din applikation vara:
* paketerad med docker
* pushad till ett remote registry (dockerhub)
* hela din app ska gå att starta via docker compose (service + databas) 

## Ramverk
* Docker

# Del 1: Docker
Installera docker (Docker version 20.10.7, build f0df350)
Installera docker-compose (docker-compose version 1.29.2, build 5becea4c)
https://docs.docker.com/

Skapa ett docker hub konto `https://hub.docker.com/`
Skapa ett repository, publikt eller privat. Om du väljer privat måste du logga in på det på din dator det kan du göra genom att skriva `docker login` och sen tillhandahålla ditt användarnamn och lösenord.

## Docker basics

## Dockerize your app

Bygg din image `docker build -t <docker-hub-konto>/<namn>:<version>`

Kör din image `docker run --rm -p "8080:8080" -t <docker-hub-konto>/<namn>:<version>`
Fail! vi har ju ingen databas. Vi löser det i nästa del men innan dess - 
Pusha din image

`docker push <docker-hub-konto>/<namn>:<version>`

Nu ska du kunna se den i docker hub.

# Del 2: docker-compose basics

## Docker-compose your app!

### mysql

### application

titta i din `application.properties` här finns det lite saker förberett `spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/lab1
` alla ställen som använder databasen har dessa kryptiska saker. Det betyder, använd environment variablen MYSQL_HOST och om den inte finns, defaulta till localhost.

Dvs vi kan nu i docker-compose sätta den variabeln till dess rätta värde. I docker-compose får alla tjänster ett domännamn som är samma som dess namn. I detta fall är det `mysql`.

 