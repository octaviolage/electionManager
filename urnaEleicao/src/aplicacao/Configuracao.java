package aplicacao;

import java.util.Scanner;

public class Configuracao {
    public static void main(String[] args) throws InterruptedException {
		
        mainMenu();
}

public static void mainMenu() throws InterruptedException {
		Funcionalidades executa = new Funcionalidades();
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        while (opcao >= 0) {
        System.out.println("=====Configuracao Urnas municipais 2020!=====");
        System.out.println();
        System.out.println("Escolha uma opção abaixo:");
        System.out.println("1- Importar arquivo de configuracao Urna");
        System.out.println("2- Exportar votacoes");
        System.out.println("3- Abrir aplicação para eleitores");
        System.out.println("0- Sair da aplicacao");
        System.out.printf("Sua escolha:");
        opcao = ler.nextInt();
        switch (opcao) {
        case 1:
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            executa.importaArquivoUrna();
            executa.importaArquivoMunicipio();
            break;
            
        case 2:
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Exportando....");
            break;

        case 3:
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            Main.mainMenu();
            break;
            
        case 0:
            System.exit(1);
            
        default:
            System.err.println(">>>Opcao inválida!<<<");
            System.out.println("Voltando ao menu principal...");
            Thread.sleep(3000);
            mainMenu();
        }
    }
    
}
    
}