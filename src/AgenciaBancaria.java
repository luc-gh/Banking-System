import java.util.HashSet;
import java.util.Scanner;

public class AgenciaBancaria {
    private final Scanner sc = new Scanner(System.in);
    private HashSet<ContaBancaria> contas;
    private String nomeDaAgencia;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDaAgencia() {
        return nomeDaAgencia;
    }

    public void setNomeDaAgencia(String nomeDaAgencia) {
        this.nomeDaAgencia = nomeDaAgencia;
    }

    public HashSet<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(HashSet<ContaBancaria> contas) {
        this.contas = contas;
    }

    public AgenciaBancaria(String nome) {
        this.setContas(new HashSet<>());
        this.setNomeDaAgencia(nome);
    }

    public void adicionarConta() {
        System.out.println("\n---------------------------------");
        System.out.println("Digite as informações da conta:");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.println();
        System.out.print("ID: ");
        int id = sc.nextInt();
        ContaBancaria c = new ContaBancaria(id, nome);
        this.getContas().add(c);
        System.out.println("Conta adicionada com sucesso!");
    }

    public void removerConta() {
        System.out.println("Digite o ID da conta: ");
        int id = sc.nextInt();
        ContaBancaria c = encontrarConta(id);
        if (c == null) {
            System.out.println("Erro. Conta não existe.");
            return;
        }
        System.out.println("Conta nº " + c.getId() + ", de " + c.getTitular() + " removida.");
        this.getContas().remove(c);
    }

    public void listarContas() {
        for (ContaBancaria c : this.getContas()) {
            System.out.println("\n- Conta " + c.getId() + "\n   Titular: " + c.getTitular() + "\n   Saldo: " + c.getSaldo());
        }
    }

    private ContaBancaria encontrarConta(int id) {
        for (ContaBancaria c : this.getContas()) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void inicializar() {
        System.out.println("\n               -- Agência " + this.getNomeDaAgencia() + " --");
        System.out.println();
        System.out.println("""
                Selecione sua operação:
                
                [1] Listar contas
                [2] Adicionar conta
                [3] Remover conta
                [4] Realizar operação em conta
                [5] Encerrar visualização nesta agência
                
                Opção:\s""");
        int i = sc.nextInt();
        switch (i) {
            case 1 -> this.listarContas();
            case 2 -> this.adicionarConta();
            case 3 -> this.removerConta();
            case 4 -> {
                System.out.println("ID: ");
                int id = sc.nextInt();
                ContaBancaria conta = this.getContaByID(id);
                if (conta == null) {
                    System.out.println("Conta não encontrada.");
                } else {
                    conta.inicializarConta();
                }
            }
            case 5 -> System.out.println("Fim.");
            default -> System.out.println("Opção inválida.");
        }
    }

    private ContaBancaria getContaByID(int id) {
        for (ContaBancaria c : this.getContas()) {
            if (c.getId() == id) return c;
        }
        return null;
    }
}
