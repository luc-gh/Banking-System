import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBancario {
    private final Scanner sc = new Scanner(System.in);
    private ArrayList<AgenciaBancaria> agencias;
    private int nextAgenciaId = 1;

    public ArrayList<AgenciaBancaria> getAgencias() {
        return agencias;
    }

    public void setAgencias(ArrayList<AgenciaBancaria> agencias) {
        this.agencias = agencias;
    }

    public SistemaBancario() {
        this.setAgencias(new ArrayList<>());
    }

    public void adicionarAgencia() {
        System.out.println("--------------------------------------");
        System.out.print("-> Nome da agência: ");
        String nome = sc.next();
        System.out.println();
        AgenciaBancaria ab = new AgenciaBancaria(nome);
        ab.setId(nextAgenciaId++);
        this.getAgencias().add(ab);
    }

    private void removerAgencia() {
        this.listarAgencias();
        System.out.println("\nDigite o ID: ");
        int i = sc.nextInt();
        if (i < 0 || i >= this.getAgencias().size()) {
            System.out.println("ID inválida.");
            return;
        }
        String a = this.getAgencias().get(i).getNomeDaAgencia();
        this.getAgencias().remove(i);
        System.out.println("Agência " + a + " removida.");
    }

    public void listarAgencias() {
        System.out.println("Agências:");
        for (AgenciaBancaria a : this.getAgencias()) {
            System.out.println("[" + (a.getId()-1) + "] " + a.getNomeDaAgencia());
        }
    }

    public void inicializarSistema() {
        System.out.println("-----------------------------------------------------");
        System.out.println("               -- SISTEMA BANCÁRIO --");
        int i = 0;
        while(i!=4) {
            System.out.println();
            System.out.println("""
                        Selecione sua operação:
                                            
                        [1] Escolher agência para realizar ações em contas
                        [2] Adicionar agência
                        [3] Remover agência
                        [4] Encerrar sistema
                                            
                        Opção:\s""");
            i = sc.nextInt();
            switch (i) {
                case 1 -> {
                    this.listarAgencias();
                    this.escolherAgencia();
                }
                case 2 -> this.adicionarAgencia();
                case 3 -> this.removerAgencia();
                case 4 -> System.out.println("Sistema encerrado!");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void escolherAgencia() {
        System.out.println("Digite o id da agência desejada: ");
        int i = sc.nextInt();
        if (i < 0 || i >= this.getAgencias().size()) {
            System.out.println("ID inválida.");
            return;
        }
        this.getAgencias().get(i).inicializar();
    }
}
