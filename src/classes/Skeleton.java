package classes;

import java.io.*;

public class Skeleton{

    public void runUsecase(String line) throws NumberFormatException {
        int num = Integer.parseInt(line);
            if (num == 1) {
                //exit(cmd);
                System.out.println("Ez az elso parancs.");
            } else if (num == 2) {
                //pwd(cmd);
            } else if (num == 3) {
                //cd(cmd);
            } else {
                System.out.println("Invalid command");
            }

    }
}