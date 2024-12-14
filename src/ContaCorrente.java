public class ContaCorrente extends Conta{
    private double limite;
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirTipoConta(){
        System.out.println("=== Conta Corrente ===");
    }
    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato conta corrente ===");
        super.imprimirInfosCommuns();
    }
}
