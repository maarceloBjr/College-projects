import java.util.Scanner;

public class Funcionario {
    private String nome;
    private String cpf;
    private double valorHora;
    private double cargaSemanal;
    private boolean temFilhos;

    public Funcionario(String nome, String cpf, double valorHora, double cargaSemanal, boolean temFilhos){
        this.nome = nome;
        this.cpf = cpf;
        this.valorHora = valorHora;
        this.cargaSemanal= cargaSemanal;
        if(this.cargaSemanal > 44){
            this.cargaSemanal = 44;
        }else{
            this.cargaSemanal = cargaSemanal;
        }
        this.temFilhos = temFilhos;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public double getValorHora(){
        return valorHora;
    }

    public double getCargaSemanal(){
        return cargaSemanal;
    }

    public String getTemFilhos(){
        String strTemFilhos = "";
        if (this.temFilhos = true){
            strTemFilhos = "Tem filhos";
        }else{
            strTemFilhos = "Não tem filhos";
        }
        return strTemFilhos;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setValorHora(double valorHora){
        this.valorHora = valorHora;
    }

    public void setCargaSemanal(double cargaSemanal){
        if(cargaSemanal > 44){
            this.cargaSemanal = 44;
        }else{
            this.cargaSemanal = cargaSemanal;
        }
    }

    public void setTemFilhos(boolean temFilhos){
        this.temFilhos = temFilhos;
    }

    @Override
    public String toString() {
        return "Funcionário [nome= " + nome + ", cpf= " + cpf + ", valor/hora= " + valorHora +
         "carga semanal= " + cargaSemanal + "Filhos? " + temFilhos + "]";
    }

    public static Funcionario[] alterarSalario(Funcionario funcionarios[]){ //altera salario do funcionario pelo CPF
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CPF do funcionario a ter o salario alterado");
        String cpfSalario = sc.nextLine();

        System.out.println("O que deseja alterar?");
        System.out.println("1- O valor/hora (em Reais).");
        System.out.println("2- A carga semanal (em Horas).");
        System.out.println("3- Ambos");

        int opcao = Integer.parseInt(sc.nextLine());

        switch(opcao){
            case 1:
                System.out.println("Qual o novo valor/hora em Reais?");
                double novoValorHora = sc.nextDouble();
                for(int i = 0; i < funcionarios.length; i++){
                    if(funcionarios[i].getCpf().equals(cpfSalario)){
                        funcionarios[i].setValorHora(novoValorHora);
                        break;
                    }
                }
            break;
            case 2:
                System.out.println("Qual a nova carga horária em horas?");
                double novaCargaHoraria = sc.nextDouble();
                for(int i = 0; i < funcionarios.length; i++){
                    if(funcionarios[i].getCpf().equals(cpfSalario)){
                        funcionarios[i].setCargaSemanal(novaCargaHoraria);
                        break;
                    }
                }
            break;
            case 3:
                System.out.println("Qual o novo valor/hora em Reais?");
                novoValorHora = sc.nextDouble();
                System.out.println("Qual a nova carga horária em horas?");
                novaCargaHoraria = sc.nextDouble();
                for(int i = 0; i < funcionarios.length; i++){
                    if(funcionarios[i].getCpf().equals(cpfSalario)){
                        funcionarios[i].setCargaSemanal(novaCargaHoraria);
                        funcionarios[i].setValorHora(novoValorHora);
                        break;
                    }
                }
            break;
        }
        return funcionarios; 
    }

    public static void maiorSalario(Funcionario funcionarios[]){ // analisa quem tem o maior salario
        double salario = 0;
        double maiorSalario = 0;
        String cpfMaiorSalario = "";
        String nomeFuncionario = "";

        for(int i = 0; i < funcionarios.length; i++){
            salario = funcionarios[i].getCargaSemanal() * funcionarios[i].getValorHora();

            if(salario > maiorSalario){
                maiorSalario = salario;
                cpfMaiorSalario = funcionarios[i].getCpf();
                nomeFuncionario = funcionarios[i].getNome();
            }
        }

        System.out.println("\nCPF: " + cpfMaiorSalario);
        System.out.println("Nome: " + nomeFuncionario);
        System.out.println("Salario: " + maiorSalario + "\n");
    }

    public static void porcentagemFilhos(Funcionario funcionarios[]){ // calcula a porcentagem de funcionarios com filhos
        int contador = 0;

        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i].temFilhos == true){
                contador++;
            }
        }

