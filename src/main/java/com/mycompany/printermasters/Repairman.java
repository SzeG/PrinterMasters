/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.printermasters;

import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author Mi
 */
public class Repairman {
    public static Integer defaultBaseFee=100;
    public static Integer defaultTravelFee=20; 
    private Pair<Integer, Integer> officeCoords;
    private Integer baseFee;
    private Integer travelFee;
    private String name;
    private Integer cost;

    public Repairman(Pair<Integer, Integer> officeCoords, Integer baseFee, Integer travelFee, String name) {
        this.officeCoords = officeCoords;
      if(baseFee!=null)  this.baseFee = baseFee;else this.baseFee=defaultBaseFee;
        this.travelFee = travelFee;
       if(name!=null) this.name = name; else this.name="Rep_"+officeCoords.getLeft()+officeCoords.getRight();
       this.cost=0;
    }

    public Integer getX() {
        return officeCoords.getLeft();
    }

    public Integer getY() {
        return officeCoords.getRight();
    }

    public Integer getBaseFee() {
        return baseFee;
    }

    public Integer getTravelFee() {
        return travelFee;
    }

    public void setBaseFee(Integer baseFee) {
        this.baseFee = baseFee;
    }

    public void setOfficeCoords(Pair<Integer, Integer> officeCoords) {
        this.officeCoords = officeCoords;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    
    public void setTravelFee(Integer travelFee) {
        this.travelFee = travelFee;
    }

    public static Integer getDefaultBaseFee() {
        return defaultBaseFee;
    }
    
    @Override
    public String toString(){
     String s= this.getBaseFee()+" "+this.getTravelFee()+" "+this.getX()+" "+this.getY()+" "+this.getName();
     return s;
}
}
