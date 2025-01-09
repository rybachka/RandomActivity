# Random Activity App

**Random Activity App** to aplikacja, która pozwala użytkownikom przeglądać, losować oraz zapisywać ulubione aktywności. Projekt wykorzystuje **Vue.js** jako frontend, **Spring Boot** jako backend oraz **PostgreSQL** jako bazę danych. Całość działa w kontenerach dzięki **Docker Compose**.

## Funkcjonalności

- **Przeglądanie listy aktywności**: Możliwość filtrowania według kategorii i wyświetlania szczegółów.
- **Losowanie aktywności**: Wylosowanie losowej aktywności.
- **Historia aktywności**: Automatyczne zapisywanie przeglądanych aktywności do historii.
- **Lista ulubionych aktywności**: Możliwość zapisywania i przeglądania ulubionych aktywności.
- **Szczegóły aktywności**: Wyświetlanie szczegółowych informacji, w tym linków do filmików na YouTube.

---

## Technologie

### **Frontend:**
- Vue.js 3
- Axios (do komunikacji z backendem)
- Bootstrap (opcjonalnie, do stylizacji)

### **Backend:**
- Spring Boot
- Hibernate (JPA)
- REST API

### **Baza danych:**
- PostgreSQL

### **Konteneryzacja:**
- Docker Compose
- Kontenery: backend, frontend, baza danych

---

## Instalacja i uruchomienie

### Wymagania wstępne
- Zainstalowany **Docker** i **Docker Compose**
- **Node.js** z **npm** (opcjonalnie, do lokalnego uruchamiania frontendu)
- **Java 17+**

### **Uruchomienie z Docker Compose**
1. Sklonuj repozytorium:
    ```bash
    git clone https://github.com/rybachka/random-activity-app.git
    cd random-activity-app
    ```

2. Uruchom aplikację:
    ```bash
    docker-compose up --build
    ```

3. Frontend aplikacji będzie dostępny pod adresem:
    [http://localhost:8081](http://localhost:8081)

4. Backend REST API działa pod adresem:
    [http://localhost:8080/api](http://localhost:8080/api)

---

## Lokalny rozwój

### **Backend**
1. Otwórz folder `backend` w IDE (np. IntelliJ, Eclipse).
2. Skonfiguruj dostęp do bazy danych w pliku `application.properties`.
3. Uruchom projekt Spring Boot (np. za pomocą komendy `Run` w IDE).

### **Frontend**
1. Przejdź do folderu `frontend`:
    ```bash
    cd frontend
    ```

2. Zainstaluj zależności:
    ```bash
    npm install
    ```

3. Uruchom w trybie deweloperskim:
    ```bash
    npm run serve
    ```

4. Aplikacja będzie dostępna pod adresem: 
    [http://localhost:8080](http://localhost:8080)

---

## Struktura projektu

```plaintext
random-activity-app/
│
├── backend/               # Backend w Spring Boot
│   ├── src/               # Kod źródłowy w Java
│   └── Dockerfile         # Konfiguracja kontenera backendu
│
├── frontend/              # Frontend w Vue.js
│   ├── src/               # Kod źródłowy Vue.js
│   └── Dockerfile         # Konfiguracja kontenera frontendu
│
├── db/                    # Skrypty inicjalizacyjne bazy danych
│
├── docker-compose.yml     # Konfiguracja Docker Compose
│
└── README.md              # Dokumentacja projektu
``````
## REST API

### Endpointy:

#### Aktywności
- **`GET /api/activities`**  
  Pobiera listę wszystkich aktywności dostępnych w systemie.

- **`GET /api/activities/random`**  
  Pobiera losową aktywność z bazy danych.

- **`GET /api/activities/{id}`**  
  Pobiera szczegóły aktywności o podanym ID.  

#### Historia
- **`POST /api/history`**  
  Dodaje aktywność do historii przeglądania.  
  **Parametry**:  
  - `activityId`: ID aktywności do zapisania w historii.  

- **`GET /api/history`**  
  Pobiera listę aktywności zapisanych w historii użytkownika.  

#### Ulubione
- **`POST /api/favorites`**  
  Dodaje aktywność do ulubionych.  
  **Parametry**:  
  - `activityId`: ID aktywności do dodania do ulubionych.  

- **`GET /api/favorites`**  
  Pobiera listę ulubionych aktywności użytkownika.  

---

### Autor
Projekt został opracowany przez **rybachka**.

### Licencja
Projekt jest udostępniony na licencji **MIT**. Szczegóły znajdują się w pliku `LICENSE`.

