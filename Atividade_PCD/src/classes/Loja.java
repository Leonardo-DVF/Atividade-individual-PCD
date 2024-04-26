package classes;

public class Loja {
    private String nomeLoja;
    private String enderecoLoja;
    private Banco bancoLoja;
    private Conta contaLoja;
    private Funcionario[] funcionarios;

    public Loja(String nomeLoja, String enderecoLoja, Banco bancoLoja) {
        this.nomeLoja = nomeLoja;
        this.enderecoLoja = enderecoLoja;
        this.bancoLoja = bancoLoja;
        this.contaLoja = new Conta(0, bancoLoja); 
        this.funcionarios = new Funcionario[0]; 
    }

    public synchronized void addFuncionario(Funcionario funcionario) {
        Funcionario[] newFuncionarios = new Funcionario[funcionarios.length + 1];
        System.arraycopy(funcionarios, 0, newFuncionarios, 0, funcionarios.length);
        newFuncionarios[funcionarios.length] = funcionario;
        funcionarios = newFuncionarios;
    }

    public synchronized void efetuarCompra(Cliente cliente, double valor) {
        if (cliente.getSaldo() >= valor) {
           
            if (cliente.getSaldo() >= valor) {
                cliente.debitarSaldo(valor);
                contaLoja.depositar(valor);
                System.out.println(cliente.getNomeCliente()+ " fez a compra na " + nomeLoja + " e foi no valor de R$ " + valor);
            }
            if (contaLoja.getSaldo() >= 1400 && !isFuncionarioPago()) {
                pagarSalario();
            }
        } else {
            System.out.println(cliente.getNomeCliente()+ " sem saldo suficiente para comprar na " + nomeLoja);
        }
    }

    private boolean isFuncionarioPago() {
        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.isSalarioRecebido()) {
                return false;
            }
        }
        return true;
    }


    private void pagarSalario() {
        for (Funcionario funcionario : funcionarios) {
            if (!funcionario.isSalarioRecebido()) {
                double salario = funcionario.getSalario();
                double valorInvestimento = salario * 0.2; 
                contaLoja.sacar(salario); 
                funcionario.receberSalario(); 
                System.out.println("Salário de " + funcionario.getNomeFuncionario()+ " pago na " + nomeLoja);
                break;
            }
        }
    }
    
    public synchronized void pagarSalarios() {
        double salarioTotal = 0;
        for (Funcionario funcionario : funcionarios) {
            salarioTotal += funcionario.getSalario();
        }
        if (contaLoja.getSaldo() >= salarioTotal) { 
            contaLoja.sacar(salarioTotal);
            System.out.println("Salários pagos da " + nomeLoja);
            for (Funcionario funcionario : funcionarios) {
                funcionario.receberSalario();
            }
        }
    }

    public Banco getBanco() {
        return bancoLoja;
    }

    public synchronized double getSaldo() {
        return contaLoja.getSaldo();
    }

    public String getNome() {
        return nomeLoja;
    }
}
