
# FA_rest_hotel

Разработать REST сервис

Таблицы БД:  

**Клиент**  

  1. Фамилия  
  2. Имя  
  3. Отчество  
  4. Дата рождения  

**Номер**    
  1. Тип номера  
  2. Номер  
  3. Этаж  
  4. Цена за ночь  

**Бронь**    
  1. Номер  
  2. Дата заезда  
  3. Дата выезда  
  4. Список дополнительных услуг  
  5. Стоимость  
 
**Дополнительные услуги**
  1. Наименование  
  2. Цена за сутки  

* Реализовать JavaFX приложение, с двумя сценами.
* На первой в таблице отображаются список бронирований и кнопка на переход создания нового бронирования.
* JavaFX получает данные по REST API с первого сервиса. Нельзя забронировать номер в даты, когда номер занят.
