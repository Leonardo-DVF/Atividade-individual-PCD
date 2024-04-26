package classes;

public class Funcionario implements Runnable {
    private String nomeFuncionario;
    private String cargo;
    private double salario;
    private Loja loja;
    private Conta contaSalario;
    private Conta contaInvestimento;
    private boolean salarioRecebido;

    public Funcionario(String nomeFuncionario, String cargo, double salario, Loja loja) {
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.loja = loja;
        this.contaSalario = new Conta(0, loja.getBanco()); 
        this.contaInvestimento = new Conta(0, loja.getBanco());
        this.salarioRecebido = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(5000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }
            loja.pagarSalarios();
        }
    }

    public synchronized void receberSalario() {
        double valorInvestimento = salario * 0.2; 
        contaSalario.depositar(salario - valorInvestimento);
        contaInvestimento.depositar(valorInvestimento);
        salarioRecebido = true;
        System.out.println(nomeFuncionario + " recebeu o salário da loja " + loja.getNome());
        System.out.println(nomeFuncionario + " investiu R$" + valorInvestimento + " do salário.");
    }
   
    public synchronized double getSaldoSalario() {
        return contaSalario.getSaldo();
    }

    public double getSalario() {
        return salario;
    }

    public boolean isSalarioRecebido() {
        return salarioRecebido;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    
    public synchronized double getSaldo() {
        return contaSalario.getSaldo();
    }
    
    public synchronized double getSaldoInvestimento() {
        return contaInvestimento.getSaldo();
    }
}
