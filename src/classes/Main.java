package classes;

import java.io.*;

public class Main {

    public static void main(String args[]) {
        Skeleton skeleton = new Skeleton();
        try {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

            while (true) {
                try {
                    String line = br.readLine();
                    if (line == null) break;
                    skeleton.runUsecase(line);
                } catch (NumberFormatException ex){
                    System.out.println("A megadott parancs nem szam.");
                    //ex.printStackTrace();
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}