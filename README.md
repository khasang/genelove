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

какие есть таблицы и зачем

## Доступы к объектам

какие методы и зачем

