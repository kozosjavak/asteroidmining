package classes;

public class Skeleton{
<<<<<<< HEAD
    
=======

    public void runUsecase(String line) {
        try {
            int num = Integer.parseInt(line);
            if (num == 1) {
                //exit(cmd);
            } else if (num = 2) {
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
>>>>>>> 0771e130c2dfa7aca2d69f4d85a87e95a83ce35c
}