package com.example.admin.cuahangdienthoaionline.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.cuahangdienthoaionline.R;
import com.example.admin.cuahangdienthoaionline.adapter.LoaispAdapter;
import com.example.admin.cuahangdienthoaionline.model.Loaisp;
import com.example.admin.cuahangdienthoaionline.ultil.CheckConnectionInternet;
import com.example.admin.cuahangdienthoaionline.ultil.Sever;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    ArrayList<Loaisp> arrayListLoaisp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        if (CheckConnectionInternet.haveNetworkConnection(getApplicationContext())){
            Actionbar();
            ActionViewFlipper();
            GetDuLieuLoaisp();
        }else{
            CheckConnectionInternet.showToast_Shot(getApplicationContext(),"Kiểm tra lại keetss nối mạng!");
            finish();
        }

    }

    private void GetDuLieuLoaisp() {
        arrayListLoaisp= new ArrayList<>();
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());//thực hiên phương thức gửi lên sever
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Sever.duongDanLoaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response !=null){
                    for (int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String tenLoaisp = jsonObject.getString("tenloaisanpham");
                            String  hinhLoaisp= jsonObject.getString("hinhanhsanpham");
                            mangloaisp.add(new Loaisp(id,tenLoaisp,hinhLoaisp));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mangloaisp.add(0,new Loaisp(0,"Giỏ hàng","https://previews.123rf.com/images/luka007/luka0071505/luka007150500204/39574212-shopping-cart-icon.jpg"));
                }
                loaispAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnectionInternet.showToast_Shot(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);



    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao= new ArrayList<>();
        mangquangcao.add("https://tinhte.cdnforo.com/store/2014/08/2572609_Hinh_2.jpg");
        mangquangcao.add("https://baomoi-photo-1-td.zadn.vn/w1000_r1/16/12/11/139/21053302/4_33173.jpg");
        mangquangcao.add("https://dantricdn.com/thumb_w/640/503cf536a0/2017/09/21/img20170921085513447-5ecb1.jpg");
        mangquangcao.add("https://kenh14cdn.com/Images/Uploaded/Share/2011/06/03/110603tekb3.jpg");

        for(int i=0;i<mangquangcao.size();i++){
            ImageView imageView= new ImageView(getApplicationContext());//viewflipper cần imageview
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);// đinh thời gian hiển thị 1 ảnh là 5s
        viewFlipper.setAutoStart(true);// tự động chạy quảng cáo
        Animation animation_slide_in= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void Actionbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
    }
    private void Init() {
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewfliprer);
        recyclerViewmanhinhchinh = (RecyclerView) findViewById(R.id.recyclerview);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewmanhinhchinh = (ListView) findViewById(R.id.lvmanhinhchinh);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawerlayout);
        mangloaisp= new ArrayList<>();
        loaispAdapter= new LoaispAdapter(mangloaisp,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);

    }
}





















































