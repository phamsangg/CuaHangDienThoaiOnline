package com.example.admin.cuahangdienthoaionline.model;

import android.view.ViewGroup;

/**
 * Created by admin on 8/30/2018.
 */

public class Loaisp {
    public int Id;
    public String Tenloaisp;
    public String Hinhanhloaisanpham;

    public Loaisp(int id, String tenloaisp, String hinhanhloaisanpham) {
        Id = id;
        Tenloaisp = tenloaisp;
        Hinhanhloaisanpham = hinhanhloaisanpham;
    }
    public Loaisp(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenloaisp() {
        return Tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        Tenloaisp = tenloaisp;
    }

    public String getHinhanhloaisanpham() {
        return Hinhanhloaisanpham;
    }

    public void setHinhanhloaisanpham(String hinhanhloaisanpham) {
        Hinhanhloaisanpham = hinhanhloaisanpham;
    }
}
