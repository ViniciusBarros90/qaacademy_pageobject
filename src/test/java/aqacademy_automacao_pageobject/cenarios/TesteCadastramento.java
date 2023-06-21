package aqacademy_automacao_pageobject.cenarios;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import aqacademy_automacao_pageobject.pages.HomePage;

public class TesteCadastramento {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setup() {
        driver = new ChromeDriver(); //Driver instanciado
        homePage = new HomePage(driver); // Instanciado, assim consigo acessar todos os métodos lá na classe HomePage
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");

    }

    @Test
    public void testePositivoCadastro() {                                  // Método testePositivoCadastro
        homePage.clicarRegistrar();                                        // Fazendo as chamadas da classe HomePage
        homePage.PreencherEmail("teste@gmail.com");                 // Fazendo as chamadas da classe HomePage
        homePage.PreencherNome("QA Academy");                         // Fazendo as chamadas da classe HomePage
        homePage.PreencherSenha("teste");                            // Fazendo as chamadas da classe HomePage
        homePage.PreencherConfirmacaoSenha("teste");      // Fazendo as chamadas da classe HomePage
        homePage.ClicarEmCriarComSaldo();                                  // Fazendo as chamadas da classe HomePage
        homePage.ClicarCadastrar();                                        // Fazendo as chamadas da classe HomePage
        validarMensagem("foi criada com sucesso");                                                
    }

     @Test
    public void testeCadastroVazio() {                                                                           // Fazendo as chamadas da classe HomePage
        homePage.clicarRegistrar();                          
        homePage.ClicarCadastrar();                                        
        validarMensagem("É campo obrigatório");                                                
    }


      public void validarMensagem(String msg){
        Assert.assertTrue(driver.getPageSource().contains(msg));
    }

      @After
    public void finalizar() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
