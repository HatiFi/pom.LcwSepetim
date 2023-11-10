package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LcwPages {
    public LcwPages(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//*[@id='cookieseal-banner-accept']")
    public WebElement cookies;

    @FindBy(xpath = "//*[@href=\"https://www.lcwaikiki.com/tr-TR/TR/lp/kadin-erkek-cocuk-bebek-ayakkabi\"]")
    public WebElement ayakkabiKategorisi;

    @FindBy(xpath = "(//*[@class='sc4lu-content'])[1]")
    public WebElement yeniSezonKadinAyakkabi;

    @FindBy(xpath = "//*[@class='product-list-heading__heading']")
    public WebElement kadinYeniSezonAyakkabilarSayfasi;

    @FindBy(xpath = "(//*[@class='product-card__title'])[8]")
    public WebElement yeniSezonKadinAyakkabisiOnuncuUrun;

    @FindBy(xpath = "(//*[@class='product-title'])[2]")
    public WebElement acilanUrununIsmi;

    @FindBy(xpath = "(//*[@data-tracking-label='BedenSecenekleri'])[1]")
    public WebElement bedenSecenegiBir;

    @FindBy(xpath = "(//*[@data-tracking-label='BedenSecenekleri'])[2]")
    public WebElement bedenSecenegiIki;

    @FindBy(xpath = "(//*[@data-tracking-label='BedenSecenekleri'])[3]")
    public WebElement bedenSecenegiUc;


    @FindBy(xpath = "//*[@data-tracking-label='GelinceHaberVer']")
    public WebElement gelinceHAberVer;

    @FindBy(xpath = "//*[@class='add-to-cart button-link add-to-cart-button']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "(//*[@class='drop-down-menu__wrapper'])[3]")
    public WebElement urunSepeteEklendiBilgisi;

    @FindBy(xpath = "//*[@class='badge-circle']")
    public WebElement sepetimButonu;

    @FindBy(xpath = "(//*[@xmlns='http://www.w3.org/2000/svg'])[1]")
    public WebElement lcwBaslik;

    @FindBy (xpath = "//*[@class='rd-cart-item-main-info pl-15']")
    public WebElement sepettekiUrunInfo;

}
