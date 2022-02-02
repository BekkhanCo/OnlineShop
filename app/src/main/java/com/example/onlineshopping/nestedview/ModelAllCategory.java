package com.example.onlineshopping.nestedview;

import java.util.ArrayList;

public class ModelAllCategory {
    private int id;
    private String nomi;
    private byte[] rasmi;
    private double narxi;
    private String marka;
    private String sana;
    private int soni;


    public ModelAllCategory() {
        this.rasmi = rasmi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public byte[] getRasmi() {
        return rasmi;
    }

    public void setRasmi(byte[] rasmi) {
        this.rasmi = rasmi;
    }

    public double getNarxi() {
        return narxi;
    }

    public ModelAllCategory(byte[] rasmi) {
        this.rasmi = rasmi;
    }

    public void setNarxi(double narxi) {
        this.narxi = narxi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

    public int getSoni() {
        return soni;
    }

    public void setSoni(int soni) {
        this.soni = soni;
    }
}
