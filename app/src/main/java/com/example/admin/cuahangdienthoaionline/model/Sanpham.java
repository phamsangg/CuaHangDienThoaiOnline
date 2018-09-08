package com.example.admin.cuahangdienthoaionline.model;

/**
 * Created by admin on 9/7/2018.
 */

public class Sanpham {
    private int id;
    private String tensanpham;
    private int giasanpham;
    private String hinhanhsanpham;
    private String mota;
    private int idsanpham;
    ///video la public

    public Sanpham(int id, String tensanpham, int giasanpham, String hinhanhsanpham, String mota, int idsanpham) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.giasanpham = giasanpham;
        this.hinhanhsanpham = hinhanhsanpham;
        this.mota = mota;
        this.idsanpham = idsanpham;
    }
    public Sanpham(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getGiasanpham() {
        return giasanpham;
    }

    public void setGiasanpham(int giasanpham) {
        this.giasanpham = giasanpham;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(int idsanpham) {
        this.idsanpham = idsanpham;
    }
}
