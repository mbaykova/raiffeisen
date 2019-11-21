#language: ru
Функционал: Депозит

  @web
  Сценарий: Заявка на вклад

    * подтвержден регион
    * выбран пункт меню "Вклады"
    * выбран подпункт меню "Накопительные счета"
    * выбран вклад "На каждый день"

    * страница "DepositPage" загружена
    * заполняются поля:
      | Фамилия, Имя и Отчество | Иванов Иван Иванович |
      | Телефон                 | 9101234567           |
      | Дата рождения           | 12121992             |

    * поля заполнены значениями:
      | Дата рождения | 12.12.1992         |
      | Телефон       | +7 (910) 123-45-67 |


    * поле "Выслать код" доступно
    * выпадающий список "Город" заполняется значением "Москва"

    * выполнено нажатие на "Я подтверждаю"
    * поле "Осталось заполнить Телефон" присутствует