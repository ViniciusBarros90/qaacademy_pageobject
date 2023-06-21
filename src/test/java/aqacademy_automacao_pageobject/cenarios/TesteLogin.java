package aqacademy_automacao_pageobject.cenarios;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import aqacademy_automacao_pageobject.pages.HomePage;
import aqacademy_automacao_pageobject.pages.LoginPage;

public class TesteLogin {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    String email = "teste@gmail.com";
    String senha = "teste";
    String emailIncorreto = "teste200@gmail.com";
    String senhaIncorreta = "senha200";

    @Before
    public void setup() throws InterruptedException {
        driver = new ChromeDriver(); //Driver instanciado
        homePage = new HomePage(driver); 
        loginPage = new LoginPage(driver); // Instanciado, assim consigo acessar todos os métodos lá na classe Loginage
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
        cadastrarUsuario();

    }
 @Test
    public void testeLoginComSucesso() throws InterruptedException {   
        String msgValidacao = "bem vindo ao BugBank :)";                                                                       // Fazendo as chamadas da classe HomePage
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
        loginPage.clicarAcessar();
        Thread.sleep(2000);
        validarMensagem(msgValidacao);
        validarUrl("/home");
    }

    @Test
    public void testeLoginEmailIncorreto() throws InterruptedException {
     String msgValidacao = "Usuário ou senha inválido";                                                                      // Fazendo as chamadas da classe HomePage
        loginPage.preencherEmailIncorreto(emailIncorreto);
        loginPage.preencherSenha(senha);
        loginPage.clicarAcessar();
        Thread.sleep(2000);
        validarMensagem(msgValidacao);
            }
                                                   
     public void validarMensagem(String msg){
        Assert.assertTrue(driver.getPageSource().contains(msg));
    }
      
    public void validarUrl(String pagina){
        Assert.assertTrue(driver.getCurrentUrl().contains(pagina));
        }

    
    public void cadastrarUsuario() throws InterruptedException{
        homePage.clicarRegistrar();                                        
        homePage.PreencherEmail(email);                 
        homePage.PreencherNome("QA Academy");                         
        homePage.PreencherSenha(senha);                            
        homePage.PreencherConfirmacaoSenha(senha);      
        homePage.ClicarEmCriarComSaldo();                                  
        homePage.ClicarCadastrar();                                        
        validarMensagem("foi criada com sucesso");  
        Thread.sleep(2000);
        homePage.ClicarFechar();
    }

      @After
    public void finalizar() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
