# back
# устанавливаем самую лёгкую версию JVM
FROM openjdk:17-jdk-alpine

# указываем ярлык. Например, разработчика образа и проч. Необязательный пункт.
LABEL maintainer="MGrintsevich"

# указываем точку монтирования для внешних данных внутри контейнера (как мы помним, это Линукс)
VOLUME /tmp

# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8080

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=target/*.jar
ARG DATABASE_URL=jdbc:postgresql://host.docker.internal:5432/postgres

# добавляем джарник в образ под именем stepUp5.jar
COPY ${JAR_FILE} app.jar

# команда запуска джарника
ENTRYPOINT ["java", "-Ddatabase.url=${DATABASE_URL}","-jar","/app.jar"]



