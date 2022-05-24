package BancoDigitalDio;

public class Main {

    public static void main(String[] args) {

        Cliente gabriel = new Cliente();
        gabriel.setNome("Gabriel");
        
        Conta c_corrente = new ContaCorrente(gabriel);
        c_corrente.abrirConta();
        
        Conta c_poupanca = new ContaPoupanca(gabriel);
        c_poupanca.abrirConta();
        
        c_corrente.depositar(100);
        c_corrente.transferir(100, c_poupanca);

        c_corrente.estadoAtual();
        c_poupanca.estadoAtual();

    }
}
