public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    @Override
    public void imprimirTipoConta(){
        System.out.println("=== Conta Poupança ===");
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato conta Poupança ===");
        super.imprimirInfosCommuns();
    }
}
