import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    Scanner scan = new Scanner(System.in);
    private String cpfOrigem;
    private String cpfDestino;
    private double valor;
    private String nome;
    private boolean validar = false;
    private List<Conta> contas;
    private int opcao;
    private int numeroConta;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarContasList(Conta conta) {
        this.contas.add(conta);
    }

    public void exibirContas() {
        for (Conta c : contas) {
            Cliente cliente = c.cliente;
            c.imprimirTipoConta();
            System.out.println("Cliente: " + cliente.getNome() + " - CPF: " + cliente.getCpf() + "\nAgencia: " + c.agencia + "\nNumero: " + c.numero + "\nSaldo: " + c.saldo + "\n");
        }
    }

    public void validarConta(String cpf, int numero) {
        while (!validar) {
            for (Conta c : contas) {
                if (c.cliente.getCpf().equalsIgnoreCase(cpf) && c.getNumero() == numero) {
                    System.out.println("Entre com opção desejada:\n1- Saque\n2- Deposito\n3- Transferencia\n9-Sair");
                    opcao = scan.nextInt();
                    if (opcao == 1) {
                        System.out.println("Valor do saque: ");
                        valor = scan.nextDouble();
                        c.sacar(valor);
                    } else if (opcao == 2) {
                        System.out.println("Valor do deposito");
                        valor = scan.nextInt();
                        c.depositar(valor);
                    } else if (opcao == 3) {
                        System.out.println("Entre seu CPF");
                        cpfOrigem = scan.next();

                        System.out.println("Entre com CPF destino");
                        cpfDestino = scan.next();

                        System.out.println("Valor da transferencia");
                        valor = scan.nextDouble();
                        Conta contaOrigem = null;
                        Conta contaDestino = null;
                        for (Conta conta : getContas()){
                            if (conta.cliente.getCpf().equalsIgnoreCase(cpfOrigem)){
                                contaOrigem = conta;
                            }
                            if (conta.cliente.getCpf().equalsIgnoreCase(cpfDestino)){
                                contaDestino= conta;
                            }
                        }
                        if (contaOrigem != null && contaDestino != null){
                            contaOrigem.transferir(contaDestino, valor);
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    } else if (opcao == 9) {
                        System.out.println("Até mais");
                        validar = true;
                    } else{
                        System.out.println("Opção invalida");
                    }
                }
            }
        }
    }


    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
