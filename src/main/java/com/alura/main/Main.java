package com.alura.main;

import com.alura.controller.PairConversionRequestController;
import com.alura.models.Coin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PairConversionRequestController pairConverter = new PairConversionRequestController();

        int choose;
        do {
            Coin coin;
            System.out.println("BIENVENIDO AL CONVERSOR DE MONEDAS" +
                    "\n" +
                    "Seleccione una opcion: " + "\n");
            System.out.println("1) Conversor de monedas");
            System.out.println("2) Historial de conversiones");
            System.out.println("9) Salir");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1 -> {
                    converterMenu(scanner, pairConverter);
                }
                case 2 -> {
                    System.out.println("Historial");
                }
                case 9 -> System.out.println("EXIT");
                default -> System.out.println("Opcion Invalida!");
            }
        } while (choose != 9);
    }

    private static void converterMenu(Scanner scanner, PairConversionRequestController pairConverter) {
        Coin coin;
        try {
            System.out.println("1) Dollar -> Peso (MXN) \n");
            System.out.println("Ingresa el tipo de moneda base. ejemplo (USD) ");
            String base_code = scanner.nextLine();
            base_code.toUpperCase();
            System.out.println("Ingresa el tipo de moneda a convertir");
            String target_code = scanner.nextLine();
            target_code.toUpperCase();
            System.out.println("Ingresa la cantidad que deseas convertir");
            String amount = scanner.nextLine();
            coin = pairConverter.Pairconvert(base_code, target_code, amount);
            System.out.println(amount + " " + coin.base_code() + ", son: " + coin.conversion_result() + " " + coin.target_code());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}