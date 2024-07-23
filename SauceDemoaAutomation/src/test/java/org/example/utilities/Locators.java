
package org.example.utilities;
import org.openqa.selenium.By;

public class Locators {

 public static final By loginButtonLocator = By.id("lnkGiris");
 public static final By homeLoadSuccessElementLocator = By.xpath("//a[@id='lnkGiris']/b");
 public static final By eDevletButtonLocator = By.xpath("//a[@href='/Portal/KullaniciIslemleri/EDevletGiris']");
 public static final By userTcLocator = By.xpath("//input[@name='tridField']");
 public static final By userPasswordLocator = By.cssSelector("input[name='egpField']");
 public static final By loginSubmitButtonLocator = By.cssSelector("button[name='submitButton']");
 public static final By userSuccessLoginVerifyElementLocator = By.xpath("//h3[@class='page-header']");
 public static final By establishmentApplicationLocator = By.xpath("//*[contains(text(),'Kuruluş Başvurusu')]");
 public static final By establishmentApplicationVerifyLocator = By.xpath("//div[contains(text(),'Kuruluş Başvurusu')]");
 public static final By anonimCompanyLocator = By.xpath("//*[contains(text(),'Anonim Şirket')]");
 public static final By anonimCompanyLocatorVerifyLocator = By.xpath("//*[contains(text(),'Anonim Şirket')]");
 public static final By neviAltTurLocator = By.cssSelector("select[name='FirmaNeviId']");
 public static final By neviIlLocator = By.xpath("//select[@name='IlId']");
 public static final By neviIlceLocator = By.xpath("//select[@name='IlceId']");
 public static final By neviSubmitButtonLocator = By.xpath("//input[@value='İleri']");
 public static final By detayWaitLocator = By.xpath("//h3[@class='panel-title']");
 public static final By paySahibiMenuButtonLocator = By.id("form1");
 public static final By paySahibiCreateButtonLocator = By.xpath("//*[@id='divGercekOrtakListesi']/div/button");
 public static final By secilenKisiTcLocator = By.xpath("//div[@id='SecilenKisi_divYKTCKimlikNoIleAra']//input[@id='SecilenKisi_txtYKTCKimlikNo']");
 public static final By secilenKisiSeriNoLocator = By.xpath("//input[@name='SecilenKisi.YKSeri']");
 public static final By kpsButtonLocator = By.xpath("//button[@id='SecilenKisi_btnYKTCKimlikNoIleKisiAra']");
 public static final By KpsSaveButtonLocator = By.xpath("//button[contains(text(),'Kaydet')]");
 //public static final By modalLocator = By.id("modalContainer");
 public static final By unvanMenuButtonLocator = By.id("form2");
 public static final By rezervButtonLocator = By.xpath("//*[@id='divAnaIcerik']/div[2]/div/button");
 public static final By unvanEkiInputLocator = By.cssSelector("[name='KokUnvan']");
 public static final By unvanKonuLocator = By.cssSelector("[name='Konu']");
 public static final By unvanRezervSubmitLocator = By.cssSelector("[title='Rezerv Et']");
 public static final By adresMenuButtonLocator = By.id("form3");
 public static final By adresCreateButtonLocator = By.xpath("//*[@id='divIletisimIslemleri']/div[1]/div/div/div/div[1]/div/button");
 public static final By adresMahalleLocator = By.xpath("//*[@id='MahalleId']");
 public static final By adresCaddeLocator = By.xpath("//*[@id='CsbmId']");
 public static final By adresDisKapiNoLocator = By.xpath("//*[@id='cmbDisKapiNo']");
 public static final By adresİcKapiNoLocator = By.xpath("//*[@id='cmbIcKapiNo']");
 public static final By adresSaveLocator = By.xpath("//*[@id='yurtIciAdresKaydet']");
 public static final By adresIletisimCreateButtonLocator = By.xpath("//*[@id='divIletisimIslemleri']/div[2]/div/div/div/div[1]/div/button");
 public static final By adresIletisimTuruLocator = By.xpath("(//*[@id='IletisimTuruId'])[1]");
 public static final By adresIletisimDegerLocator = By.xpath("(//*[@id='Deger'])[1]");
 public static final By adresSaveIletisimButtonLocator = By.xpath("//*[@id='btnIletisimEkle']");
 public static final By amacKonuMenuButtonLocator = By.id("form4");
 public static final By amacKonuCreateButtonLocator = By.xpath("//*[@id='divAnaIcerik']/div[1]/div/button[2]");
 public static final By amacKonuInputLocator = By.id("Icerik");
 public static final By amacKonuSaveButtonLocator = By.xpath("//*[@id='form0']/div/div[2]/div/button[2]");
 public static final By naceKoduMenuButtonLocator = By.id("form5");
 public static final By naceCreateButtonLocator = By.xpath("//*[@id='btnNaceEkle']");
 public static final By naceKoduInputLocator = By.cssSelector("[name='Kodu']");
 public static final By naceTanimiInputLocator = By.cssSelector("[name='Tanimi']");
 public static final By naceSearchButtonLocator = By.id("btnNaceAra");
 public static final By naceToolTipLocator = By.xpath("//*[@id='gridNaceKoduArama']/tbody/tr[1]/td[3]/button");
 public static final By naceCloseModalLocator = By.xpath("//*[@id='modalDialog']/div/div[1]/button");
 public static final By naceAnaFaaliyetLocator = By.xpath("//*[@id='gridNaceKoduIslemleri']/tbody/tr/td[4]/button[1]");
 public static final By naceDeleteButtonLocator = By.id("btnNaceKoduSil");
 public static final By sermayeMenuButtonLocator = By.id("form6");
 public static final By sermayeCreateButtonLocator = By.xpath("//*[@id='divAnaIcerik']/div/div/div/input");
 public static final By toplamSermayeInputButtonLocator = By.cssSelector("[name='ToplamSermaye']");
 public static final By toplamNamaYaziliPayAdediInputButtonLocator = By.cssSelector("[name='ToplamNamaYaziliPayAdedi']");
 public static final By sermayeSaveButtonLocator = By.id("btnSermayeKaydet");
 public static final By sermayeUpdateButtonLocator = By.xpath("//*[@id='divAnaIcerik']/div/div[2]/div/div[1]/div/button");
 public static final By sermayeDeleteButtonLocator = By.xpath("//*[@id='divAnaIcerik']/div/div[1]/div/button");
 public static final By payMenuButtonLocator = By.id("form7");
 public static final By payDagitimButtonLocator = By.xpath("//*[@id='grid_GercekOrtak']/tbody/tr/td[7]/button");
 public static final By payNakdiSermayeLocator = By.cssSelector("[name='NakdiSermaye']");
 public static final By namaYaziliPayAdediLocator = By.cssSelector("[name='NamaYaziliHisseAdedi']");
 public static final By odenmisSermayeLocator = By.cssSelector("[name='OdenmisSermaye']");
 public static final By payDagitimBilgileriSaveLocator = By.xpath("//*[@id='formSermayeKaydet']/div/div[7]/div/input");
 public static final By payDagitimDeleteButtonLocator = By.xpath("//button[@title='Payı kaldır']");
 public static final By odemeyeAliskinAciklamaCreateButtonLocator = By.xpath("//*[@id='divAnaIcerik']/div[2]/div[2]/div/button");
 public static final By odemeyeIliskinAciklamaInputButtonLocator = By.cssSelector("[name='Icerik']");
 public static final By odemeyeİliskinSaveButtonLocator = By.xpath("//*[@id='form0']/div/div[2]/div/button[2]");
 public static final By sureMenuButtonLocator = By.id("form8");
 public static final By sureCreateButtonLocator = By.xpath("//*[@id='divAnaIcerik']/div[1]/div/button");
 public static final By sinirsizSureCheckboxLocator = By.xpath("//input[@type='checkbox']");
 public static final By sureSaveButtonLocator = By.xpath("//*[@id='divSureKaydet']/div[3]/div/button[2]");
 public static final By denetciMenuButtonLocator = By.id("form9");
 public static final By denetciCreateButtonLocator = By.xpath("//*[@id='tabDenetimUyeleri']/div/div/div[1]/div/div/button");
 public static final By denetciGercekKisiLocator = By.xpath("(//*[@id='KisiTuru'])[1]");
 public static final By denetciTuzelKisiLocator = By.xpath("((//*[@id='KisiTuru'])[2]");
 public static final By denetciModalCloseButtonLocator = By.xpath("(//button[@class='close'])[6]");
 public static final By denetciGercekKisiCreateLocator = By.xpath("//*[@id='KisiAraModel_txtYKTCKimlikNo']");
 public static final By denetciGercekKisiTcLocator = By.xpath("//*[@id='KisiAraModel_txtYKTCKimlikNo']");
 public static final By denetciGercekKisiSeriNoLocator = By.xpath("//*[@id='KisiAraModel_txtYKSeri']']");
 public static final By kpsQueryButtonLocator = By.xpath("//*[@id='KisiAraModel_btnYKTCKimlikNoIleKisiAra']");
 public static final By faaliyetBaslangicTarihiButtonLocator = By.xpath("//*[@id='KisiAraModel_btnYKTCKimlikNoIleKisiAra']");
 public static final By faaliyetBitisTarihiButtonLocator = By.xpath("[name='FaaliyetDonemiBitisTarihi']']");
 public static final By DenetciDeleteButtonLocator = By.xpath("//*[@id='grdDenetimUye']/tbody/tr[1]/td[6]/button]']");
 public static final By yonetimMenuButtonLocator = By.id("form10");
 public static final By yonetimCreateButtonLocator =By.xpath("//*[@id='divAnaIcerik']/div/div/div[1]/div/button");
 public static final By yonetimuyeSayisiButtonLocator = By.id("[name='UyeSayisiTipi']");
 public static final By yonetimGorevSuresiEnAzButtonLocator = By.cssSelector("[name='GorevSuresiYilEnAz']");
 public static final By yonetimGorevSuresiEnCokButtonLocator = By.cssSelector("[name='[name='GorevSuresiYilEnCok']']");
 public static final By yonetimSecilenIlkYonKuruluButtonLocator = By.cssSelector("[name='SecilenKurulGorevSuresi']");
 public static final By yonetimKuruluBilgisiSaveButtonLocator = By.xpath("//*[@id='frmSureSayiKayitYonetim']/div/div[7]/div/button[2]");
 public static final By yonetimKuruluPaySahibiUyeEkleButtonLocator = By.xpath("//*[@id='tabYonetimKuruluUyeleri']/div/div/div[1]/div/div/button[1]");
 public static final By yonetimPaySahibiGercekKisiCreateButtonLocator = By.cssSelector("button[title='Ekle']");
 public static final By yonetimTemsileYetkiliLocator = By.xpath("(//*[@id='tabList']/li[2]/a");
 public static final By yonetimUyelerdenYetkiliCreateButtonLocator = By.xpath("//*[@id='tabYetkilileri']/div/div/div[1]/div/div/button[1]");
 public static final By yonetimYetkiSekliButtonLocator = By.xpath("//*[@id='YetkiSekli-8140661']");
 public static final By yonetimYetkiSuresiButtonLocator = By.xpath("//*[@id='YetkiSuresi-8140661']");
 public static final By uyelerdenYetkiliToolTipButtonLocator = By.xpath("//*[@id='grdYonetimKuruluUyeListesi']/tbody/tr/td[7]/button");
 public static final By uyelerdenYetkiliModalCloseLocator = By.xpath("//*[@id='modalDialog']/div/div[1]/button");
 public static final By eBildirgeMenuButtonLocator = By.id("form19");
 public static final By eBildirgeTercihCheckboxLocator = By.xpath("(//input[@name='TercihTur'])[2]");
 public static final By yetkiliIletisimMenuButtonLocator = By.id("form20");
 public static final By yetkiliIletisimToolTipButtonLocator = By.xpath("//*[@id='grdYonetimKuruluYetkili']/tbody/tr/td[5]/button");
 public static final By yetkiliIletisimTelInputLocator = By.xpath("//*[@id='TelNo']");
 public static final By yetkiliIletisimEpostaInputLocator = By.xpath("//*[@id='EpostaAdresi']");
 public static final By yetkiliIletisimSaveButtonLocator = By.id("btnIletisimEkle");
 public static final By imzaBeyaniMenuButtonLocator = By.id("form21");
 public static final By imzaBeyaniOnayCheckBoxLocator = By.xpath("//*[@id='chkYeniKimlikUyariOnay']");




}
