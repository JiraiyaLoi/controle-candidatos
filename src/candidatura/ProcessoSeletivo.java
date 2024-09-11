package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        // primeiro código(case 1)

        // analisarCandidato(1900.0);
        // analisarCandidato(2200.0);
        // analisarCandidato(2000.0);

        // case 2
        // selecaoCandidatos();

        // case 3
        // imprimirSelecionados();

        //case 4

        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        for(String candidato : candidatos){
            entrandoEmContato(candidato);;
        }



    }
    //case 1
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
    //case 2
    static void selecaoCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi SELECIONADO para a vaga");
                candidatosSelecionados++;
            }else {
                System.out.println("O candidato " + candidato + " foi REJEITADO para a vaga");
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        // gera valores aleatórios entre o primeiro parametro (1800) e o segundo (2200)
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // case 3
    static void imprimirSelecionados(){
         String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        
         System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

         for(int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de número: " + (indice+1) + " é " + candidatos[indice]);
         }

         //ou 

         System.out.println("Forma abreviada da interação for each");

         for(String candidato : candidatos){
            System.out.println("O canditado selecionado é o: " + candidato);
        }

    }


    //case 4

    //método auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            // tentativasRealizadas e continuarTentando devem sofrer modificações para não resultar em loop infinito
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){ 
                tentativasRealizadas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }

        }while(continuarTentando && tentativasRealizadas < 3);
        if(atendeu){
        System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA.");
        }else{ 
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " DEPOIS DE " + tentativasRealizadas + " TENTATIVAS REALIZADAS.");
        }
    }











}
