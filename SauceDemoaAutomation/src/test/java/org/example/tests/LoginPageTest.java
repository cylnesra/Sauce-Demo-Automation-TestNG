package org.example.tests;
import org.example.dataprovider.JsonDataProvider;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginAndHomePageTest extends BaseTest {


    @Test(priority = 1,
            description = "Ana sayfanın başarıyla yüklenme işleminin doğrulanması")
    public void verifyHomePageLoadsSuccessfullyTest() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(baseUrl);
        Assert.assertEquals(loginPage.homePageLoadSuccessVerify(), "Giriş");
    }

    @Test(priority = 2,
            description = "Kullanıcının giriş işlemlerinin doğrulanması",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void loginClickSuccessTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.isDisplayedLoginClick(), "Giriş butonuna tıklanılamadı!");
        Thread.sleep(2000);

    }

    @Test(priority = 3,
            description = "Kullanıcı e-Devlet üzerinden giriş işlemlerinin doğrulanması",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void eDevletButtonClickTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(3000);
        loginPage.eDevletClick();
        Thread.sleep(3000);
        //Assert.assertTrue(loginPage.isDisplayedEdevletClick(),"E-Devlet butonuna tıklanılamadı!");
    }

    @Test(priority = 4,
            description = "Kullanıcı oturum açma işlemlerinin doğrulanması",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest",
            dataProvider = "combinedDataProvider", dataProviderClass = JsonDataProvider.class)
    public void userLoginTest(Map<String, Object> combinedData) {
        String userTc = (String) combinedData.get("tcKimlikNo");
        String userPassword = (String) combinedData.get("eDevletSifresi");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.setUserTc(userTc);
        Assert.assertEquals(userTc, loginPage.getUserTc(), "T.C No değeri doğru değil!");
        System.out.println(loginPage.getUserTc());

        loginPage.setUserPassword(userPassword);
        Assert.assertEquals(userPassword, loginPage.getUserPassword(), "E-Devlet şifre değeri doğru değil!");
        System.out.println(loginPage.getUserPassword());

        loginPage.submitButtonClick();

        HomePage homePage = new HomePage(driver);
        homePage.establishmentApplicationClick();

    }

    @Test (priority = 5,
            description = "Nevi seçimi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void neviSecimiTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(3000);
        homePage.anonimCompanyClick();
        Thread.sleep(3000);

        // Assert.assertEquals(homePage.anonimCompanyClickVerify(),"Anonim Şirket");
        //System.out.println(homePage.anonimCompanyClickVerify());
    }

    @Test (priority = 6,
            description = "Nevi Alt Tür Seçimi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void neviAltTurTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.neviSelectAltTur();
        Thread.sleep(2000);
        homePage.optionSelectNeviAltTur("TEK PAY SAHİPLİ ANONİM ŞİRKET");
        Thread.sleep(2000);
        homePage.optionNeviAltTurClick();
        Thread.sleep(2000);
    }

    @Test (priority = 7,
            description = "Nevi İl Seçimi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void neviIlTest(){
        HomePage homePage = new HomePage(driver);
        homePage.optionSelectNeviIl("ANKARA");
        homePage.optionSelectNeviIlClick();
    }

    @Test (priority = 8,
            description = "Nevi İlçe Seçimi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void neviIlceTest(){
        HomePage homePage = new HomePage(driver);
        homePage.optionSelectNeviIlce("ÇANKAYA");
        homePage.optionSelectNeviIlceClick();
    }

    @Test (priority = 9,
            description = "Nevi Seçimini Kaydetme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NeviSecimiSubmit(){
        HomePage homePage = new HomePage(driver);
        homePage.neviSubmitClick();
    }

    @Test (priority = 10,
            description = "Ortak Butonunun Tıklanılabilir Olması İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void OrtakButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.jsScrollPage();
        Thread.sleep(2000);
        homePage.paySahibiButtonClick();
    }

    @Test (priority = 11,
            description = "Ortak Ekleme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void OrtakCreateTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.paySahibiCreateButtonClick();
    }

    @Test  (priority = 12,
            description = "Ortak Tc Bilgisi Ekleme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
           // dataProvider = "userCredentialsProvider",dataProviderClass = JsonDataProvider.class)
    public void OrtakTcValueTest() throws InterruptedException {
        //String userTc = (String) userData.get("tcKimlikNo");
        HomePage homePage = new HomePage(driver);
        Thread.sleep(3000);
        homePage.setSecilenKisiTc("11479251572");
        Thread.sleep(2000);
    }

    @Test  (priority = 13,
            description = "Ortak Seri No Bilgisi Ekleme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
           // dataProvider = "userCredentialsProvider",dataProviderClass = JsonDataProvider.class)
    public void OrtakSeriNoValueTest() throws InterruptedException {
        //String userSeriNo = (String) userData.get("seriNo");
        HomePage homePage = new HomePage(driver);
        Thread.sleep(3000);
        homePage.setSecilenKisiSeriNo("A25R58139");
        Thread.sleep(2000);
    }

    @Test  (priority = 14,
            description = "Kullanıcıyı Kps'den Sorgulama İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void KpsQueryTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.kpsClick();
        Thread.sleep(3000);
    }

    @Test  (priority = 15,
            description = "Ortak Bilgilerinin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void OrtakBilgileriKayıtTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.kpsSaveButtonLocator();
        Thread.sleep(3000);
    }

    @Test (priority = 16,
            description = "Unvan Butonunun Tıklanılabilir Olması İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void UnvanButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.unvanButtonClick();
    }

    @Test (priority = 17,
            description = "Unvan Ekleme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void UnvanCreateTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.unvanRezervCreateButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 18,
            description = "Unvan Eki Ekleme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest",
            dataProvider = "combinedDataProvider", dataProviderClass = JsonDataProvider.class)
    public void UnvanEkiTest(Map<String, Object> combinedData) throws InterruptedException {
        String uniqueUnvanEki = new JsonDataProvider().uniqueDataProvider()[0][0].toString();
        if (combinedData != null) {
            if (uniqueUnvanEki != null) {
                combinedData.put("unvan", uniqueUnvanEki);
                HomePage homePage = new HomePage(driver);
                Thread.sleep(2000);
                homePage.setUnvanEki(uniqueUnvanEki);
                System.out.println("Unvan Eki: " + uniqueUnvanEki);
            } else {
                System.out.println("uniqueUnvanEki is null");
            }
        } else {
            System.out.println("combinedData is null");
        }
    }

    @Test (priority = 19,
            description = "Unvan Konu Ekleme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void UnvanKonuTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.optionSelectUnvanKonu("ACENTE");
    }

    @Test (priority = 20,
            description = "Belirlenen Unvanın Rezerv Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void UnvanSaveRezervTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.rezervButtonClick();
        Thread.sleep(2000);
    }

    @Test (priority = 21,
            description = "Adres Butonunun Tıklanılabilir Olması İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AdresButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.adresButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 22,
            description = "Adres Ekleme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AdresCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(4000);
        homePage.adresCreateButtonClick();
        Thread.sleep(4000);
        homePage.optionSelectAdresMahalle("AHLATLIBEL Mahallesi");
        Thread.sleep(4000);
        homePage.optionSelectAdresCadde("AHLATLIBEL MEVKİ KÜME EVLER");
        Thread.sleep(4000);
        homePage.optionSelectAdresDisKapiNo("2 - Kamu - Bina Ana Giriş");
        Thread.sleep(4000);
        homePage.optionSelectAdresİcKapiNo("- Ofis ve İşyeri - 1459304307");
        Thread.sleep(4000);
    }

    @Test (priority = 23,
            description = "Adres Bilgilerinin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AdresSaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.adresSaveButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 24,
            description = "Adres Ekranında İletişim Ekle Butonunun Tıklanılabilir Olması İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AdresIletisimButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.adresIletisimCreateButtonClick();
        Thread.sleep(2000);
    }

    @Test (priority = 25,
            description = "Dropdowndan Cep Tel Seçeneğini Seçme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AdresIletisimOptionCepTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.optionSelectAdresIletisimCep("Cep Tel");
        Thread.sleep(2000);
        homePage.setIletisimDegeri("0(551)-818-65-18");
        Thread.sleep(2000);
        homePage.adresIletisimSaveButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 26,
            description = "Adres Ekranında İletişim Ekle Butonunun Tıklanılabilir Olması İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AdresIletisim2ButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.adresIletisimCreateButtonClick();
        Thread.sleep(2000);
        homePage.optionSelectAdresIletisimMail("E Posta");
        Thread.sleep(2000);
        homePage.setIletisimDegeri("a@gmail.com");
        Thread.sleep(2000);
        homePage.adresIletisimSaveButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 27,
            description = "Amaç Konu Butonunun Tıklanabilir Olması İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AmacKonuButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.amacKonuButtonClick();
        Thread.sleep(2000);
    }

    @Test (priority = 28,
            description = "Amaç Ekle / Güncelle Butonunun Tıklanabilir Olması İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AmacKonuCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.amacKonuCreateButtonClick();
        Thread.sleep(2000);
    }

    @Test (priority = 29,
            description = "Amaç Konu Alanına İçerik Girilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AmacKonuSetValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.setAmacKonu("Bu bir testtir.");
        Thread.sleep(2000);
    }

    @Test (priority = 30,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void AmacKonuSaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.amacKonuSaveButtonClick();
        Thread.sleep(2000);

    }

    @Test (priority = 31,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NaceButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.naceKoduButtonClick();
        Thread.sleep(2000);
    }

    @Test (priority = 32,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NaceCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.naceKoduCreateButtonClick();
        Thread.sleep(2000);
    }

    @Test (priority = 33,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NaceSetValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.setNaceKodu("0");
        Thread.sleep(2000);
    }

    @Test (priority = 34,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NaceSearchValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.naceSearchButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 35,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NaceEkleTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(3000);
        homePage.naceToolTipButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 36,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NaceCloseTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.naceCloseButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 37,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NaceOptionAnaFaaliyetTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.naceAnaFaaliyetButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 38,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void SermayeButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(3000);
        homePage.sermayeButtonClick();
        Thread.sleep(3000);
    }

    @Test (priority = 39,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void SermayeCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.sermayeCreateButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 40,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void ToplamSermayeSetValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.setToplamSermaye("250000");
        Thread.sleep(5000);
    }

    @Test (priority = 41,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void ToplamNamaYaziliPayAdediValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.setPayAdedi("1");
        Thread.sleep(5000);
    }

    @Test (priority = 42,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void SermayeSaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.sermayeSaveButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 43,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void PayButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.payButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 44,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void PayCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.payDagitimClick();
        Thread.sleep(5000);
    }

    @Test (priority = 45,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void PayNakdiSermayeSetValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.setNakdiSermaye("250000");
        Thread.sleep(5000);
    }

    @Test (priority = 46,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void NamaYaziliPayAdediSetValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.setNamaYaziliPayAdedi("1");
        Thread.sleep(5000);
    }

    @Test (priority = 47,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void ÖdenmisSermayeSetValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.setOdenmisSermaye("250000");
        Thread.sleep(5000);
    }

    @Test (priority = 48,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void PaySaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.paySaveButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 49,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void PayÖdemeyeİliskinAciklamaButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.payÖdemeyeİliskinAciklamaButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 50,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void ÖdemeyeİliskinAciklamaCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.setÖdemeyeİliskinAciklama("testttt");
        Thread.sleep(5000);
    }

    @Test (priority = 51,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void ÖdemeyeİliskinAciklamaSaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.payÖdemeyeİliskinAciklamaSaveButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 52,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void SureButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.sureButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 53,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void SureCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.sureCreateButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 54,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void SinirsizSureCheckboxButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.sinirsizSureButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 55,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void SureSaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.sureSaveButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 56,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiliButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yonetimButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 57,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiliCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yonetimBilgiDuzenleButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 58,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiliGorevYilEnAzButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.optionSelectGorevSuresiYilEnAz("1");
        Thread.sleep(5000);
    }

    @Test (priority = 59,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiliGorevYilEnCokButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.optionSelectGorevSuresiYilEnCok("3");
        Thread.sleep(5000);
    }

    @Test (priority = 60,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiliYonetimKuruluButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.optionSelectIlkYonetimKuruluGorevSuresi("3");
        Thread.sleep(5000);
    }

    @Test (priority = 61,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiliSaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yonetimYetkiliSaveButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 62,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void PaySahibiUyeCreateButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.paySahibiUyeCreateButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 63,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void PaySahibiUyeToolTipButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.paySahibiUyeToolTipButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 64,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimTemsileYetkiliButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yonetimTemsileYetkiliTabButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 65,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimUyelerdenYetkiliButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yonetimUyelerdenYetkiliButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 66,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiSekliButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.optionSelectYetkiSekli("Münferiden Temsile Yetkilidir.");
        Thread.sleep(5000);
    }

    @Test (priority = 66,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiSuresiButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.optionSelectYetkiSuresi("1");
        Thread.sleep(5000);
    }

    @Test (priority = 67,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiToolTipButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yonetimUyelerdenYetkiliToolTipButtonClick();
        Thread.sleep(5000);
    }


    @Test (priority = 68,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void YonetimYetkiModalCloseTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yonetimUyelerdenYetkiliModalCloseClick();
        Thread.sleep(5000);
    }

    @Test (priority = 69,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void eBildirgeButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.eBildirgeButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 70,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void eBildirgeCheckBoxTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.eBildirgeCheckBoxClick();
        Thread.sleep(5000);
    }

    @Test (priority = 71,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void yetkiliIletisimButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yetkiliIletisimButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 72,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void yetkiliIletisimToolTipButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yetkiliIletisimToolTipClick();
        Thread.sleep(5000);
    }

    @Test (priority = 73,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void yetkiliIletisimSetTelValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yetkiliIletisimSetTel("0(515)-151-51-56");
        Thread.sleep(5000);
    }

    @Test (priority = 74,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void yetkiliIletisimSetEpostaValueTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yetkiliIletisimSetEposta("a@a.a");
        Thread.sleep(5000);
    }

    @Test (priority = 75,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void yetkiliIletisimSaveButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.yetkiliIletisimSaveButtonClick();
        Thread.sleep(5000);
    }

    @Test (priority = 76,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void imzaBeyaniButtonTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.imzaBeyaniButtonClick();
        Thread.sleep(5000);
    }


    @Test (priority = 77,
            description = "Amaç Konu Alanına Girilen Bilgilerin Kayıt Edilme İşlemi",
            dependsOnMethods = "verifyHomePageLoadsSuccessfullyTest")
    public void imzaBeyaniCheckBoxTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.imzaBeyaniOnayCheckBoxClick();
        Thread.sleep(5000);
    }




}
