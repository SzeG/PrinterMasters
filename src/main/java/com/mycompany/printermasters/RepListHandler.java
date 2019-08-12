/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.printermasters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author Mi
 */
public class RepListHandler {

    private List<Repairman> RepList;

    public RepListHandler() {
        RepList = new ArrayList<>();
        load();
        list();
    }

    public void load() {
        try {
            FileReader fr = new FileReader("masters.dat");
            BufferedReader br = new BufferedReader(fr);

            String name = "";
            String s = br.readLine();
            while (s != null) {

                String[] string = s.split(" ");
                if (string.length > 5) {
                    for (int i = 4; i < string.length - 1; i++) {
                        name = name.concat(string[i]);
                        name = name.concat(" ");
                    }
                    name = name.concat(string[string.length - 1]);
                } else {

                    name = string[4];
                }

                Repairman r;
                r = new Repairman(new ImmutablePair(new Integer(Integer.parseInt(string[2])), new Integer(Integer.parseInt(string[3]))), Integer.parseInt(string[0]), new Integer(Integer.parseInt(string[1])), name);
                RepList.add(r);
                s = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepListHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepListHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void save() {
        try {
            FileWriter fw = new FileWriter("masters.dat");
            PrintWriter pw = new PrintWriter(fw);
            RepList.forEach((r) -> {
                pw.println(r);
            }
            );
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: masters.dat");
        } catch (IOException ex) {
            System.out.println("File writing failed");
        }
    }

    public void add(Repairman r) {
        RepList.add(r);
    }

    public boolean remove(Repairman r) {
        return true;
    }

    public Repairman find(Pair p) {

        for (Repairman r : RepList) {
            int cost;
            Double d = (Math.sqrt(Math.pow(r.getX() - (Integer) p.getLeft(), 2) + Math.pow(r.getY() - (Integer) p.getRight(), 2))) * r.getTravelFee() + r.getBaseFee();
            cost = d.intValue();
            r.setCost(cost);
        }
        RepList.sort(new CostComparator());
        Repairman r = RepList.get(0);
        return r;

    }

    public void list() {
        System.out.println("Available repairmans:");
        RepList.forEach((r) -> {
            System.out.println(r);
        });
    }
}
