package com.jojo.jiaminsun.rxjavademo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_click;
    LinearLayout line_image;
    private MyHoveringScrollView view_hover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

//        btn_click = (Button)findViewById(R.id.btn_click);
//        line_image = (LinearLayout)findViewById(R.id.line_image);
//        btn_click.setOnClickListener(this);
        view_hover = (MyHoveringScrollView) findViewById(R.id.view_hover);
        view_hover.setTopView(R.id.top);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Toast.makeText(MainActivity.this,"点击了按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isLayoutIn = true;
    private boolean isAnimationRuning;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.btn_click:
//                switchOpte();
//                break;
        }
    }

    private void switchOpte(){


        Animation topAnimation;
        Animation bottomAnimation;
        if (isLayoutIn) { // 划出动画 消失 往左边移动

            bottomAnimation = new AlphaAnimation(1, 0);
            topAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1,
                    Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF, 0);
            topAnimation.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    isAnimationRuning = true;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    isAnimationRuning = false;
                    line_image.setVisibility(View.GONE);



                }
            });
        } else { // 划入动画 显示 往右边移动

            line_image.setVisibility(View.VISIBLE);

            bottomAnimation = new AlphaAnimation(0, 1);
            topAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0,
                    Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
            topAnimation.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    isAnimationRuning = true;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    isAnimationRuning = false;

                }
            });
        }

        topAnimation.setFillAfter(true);

        bottomAnimation.setFillAfter(true);
        topAnimation.setDuration(300);
        bottomAnimation.setDuration(300);
        isLayoutIn = !isLayoutIn;
        line_image.startAnimation(topAnimation);

    }
}
