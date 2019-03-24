/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4_l1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David Massana
 */
public class Ejercicio4_L1 {
    
        public static ArrayList<String> nombreProd = new ArrayList<>();
        public static ArrayList<Double> precioProd = new ArrayList<>();
        public static ArrayList<Integer> cantidadProd = new ArrayList<>();
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner key = new Scanner(System.in);
        int opcion;
        do{
            menu();
            opcion = key.nextInt();
            switch(opcion){
                case 1: 
                    ingresoProductos();
                    break;
                case 2:
                    listaProductos(nombreProd, precioProd, cantidadProd);
                    break;
                case 3:
                    System.out.println("\nTOTAL A CANCELAR: " + precioTotal(precioProd, cantidadProd) +"\n");
                    break;
                case 4:
                    System.out.println("HASTA LA PROXIMA...");
                    break;
                default:
                    System.out.println("FAVOR INGRESE OPCION VALIDA...\n");
                    break;
            }
        }while(opcion != 4);
    }
    
    public static void ingresoProductos(){
        Scanner key = new Scanner(System.in);
            System.out.println("\nIngrese el nombre: ");
            nombreProd.add(key.nextLine());
            System.out.println("Ingrese el precio: ");
            precioProd.add(key.nextDouble());
            System.out.println("Ingrese la cantidad: ");
            cantidadProd.add(key.nextInt());
            System.out.print("\n");
    }
    
    public static void menu(){
        System.out.println("--------MENU PRINCIPAL--------");
        System.out.println("1. INGRESO DE PRODUCTOS");
        System.out.println("2. LISTA DE PRODUCTOS A COMPRAR");
        System.out.println("3. CALCULAR TOTAL A PAGAR");
        System.out.println("4. SALIR");
        System.out.println("--------MENU PRINCIPAL--------");
        System.out.print("\nINGRESE OPCION: ");
    }
    
    public static void listaProductos(ArrayList<String> nombre, ArrayList<Double> precio, ArrayList<Integer> cantidad){
        System.out.println("\n--------------PRODUCTOS-------------");
        System.out.println("NOMBRE\t\tCANTIDAD\tPRECIO");
        Iterator<String> iteradorN = nombre.iterator();
        Iterator<Double> iteradorP = precio.iterator();
        Iterator<Integer> iteradorC = cantidad.iterator();
        
        while (iteradorN.hasNext() && iteradorP.hasNext() && iteradorC.hasNext()) {
            System.out.println(iteradorN.next() + "\t\t" + iteradorC.next() + "\t" + iteradorP.next()); 
        }
        System.out.println("-------------PRODUCTOS-------------\n");
    }
    
    public static double precioTotal(ArrayList<Double> precio, ArrayList<Integer> cantidad){
        Iterator<Double> iteradorP = precio.iterator();
        Iterator<Integer> iteradorC = cantidad.iterator();
        double suma = 0.0;
        
        while(iteradorP.hasNext() && iteradorC.hasNext()){
            suma = suma + (iteradorP.next() * iteradorC.next());
        }
        return suma;
    }
}
