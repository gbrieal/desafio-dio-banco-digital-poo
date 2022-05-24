package BancoDigitalDio;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int numero;
    protected Cliente cliente;
    protected int agencia;
    protected double saldo;
    protected boolean status;

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta() {
        if (!status) {
            System.out.println("Operação indisponível!");
        } else {
            System.out.println("Conta aberta com sucesso!");
        }
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Há saldo na conta, favor efetuar o saque total!");
        }
        if (this.getSaldo() < 0) {
            System.out.println("Há pendencias na conta, favor realizar o pagamento!");
        } else {
            this.setStatus(false);
        }
        System.out.println("Conta fechada com sucesso!");
    }

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
        this.status = false;
    }

    @Override
    public void sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque de R$ %d" + "realizado na conta de " + this.getCliente());
        } else if (this.getSaldo() < valor || this.getSaldo() < 0) {
            System.out.println("Impossível realizar saque neste valor, saldo insuficiente!");
        } else {
            System.out.println("Não é possível realizar esta operação, conta inexistente!");
        }
    }

    @Override
    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito de R$ %d" + "realizado na conta de " + this.getCliente());
        } else {
            System.out.println("Não é possível realizar esta operação, conta inexistente!");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void estadoAtual() {
        System.out.println("_________________________________________");
        System.out.println(String.format("Número da Conta: 00%d", this.numero));
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: 00%d", this.agencia));
        System.out.println(String.format("Saldo: R$ %.2f", this.getSaldo()));
        System.out.println("");
    }
}
