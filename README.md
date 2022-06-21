# CRUD
## Тестовое задание для участия в проекте.  

### Оглавление
1. [Структура проекта](https://github.com/NukerDuker/CRUD#Структура-проекта)
2. [Реализованный функционал](https://github.com/NukerDuker/CRUD#Реализованный-функционал)
3. [Что не удалось (пока)](https://github.com/NukerDuker/CRUD#Что-не-удалось-(пока))
4. [Как запустить и проверить](https://github.com/NukerDuker/CRUD#Как-запустить)
#### Структура проекта:  

![2022-06-21_20-02-48](https://user-images.githubusercontent.com/64738590/174857378-a72e86ea-c355-4906-9f41-18440e8cc9e0.png)

#### Реализованный функционал    
- [X] RestAPI с использованием Spring
- [X] Взаимодействие с БД PostgreSQL (JDBCTemplate)
- [X] Реализованы 3 метода API    
  - [X] Методы принимают на вход требуемые параметры    
  - [X] Возвращают JSON с полем ID
  - [X] Метод user возвращает JSON со всеми полями пользователя, кроме пароля
- [X] Валидация даты рождения (по году), валидация почты и email.
- [X] Конфиг приложения с прописанным подключением к БД

#### Что не удалось (пока)
- [ ] Возвращать ошибки в виде JSON код + описание
- [ ] Доп.задача реализовать Makefile для автоматической сборки и запуска проекта

#### Как запустить и проверить
1. Собрать проект через Gradle
2. Запустить libs/userAPI-0.0.1-SNAPSHOT.jar через cmd
3. Отправлять запросы на http://localhost:8080/v1

##### Формат запросов    
```json
POST /auth/register
{
    "name":"Geralt",
    "phone":"+71234567890",
    "birthDate":"1374-01-03",
    "login":"KillingMonstersGuy",
    "password":"bye",
    "email":"coolboy@whitewolf.ru",
    "tg":"@plotva<3"
}
```
```json
POST /auth/login
{
    "login":"KillingMonstersGuy",
    "password":"bye"
}
```
```json
GET /auth/login/{id}
{
}
```
