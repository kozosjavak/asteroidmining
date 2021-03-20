package classes;

import java.io.*;

public class Main {

    public static void main(String args[]) {
        Skeleton skeleton = new Skeleton();

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                skeleton.runUsecase(line);
            }
            br.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}