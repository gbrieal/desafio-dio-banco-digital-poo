package BancoDigitalDio;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.print("=== EXTRATO DA CONTE POUPANÇA ===");
        super.estadoAtual();
    }

}
