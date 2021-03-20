package classes;

import java.io.*;

public class Skeleton{

    public void runUsecase(String line) throws NumberFormatException {
        int num = Integer.parseInt(line);
            if (num == 1) {
                System.out.println("Ez a komment helye volt.");
                System.out.println("Ez az elso parancs.");
            } else if (num == 2) {
                System.out.println("Ez a masodik parancs.");
                //pwd(cmd);
            } else if (num == 3) {
                //cd(cmd);
            } else {
                System.out.println("Invalid command");
            }

    }
}