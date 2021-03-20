package classes;

import java.io.*;

public class Skeleton{

    public void runUsecase(String line) {
        try {
            int num = Integer.parseInt(line);
            if (num == 1) {
                //exit(cmd);
            } else if (num == 2) {
                //pwd(cmd);
            } else if (num == 3) {
                //cd(cmd);
            } else {
                System.out.println("Invalid command");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}