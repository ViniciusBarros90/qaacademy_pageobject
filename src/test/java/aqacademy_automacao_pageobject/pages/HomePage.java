package aqacademy_automacao_pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    String REGISTRAR =     "//button[contains(text(),'Registrar')]";
    String EMAIL =         "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/input[1]";
    String NOME =          "//input[@name='name']";
    String SENHA =         "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]";
    String CONFIRM_SENHA = "//input[@name='passwordConfirmation']";
    String CRIAR_SALDO =   "//label[@id='toggleAddBalance']";
    String CADASTRAR =     "//button[contains(text(),'Cadastrar')]";
    String FECHAR =        "//*[@id=\"btnCloseModal\"]";

    public HomePage(WebDriver driverParametro){ //Atalho vindo do TesteCadastramento. Método construtor, onde consigo fazer todas as ações utilizando o Webdriver vindo lá da classe de TesteCadastramento responsável por gerenciar os meus WebDriver.
        this.driver = driverParametro;
    }
    
    public void clicarRegistrar (){
        driver.findElement(By.xpath(REGISTRAR)).click();

 }
    public void PreencherEmail(String email) {
        driver.findElement(By.xpath(EMAIL)).sendKeys(email);
    }

    public void PreencherNome(String nome) {
        driver.findElement(By.xpath(NOME)).sendKeys(nome);
    }

    public void PreencherSenha(String senha) {
        driver.findElement(By.xpath(SENHA)).sendKeys(senha);
    }

    public void PreencherConfirmacaoSenha(String ConfirmacaoSenha) {
        driver.findElement(By.xpath(CONFIRM_SENHA)).sendKeys(ConfirmacaoSenha);
    }

    public void ClicarEmCriarComSaldo() {
        driver.findElement(By.xpath(CRIAR_SALDO)).click();
    }

    public void ClicarCadastrar() {
        driver.findElement(By.xpath(CADASTRAR)).click();
            }

              public void ClicarFechar() {
        driver.findElement(By.xpath(FECHAR)).click();
    }

}
