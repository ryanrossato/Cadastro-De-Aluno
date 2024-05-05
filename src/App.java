import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        //variáveis
        String op;
        boolean looping = true;    
        int tamanho = 0;    
        String[] nomeC = null;
        String[] telefone = null;

        

        while(looping){
        System.out.println("Qual operação deseja fazer?");
        System.out.println("Cadastrar - Descadastrar - Resumo - Sair");
        op = entrada.nextLine().toLowerCase();

        switch (op) {
            case "cadastrar":
            System.out.println("Quantos cadastros deseja fazer?");
            tamanho = entrada.nextInt();
            entrada.nextLine(); 
            nomeC = new String[tamanho]; // Inicialize aqui com o tamanho desejado
            telefone = new String[tamanho]; // Inicialize aqui com o tamanho desejado
                    
            for (byte i = 0 ; i < tamanho; i++){
                System.out.println("Nome Completo:");
                nomeC[i] = entrada.nextLine();  
                
                System.out.println("Telefone:");
                telefone[i] = entrada.nextLine();
                
            }
                break;

                case "descadastrar":
                System.out.println("Nome que deseja DESCADASTRAR:");
                System.out.println("");
                String nomeD = entrada.nextLine();
            
                boolean removido = false;
                for (int i = 0; i < tamanho; i++) {
                    // Verifica se o nome começa com o nome desejado
                    if (nomeC[i].startsWith(nomeD)) {
                        // Move todos os elementos após o elemento a ser removido para uma posição anterior
                        for (int j = i; j < tamanho - 1; j++) {
                            nomeC[j] = nomeC[j + 1];
                            telefone[j] = telefone[j + 1];
                        }
                        // Define o último elemento como nulo
                        nomeC[tamanho - 1] = null;
                        telefone[tamanho - 1] = null;
                        tamanho--; // Reduz o tamanho do vetor
                        removido = true;
                        System.out.println("Cadastro removido com sucesso.");
                        System.out.println("");
                        break; // Sai do loop assim que o cadastro for removido
                    }
                }
            
                if (!removido) {
                    System.out.println("Cadastro não encontrado.");
                }
                break;

            case "resumo":
            System.out.println("");
            System.out.println("Aqui estão todos os resultados:");
            for (byte i = 0 ; i < tamanho; i++){
                System.out.println("Posição " + i + ": Nome: " + nomeC[i] +" Telefone: " + telefone[i]);
                System.out.println("");
            }
            break;
            case "sair":
            System.out.println("PROGRAMA FINALIZADO");
            System.exit(0);
            break;


            default:
            System.out.println("opção errada");
                break;
        } // switch

    } //while


        entrada.close();
    }
}
