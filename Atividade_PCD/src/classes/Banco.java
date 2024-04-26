package classes;

public class Banco {
    private String nomeBanco;
    private String enderecoBanco;
    private double saldoTotal = 0;

    public Banco(String nomeBanco, String enderecoBanco) {
        this.nomeBanco = nomeBanco;
        this.enderecoBanco = enderecoBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getEnderecoBanco() {
        return enderecoBanco;
    }

    public synchronized void depositar(double valor) {
        saldoTotal += valor;
    }

    public synchronized void sacar(double valor) {
        saldoTotal -= valor;
    }

    public synchronized double getSaldoTotal() {
        return saldoTotal;
    }
}
