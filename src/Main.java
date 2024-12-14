import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeroConta;
        int opcao = 0;
        double valor;
        String nome;
        String cpf;
        boolean output = false;
        Banco banco = new Banco();
        while (!output) {
            System.out.println("Tecle 0 para criar Conta Corrente, 1 para Poupança e 9 para sair: ");
            opcao = scan.nextInt();
            if (opcao == 0) {
                System.out.println("Entre com seu nome: ");
                nome = scan.next();
                System.out.println("Entre com o CPF: ");
                cpf = scan.next();
                Cliente cliente = new Cliente(nome, cpf);
                Conta cc = new ContaCorrente(cliente);
                banco.adicionarContasList(cc);
            } else if (opcao == 1) {
                System.out.println("Entre com seu nome:");
                nome = scan.next();
                System.out.println("Entre com o CPF:");
                cpf = scan.next();
                Cliente cliente = new Cliente(nome, cpf);
                Conta poupaca = new ContaPoupanca(cliente);
                banco.adicionarContasList(poupaca);
            } else if (opcao == 9) {
                output = true;
            }
        }
        banco.exibirContas();
        System.out.println(">>>>Terminal Cliente<<<<");
        System.out.println("Entre com CPF");
        cpf = scan.next();
        System.out.println("Entre com numero da conta");
        numeroConta = scan.nextInt();
        banco.validarConta(cpf, numeroConta);
        banco.exibirContas();
    }
}
