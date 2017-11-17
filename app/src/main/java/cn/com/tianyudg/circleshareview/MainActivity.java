package cn.com.tianyudg.circleshareview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import cn.com.tianyudg.circleshareview.view.CircleShareView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleShareView circleShareView = (CircleShareView) findViewById(R.id.csv);
        List<Integer> integers = Arrays.asList(Color.RED, Color.BLUE, Color.GREEN);
        List<Float> floats = Arrays.asList(0.3f, 0.4f, 0.3f);

//        circleShareView.setShareAndColor(floats,integers);
    }
}