        double porcentagem = contador*10 / funcionarios.length * 10;

        System.out.println("\n" + porcentagem + "% de funcionarios tem filho.");    
    }

    public static Funcionario[] excluirFuncionario(Funcionario funcionarios[]){ //exclui funcionario pelo CPF

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CPF do funcionario a ser removido");
        String cpfExcluido = sc.nextLine();

        Funcionario[] novaListaFuncionario = new Funcionario[funcionarios.length-1];
        int contador = 0;

        do{
            int i = 0;

            while(i < funcionarios.length){
                if(funcionarios[i].getCpf().equals(cpfExcluido)){
                    novaListaFuncionario = new Funcionario[funcionarios.length-1];
                    for(int j = 0; j < i; j++){
                        novaListaFuncionario[j] = funcionarios[j];
                    }
                    contador++;
                    for(int k = i; k < funcionarios.length-1; k++){
                        novaListaFuncionario[k] = funcionarios[k+1];
                    }
                    break;
                }
                i++;
            }
    
            if(i == funcionarios.length){
                System.out.println("Insira um CPF valido.");
                cpfExcluido = sc.next();
            }
            
        }while(contador == 0);

        System.out.println("CPF excluido!");
        
        return novaListaFuncionario;       
    }

    public static void listaFuncionarios(Funcionario funcionarios[]){ //lista todos os funcionarios
        System.out.println(funcionarios.length);
        for(int i = 0; i < funcionarios.length; i++){
            System.out.println(funcionarios[i].toString());
        }     
    }

    public static boolean cpfSoNumeros(String cpf){ // verifica se o CPF eh numerico
        boolean soNumeros = false;

        for(int i = 0; i < cpf.length(); i++){
            if(Character.isDigit(cpf.charAt(i))){ // referencia utilizada no final do codigo
                soNumeros = true;
            }else{
                soNumeros = false;
                break;
            }
        }
        return soNumeros;
    }

    public static boolean cpfDuplicado(String cpf, Funcionario funcionarios[]){ // verifica se o CPF eh duplicado
        boolean ehDuplicado = true;

        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i].getCpf().equals(cpf)){
                ehDuplicado = true;
                break;
            }else{
                ehDuplicado = false;
            }
        }  

        return ehDuplicado;        
    }

    public static Funcionario[] novoFuncionario(Funcionario funcionarios[]){ // cadastra funcionario

        Funcionario[] novaListaFuncionario = new Funcionario[funcionarios.length+1];

        Scanner sc = new Scanner(System.in);
        String cpf = "";

        System.out.println("Digite o nome do funcionário:");
        String nome = sc.nextLine();

        System.out.println("Digite o CPF do funcionário somente em números:");
        cpf = sc.nextLine();

        while(cpf.length() != 11 || cpfSoNumeros(cpf) == false){
            System.out.println("CPF inválido, insira novamente somente com numeros!");
            cpf = sc.nextLine();
        }
        while(cpfDuplicado(cpf, funcionarios) == true){
            System.out.println("CPF ja cadastrado, insira um CPF unico");
            cpf = sc.nextLine();
        }

        System.out.println("Digite o valor em Reais da hora trabalhada:");
        double valorHora = sc.nextDouble();

        System.out.println("Digite a carga semanal em horas:");
        double cargaSemanal = sc.nextDouble();
        if(cargaSemanal > 44){
            cargaSemanal = 44;
        }

        System.out.println("O funcionário tem filhos? [true/false]");
        boolean temFilhos = sc.nextBoolean();    
            

        Funcionario novoFunc = new Funcionario(nome, cpf, valorHora, cargaSemanal, temFilhos);

        for(int i = 0; i <= novaListaFuncionario.length-2 ; i++){
            novaListaFuncionario[i] = funcionarios[i];
        }

        novaListaFuncionario[novaListaFuncionario.length-1] = novoFunc;

        return novaListaFuncionario;
    }
}

/* REFERENCIAS

https://www.tutorialspoint.com/how-to-check-if-a-given-character-is-a-number-letter-in-java#:~:text=We%20can%20check%20whether%20the,specified%20character%20is%20a%20digit.

*/