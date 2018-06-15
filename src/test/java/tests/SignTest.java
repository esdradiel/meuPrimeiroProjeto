package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class SignTest {

    @Test
    public void testFazerLoginNoTaskit(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\esdras.faconi\\IdeaProjects\\meuPrimeiroProjeto\\src\\test\\resources\\bin\\chromedriver.exe");

        //Configs do driver para navegação
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        //Tempo de espera até que os elementos sejam apresentados na tela
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebDriverWait wda = new WebDriverWait(navegador,10);

        //Abrir o site
        navegador.get("http://www.juliodelima.com.br/taskit/");

        //Buscar pelo campo Sign in
        navegador.findElement(By.linkText("Sign in")).click();

        //Preencher User e Pass
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("testEsdras");
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");

        //Clica no botão para fazer Login
        navegador.findElement(By.linkText("SIGN IN")).click();

        String saudacao = navegador.findElement(By.className("me")).getText();

       assertEquals("Hi, Esdras",saudacao);

       navegador.quit();

    }

}
