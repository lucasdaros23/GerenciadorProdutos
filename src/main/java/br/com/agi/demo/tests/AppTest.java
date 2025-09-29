package br.com.agi.demo.tests;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class AppTest {
        public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao = 999;



        do {
            System.out.println("-------------------| MENU |-------------------");
            System.out.println("1 - post");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> criarUsuario();
            }
        }while (opcao!=0);

    }

    private static void criarUsuario(){
        System.out.print("nome: ");
        String nome = sc.nextLine();
    }
}
