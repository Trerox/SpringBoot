## Lab 3 - 4
W oparciu o przygotowany szablon wprowadź zmiany do aplikacji które umożliwią jej uruchomienie w jako kontenerów Docker.
Zapewnij wersjonowanie modelu danych z wykorzystaniem Liquibase.

### Przygotowanie projektu
1. Uruchom bazę PostgreSQL wykonując:

`docker run --name postgres -e POSTGRES_PASSWORD=12345678 -p 5432:5432 -d postgres `

2. Uruchom narzędzie PgAdmin wykonując
`docker run --name pg-admin -e PGADMIN_DEFAULT_EMAIL="foo@bar.com" -e PGADMIN_DEFAULT_PASSWORD="12345678" -p 9191:80 -d  dpage/pgadmin4`
3. Sprawdź uruchomione kontenery Docker poleceniem `docker ps`
   - zatrzymanie wybranego kontenera `docker stop <nazwa_kontenera>`
   - uruchomienie kontenera `docker start <<nazwa_kontenera>>`
4. Skonfiguruj połączenie z bazą danych w narzędziu PgAdmin. Uwaga w polu "Host name/address" podaj: `host.docker.internal`.

5. Utwórz bazę danych `lab2`.

6. Wykonaj `.\gradlew update`

###  Modyfikacje w aplikacji 
1. Przenieś model danych do bazy PostgreSQL, używając narzędzia Liquibase
2. Rozszerz model danych o kolumnę przechowującą opis produktu. Powinien on być zwracany również przez metodę API
   - `ALTER TABLE table_name ADD column_name datatype;`
3. Dodaj do aplikacji możliwość komentowania produktu. Z każdym produktem może być związane 0 .. n komentarzy. 
   - komentarz opisywany jest przez `id`, `autora` (string), `tresc` 
   - rozszerz API o możliwość dodawania komentarzy do produktów. Komentowany produkt powinien być wskazywany przez swoje `id`.
4. Zbuduj obraz dockerowy z aplikacją 
   - `docker build . -t lab2:latest`
5. Uruchom aplikację w postaci obrazu docker
   - `docker run --name lab2-container -p 9090:9090 lab2:latest`
6. Uruchom aplikację oraz bazę danych przy użyciu docker-compose
   - rozszerz plik `docker-compose.yml` o serwis aplikacji 
   - uruchom projekt poleceniem `docker compose up`
   - zatrzymanie: `docker compose down`



### Dokumentacja API:
URL: http://localhost:9090/swagger-ui.html

### PgAdmin:
URL: http://localhost:9191/ <br>
Użytkownik: foo@bar.com <br>
Hasło: 12345678