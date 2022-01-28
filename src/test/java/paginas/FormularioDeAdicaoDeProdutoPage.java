package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage informarONomeDoProduto(String produtoNome) {
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarOValorDoProduto(String produtoValor) {
        navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarAsCoresDoProduto(String produtoCor) {
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCor);
        return this;
    }
    public ListaDeProdutosPage submeterOFormularioComErro() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(navegador);
    }
    public FormularioDeEdicaoDeProdutoPage submeterOFormularioComSucesso() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new FormularioDeEdicaoDeProdutoPage(navegador);
    }
}
