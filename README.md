#SOKOL 
![logo](https://github.com/khasang/genelove/blob/development/web/WEB-INF/views/images/love2.jpg)

# Genelove

description

## Install 

(что надо для установки приложения)

## Java Mail Sending 

что надо установить чтобы JMS работал (Active MQ)

## AdminController

/admin - Экран администрирования

/admin/usersList - Список пользователей

/admin/user/id/{id} - пользователь с ID = {id}

/admin/user/login/{login} - пользователь с login = {login}

/admin/delete/id/{id} - удалить пользователя с ID = {id}



## UserController

### зарегистрироваться
`String registration()`
### войти в систему
`String login()`
### выйти из системы
`String logout()`

### отправить сообщение другому пользователю
`String messagePost()`
### получить сообщение от другого пользователя
`String messageGet()`
### удалить сообщение из своей переписки
`String messageDelete()`
### просмотреть все сообщения
`String messageAll()`

### добавить другого пользователя в закладки
`String favoriteAdd()`
### удалить другого пользователя из закладок
`favoriteDelete()`
### просмотреть все закладки
`favoriteAll()`

### добавить человека в генеалогическое дерево
`relativeNodeAdd()`
### удалить человека из генеалогического дерева
`relativeNodeDelete()`
### изменить данные человека в генеалогическом дереве
`relativeNodeUpdate()`
### посмотреть всё дерево
`relativeNodeAll()`

### добавить личную анкету
`persInfoAdd()`
### удалить личную анкету
`persInfoDelete()`
### изменить данные по личной анкете
`persInfoUpdate()`
### просмотреть анкету
`persInfoView()`

### добавить мультимедиа-альбом
`albumAdd()`
### удалить мультимедиа-альбом
`albumDelete()`
### изменить мультимедиа-альбом
`albumUpdate()`
### просмотреть альбом (все файлы)
`albumView()`
### просмотреть все альбомы
`albumAll()`

### добавить файл фото/видео в альбом
`fileAdd()`
### удалить файл фото/видео из альбома
`fileDelete()`
### изменить файл фото/видео в альбоме
`fileUpdate()`

## Сущности

User - пользователи

Role - роли пользователей

Authorisation - авторизация пользователей (связь между пользователем и ролью)

AuthorisationKey - составной ключ сущности Authorisation (в базе данных не создается)

Profile - анкеты пользователей

Message - личные сообщения пользователей

EMail - сообщения электронной почты пользователей и не только

Favourite - выбранные пользователем фавориты (друзья), т.е. другие пользователи

FavouriteKey - составной ключ сущности Favorite (в базе данных не создается)

Tree - генеалогическое дерево пользователя

Person - люди, составляющие генеалогическое дерево. Владелец дерева (т.е. пользователь) также представлен в этой таблице. Для него User (user_id) NOT NULL

Relationship - отношения между людьми, составляющими дерево

RelationshipType - типы отношений между людьми ("брак", "родительство" и т.д.)

RelationshipRole - роли людей в паре, составляющей отношение (например, для отношения "родительство" роль 1 = "мать", роль 2 = "дочь", для отношения "брак" - роль 1 = "муж", роль 2 = "жена")

Реализация дерева, с небольшими изменениями, заимствована отсюда:

http://databaseanswers.org/data_models/genealogy/genealogy_physical.htm

## Доступы к объектам

какие методы и зачем

