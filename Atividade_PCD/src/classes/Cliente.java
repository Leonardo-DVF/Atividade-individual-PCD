package classes;

import java.util.Random;

public class Cliente implements Runnable {
    private String nomeCliente;
    private String enderecoCliente;
    private Conta conta;
    private Loja lojaUm;
    private Loja lojaDois;
    private Banco banco;
    private Random random = new Random();

    public Cliente(String nomeCliente, String enderecoCliente, double saldo, Banco banco, Loja lojaUm, Loja lojaDois) {
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.banco = banco;
        this.conta = new Conta(saldo, banco);
        this.lojaUm = lojaUm;
        this.lojaDois = lojaDois;
    }

    
    public void run() {
        while (conta.getSaldo() >= 100) {
            int valorCompra = (random.nextInt(2) + 1) * 100; 
            Loja loja = random.nextBoolean() ? lojaUm : lojaDois;
            loja.efetuarCompra(this, valorCompra);
        }
    }

    public synchronized void debitarSaldo(double valor) {
        conta.sacar(valor);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public synchronized double getSaldo() {
        return conta.getSaldo();
    }
}
