<a name="logo"></a>
## Учебный проект по автоматизации тестирования мобильного приложения Wikipedia (mobile)

<p align="center">
<img title="Wikipedia" src="images/screens/Wiki-logo.png">
</p>

## Содержание:

- <a href="#tools">Технологии и инструменты</a>
- <a href="#cases">Список проверок, реализованных в тестах</a>
- <a href="#launch">Запуск тестов (сборка в Jenkins)</a>
- <a href="#allure">Allure-отчет</a>
- <a href="#allure-testops">Интеграция с Allure TestOps</a>
- <a href="#telegram">Уведомление в Telegram о результатах запуска тестов</a>
- <a href="#browserstack">Browserstack</a>

<a id="tools"></a>
## Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://developer.android.com/studio/"><img src="images/logo/androidstudio.svg" width="50" height="50"  alt="AndroidStudio"/></a>
<a href="https://appium.io/"><img src="images/logo/appium.svg" width="50" height="50"  alt="Appium"/></a>
<a href="https://appium.io/"><img src="images/logo/appium-inspector.png" width="50" height="50"  alt="AppiumInspector"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.browserstack.com/"><img src="images/logo/browserstack.svg" width="50" height="50"  alt="Browserstack"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
</p>

<a id="cases"></a>
## Список проверок, реализованных в автотестах

- [x] Проверка отображения элементов экранов онбординга
- [x] Проверка работы пунктов навигационного меню
- [x] Проверка поиска по ключевому слову

<a id="launch"></a>
## Запуск тестов

###  Локальный запуск на эмуляторе:
1. Запуск из командной строки:
```bash
gradle clean android -DdeviceHost=mobile
```
2. Получение отчёта:
```bash
gradle allureServe
```

###  Настройка Jenkins и удаленный запуск в Browserstack:
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-antonpimnev-diplom-mobile/">проект</a>

![This is an image](/images/screens/mobile-Jenkins-1.png)

2. Выбрать пункт **Собрать с параметрами**
3. Выбрать под какую мобильную операционную систему будут запущены тесты (Android/iOS)
4. Нажать **Собрать**
5. Результат запуска сборки можно посмотреть в отчёте Allure

<a id="allure"></a>
## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-antonpimnev-diplom-mobile/4/allure/">Allure report</a>

###  Главное окно
<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/mobile-allure-main.png">
</p>

###  Тесты
<p align="center">
<img title="Allure Tests" src="images/screens/mobile-allure-suites.png">
</p>

###  Графики
<p align="center">
<img title="Allure Graphics" src="images/screens/mobile-allure-graph.png">
</p>

<a id="allure-testops"></a>
## <img src="images/logo/Allure_TO.svg" width="25" height="25"  alt="Allure"/></a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/1983/dashboards">Allure TestOps</a>

### Dashboard с результатами тестирования
<p align="center">
<img title="Allure Graphics" src="images/screens/mobile-ATO-main-dashb.png">
</p>

### Пример отчёта выполнения одного из автотестов
<p align="center">
<img title="Allure Graphics" src="images/screens/mobile-ATO-TC-sample.png">
</p>

<a id="telegram"></a>
## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram о результатах запуска тестов

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/mobile-telegram.png" >
</p>

<a id="browserstack"></a>
## <img src="images/logo/browserstack.svg" width="25" height="25"  alt="Browserstack"/></a> Пример видео прохождения теста в Browserstack
<p align="center">
<img title="Browserstack Video" src="images/video/video-browserstack.gif" alt="Browserstack">
</p>

### Dashboard с результатами тестирования
<p align="center">
<img title="Browserstack Dashboard" src="images/screens/mobile-Browserstack-Dashboard.png">
</p>

[Вернуться к оглавлению ⬆](#logo)
