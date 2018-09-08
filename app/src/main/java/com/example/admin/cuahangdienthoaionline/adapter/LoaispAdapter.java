package com.example.admin.cuahangdienthoaionline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.cuahangdienthoaionline.R;
import com.example.admin.cuahangdienthoaionline.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by admin on 8/30/2018.
 */

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arraylistloaisp= new ArrayList<>();// khuôn dữ liệu
    Context context;// truyen cho nos man hinh de no biet vẽ trên màn hình nào

    public LoaispAdapter(ArrayList<Loaisp> arraylistloaisp, Context context) {
        this.arraylistloaisp = arraylistloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylistloaisp.size();// đổ hêt dữ liệu trong mảng ra

    }

    @Override
    public Object getItem(int position) {
        return arraylistloaisp.get(position);// lấy từng thuộc tính trong giá trị mảng
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        TextView tvtenloaisp;
        ImageView imgloaisp;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView == null){//neu cai view trống
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Giả sử bạn muốn tạo một cái view, thì để biết cái view đó đang
            // chịu trách nhiệm phần giao diện nào (XML) thì bạn phải inflate cái XML đó vào view.
            convertView = inflater.inflate(R.layout.dong_listview,null);
            viewHolder.tvtenloaisp= convertView.findViewById(R.id.tvlaoisp);
            viewHolder.imgloaisp=convertView.findViewById(R.id.imvloaisp);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
//            Loaisp loaisp= (Loaisp) getItem(position);
//            viewHolder.tvtenloaisp.setText(loaisp.getTenloaisp());
//            Picasso.with(context).
//                    load(loaisp.getHinhanhloaisanpham()).
//                    placeholder(R.drawable.b).
//                    into(viewHolder.imgloaisp);
        }
        Loaisp loaisp= (Loaisp) getItem(position);
        viewHolder.tvtenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).
                load(loaisp.getHinhanhloaisanpham()).
                placeholder(R.drawable.b).
                into(viewHolder.imgloaisp);

        return convertView;
    }
}
