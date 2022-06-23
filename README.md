# CRUD
## Тестовое задание для участия в проекте.  

### Оглавление
1. [Структура проекта](https://github.com/NukerDuker/CRUD#Структура-проекта)
2. [Реализованный функционал](https://github.com/NukerDuker/CRUD#Реализованный-функционал)
3. [Что не удалось](https://github.com/NukerDuker/CRUD#Что-не-удалось)
4. [Как запустить и проверить](https://github.com/NukerDuker/CRUD#Как-запустить-и-проверить)
#### Структура проекта:  

![2022-06-23_19-02-46](https://user-images.githubusercontent.com/64738590/175345591-54cbf3bd-206a-4953-b6f5-c6525fa4b6b9.png)

##### Изменения из последних коммитов
- Добавлены валидаторы пароля и логина телеграмм
- Добавлены ошибки валидации для новых валидаторов
- Проверка валидации вынесена из метода UserController.register() в метод CheckValid.fullCheck(), чтобы сократить метод и убрать дополнительную линию изменений


Входной файл для Spring приложения - src/main/java/com.example.userAPI/UserApiApplication  
resources/ - Директория с конфигом для PostgreSQL и скриптом создания таблицы.

В пакетах:
- controller - Rest контроллер для маршрутизации запросов по методам
- model - Модель объекта User для работы с БД
- repository - DAO с реализацией JDBCTemplate и методов работы с базой
- validators - Валидаторы почты и телефона    
- Валидаторы сделаны через удобный интерфейс, легко можно добавить валидацию для других полей и вынести 
- utils - утилитные классы для валидации и генерации Json ответов

#### Реализованный функционал    
- [X] RestAPI с использованием Spring
- [X] Взаимодействие с БД PostgreSQL (JDBCTemplate)
- [X] Реализованы 3 метода API    
  - [X] Методы принимают на вход требуемые параметры    
  - [X] Возвращают JSON с полем ID
  - [X] Метод user возвращает JSON со всеми полями пользователя, кроме пароля    
  - [X] Метод возвращает все ошибки в виде JSON код + описание
- [X] Валидация даты рождения (по году), валидация почты и email
- [X] Конфиг приложения с прописанным подключением к БД

#### Что не удалось    

- [ ] Доп.задача реализовать Makefile для автоматической сборки и запуска проекта    
- С помощью gradle приложение поднимается одной командой, не вижу смысла писать для нее скрипт.

#### Как запустить и проверить    
1. Прописать конфигурацию для доступа к БД в файле src/main/resources/application.properies
2. Запустить gradle :bootRun
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
GET /user/{id}
{
}
```
