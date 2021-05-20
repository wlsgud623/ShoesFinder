package com.example.shoesfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ResultActivity extends AppCompatActivity {

    Bitmap br;
    ImageView img, img_res;
    View resulteview, similar_shoes, resultText;
    View ss, ts, fs;
    TextView fb, fp;
    TextView sst, tst, fst;
    ImageView sp, tp, fop;
    String[] barr, parr;
    String url;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        byte[] arr = intent.getByteArrayExtra("PhotoforSearch");
        br = BitmapFactory.decodeByteArray(arr,0, arr.length);

        resulteview = (View) findViewById(R.id.picture_result);
        similar_shoes = (View) findViewById(R.id.similar_shoes);
        resultText = (View) findViewById(R.id.name_result);

        ss = (View)similar_shoes.findViewById(R.id.first_Shoes);
        ts = (View)similar_shoes.findViewById(R.id.second_Shoes);
        fs = (View)similar_shoes.findViewById(R.id.third_Shoes);

        sst = (TextView)ss.findViewById(R.id.Shoes_Name);
        tst = (TextView)ts.findViewById(R.id.Shoes_Name);
        fst = (TextView)fs.findViewById(R.id.Shoes_Name);

        sp = (ImageView)ss.findViewById(R.id.Shoes_Photo);
        tp = (ImageView)ts.findViewById(R.id.Shoes_Photo);
        fop = (ImageView)fs.findViewById(R.id.Shoes_Photo);

        img = (ImageView)resulteview.findViewById(R.id.original_small_pic);
        img.setImageBitmap(br);

        img_res = (ImageView) resulteview.findViewById(R.id.result_small_pic);


        //fb = (TextView) resulteview.findViewById(R.id.first_brand);
        //fb.setText(barr[0]);

        barr = intent.getStringArrayExtra("Brandarr");
        parr = intent.getStringArrayExtra("Percent");

        fb = (TextView)resultText.findViewById(R.id.result_shoes_name);
        fp = (TextView)resultText.findViewById(R.id.result_shoes_percent);

        fb.setText(barr[0]);
        fp.setText(parr[0] + "%");

        String url = "https://firebasestorage.googleapis.com/v0/b/shoes-finder-project.appspot.com/o/Shose_Image%2F%EC%BB%A8%EB%B2%84%EC%8A%A4%20%EC%B2%99%ED%85%8C%EC%9D%BC%EB%9F%AC%20%EB%AC%B4%EB%B8%8C%20%ED%95%98%EC%9D%B4.jpg?alt=media&token=5fa688ae-0b92-45bd-b841-c7a05c962d81";
        Glide.with(this).load(url).override(160,200).into(img_res);





        //fp = (TextView) resulteview.findViewById(R.id.first_percent);
        //fp.setText(parr + " %");

        //sst.setText(barr[1]);
        //sst.setTextSize(15);
        //tst.setText(barr[2]);
        //tst.setTextSize(15);
        //fst.setText(barr[3]);
        //fst.setTextSize(15);
    }
}