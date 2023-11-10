package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LcwPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class LCW extends TestBaseRapor {

    LcwPages LcwPages = new LcwPages(); //Locate sayfasi.
    Actions actions = new Actions(Driver.getDriver());


    @BeforeTest
    public void adress(){

        extentTest = extentReports.createTest("LcWaikiki sayfasinda sepete ürün ekleme.", "Kullanicinin LcWaikiki sayfasinda sepetine ürün ekleyebildigi dogrulanmali.");

        //https://www.lcwaikiki.com/tr-TR/TR adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("lcwUrl"));
        Driver.getDriver().navigate().refresh();
        LcwPages.cookies.click();
        actions.moveByOffset(0,0).perform();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.lcwaikiki.com/tr-TR/TR"));
        extentTest.info("Kullanici LcWaikiki sayfasina gider.");
    }

    @Test
    public void lcwTest(){

        //Herhangi bir kategori sayfasına gidin.
        if (!LcwPages.ayakkabiKategorisi.isDisplayed()) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, 0)");

            LcwPages.ayakkabiKategorisi.click();
        }else {
            LcwPages.ayakkabiKategorisi.click();
        }
        if (!LcwPages.yeniSezonKadinAyakkabi.isDisplayed()) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, 0)");
            LcwPages.yeniSezonKadinAyakkabi.click();
        }else {
            LcwPages.yeniSezonKadinAyakkabi.click();
        }
        Assert.assertTrue(LcwPages.kadinYeniSezonAyakkabilarSayfasi.isDisplayed());
        extentTest.info("Kullanici herhangi bir kategori sayfasına gider");


        //Herhangi bir ürün sayfasına gidin.
        String UrunIsmi = LcwPages.yeniSezonKadinAyakkabisiOnuncuUrun.getText();
        LcwPages.yeniSezonKadinAyakkabisiOnuncuUrun.click();
        Assert.assertTrue(LcwPages.acilanUrununIsmi.getText().contains(UrunIsmi));
        extentTest.info("Kullanici herhangi bir ürün sayfasına gider.");



        // Ürünü sepete ekleyin.

        try {
            Driver.getDriver().navigate().refresh();//tükenen ürünler varsa çıkan ürün tükendi pop-up ının önüne geçmek için.

            LcwPages.bedenSecenegiBir.click();

            if (LcwPages.gelinceHAberVer.isDisplayed()) {
                LcwPages.bedenSecenegiIki.click();
                if (LcwPages.gelinceHAberVer.isDisplayed()) {
                    LcwPages.bedenSecenegiUc.click();
                }
            }

            LcwPages.sepeteEkleButonu.click();
            ReusableMethods.wait(4);

            String dropdownText = LcwPages.urunSepeteEklendiBilgisi.getText();
            Assert.assertTrue(dropdownText.contains("Sepetinize 1 adet ürün eklenmiştir."));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test başarısız! Sepete ürün eklenirken bir hata oluştu.");
        }



        // Sepet sayfasına gidin.
        LcwPages.sepetimButonu.click();
        String sepetSayfasindakiUrun = LcwPages.sepettekiUrunInfo.getText();
        String sepeteEklenenUrun = LcwPages.urunSepeteEklendiBilgisi.getText();
        Assert.assertTrue(sepetSayfasindakiUrun.contains(sepeteEklenenUrun)); //eklenmek istenen ürün ve sepetteki ürün aynı mı.
        extentTest.info("Kullanici sepetim sayfasina gider.");



        // Anasayfaya geri dönün.
        LcwPages.lcwBaslik.click();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://www.lcwaikiki.com/tr-TR/TR";
        Assert.assertTrue(expectedUrl.equals(actualUrl));
        extentTest.info("Kullanici anasayafaya geri döner.");

    }

    @AfterTest
    public void kapat(){
        //Driverı kapatın.
        Driver.closeDriver();
    }
}
