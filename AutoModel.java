package AutoTrader;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AutoModel {
	//private WebDriver webDriver;
	//Actions a = new Actions(webDriver);
	
	@FindBy(id = "postcode")
	private WebElement inputPostcode;
	
	@FindBy(id = "radius")
	private WebElement inputDistance;
	
	@FindBy(css = "#searchVehicles > div > div.global__quicksearchform--tickboxes.cf > fieldset.checkfieldused > label")
	private WebElement typeUsed;
	
	@FindBy(css = "#searchVehicles > div > div.global__quicksearchform--tickboxes.cf > fieldset.checkfieldnearlynew > label")
	private WebElement typeNearlyNew;
	
	@FindBy(css = "#searchVehicles > div > div.global__quicksearchform--tickboxes.cf > fieldset.checkfieldbrandnew > label")
	private WebElement typeNew;	

	@FindBy(id = "searchVehiclesMake")
	private WebElement inputMake;
	
	@FindBy(id = "searchVehiclesModel")
	private WebElement inputModel;
	
	@FindBy(id = "searchVehiclesPriceFrom")
	private WebElement inputMinPrice;
	
	@FindBy(id = "searchVehiclesPriceTo")
	private WebElement inputMaxPrice;
	
	@FindBy(id = "search")
	private WebElement searchButton;
	
	@FindBy(css = "#home > header > nav.site-header__other-vehicles.js-peek-nav.is-active > ul > li:nth-child(4)")
	private WebElement searchBikes;
	
	@FindBy(css = "#js-header-nav > ul > li:nth-child(3) > a > span")
	private WebElement reviews;
	
	@FindBy(css = "#top-nav__reviews > li:nth-child(1) > a")
	private WebElement LatestReviews;
	
	@FindBy(css = "body > main > section.content-page__main.cf > article.article2.review-page--review-all-article.cf > span.review-page--review-all-text.cf > h2 > a")
	private WebElement StudentReviews;
	
	@FindBy(name = "make")
	private WebElement inputBikeMake;
	
	@FindBy(name = "model")
	private WebElement inputBikeModel;
	
	@FindBy(name = "cc-from")
	private WebElement inputCCFrom;
	
	@FindBy(name = "cc-to")
	private WebElement inputCCTo;
	
	
	
	
	public void inputMinCC(String CC){
		inputCCFrom.click();
		inputCCFrom.sendKeys(CC, Keys.RETURN);
	}
	
	public void inputMaxCC(String CC){
		inputCCTo.click();
		inputCCTo.sendKeys(CC, Keys.RETURN);
	}
	
	
	public void inputBikeMake(String make){
		inputBikeMake.click();
		inputBikeMake.sendKeys(make, Keys.RETURN);
	}
	
	public void inputBikeModel(String model){
		inputBikeModel.click();
		inputBikeModel.sendKeys(model, Keys.RETURN);
	}
	
	
	public void clickStudentReviews(){
		StudentReviews.click();
	}
	
	public void clickLatestReviews(){
		LatestReviews.click();
	}
	
	public void clickReviews(){
		reviews.click();
	}
	
	public void searchBikesClick(){
		searchBikes.click();
	}
	
	public void inputPostcode(String postcode){
		inputPostcode.click();
		inputPostcode.sendKeys(postcode);
	}
	
	public void inputDistance(String distance){
		inputDistance.click();
		Select s = new Select(inputDistance);
		s.selectByValue(distance);
	}
	
	public void checkUsed(){
		typeUsed.click();
	}
	
	public void checkNearlyNew(){
		typeNearlyNew.click();
	}
	
	public void checkNew(){
		typeNew.click();
	}
	
	public void inputMake(String make){
		inputMake.click();
		inputMake.sendKeys(make, Keys.RETURN);
	}
	
	public void inputModel(String model){
		inputModel.click();
		inputModel.sendKeys(model, Keys.RETURN);
	}
	
	public void inputMinPrice(String price){
		inputMinPrice.click();
		inputMinPrice.sendKeys("from £"+price, Keys.RETURN);
	}
	
	public void inputMaxPrice(String price){
		inputMaxPrice.click();
		inputMaxPrice.sendKeys("to £"+price, Keys.RETURN);
	}
	
	public void clickSearch(){
		searchButton.click();
	}
	
}
