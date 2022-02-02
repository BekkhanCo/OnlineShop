package com.example.onlineshopping.CategoryItem;

public class ModelCategoryItem {
    private int id;
    private String nomi;
    private Double narxi;
    private String sanasi;
    private int marka_id;

    public int getMarka_id() {
        return marka_id;
    }

    public void setMarka_id(int marka_id) {
        this.marka_id = marka_id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public Double getNarxi() {
        return narxi;
    }

    public void setNarxi(Double narxi) {
        this.narxi = narxi;
    }

    public String getSanasi() {
        return sanasi;
    }

    public void setSanasi(String sanasi) {
        this.sanasi = sanasi;
    }

    private byte[] rasm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getRasm() {
        return rasm;
    }

    public void setRasm(byte[] rasm) {
        this.rasm = rasm;
    }

    public ModelCategoryItem() {
        this.id = id;
        this.rasm = rasm;
    }
}
