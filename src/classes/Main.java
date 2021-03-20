package classes

import java.io.*;

public class Main {

    public static void main(String args[]) {
        //FileFun filefun = new FileFun();

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                //filefun.readFun(line);
            }
            br.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}