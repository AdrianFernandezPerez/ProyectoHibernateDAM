package view;

import java.util.Scanner;

public class View {
    Scanner scan = new Scanner(System.in);
    public void muestraMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public  String pideString(String mensaje) {
        String texto = "";
        scan.useDelimiter("\n");
        System.out.print(mensaje);
        texto = scan.next();

        return texto;
    }

    public int pideInt(String mensaje) {
        int num = 0;
        boolean ok = false;
        do {
            try {
                System.out.print(mensaje);
                num = scan.nextInt();
                ok = true;
            } catch (java.util.InputMismatchException e) {
                ok = false;
                System.out.println("Error, introduce un número");
                scan.useDelimiter("\n");
                scan.next();
            }
        } while (!ok);

        return num;
    }
}
