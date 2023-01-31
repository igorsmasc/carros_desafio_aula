package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceTest {

    @Test
    public void deveAcelerarCorretamente() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 150);
        carroService.ligar(carro);

        // Quando:
        carroService.acelerar(carro, 10);

        // Então:
        Assert.assertEquals(10, carro.getVelocidadeAtual());
    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);
        carroService.ligar(carro);

        // Quando:
        carroService.acelerar(carro, 100);
        carroService.acelerar(carro, 100);

        // Então:
        Assert.assertEquals(100, carro.getVelocidadeAtual());
    }

    @Test
    public void umCarroDeveIniciarDesligado() {
        // Dado:
        Carro carro = new Carro("azul", "fiat", "uno", 2020, 100);

        // Então:
        // Assert.assertTrue();
        Assert.assertFalse(carro.isLigado());
    }

}
