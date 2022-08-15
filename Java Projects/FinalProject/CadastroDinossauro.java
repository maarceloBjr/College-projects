import java.util.Scanner;

public class CadastroDinossauro {
    private Dinossauro vetorDino[];
    private int cont;

    public CadastroDinossauro() {
        vetorDino = new Dinossauro[100];
        cont = 0;
    }

    public boolean idPositivo(int id){ //verifica se o id eh maior q 0
        if(id > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean idRepetido(int id){ //verifica se o id repete
        for(int i = 0; i < cont; i++){
            if(vetorDino[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean ehVazia(){
        if(cont == 0){
            return true;
        }
        return false;
    }

    public boolean adicionarDinossauro(Dinossauro novoDino){ //adiciona dinossauro
        if(cont < 100){ //verifica se tem espaco
            vetorDino[cont] = novoDino;
            cont++;
            return true;
        } 
        return false;
    }

    public Dinossauro pequisarDinossauro(int id){ //pesquisa dinossauro por id
        for(int i = 0; i < cont; i++){
            if(vetorDino[i].getId() == id){
                return vetorDino[i];
            } 
        }
        return null;     
    }

    public boolean removerDinossauro(int id){ //remove dinossauros
        for(int i = 0; i < cont; i++){
            if(vetorDino[i].getId() == id){
                for(int j = i; j < cont-1; j++){
                    vetorDino[j] = vetorDino[j+1];
                }
                cont--;
                return true;
            }
        }  
        return false;
    }

    public void relatorioQuantidadeDinos(){ //relatorio de dinossauros por tipo e categoria
        int qtdPPCarn = 0;
        int qtdMPCarn = 0;
        int qtdGPCarn = 0;

        int qtdPPHerb = 0;
        int qtdMPHerb = 0;
        int qtdGPHerb = 0;

        for(int i = 0; i < cont; i++){    
            if(vetorDino[i].getTipo() == 1){ //conta carnivoros por categoria
                if(vetorDino[i].getCategoria() == 1){
                    qtdPPCarn++;
                }
                if(vetorDino[i].getCategoria() == 2){
                    qtdMPCarn++;
                }
                if(vetorDino[i].getCategoria() == 3){
                    qtdGPCarn++;
                }
            }else{ //conta herbivoros por categoria
                if(vetorDino[i].getCategoria() == 1){
                    qtdPPHerb++;
                }
                if(vetorDino[i].getCategoria() == 2){
                    qtdMPHerb++;
                }
                if(vetorDino[i].getCategoria() == 3){
                    qtdGPHerb++;
                }
            }
        }

        System.out.println("\nRELATORIO - QUANTIDADE DE DINOSSAUROS CADASTRADOS\n");
        System.out.println("Quantidade de dinossouros carnívoros separados por tipo:");
        System.out.println("Pequeno porte: " + qtdPPCarn);
        System.out.println("Médio porte: "+ qtdMPCarn);
        System.out.println("Grande porte: " + qtdGPCarn);
        System.out.println("Quantidade de dinossouros herbívoros separados por tipo:");
        System.out.println("Pequeno porte: " + qtdPPHerb);
        System.out.println("Médio porte: "+ qtdMPHerb);
        System.out.println("Grande porte: " + qtdGPHerb);
    }

    public Dinossauro relatorioMaisPesado(int tipo, int categoria){ //relatorio que retorna o dinossauro mais pesado
        double maisPesado = 0;
        
        Dinossauro dinoPesado = new Dinossauro(5000, "sub", 1, 1, 0, 0);

        for(int i = 0; i < cont; i++){ //compara peso por tipo e categoria e atribui o mais pesado
            if(vetorDino[i].getTipo() == tipo && vetorDino[i].getCategoria() == categoria){
                if(vetorDino[i].getPeso() > maisPesado){
                    maisPesado = vetorDino[i].getPeso();
                    dinoPesado = vetorDino[i];
                }
            }
        }

        return dinoPesado;
    }

    public double relatorioCarne(){ //relatorio de quantidade de carne mensal para carnivoros
        double qtdCarne = 0;
        double pesoDino = 0;

        for(int i = 0; i < cont; i++){ //calcula quantidade de carne diaria por tipo
            pesoDino = vetorDino[i].getPeso();
            if(vetorDino[i].getTipo() == 1){
                if(vetorDino[i].getCategoria() == 1){
                    qtdCarne += pesoDino * 0.1;
                }else if(vetorDino[i].getCategoria() == 2){
                    qtdCarne += pesoDino * 0.15;
                }else{
                    qtdCarne += pesoDino * 0.2;
                }
            } 
        }

        return qtdCarne * 30;
    }

    public boolean relatorioFuga(int id, double distDinoBunker, double distPessoaBunker){ //relatorio de tempo de fuga para seguranca

        final int velocidadeHumano = 20;
        double tempoDino = 0;
        double tempoPessoa = 0;

        tempoPessoa = distPessoaBunker / velocidadeHumano;
        
        for(int i = 0; i < cont; i++){ //compara o id e calcula o tempo do dinossauro
            if(vetorDino[i].getId() == id){
                tempoDino = distDinoBunker / vetorDino[i].getVelocidade();
                break;
            }
        }
        
        if(tempoDino > tempoPessoa){
            System.out.println("Para este dinossauro, o bunker está em distância segura.");
            return true;
        }
        System.out.println("Para este dinossauro, o bunker NÃO está em distância segura.");
        return false;
    }

    public Dinossauro[] relatorioTop10(){ //relatorio top 10 mais rapidos
        Dinossauro top10[] = new Dinossauro[10];
        Dinossauro vetorDinoVelocidade[] = new Dinossauro[vetorDino.length];
        Dinossauro dinoTroca = vetorDino[1];

        for(int i = 0; i < cont; i++){ //clonando o vetor para ajustar por ordem de velocidade
            vetorDinoVelocidade[i] = vetorDino[i];
        }

        for(int i = 1; i < cont; i++){ // ordena por velocidade
            for(int j = 0; j < i; j++){
                if(vetorDinoVelocidade[i].getVelocidade() >= vetorDinoVelocidade[j].getVelocidade()){
                    dinoTroca = vetorDinoVelocidade[i];
                    vetorDinoVelocidade[i] = vetorDinoVelocidade[j];
                    vetorDinoVelocidade[j] = dinoTroca;
                }
            }
        }

        System.out.println("\nRELATORIO - TOP 10 DINOSSAUROS POR VELOCIDADE\n");

        for(int i = 0; i < top10.length; i++){
            top10[i] = vetorDinoVelocidade[i];
        }

        return top10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        CadastroDinossauro lista = new CadastroDinossauro();

        System.out.println("\nBem vindo ao sistema dos Jurássicos.\n");

        do{
            System.out.println("Digite a opção.");
            System.out.println("1- Adicionar dinossauro.");
            System.out.println("2- Pequisar dinossauro.");
            System.out.println("3- Remover dinossauro.");
            System.out.println("4- Menu de relatorios.");
            System.out.println("5- Sair do sistema.");
            System.out.print("Opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
            if(opcao > 5 || opcao < 1){
                System.out.println("Opcao invalida, insira novamente");
                System.out.print("Opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
            }

            switch(opcao){
                case 1:
                System.out.println("Qual o ID do dinossauro?");
                int id = Integer.parseInt(sc.nextLine());
                while(lista.idPositivo(id) == false || lista.idRepetido(id) == true){
                    System.out.println("ID inválido ou repetido, digite um novo ID.");
                    id = Integer.parseInt(sc.nextLine());
                }
    
                System.out.println("Qual a raça do dinossauro?");
                String nomeRaca = sc.nextLine();
    
                System.out.println("Qual o tipo do dinossauro?");
                System.out.println("1- Carnívoro");
                System.out.println("2- Herbívoro");
                int tipo = Integer.parseInt(sc.nextLine());
                while(tipo < 1 || tipo > 2){
                    System.out.println("Tipo invalido, insira novamente.");
                    System.out.println("1- Carnívoro");
                    System.out.println("2- Herbívoro");
                    tipo = Integer.parseInt(sc.nextLine());
                }
    
                System.out.println("Qual a categoria do dinossauro?");
                System.out.println("1- Pequeno porte");
                System.out.println("2- Médio porte");
                System.out.println("3- Grande porte");
                int categoria = Integer.parseInt(sc.nextLine());
                while(categoria < 1 || categoria > 3){
                    System.out.println("Categoria invalida, insira novamente.");
                    System.out.println("1- Pequeno porte");
                    System.out.println("2- Médio porte");
                    System.out.println("3- Grande porte");
                    categoria = Integer.parseInt(sc.nextLine());
                }
    
                System.out.println("Qual o peso do dinossauro? [em KG]");
                double peso = Double.parseDouble(sc.nextLine());
    
                System.out.println("Qual a velocidade do dinossauro? [em KM/H]");
                double velocidade = Double.parseDouble(sc.nextLine());
    
                Dinossauro novoDino = new Dinossauro(id, nomeRaca, tipo, categoria, peso, velocidade);
                
                if(lista.adicionarDinossauro(novoDino) == false){
                    System.out.println("A lista está cheia, remova um dinossauro antes de adicionar outro.\n");
                    break;
                }
                break;
    
                case 2:
                if(lista.ehVazia()){
                    System.out.println("Não posuem dinossauros cadastrados, cadastre antes de tentar pesquisar. \n");
                    break;
                }
                System.out.println("Qual o ID do dinossauro que deseja pesquisar?");
                int idPesquisar = Integer.parseInt(sc.nextLine());
                lista.pequisarDinossauro(idPesquisar);
                while(lista.pequisarDinossauro(idPesquisar) == null){
                    System.out.println("ID não encontrado, digite novamente.");
                    idPesquisar = Integer.parseInt(sc.nextLine());
                    lista.pequisarDinossauro(idPesquisar);
                }
                System.out.println(lista.pequisarDinossauro(idPesquisar).toString());
                break;
    
                case 3:
                if(lista.ehVazia()){
                    System.out.println("Não posuem dinossauros cadastrados, cadastre antes de tentar excluir. \n");
                    break;
                }
                System.out.println("Digite o ID do dinossauro que será excluído.");
                int idExcluido = Integer.parseInt(sc.nextLine());
                while(lista.removerDinossauro(idExcluido) == false){
                    System.out.println("ID não encontrado, digite novamente.");
                    idExcluido = Integer.parseInt(sc.nextLine());
                    lista.removerDinossauro(idExcluido);
                }
                System.out.println("Removido!\n");
                break;
                case 4:
                System.out.println("Qual relatorio deseja imprimir?");
                System.out.println("1- Relatorio de quantidade por tipo e categoria.");
                System.out.println("2- Relatorio do mais pesado por tipo e categoria.");
                System.out.println("3- Relatorio de quantidade de carne para os carnivoros.");
                System.out.println("4- Relatorio de seguranca (distancia do bunker).");
                System.out.println("5- Relatorio dos 10 dinossauros mais rapidos.");
                int entrada = Integer.parseInt(sc.nextLine());
                do{
                    if(entrada < 1 || entrada > 5){
                        System.out.println("Digite uma opcao valida");
                        entrada = Integer.parseInt(sc.nextLine());
                    }
                    switch(entrada){
                        case 1:
                        lista.relatorioQuantidadeDinos();
                        break;
                        case 2:
                        System.out.println("Qual o tipo que deseja analisar?");
                        tipo = Integer.parseInt(sc.nextLine());
                        System.out.println("Qual a categoria que deseja analisar?");
                        categoria = Integer.parseInt(sc.nextLine());
                        System.out.println("\nRELATORIO - MAIS PESADO POR TIPO E CATEGORIA\n");
                        System.out.println(lista.relatorioMaisPesado(tipo, categoria).toString());
                        break;
                        case 3:
                        System.out.println("\nRELATORIO - QUANTIDADE CARNE MENSAL PARA CARNIVOROS");
                        System.out.println(lista.relatorioCarne() + "Kgs");
                        break;
                        case 4:
                        System.out.println("Qual o id do dinossauro?");
                        id = Integer.parseInt(sc.nextLine());
                        while(lista.idRepetido(id) == false){
                            System.out.println("ID invalido, insira novamente.");
                            id = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("Qual a distancia do dinossauro até o bunker?");
                        double distDinoBunker = Double.parseDouble(sc.nextLine());
                        System.out.println("Qual a distancia da pessoa até o bunker?");
                        double distPessoaBunker = Double.parseDouble(sc.nextLine());
                        lista.relatorioFuga(id, distDinoBunker, distPessoaBunker);
                        break;
                        case 5:
                        Dinossauro dinoTop10[] = lista.relatorioTop10();
                        for(int i = 0; i < dinoTop10.length; i++){
                            if(dinoTop10[i] == null){
                                break;
                            }
                            System.out.println(dinoTop10[i].toString());
                        }
                        System.out.println();
                        break;
                    }
                }while(entrada < 1 || entrada > 5);
                break;
                case 5:
                System.out.println("\nSaindo...\n");
                break;
            }
        }while(opcao != 5);
        sc.close();
    }
}
