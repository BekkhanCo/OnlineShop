package com.example.onlineshopping.subCategoryin;

public class ModelSubCategoryIn {
    private int id;
    private String nomi;
    private byte[] rasmi;
    private double narxi;
    private String marka;
    private String sana;
    private int kate;

    public int getKate() {
        return kate;
    }

    public void setKate(int kate) {
        this.kate = kate;
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
}


// SELECT marka.id,marka.nomi,kategoriya.nomi,kategoriya.rasmi,kategoriya.narxi,kategoriya.sanasi FROM marka JOIN kategoriya ON kategoriya.marka_id=marka.id WHERE kategoriya.marka_id=