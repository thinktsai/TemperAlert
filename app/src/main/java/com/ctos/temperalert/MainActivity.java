package com.ctos.temperalert;

import android.content.Context;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 //      lockStatusBar();
    }

    public void lockStatusBar() {
        WindowManager manager = ((WindowManager) this.getApplicationContext().getSystemService(Context.WINDOW_SERVICE));

        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
        localLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        localLayoutParams.gravity = Gravity.TOP;
        localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;

        int resId = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int result = 0;
        if (resId > 0) {
            result = this.getResources().getDimensionPixelSize(resId);
        } else {
            result = 60; // 60px
        }

        localLayoutParams.height = result;
        localLayoutParams.format = PixelFormat.TRANSPARENT;

        class VG extends ViewGroup {
            public VG(Context context) {
                super(context);
            }
            @Override
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
            }

        }

        manager.addView(new VG(this), localLayoutParams);
    }

}
