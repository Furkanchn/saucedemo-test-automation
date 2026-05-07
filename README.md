# SauceDemo Test Automation Project

Bu proje, Yazilim Test Muhendisligi dersi icin hazirlanmis BDD tabanli UI test otomasyon projesidir.

## Proje Bilgileri

- Domain: E-ticaret
- Test edilen uygulama: SauceDemo
- URL: https://www.saucedemo.com/
- Yaklasim: BDD + Page Object Model
- Teknolojiler: Java 17, Maven, Selenium WebDriver, TestNG, Cucumber, GitHub Actions

## Test Kapsami

- Kullanici girisi
- Urun listeleme ve siralama
- Sepete urun ekleme ve sepet kontrolu
- Checkout ve siparis tamamlama

## Klasor Yapisi

```text
src/test/java
  hooks
  pages
  runners
  stepdefinitions
  utilities
src/test/resources
  features
  config.properties
.github/workflows
  main.yml
docs
  TEST_PLAN.md
```

## Lokal Calistirma

```bash
mvn clean test
```

Headless modda calistirmak icin:

```bash
mvn clean test -Dheadless=true
```

## Raporlar

Test calistiktan sonra raporlar su dizinlerde olusur:

```text
target/cucumber-reports/cucumber.html
target/cucumber-reports/cucumber.json
target/surefire-reports
```

## CI/CD

GitHub Actions pipeline'i her push ve pull request icin calisir. Pipeline Java 17 kurar, Maven testlerini tetikler ve HTML raporu artifact olarak saklar.
