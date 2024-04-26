# Objetivo da atividade:
Este projeto consiste em um sistema bancário simulado utilizando threads e os conceitos de programação concorrente. O sistema inclui as seguintes entidades: Banco, Loja, Funcionário, Cliente e Conta. O objetivo é simular transações bancárias entre clientes, lojas e funcionários, garantindo a consistência dos saldos das contas em um ambiente multithread.

# Entidades do Sistema:
* Banco: Responsável por intermediar as transações de forma síncrona e coordenada, garantindo a consistência dos saldos das contas.
* Loja: Representa as lojas onde os clientes realizam suas compras. Cada loja possui uma conta para receber os pagamentos dos clientes e pagar os funcionários.
* Funcionário: Cada loja possui funcionários que recebem um salário e investem uma parte desse salário em uma conta de investimentos.
* Cliente: Representa os clientes que realizam compras nas lojas. Cada cliente possui uma conta com um saldo inicial para realizar as compras.
* Conta: Representa uma conta bancária associada a cada cliente, loja e funcionário.

# Funcionalidades do Sistema:
* Clientes: Cada cliente é uma thread que realiza compras alternando entre as lojas até que o saldo da conta esteja vazio. Os clientes possuem uma conta com um saldo inicial de R$ 1.000,00 e realizam compras de R$ 100,00 ou R$ 200,00.
* Lojas: Cada loja possui uma conta para receber os pagamentos dos clientes e pagar os funcionários. As lojas pagam os funcionários assim que possuem o valor dos salários.
* Funcionários: Cada funcionário é uma thread que recebe um salário e investe uma parte desse salário em uma conta de investimentos.
* Banco: O banco coordena as transações de forma síncrona para garantir a consistência dos saldos das contas.

# Resultados Esperados:
Ao final da execução do programa, o sistema deverá exibir o valor das transferências, o saldo das contas de investimentos, o saldo final de cada conta dos funcionários e o saldo final de cada conta dos clientes. É importante garantir que os saldos estejam consistentes ao fim da execução, independentemente da ordem em que as transações foram realizadas.
