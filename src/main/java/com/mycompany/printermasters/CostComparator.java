/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.printermasters;

import java.util.Comparator;

/**
 *
 * @author Mi
 */
public class CostComparator implements Comparator<Repairman> {

    @Override
    public int compare(Repairman t, Repairman t1) {
        return t.getCost() - t1.getCost();
    }

}
