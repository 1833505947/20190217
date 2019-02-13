package com.example.fanshezhujiefanxing20190213;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView fresco;
    Button yuanjiao,yuanxing,bili,donghua,zhujie,fanshe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initData();
    }

    private void initData() {
        Uri uri = Uri.parse("http://www.zhaoapi.cn/images/quarter/ad1.png");
        fresco.setImageURI(uri);
        yuanjiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(20);
                roundingParams.setRoundAsCircle(false);
                roundingParams.setCornersRadius(7);
                fresco.getHierarchy().setRoundingParams(roundingParams);


            }
        });
        yuanxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(20);
                roundingParams.setRoundAsCircle(true);
                fresco.getHierarchy().setRoundingParams(roundingParams);
            }
        });
        bili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fresco.setAspectRatio(1.2f);
            }
        });
        donghua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControllerListener controllerListener = new BaseControllerListener<ImageInfo>(){
                    @Override
                    public void onFinalImageSet(String id,ImageInfo imageInfo, Animatable animatable) {
                        super.onFinalImageSet(id, imageInfo, animatable);
                        if (animatable!=null){
                            animatable.start();
                        }
                    }
                };
                Uri uri2 = Uri.parse("http://www.zhaoapi.cn/images/girl.gif");
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setControllerListener(controllerListener)
                        .setUri(uri2)
                        // other setters
                        .build();
                fresco.setController(controller);
            }


        });
        zhujie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hello world",Toast.LENGTH_SHORT).show();
            }
        });
        fanshe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {
        fresco = findViewById(R.id.fresco);
        yuanjiao = findViewById(R.id.yuanjiao);
        yuanxing = findViewById(R.id.yuanxing);
        bili = findViewById(R.id.bili);
        donghua = findViewById(R.id.donghua);
        zhujie = findViewById(R.id.zhujie);
        fanshe = findViewById(R.id.fanshe);
    }
}
