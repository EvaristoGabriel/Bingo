package brufjfdcc025.bingo;

import java.util.Random;

public class Cartela {
    public static int numcartela=1;
    public int num,numsort;
    private String[][] cartela;
    private Random gerador;

    public Cartela() {
        num = numcartela;
        numcartela++;
        cartela = new String[6][5];
        gerador = new Random();
        int nume;
        this.cartela[0][0] = "B ";
        this.cartela[0][1] = "I ";
        this.cartela[0][2] = "N ";
        this.cartela[0][3] = "G ";
        this.cartela[0][4] = "O ";
        for(int i=1; i<6;i++){
            for(int j=0; j<5; j++){
                if(i == 3 && j == 2)
                    this.cartela[i][j] = " ☺";
                else{
                    if(j == 0){
                        nume = gerador.nextInt(15)+1;
                        this.cartela[i][j] = Integer.toString(nume);
                    }
                    if(j == 1){
                        nume = 16+ gerador.nextInt(15);
                        this.cartela[i][j] = Integer.toString(nume);
                    }
                    if(j == 2){
                        nume = 31+gerador.nextInt(15);
                        this.cartela[i][j] = Integer.toString(nume);
                    }
                    if(j == 3){
                        nume = 46 + gerador.nextInt(15);
                        this.cartela[i][j] = Integer.toString(nume);
                    }
                    if(j == 4){
                        nume = 61 + gerador.nextInt(15);
                        this.cartela[i][j] = Integer.toString(nume);
                    }
                }
            }
        }
    }

    public void ImprimirCartela(){
        System.out.println("Cartela: "+num);
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5; j++){
                //System.out.println("i = "+i+"\nj = "+j);
                System.out.print(this.cartela[i][j]+"|");
            }
            System.out.println("");
            System.out.println("-------------");
        }
    }
    
    public void VerificaCartela(int num){
        for(int i = 1; i < 6; i++){
            for(int j = 0; j < 5; j++){
                if(this.cartela[i][j].equals(Integer.toString(num))){
                    this.cartela[i][j] = "x";
                }
            }
        }
    }
    public boolean VerificaGanhar(){
        
        for(int i = 1; i < 6; i++){
            for(int j = 0; j < 5; j++){
                if(i == 3 && j == 2)
                    ;
                else{
                    if(this.cartela[i][j].equals("x")){
                        ;
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }

    public int getNum() {
        return this.num;
    }

    public static void setNumcartela(int num) {
        Cartela.numcartela = num;
    }
    
    
}
