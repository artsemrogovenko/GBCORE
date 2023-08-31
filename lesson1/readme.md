**Для копирования из образа в локальный носитель**

FROM bellsoft/liberica-openjdk-alpine:11.0.11 as BuildProject

WORKDIR /app

COPY ./java ./src 

RUN mkdir ./out

RUN javac -sourcepath ./src -d out src/ru/
geekbrains/lesson1/app/App.java

FROM scratch as OutputFiles
COPY --from=BuildProject /app/out /bin

**команда докера**

docker buildx build --output type=local,dest=. .