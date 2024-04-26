package main;

import classes.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco", "Rua Católica, 1234");
        
        //Definindo os nomes e os endereços das lojas 
        Loja loja1 = new Loja("Loja Azul", "Rua 1, 250", banco);
        Loja loja2 = new Loja("Loja Vermelho", "Rua 2, 350", banco);
        
        //Definindo os funcionários, os salários e suas funções
        Funcionario funcionario1 = new Funcionario("Funcionário 1", "Vendedor", 1400, loja1);
        Funcionario funcionario2 = new Funcionario("Funcionário 2", "Caixa", 1400, loja1);
        Funcionario funcionario3 = new Funcionario("Funcionário 3", "Vendedor", 1400, loja2);
        Funcionario funcionario4 = new Funcionario("Funcionário 4", "Caixa", 1400, loja2);

        //Definindo em quais lojas os funcionários irão ficar
        loja1.addFuncionario(funcionario1);
        loja1.addFuncionario(funcionario2);
        loja2.addFuncionario(funcionario3);
        loja2.addFuncionario(funcionario4);
        
        //Recebendo Threads (funcionários)
        Thread threadFuncionario1 = new Thread(funcionario1);
        Thread threadFuncionario2 = new Thread(funcionario2);
        Thread threadFuncionario3 = new Thread(funcionario3);
        Thread threadFuncionario4 = new Thread(funcionario4);

        //Iniciando as threads (funcionários)
        threadFuncionario1.start();
        threadFuncionario2.start();
        threadFuncionario3.start();
        threadFuncionario4.start();
        
        //Definindo os funcionários, os saldos e suas funções
        Cliente cliente1 = new Cliente("Cliente 1", "Rua A, 100", 1000, banco, loja1, loja2);
        Cliente cliente2 = new Cliente("Cliente 2", "Av. B, 200", 1000, banco, loja1, loja2);
        Cliente cliente3 = new Cliente("Cliente 3", "Rua C, 300", 1000, banco, loja1, loja2);
        Cliente cliente4 = new Cliente("Cliente 4", "Av. D, 400", 1000, banco, loja1, loja2);
        Cliente cliente5 = new Cliente("Cliente 5", "Rua E, 500", 1000, banco, loja1, loja2);

        //Recebendo Threads (clientes)
        Thread threadCliente1 = new Thread(cliente1);
        Thread threadCliente2 = new Thread(cliente2);
        Thread threadCliente3 = new Thread(cliente3);
        Thread threadCliente4 = new Thread(cliente4);
        Thread threadCliente5 = new Thread(cliente5);
        
        //Iniciando as threads (clientes)
        threadCliente1.start();
        threadCliente2.start();
        threadCliente3.start();
        threadCliente4.start();
        threadCliente5.start();

        try {
            threadCliente1.join();
            threadCliente2.join();
            threadCliente3.join();
            threadCliente4.join();
            threadCliente5.join();
            threadFuncionario1.interrupt();
            threadFuncionario2.interrupt();
            threadFuncionario3.interrupt();
            threadFuncionario4.interrupt();
            threadFuncionario1.join();
            threadFuncionario2.join();
            threadFuncionario3.join();
            threadFuncionario4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostra o saldo das contas (final)
        System.out.println("\n=-=-=-=-=-=-=-==-=-=-=-=-=-=- RESULTADOS -=-=-=-=-=-=-==-=-=-=-=-=-=-=");
        System.out.println("Saldos das contas das lojas Azul e Vermelho:");
        System.out.println("Saldo da " + loja1.getNome() + " é de: R$" + loja1.getSaldo());
        System.out.println("Saldo da " + loja2.getNome() + " é de: R$" + loja2.getSaldo());

        // Mostra os saldos das contas dos clientes
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Saldos dos clientes:");
        System.out.println("Saldo de " + cliente1.getNomeCliente()+ ": R$" + cliente1.getSaldo());
        System.out.println("Saldo de " + cliente2.getNomeCliente()+ ": R$" + cliente2.getSaldo());
        System.out.println("Saldo de " + cliente3.getNomeCliente()+ ": R$" + cliente3.getSaldo());
        System.out.println("Saldo de " + cliente4.getNomeCliente()+ ": R$" + cliente4.getSaldo());
        System.out.println("Saldo de " + cliente5.getNomeCliente()+ ": R$" + cliente5.getSaldo());

        // Mostra os saldos das contas dos funcionários (Investimentos)
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Saldo dos investimentos dos funcionários:");
        System.out.println("Saldo de " + funcionario1.getNomeFuncionario()+ " (Investimento): R$" + funcionario1.getSaldoInvestimento());
        System.out.println("Saldo de " + funcionario2.getNomeFuncionario()+ " (Investimento): R$" + funcionario2.getSaldoInvestimento());
        System.out.println("Saldo de " + funcionario3.getNomeFuncionario()+ " (Investimento): R$" + funcionario3.getSaldoInvestimento());
        System.out.println("Saldo de " + funcionario4.getNomeFuncionario()+ " (Investimento): R$" + funcionario4.getSaldoInvestimento());
        
        // Mostra os saldos das contas dos funcionários (salários)
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Saldo dos salários dos funcionários:");
        System.out.println("Saldo de " + funcionario1.getNomeFuncionario()+ " (Salário): R$" + funcionario1.getSaldoSalario());
        System.out.println("Saldo de " + funcionario2.getNomeFuncionario()+ " (Salário): R$" + funcionario2.getSaldoSalario());
        System.out.println("Saldo de " + funcionario3.getNomeFuncionario()+ " (Salário): R$" + funcionario3.getSaldoSalario());
        System.out.println("Saldo de " + funcionario4.getNomeFuncionario()+ " (Salário): R$" + funcionario4.getSaldoSalario());

    }
}