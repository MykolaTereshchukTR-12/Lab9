import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        Main mainObject = new Main();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hello, It's project 9, please enter a mode you want to use here. " +
                    "If you don`t know which modes are available, just type 2 to get a 'Help'");
            int mode = scanner.nextInt();

            scanner.nextLine();

            try {
                mainObject.cases(mode);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid mode number.");
            }
        }
    }

    private void cases(int mode) {
        switch (mode) {
            case 1: // TASK
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FirstForm formObject = FirstForm.launchTheApp();
                    }
                });
                System.out.println("The application is already running, check it!");
                return;
            case 2: // HELP
                System.out.println("By typing '1' you will access the first and only task of this project!" +
                        " If you type '2', you will be dragged here again (Help)\n");
        }
    }
}
