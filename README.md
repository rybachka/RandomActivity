# RandomActivity
Random Activity App to aplikacja, która pozwala użytkownikom przeglądać, losować, oraz zapisywać ulubione aktywności. Projekt został stworzony z wykorzystaniem technologii Vue.js (frontend), Spring Boot (backend) oraz PostgreSQL (baza danych). Aplikacja działa w środowisku kontenerowym za pomocą Docker Compose.

Funkcjonalności:
Przeglądanie listy aktywności: Możliwość filtrowania według kategorii i wyświetlania szczegółów.
Losowanie aktywności: Użytkownik może wylosować losową aktywność za pomocą przycisku.
Historia aktywności: Automatyczne zapisywanie przeglądanych aktywności do historii.
Lista ulubionych aktywności: Dodawanie i przeglądanie ulubionych aktywności.
Szczegóły aktywności: Wyświetlanie szczegółowych informacji o aktywnościach, w tym linków do filmików na YouTube.

Technologie
Frontend:
Vue.js 3
Axios do komunikacji z backendem
Bootstrap (opcjonalnie) dla stylizacji komponentów

Backend:
Spring Boot
REST API
Hibernate i JPA do zarządzania bazą danych

Baza danych:
PostgreSQL

Konteneryzacja:
Docker Compose
Oddzielne kontenery dla backendu, frontendu oraz bazy danych


Instalacja i uruchomienie
Wymagania wstępne:
Docker i Docker Compose
Node.js i npm/yarn (jeśli chcesz pracować lokalnie z frontendem)
Java 17+ (dla backendu)



Uruchomienie z Docker Compose
1. Sklonuj repozytorium:
git clone https://github.com/rybachka/random-activity-app.git
cd random-activity-app

2. Uruchom aplikację za pomocą Docker Compose:
docker-compose up --build

3. Aplikacja frontendowa będzie dostępna pod adresem:
http://localhost:8081

4. Backend REST API działa pod adresem:
http://localhost:8080/api


Lokalny rozwój
Backend:
1. Otwórz folder backend i uruchom projekt Spring Boot w swoim IDE.
2. Skonfiguruj dostęp do bazy danych w application.properties.
   
Frontend:
Otwórz folder frontend:
cd frontend

Zainstaluj zależności:
npm install

Uruchom aplikację w trybie deweloperskim:
npm run serve

Aplikacja frontendowa będzie działać na:
http://localhost:8080


Struktura projektu:
random-activity-app/
│
├── backend/               # Kod backendu w Spring Boot
│   ├── src/               # Źródła Java
│   └── Dockerfile         # Konfiguracja kontenera backendu
│
├── frontend/              # Kod frontendowy w Vue.js
│   ├── src/               # Źródła Vue.js
│   └── Dockerfile         # Konfiguracja kontenera frontendowego
│
├── db/                    # Skrypty inicjalizacyjne bazy danych
│
├── docker-compose.yml     # Konfiguracja Docker Compose
│
└── README.md              # Dokumentacja projektu


REST API

Endpointy

Aktywności:
GET /api/activities - Pobiera listę wszystkich aktywności.
GET /api/activities/random - Pobiera losową aktywność.
GET /api/activities/{id} - Pobiera szczegóły aktywności o podanym ID.

Historia:
POST /api/history - Dodaje aktywność do historii.
GET /api/history - Pobiera listę aktywności z historii.

Ulubione:
POST /api/favorites - Dodaje aktywność do ulubionych.
GET /api/favorites - Pobiera listę ulubionych aktywności.


Autor
Projekt został opracowany przez rybachka.


Licencja
Projekt jest udostępniony na licencji MIT. Szczegóły w pliku LICENSE.
