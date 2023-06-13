FROM amazoncorretto:17

WORKDIR /app

COPY . ./

RUN ./gradlew bootJar

EXPOSE 9090

CMD ["./gradlew", "bootRun"]