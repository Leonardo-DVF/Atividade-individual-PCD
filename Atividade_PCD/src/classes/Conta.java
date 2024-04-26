package classes;

class Conta {
    private double saldoConta;
    private Banco bancoConta;

    public Conta(double saldoInicial, Banco banco) {
        this.saldoConta = saldoInicial;
        this.bancoConta = banco;
    }

    public synchronized void depositar(double valor) {
        saldoConta += valor;
        bancoConta.depositar(valor);
    }

    public synchronized void sacar(double valor) {
        if (valor <= saldoConta) {
            saldoConta -= valor;
            bancoConta.sacar(valor);
        } else {
            System.out.println("Sem saldo suficiente na conta.");
        }
    }

    public synchronized double getSaldo() {
        return saldoConta;
    }
}
