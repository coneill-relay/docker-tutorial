FROM clojure:lein
WORKDIR /
COPY . /
RUN lein deps \
    && lein uberjar \
    && cp ./target/uberjar/*-standalone.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
