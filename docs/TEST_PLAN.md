# Yazilim Test Plani

## 1. Giris

Bu test planinin amaci, SauceDemo e-ticaret demo uygulamasinin temel kullanici akislarini uctan uca test etmektir. Proje kapsaminda kullanici girisi, urun listeleme, siralama, sepete urun ekleme ve checkout islemleri dogrulanacaktir.

## 2. Test Edilecek Sistem

| Alan | Aciklama |
|---|---|
| Uygulama | SauceDemo |
| URL | https://www.saucedemo.com/ |
| Domain | E-ticaret |
| Test kullanicisi | standard_user |
| Test sifresi | secret_sauce |
| Test yaklasimi | BDD tabanli UI test otomasyonu |

## 3. Test Kapsami

### In-scope

- Gecerli kullanici bilgileri ile login
- Hatali login denemelerinde hata mesaji dogrulama
- Urun listesinin goruntulenmesi
- Urunlerin fiyat ve isim kriterlerine gore siralanmasi
- Sepete urun ekleme ve sepet ikonunu dogrulama
- Sepette urun goruntuleme ve urun silme
- Checkout bilgilerini girme
- Siparis tamamlama ve basari mesaji dogrulama

### Out-of-scope

- API testleri
- Performans testleri
- Guvenlik testleri
- Gercek odeme entegrasyonu
- Mobil uygulama testleri
- Veritabani dogrulamalari

## 4. Test Stratejisi

Testler Cucumber ile BDD formatinda yazilacak ve Selenium WebDriver ile otomasyona donusturulecektir. Kod tarafinda Page Object Model kullanilarak sayfa nesneleri, step definition class'larindan ayrilacaktir. TestNG, test kosum motoru ve assertion kutuphanesi olarak kullanilacaktir.

| Test Turu | Aciklama |
|---|---|
| Fonksiyonel test | Uygulama davranisinin gereksinimlere uygunlugunu kontrol eder. |
| Smoke test | Kritik akislarin calisip calismadigini hizli kontrol eder. |
| Regresyon test | Mevcut akislarin degisikliklerden etkilenmedigini kontrol eder. |
| Uctan uca test | Login'den siparis tamamlamaya kadar kullanici akisini dogrular. |

## 5. Test Ortami

| Bilesen | Deger |
|---|---|
| Java | JDK 17 |
| Build araci | Maven |
| Browser | Chrome |
| Otomasyon | Selenium WebDriver |
| BDD | Cucumber |
| Test framework | TestNG |
| CI/CD | GitHub Actions |

## 6. Giris ve Cikis Kriterleri

### Giris Kriterleri

- SauceDemo uygulamasi erisilebilir olmalidir.
- Test kullanici bilgileri calisir durumda olmalidir.
- Java 17 ve Maven kurulu olmalidir.
- Maven bagimliliklari indirilebilir olmalidir.
- Feature dosyalari hazir olmalidir.

### Cikis Kriterleri

- Kritik login, cart ve checkout senaryolari basariyla kosulmalidir.
- HTML test raporu uretilmelidir.
- GitHub Actions pipeline'i testleri calistirmalidir.
- Basarisiz senaryolar raporlanmalidir.

## 7. Riskler

| Risk | Etki | Olasilik | Onlem |
|---|---:|---:|---|
| Demo sitenin erisilememesi | Yuksek | Orta | Testler daha sonra tekrar calistirilir. |
| UI locator degisikligi | Orta | Dusuk | Page Object Model ile locator bakimi kolaylastirilir. |
| CI ortaminda browser problemi | Yuksek | Orta | Headless Chrome argumanlari kullanilir. |
| Internet baglanti problemi | Orta | Orta | Test tekrar kosumu yapilir. |
| Kirilgan test adimlari | Orta | Orta | Explicit wait kullanilir. |

## 8. Takvim

| Aktivite | Sure |
|---|---:|
| Test plani hazirlama | 1 gun |
| Gherkin senaryolari yazma | 1 gun |
| Maven proje yapisi kurma | 1 gun |
| Page Object ve step class'lari yazma | 2 gun |
| Lokal test ve hata duzeltme | 1-2 gun |
| GitHub Actions pipeline hazirlama | 1 gun |
| Teslim kontrolu | 1 gun |
