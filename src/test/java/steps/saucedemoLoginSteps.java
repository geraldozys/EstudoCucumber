package steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class saucedemoLoginSteps {
	
	private WebDriver driver;

	
    @Before
    public void setup() {
        // Configurar o caminho do driver do Google Chrome
        System.setProperty("webdriver.gecko.driver", "D:\\Projeto Automação\\driver navegador\\chromedriver.exe");

        // Inicializar o WebDriver do Google Chrome
        driver = new ChromeDriver();
		driver.manage().window().maximize();

    }
	
	@Dado("que desejo realizar o login")
	public void queDesejoRealizarOLogin() throws Throwable {
		
		// Abrir o site https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
	    
	}

	@Quando("adiciono o login {string}")
	public void adicionoOLogin(String login) throws Throwable {
		
		// localizando o campo login e preenchendo o mesmo com os exemplos na feature
		driver.findElement(By.id("user-name")).sendKeys(login);
		// localizando o campo senha e preenchendo o mesmo com a senha padrao
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    //clicar no botao de login
	    driver.findElement(By.id("login-button")).click();
	}

	@Então("o sistema deverá fazer o login com sucesso")
	public void oSistemaDeveráFazerOLoginComSucesso() throws Throwable {
		
		driver.findElement(By.className("shopping_cart_link")).isDisplayed();
	    
	}
	
	@After
    public void teardown() {
        // Fechar o navegador após cada teste
        driver.quit();

    }
	
}
