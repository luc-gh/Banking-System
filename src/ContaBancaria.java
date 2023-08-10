import java.util.Scanner;

public class ContaBancaria {
    private final Scanner sc = new Scanner(System.in);
    private int id;
    private String titular;
    private double saldo;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    private void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void saque(double valor) {
        if (valor > 0 && valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado. A conta de " + this.titular + " teve um decréscimo de R$ " + valor + ".");
        } else {
            System.out.println("Saque não permitido. Saldo insuficiente ou valor inválido.");
        }
    }

    public void deposito(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado. A conta de " + this.titular + " teve um acréscimo de R$ " + valor + ".");
        } else {
            System.out.println("Depósito não permitido. Valor inválido.");
        }
    }

    public ContaBancaria(int id, String nome) {
        this.setId(id);
        this.setTitular(nome);
        this.setSaldo(0.0);
    }

    public void inicializarConta() {
        System.out.println("Opções:\n [1] Saque \n[2] Depósito \n[3] Sair \nOpção: ");
        int i = sc.nextInt();
        switch (i) {
            case 1 -> {
                System.out.println("Digite o valor: ");
                double d = sc.nextDouble();
                this.saque(d);
            }
            case 2 -> {
                System.out.println("Digite o valor: ");
                double f = sc.nextDouble();
                this.deposito(f);
            }
            case 3 -> System.out.println("Fim.");
            default -> System.out.println("Opção inválida.");
        }
    }
}
