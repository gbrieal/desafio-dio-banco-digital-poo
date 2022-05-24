package BancoDigitalDio;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.print("=== EXTRATO DA CONTE CORRENTE ===");
        super.estadoAtual();
    }

}
