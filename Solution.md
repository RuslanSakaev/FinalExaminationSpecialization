## Решение
1. Используя команду __cat__ в терминале операционной системы __Linux__, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными (заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
~~~
lab@node-03:~$ mkdir FinalExaminationSpecialization
lab@node-03:~$ cd FinalExaminationSpecialization/
lab@node-03:~/FinalExaminationSpecialization$ cat > "Домашние животные" << EOF
> собаки
> кошки
> хомяки
> EOF
lab@node-03:~/FinalExaminationSpecialization$ cat > "Вьючные животными" << EOF
> Лошадьми
> верблюдами
> ослы
> EOF
lab@node-03:~/FinalExaminationSpecialization$ cat "Домашние животные" "Вьючные животными" > "Друзья человека"
lab@node-03:~/FinalExaminationSpecialization$ cat "Друзья человека"
собаки
кошки
хомяки
Лошадьми
верблюдами
ослы
lab@node-03:~/FinalExaminationSpecialization$ mv "Друзья человека" "Новое имя файла"
~~~
2. Создать директорию, переместить файл туда. 
~~~
lab@node-03:~/FinalExaminationSpecialization$ mkdir new_dir
lab@node-03:~/FinalExaminationSpecialization$ mv "Новое имя файла" "Друзья человека"
lab@node-03:~/FinalExaminationSpecialization$ ls
 new_dir  'Вьючные животными'  'Домашние животные'  'Друзья человека'
lab@node-03:~/FinalExaminationSpecialization$ mv "Друзья человека" new_dir/
~~~
3. Подключить дополнительный репозиторий __MySQL__. Установить любой пакет из этого репозитория.

- Обновляю информацию о пакетах: __sudo apt update__
- Добавляю репозиторий MySQL: __sudo add-apt-repository "deb http://repo.mysql.com/apt/ubuntu/ bionic mysql-apt-config"__
~~~
lab@node-03:~/FinalExaminationSpecialization$ sudo apt update
lab@node-03:~/FinalExaminationSpecialization$ sudo apt upgrade

lab@node-03:~/FinalExaminationSpecialization$ sudo add-apt-repository "deb http://repo.mysql.com/apt/ubuntu/ jammy mysql-apt-config"
Репозиторий: 'deb http://repo.mysql.com/apt/ubuntu/ jammy mysql-apt-config'
Описание:
Archive for codename: jammy components: mysql-apt-config
Дополнительные сведения: http://repo.mysql.com/apt/ubuntu/
Добавление репозитория.
Нажмите [ENTER] для продолжения или Ctrl-C для отмены.
Adding deb entry to /etc/apt/sources.list.d/archive_uri-http_repo_mysql_com_apt_ubuntu_-jammy.list
Adding disabled deb-src entry to /etc/apt/sources.list.d/archive_uri-http_repo_mysql_com_apt_ubuntu_-jammy.list
Сущ:1 http://ru.archive.ubuntu.com/ubuntu jammy InRelease
Сущ:2 http://ru.archive.ubuntu.com/ubuntu jammy-updates InRelease
Пол:3 http://repo.mysql.com/apt/ubuntu jammy InRelease [15,2 kB]
Сущ:4 http://ru.archive.ubuntu.com/ubuntu jammy-backports InRelease
Сущ:5 http://security.ubuntu.com/ubuntu jammy-security InRelease
Сущ:6 https://download.docker.com/linux/ubuntu jammy InRelease
Ошб:3 http://repo.mysql.com/apt/ubuntu jammy InRelease
  Следующие подписи не могут быть проверены, так как недоступен открытый ключ: NO_PUBKEY 467B942D3A79BD29
Чтение списков пакетов… Готово
W: Ошибка GPG: http://repo.mysql.com/apt/ubuntu jammy InRelease: Следующие подписи не могут быть проверены, так как недоступен открытый ключ: NO_PUBKEY 467B942D3A79BD29
E: Репозиторий «http://repo.mysql.com/apt/ubuntu jammy InRelease» не подписан.
N: Обновление из этого репозитория нельзя выполнить безопасным способом, поэтому по умолчанию он отключён.
N: Информацию о создании репозитория и настройках пользователя смотрите в справочной странице apt-secure(8).
lab@node-03:~/FinalExaminationSpecialization$ sudo service mysql status
Unit mysql.service could not be found.
lab@node-03:~/FinalExaminationSpecialization$ sudo apt install mysql-server
Чтение списков пакетов… Готово
Построение дерева зависимостей… Готово
Чтение информации о состоянии… Готово
Будут установлены следующие дополнительные пакеты:
  libaio1 libcgi-fast-perl libcgi-pm-perl libevent-core-2.1-7 libevent-pthreads-2.1-7 libfcgi-bin libfcgi-perl
  libfcgi0ldbl libhtml-template-perl libmecab2 libprotobuf-lite23 mecab-ipadic mecab-ipadic-utf8 mecab-utils
  mysql-client-8.0 mysql-client-core-8.0 mysql-common mysql-server-8.0 mysql-server-core-8.0
  ...
done!
update-alternatives: используется /var/lib/mecab/dic/ipadic-utf8 для предоставления /var/lib/mecab/dic/debian (mecab-dictionary) в автоматическом режиме
Настраивается пакет mysql-server-8.0 (8.0.33-0ubuntu0.22.04.2) …
update-alternatives: используется /etc/mysql/mysql.cnf для предоставления /etc/mysql/my.cnf (my.cnf) в автоматическом режиме
Renaming removed key_buffer and myisam-recover options (if present)
mysqld will log errors to /var/log/mysql/error.log
mysqld is running as pid 14509
Created symlink /etc/systemd/system/multi-user.target.wants/mysql.service → /lib/systemd/system/mysql.service.
Настраивается пакет mysql-server (8.0.33-0ubuntu0.22.04.2) …
Обрабатываются триггеры для man-db (2.10.2-1) …
Обрабатываются триггеры для libc-bin (2.35-0ubuntu3.1) …
lab@node-03:~/FinalExaminationSpecialization$ sudo service mysql status
● mysql.service - MySQL Community Server
     Loaded: loaded (/lib/systemd/system/mysql.service; enabled; vendor preset: enabled)
     Active: active (running) since Thu 2023-07-13 01:20:50 MSK; 7s ago
    Process: 14692 ExecStartPre=/usr/share/mysql/mysql-systemd-start pre (code=exited, status=0/SUCCESS)
   Main PID: 14700 (mysqld)
     Status: "Server is operational"
      Tasks: 38 (limit: 8445)
     Memory: 365.3M
        CPU: 1.654s
     CGroup: /system.slice/mysql.service
             └─14700 /usr/sbin/mysqld

июл 13 01:20:48 node-03 systemd[1]: Starting MySQL Community Server...
июл 13 01:20:50 node-03 systemd[1]: Started MySQL Community Server.
~~~
- Устанавливаю пакет MySQL из репозитория: __sudo apt install mysql-server__
- Проверяю статус службы:__sudo service mysql status__
  ![pictures](Mysql.bmp)
1. Установить и удалить __deb-пакет__ с помощью __dpkg__.
Скачаем в исходную папку деб-пакет __teamviewer__ с помощью утилиты __wget__, затем установим с помощью утилиты __dpkg__:
~~~
lab@node-03:~/FinalExaminationSpecialization$ wget https://download.teamviewer.com/download/linux/teamviewer_amd64.deb
--2023-07-13 01:59:49--  https://download.teamviewer.com/download/linux/teamviewer_amd64.deb
Распознаётся download.teamviewer.com (download.teamviewer.com)… 104.16.63.16, 104.16.62.16, 2606:4700::6810:3e10, ...
Подключение к download.teamviewer.com (download.teamviewer.com)|104.16.63.16|:443... соединение установлено.
HTTP-запрос отправлен. Ожидание ответа… 302 Found
Кукисы, полученные из download.teamviewer.com, попытались изменить домен на downloadprovider.teamviewer.com
Кукисы, полученные из download.teamviewer.com, попытались изменить домен на downloadprovider.teamviewer.com
Адрес: https://dl.teamviewer.com/download/linux/version_15x/teamviewer_15.43.7_amd64.deb [переход]
--2023-07-13 01:59:49--  https://dl.teamviewer.com/download/linux/version_15x/teamviewer_15.43.7_amd64.deb
Распознаётся dl.teamviewer.com (dl.teamviewer.com)… 104.16.62.16, 104.16.63.16, 2606:4700::6810:3f10, ...
Подключение к dl.teamviewer.com (dl.teamviewer.com)|104.16.62.16|:443... соединение установлено.
HTTP-запрос отправлен. Ожидание ответа… 200 OK
Длина: 86262340 (82M) [application/octet-stream]
Сохранение в: ‘teamviewer_amd64.deb’

teamviewer_amd64.deb          100%[=================================================>]  82,27M  1,15MB/s    за 62s

2023-07-13 02:00:51 (1,34 MB/s) - ‘teamviewer_amd64.deb’ сохранён [86262340/86262340]
~~~
Далее вводим команду для установки всех пакетов из директории:
~~~
sudo dpkg -i *.deb
~~~
Получаем ошибку, так как программа не умеет разрешать зависимости, для решения этой проблемы устанавливаем недостающие зависимости __libminizip1__ и __libxcb-xinerama0__.
Удаляем __deb-пакет__ полностью, включая его файлы конфигурации:
~~~ 
sudo dpkg -P teamviewer
~~~
Проверяем наличие пакетов, содержащих имя __team__:
~~~
dpkg-query -W -f='${Package}\n' | grep 'team'
~~~
5. Выложить историю команд в терминале __ubuntu__
~~~
  101  mkdir FinalExaminationSpecialization
  102  cat > "Домашние животные" << EOF
собаки
кошки
хомяки



  103  cd FinalExaminationSpecialization/
  104  cat > "Домашние животные" << EOF
собаки
кошки
хомяки
EOF

  105  ls
  106  cat > "Вьючные животными" << EOF
Лошадьми
верблюдами
ослы
EOF

  107  lls
  108  ls
  109  cat "Домашние животные" "Вьючные животными" > "Друзья человека"
  110  cat "Друзья человека"
  111  mv "Друзья человека" "Новое имя файла"
  112  cd
  113  rm -r FinalExaminationSpecialization/
  114  ls
  115  clear
  116  mkdir FinalExaminationSpecialization
  117  cd FinalExaminationSpecialization/
  118  cat > "Домашние животные" << EOF
собаки
кошки
хомяки
EOF

  119  cat > "Вьючные животными" << EOF
Лошадьми
верблюдами
ослы
EOF

  120  cat "Домашние животные" "Вьючные животными" > "Друзья человека"
  121  cat "Друзья человека"
  122  mv "Друзья человека" "Новое имя файла"
  123  mkdir new_dir
  124  mv "Новое имя файла" "Друзья человека"
  125  ls
  126  mv "Друзья человека" new_dir/
  127  sudo update
  128  sudo apt update
  129  sudo apt upgrade
  130  sudo add-apt-repository "deb http://repo.mysql.com/apt/ubuntu/ jammy mysql-apt-config"
  131  sudo service mysql status
  132  sudo apt install mysql-server
  133  sudo service mysql status
  134  apt download libssl-dev
  135  sudo dpkg -i libssl-dev_3.0.2-0ubuntu1.10_amd64.deb
  136  wget https://download.teamviewer.com/download/linux/teamviewer_amd64.deb
  137  sudo dpkg -i *.deb
  138  sudo dpkg -i teamviewer_amd64.deb
  139  sudo apt-get install libminizip1 libxcb-xinerama0
  140  sudo apt-get -f install
  141  sudo apt update
  142  sudo apt upgrade
  143  history
  144  sudo dpkg -P teamviewer_amd64.deb
  145  sudo dpkg -P teamviewer
  146  sudo dpkg -P telnet
  147  dpkg-query -W -f='${Package}\n' | grep 'team'
  148  history
~~~
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы.
![pictures](diagram.drawio.png)
7. В подключенном __MySQL__ репозитории создать базу данных “Друзья человека”
```
CREATE DATABASE `Друзья человека`;
```
8. Создать таблицы с иерархией из диаграммы в БД
```

```
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
10.  Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
11.  Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
12.  Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
13.  Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14.  Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:

        14.1. Завести новое животное;

        14.2. определять животное в правильный класс;

        14.3. увидеть список команд, которое выполняет животное;

        14.4. обучить животное новым командам;

        14.5. Реализовать навигацию по меню.

15.   Создайте класс Счетчик, у которого есть метод __add()__, увеличивающий̆
значение внутренней̆int переменной на 1 при нажатие __“Завести новое животное”__ Сделайте так, чтобы с объектом такого типа можно было работать в
блоке __try-with-resources__. Нужно бросить исключение, если работа с объектом
типа счетчик была не в ресурсном __try__ и/или ресурс остался открыт. Значение
считать в ресурсе __try__, если при заведения животного заполнены все поля.