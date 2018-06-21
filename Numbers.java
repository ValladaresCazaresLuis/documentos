/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbers;

import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);
        String[] Nums = new String[100];
        int T = 100;
        int K = 0;
        
        do {

            System.out.println("Ingresar cantidad de enteros no mayor a 100");
            T = ent.nextInt();
            if (T > 100 || T < 1) {
                System.out.println("Error en la cantidad");
            }

        } while (T > 100 || T < 1);

        System.out.println("Ingresar valores ");
        for (int i = 0; i <= T; i++) {
            Nums[i] = ent.nextLine();
        }
        
        do {
            System.out.println("Ingresar valor de K no mayor a 7: ");
            K = ent.nextInt();
            if (K > 7 || K < 1) {
                System.out.println("Error en la cantidad");
            }
        } while (K > 7 || K < 1);
        
        
        char tal = ' ';

        int producto_Subcadena = 1;
        int producto_Num = 0;
        int prod_Maj = 0;

        int[] list_prod = new int[7];

        int m = 0;

        for (int i = 0; i <= T; i++) {// Posicion de array
            prod_Maj = 0;

            //Verificación de entero: si es posible recorrer sus digitos
            if (Nums[i].length() >= K) {

                System.out.println("número a analizar: " + Nums[i]);

                //Delimitación de obtención de numero de veces a recorrer el entero
                int cads = Nums[i].length() - K + 1;

                //Loop para recorrer la subcadena de números
                for (int l = 0; l < cads; l++) {

                    //guardar números a la subcadena
                    for (m = 0; m < K; m++) {
                        tal = Nums[i].charAt(l + m);
                        list_prod[m + 1] = Character.getNumericValue(tal);
                    }

                    producto_Subcadena = 1;
                    producto_Num = 1;

                    //Operación de subcadena
                    for (int n = 1; n <= K; n++) {
                        //System.out.println("Operación "+n+" cadenita de numero "+i+" :"+list_prod[n]+" * "+producto_cadenita);
                        producto_Subcadena = list_prod[n] * producto_Subcadena;
                        // System.out.println("Producto cadenita de numero "+n+" :"+producto_cadenita);

                    }

                    //Verificación de producto más grande
                    if (producto_Subcadena > prod_Maj) {
                        prod_Maj = producto_Subcadena;
                    }
                }
                //Impresión de número más grande de subcadena del entero analizado
                System.out.println("Mayor producto de cadena " + prod_Maj);
            }
        }
    
    }
}
