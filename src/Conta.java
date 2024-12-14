public class Conta implements IConta {
    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 0;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    protected void imprimirInfosCommuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("CPF: %s", this.cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo){
            this.saldo -= valor;
        } else {
            System.out.println("saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor <= saldo){
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferencia realizada com sucesso!");
        } else {
            System.out.println("Saldo insulficiente para transferencia");
        }
    }

    @Override
    public void imprimirExtrato() {

    }

    @Override
    public void imprimirTipoConta() {

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


}
