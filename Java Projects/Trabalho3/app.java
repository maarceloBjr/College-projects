import java.util.Scanner;

public class app {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        Funcionario func1 = new Funcionario("Leonardo", "11111111111", 200, 43, false);
        Funcionario func2 = new Funcionario("João", "22222222222", 200, 44, false);
        Funcionario func3 = new Funcionario("Marcelo", "33333333333", 200, 45, true);
        Funcionario func4 = new Funcionario("Pedro", "44444444444", 200, 31, false);
        Funcionario func5 = new Funcionario("Ronaldo", "55555555555", 200, 20, false);

        Funcionario[] funcionarios = {func1, func2, func3, func4, func5};
        int opcao = 0;
        
        do{
            System.out.println("\n--- Digite a opção: ---");
            System.out.println("1- Cadastrar funcionario.");
            System.out.println("2- Listar todos os funcionarios.");
            System.out.println("3- Remover funcionario a partir do CPF.");
            System.out.println("4- Editar o salario de um funcionario a partir do CPF.");
            System.out.println("5- Imprimir o funcionario com maior salario.");
            System.out.println("6- Imprimir percentual de funcionarios que tem filho.");
            System.out.println("7- Sair do programa.\n");
            opcao = Integer.parseInt(sc.nextLine());
            switch(opcao){
                case 1:
                    funcionarios = Funcionario.novoFuncionario(funcionarios);
                break;
                case 2:
                    Funcionario.listaFuncionarios(funcionarios);
                break;
                case 3:
                    funcionarios = Funcionario.excluirFuncionario(funcionarios);
                break;
                case 4:
                    funcionarios = Funcionario.alterarSalario(funcionarios);
                break;
                case 5:
                    Funcionario.maiorSalario(funcionarios);
                break;
                case 6:
                    Funcionario.porcentagemFilhos(funcionarios);
                break;
                case 7:
                    System.out.println("Saindo...");
                break;
            }
        }while(opcao != 7);
        
        sc.close();
    }
}