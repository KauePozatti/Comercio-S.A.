import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contato {
    String tipo;
    String valor;
    String observacao;

    public Contato(String tipo, String valor, String observacao) {
        this.tipo = tipo;
        this.valor = valor;
        this.observacao = observacao;
    }
}

class Cliente {
    String nome;
    String cpf;
    String dataNascimento;
    String endereco;
    List<Contato> contatos;

    public Cliente(String nome, String cpf, String dataNascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contatos = new ArrayList<>();
    }
    
    public void adicionarContato(Contato contato) {
        this.contatos.add(contato);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Data de Nascimento: ");
        String dataNascimento = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
        
        System.out.print("Deseja adicionar um contato? (sim/não): ");
        String resposta = sc.nextLine();
        
        while (resposta.equalsIgnoreCase("sim")) {
            System.out.print("Tipo de contato (ex: telefone, email): ");
            String tipo = sc.nextLine();

            System.out.print("Valor do contato: ");
            String valor = sc.nextLine();

            System.out.print("Observação sobre o contato: ");
            String observacao = sc.nextLine();
            
            Contato contato = new Contato(tipo, valor, observacao);
            cliente.adicionarContato(contato);
            
            System.out.print("Deseja adicionar outro contato? (sim/não): ");
            resposta = sc.nextLine();
        }
        
        System.out.println("Cliente cadastrado: " + cliente.nome);
        System.out.println("Contatos do cliente:");
        for (Contato contato : cliente.contatos) {
            System.out.println("Tipo: " + contato.tipo + ", Valor: " + contato.valor + ", Observação: " + contato.observacao);
        }

        sc.close();
    }
}
