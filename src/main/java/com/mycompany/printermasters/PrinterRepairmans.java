/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.printermasters;

import java.util.Scanner;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author Mi
 */
public class PrinterRepairmans {

    public static void main(String[] args) {
        int P_x, P_y;
        Scanner scanner = new Scanner(System.in);
        RepListHandler listHandler = new RepListHandler();
        System.out.println("Pls, enter the X coord of destination");
        P_x = scanner.nextInt();
        System.out.println("Pls, enter the Y coord of destination");
        P_y = scanner.nextInt();
        Repairman r = listHandler.find(new ImmutablePair(P_x, P_y));
        System.out.println("The most inexpensive repairman:");
        System.out.println(r);
        System.out.println("The cost is");
        System.out.println(r.getCost());
       }
}
