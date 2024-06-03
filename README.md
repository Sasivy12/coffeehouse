**Огромное спасибо за идею [Quatry](https://github.com/Quatry). [Ссылка на его версию данного проекта, выполненного с помощью Django](https://github.com/Quatry/coffeehouse?tab=readme-ov-file#%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C-menuitem)**

# Документация API для кофейни
## CoffeeHouse (Кофейня)
### Модель CoffeeHouse
Модель представляет кофейню с её основными характеристиками.

Поля модели:
* name: Название кофейни (String)
* schedule: Расписание работы кофейни (String)
* date_created: Дата создания записи (dateCreated, автоматически заполняется при создании)
* info: Дополнительная информация о кофейне (TEXT)
* coffeeHouseId: Уникальный идентификатор (Long, уникальный)
  
### URL-шаблоны 
`GET` Возвращает список всех кофеен.
`localhost:8000/api/`

`POST` Создает новую кофейню.
`localhost:8000/api/add_coffee_house`

`GET` Возвращает информацию о конкретной кофейне по его уникальному идентификатору.
`localhost:8000/api/{coffeeHouseId}>`

`PUT`, `DELETE` Изменяет или удаляет информацию о конкретной кофейне по его уникальному идентификатору.
`localhost:8000/api/{coffeeHouseId}/edit`

## Menu (Меню)
### Модель Menu
Модель представляет меню кофейни с набором блюд.

Поля модели:
* name: Название меню (String)
* coffeeHouse: Ссылка на кофейню (ForeignKey)
* menuId: Уникальный идентификатор (Long, уникальный)
  
### URL-шаблоны
`POST` Добавляет новое меню для конкретной кофейни.
`localhost:8000/api/{coffeeHouseId}/menu/add`

`GET` Возвращает информацию о конкретном меню по его уникальному идентификатору.
`localhost:8000/api/{coffeeHouseId}/menu/{menuId}  `

`PUT`, `DELETE` Изменяет или удаляет информацию о конкретном меню по его уникальному идентификатору.
`localhost:8000/api/{coffeeHouseId}/edit/{menuId}`

## MenuItem (Элемент меню)
### Модель MenuItem
Модель представляет отдельный пункт в меню кофейни.

Поля модели:
* name: Название пункта меню (String)
* measure_unit: Единица измерения (String)
* units: Количество единиц (Integer)
* menu: Ссылка на меню (ForeignKey)
* photo: Фотография блюда (byte[])
  
### URL-шаблоны
`POST` Добавляет новый пункт меню в конкретное меню.
`localhost:8000/api/{coffeeHouseId}/menu/{menuId}/items/add`

`GET` Возвращает информацию о конкретном пункте меню по его уникальному идентификатору.
`localhost:8000/api//{coffeeHouseId}/menu/{menuId}/items/{menuItemId}`

`PUT`, `DELETE` Изменяет или удаляет информацию о конкретном пункте меню по его уникальному идентификатору.
`localhost:8000/api//{coffeeHouseId}/menu/{menuId}/items/{menuItemId}/edit`

