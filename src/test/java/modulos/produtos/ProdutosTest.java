package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;
import java.time.Duration;

@DisplayName("Teste Web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {

        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        this.navegador.manage().window().maximize();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a 0")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("Mackbook pro")
                .informarOValorDoProduto("000")
                .informarAsCoresDoProduto("preto, branco")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor acima de 7000")
    public void testNaoEPermitiditoRegistrarProdutoComValorAcimaDeSeteMil() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("PS5")
                .informarOValorDoProduto("700001")
                .informarAsCoresDoProduto("Preto")
                .submeterOFormularioComErro()
                .capturarMensagemApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Cadastrar um produto com o valor limite de 0,01")
    public void testCadastrarUmProdutoComOValorDeUmCentavo() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("Xbox")
                .informarOValorDoProduto("001")
                .informarAsCoresDoProduto("Branco")
                .submeterOFormularioComSucesso()
                .capturarMensagemApresentada();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("Cadastra um produto com valor de 7000")
    public void testCadastrarUmProdutoComValorDeSeteMil() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("Arroz")
                .informarOValorDoProduto("700000")
                .informarAsCoresDoProduto("Branco")
                .submeterOFormularioComSucesso()
                .capturarMensagemApresentada();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }



    @AfterEach
    public void afterEach() {

        navegador.quit();
    }
}
