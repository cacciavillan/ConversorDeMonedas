package com.conversor.ui;

import com.conversor.calculadora.CurrencyConverter;

import java.util.Scanner;

public class UserConsole {
    CurrencyConverter converter = new CurrencyConverter();

    Double ammount;
    Double result;
    String fromCurrency;
    String toCurrency;

    private Scanner scanner;
    public UserConsole() {
        this.scanner = new Scanner(System.in);
    }

    public void showOptions() {
        System.out.println("****** CONVERSOR DE DIVISAS ******");
        System.out.println("Elija el par de divisas a converir");
        System.out.println("1: *** ARS / USD ***");
        System.out.println("2: *** ARS / EUR ***");
        System.out.println("3: *** EUR / USD ***");
        System.out.println("4: *** GBP / USD ***");
        System.out.println("5: *** Salir ***");
    }

    public void start () {
        int command;
        do {
            showOptions();

            System.out.print("> ");
            command = scanner.nextInt();

            processCommand(command);
            conversionPrint(result);
        } while (command != 5);
        System.out.println("Gracias por usar CONVERSOS DE DIVISAS");
    }

    private void processCommand(int command) {

        switch (command) {
            case 1:
                System.out.println("Ingrese el monto");
                System.out.print("> ");
                ammount = scanner.nextDouble();
                fromCurrency = "ARS";
                toCurrency = "USD";
                result = converter.convert(ammount,"ARS","USD");
                break;
            case 2:
                System.out.println("Ingrese el monto");
                System.out.print("> ");
                ammount = scanner.nextDouble();
                fromCurrency = "ARS";
                toCurrency = "EUR";
                result = converter.convert(ammount,"ARS","EUR");
                break;
            case 3:
                System.out.println("Ingrese el monto");
                System.out.print("> ");
                ammount = scanner.nextDouble();
                fromCurrency = "EUR";
                toCurrency = "USD";
                result = converter.convert(ammount,"EUR","USD");
                break;
            case 4:
                System.out.println("Ingrese el monto");
                System.out.print("> ");
                ammount = scanner.nextDouble();
                fromCurrency = "GBP";
                toCurrency = "USD";
                result = converter.convert(ammount,"GBP","USD");
                break;
            default:
                if (command != 5) {
                    System.out.println("Opcion inválida, intente nuevamente");
                }
                break;
        }
    }

    public void conversionPrint(Double result) {
        System.out.println(String.format("%.2f %s EQUIVALEN A %.2f %s", ammount, fromCurrency, result, toCurrency ));
        System.out.println("");
    }
}
