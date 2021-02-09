package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasketPage extends BasePage{

//span[contains(@class, 'base-ui-radio-button__icon')]
    //Проверка гарантии
    @FindBy(xpath = "//span[contains(@class, 'base-ui-radio-button__icon')]")
    private List<WebElement> guaranteeSelect;
    //Стоимость корзины
    @FindBy(xpath = "//span[@class='price__current']")
    private List<WebElement> checkCostProducts;
    //Элементы товаров в корзине
    @FindBy(xpath = "//div[@data-cart-product-id]")
    private List<WebElement> listCardProduct;
    //Наименования товаров в корзине
    @FindBy(xpath = "//a[@class='cart-items__product-name-link']")
    private List<WebElement> listOfProductsInBasket;
    //Стоимость корзины
    @FindBy(xpath = "//span[@class='cart-link__price']")
    private WebElement costBasketAfterDlt;
    //Плюсик для добавления товара
    @FindBy(xpath = "//i[@class='count-buttons__icon-plus']")
    private WebElement plusForEnhanceProduct;
    //Счетчик товаров в корзине
    @FindBy(xpath = "//input[@class='count-buttons__input']")
    private WebElement productCounter;
    //Стоимость консолей х3
    @FindBy(xpath = "//div[@class='cart-items__product-block-amount']")
    private WebElement consoleCost;
    //Второй клик по плюсику
    @FindBy(xpath = "//i[@class='count-buttons__icon-plus']")
    private WebElement zalupadlyaTesta;
    //Проверка стоимости 3-ёх консолей
    @FindBy(xpath = "//div[@class='cart-items__product-block-amount']//span[@class='price__current']")
    private WebElement checkCost3PS;
    //Вернуть удалённый товар
    @FindBy(xpath = "//span[contains(@class, 'group')]//span[contains(@class, 'restore')]")
    private WebElement returnDlt;
    //Сумма корзины после всех покупок с гарантией
    @FindBy(xpath = "//div[@class='total-amount-block total-amount__info-block']//span[@class='price__current']")
    private WebElement totalAmount;




    public BasketPage checkGuaranteeType() {
        for (WebElement elem : guaranteeSelect) {
            if (elem.getText().equalsIgnoreCase("+ 24 мес.")) {
                elem.getAttribute("isConnected").equalsIgnoreCase("true");
                System.out.println(elem.getText());
                return this;
            }
        }
        Assert.fail("Выбрана неверная гарантия");
        return this;
    }

    public BasketPage checkCostOfProducts() {
        ArrayList<Integer> list = new ArrayList();
        ArrayList<Integer> list1 = new ArrayList();
        list1.add(OpenPsPage.beforeCost);
        list1.add(ChooseGame.totalCost);
        list1.add(ChooseGame.gameCost);

        for (WebElement elem: checkCostProducts) {
            System.out.println(elem.getText().substring(0,6).replaceAll(" ", ""));
            list.add(Integer.parseInt(elem.getText().substring(0,6).replaceAll(" ", "")));
        }
        Collections.sort(list);
        Collections.sort(list1);
        if (list.equals(list1)) {
            return this;
        }
        System.out.println(list);
        System.out.println(list1);
        Assert.fail("Некорректная стоимость товаров в корзине");
        return this;
    }
      public BasketPage dltProductInCartByName(String nameProduct) {
        WebElement name;
        WebElement dltElem;
        for (WebElement elem : listCardProduct) {
            name = elem.findElement(By.xpath(".//div[@class='cart-items__product-name']/a"));
            if (name.getText().contains(nameProduct)) {
                dltElem = elem.findElement(By.xpath(".//button[.='Удалить']"));
                dltElem.click();
                /*try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                return this;
            }
        }
        Assert.fail("Такой продукт с наименованием " + nameProduct + " не найден в корзине");
        return this;
    }

    public BasketPage checkDltGameFromBasket(String productName) {
        for(WebElement elem : listOfProductsInBasket) {
            if (!elem.getText().equalsIgnoreCase(productName)) {
                return this;
            }
        }
        Assert.fail("Продукт с наименованием " + productName + "не был удалён" );
        return this;
    }

    public BasketPage checkCostBasketAfterDlt(String costValue) {
        attributeToBe(costBasketAfterDlt, "textContent", costValue);
        if (costBasketAfterDlt.getText().substring(0,6).replaceAll(" ", "").
                equalsIgnoreCase(OpenPsPage.afterCost.toString())) {
            return this;
        }
        Assert.fail("Некорректная стоимость товаров в корзине");
        return this;
    }

    public BasketPage enhanceQuantityProduct(){
        plusForEnhanceProduct.click();
        attributeToBe(productCounter, "value", "2");
        zalupadlyaTesta.click();
        attributeToBe(productCounter, "value", "3");
        //if (productCounter.getAttribute("value").equalsIgnoreCase("3")) {
        System.out.println(productCounter.getAttribute("value"));
        return this;
    }

    public BasketPage costConsole() {
        /*System.out.println("Стоимость трёх консолей " + consoleCost.findElement(By.xpath(".//span[@class='price__current']"))
                .getText().substring(0,6).replaceAll(" ", "").
                equalsIgnoreCase(OpenPsPage.afterCost.toString()));*/
        System.out.println(checkCost3PS.getText());
        return this;
    }

    public BasketPage returnDltProduct(String productName) {
        returnDlt.click();
        attributeToBe(productCounter, "value", "2");
        for(WebElement elem : listOfProductsInBasket) {
            if (elem.getText().equalsIgnoreCase(productName)) {
                checkCostBasketAfterDlt(productName);
                return this;
            }
        }
        Assert.fail("Продукт с наименованием " + productName + "не возвращен в корзину" );
        return this;
    }
    public BasketPage totalAmountBasket(String basketCostAtTheLast) {
        if (totalAmount.getText().equalsIgnoreCase(basketCostAtTheLast)) {
            return this;
        }
        Assert.fail("Стоимость корзины не соотвествует ожидаемой = " + basketCostAtTheLast);
        return this;
    }
}
