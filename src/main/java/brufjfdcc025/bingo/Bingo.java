package brufjfdcc025.bingo;

import java.util.Random;
import java.util.Scanner;

/*
    Gabriel Evaristo Carlos
    201965034AB
*/
public class Bingo {
    public static void main(String[] args){
        System.out.println("----- SEJA BEM-VINDO -----");
        System.out.println("Quantos jogadores participarão do nosso bingo?");
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();
        Cartela cartela[] = new Cartela[N];
        for(int i = 0; i<N; i++){
            cartela[i] = new Cartela();
        }
        for(int i = 0; i<N; i++){
            
            cartela[i].ImprimirCartela();
        }
        boolean ganhar = false;
        int vetordesorteados[],numerosorteado,vetordeganhadores[];
        vetordesorteados = new int[75];
        vetordeganhadores = new int[N];
        for(int i = 0; i<75;i++){
            vetordesorteados[i] = 0;
        }
        for(int i = 0; i<N;i++){
            vetordeganhadores[i] = 0;
        }
        int pos=0,ganhador=1,posganhar=0;
        while(ganhar == false){
            numerosorteado = SortearNumero(vetordesorteados);
            vetordesorteados[pos] = numerosorteado;
            System.out.println("Numero sorteado: "+numerosorteado);
            for(int i=0; i<N; i++){
                cartela[i].VerificaCartela(numerosorteado);
                cartela[i].ImprimirCartela();
                ganhar = cartela[i].VerificaGanhar();
                ganhador++;
                if(ganhar == true){
                    vetordeganhadores[posganhar] = cartela[i].getNum();
                    ganhar=false;
                    posganhar++;
                }
            }
            if(vetordeganhadores[0] != 0)
                ganhar=true;
            pos++;
        }
        System.out.println("BINGO!!!");
        System.out.println("Cartela(s) Vencedora(s) ");
        for(int i = 0; i<posganhar;i++){
            System.out.print(vetordeganhadores[i] + " ");
        }
    }
    public static int SortearNumero(int[] vetordesorteados){
        int numsort;
        Random gerador = new Random();
        numsort = gerador.nextInt(75)+1;
        
        for(int i=0; i<75;i++){
            if(numsort == vetordesorteados[i]){
                while(numsort == vetordesorteados[i])
                    numsort = gerador.nextInt(75)+1;
                i=0;
            }
        }
        
        return numsort;
    }
}
