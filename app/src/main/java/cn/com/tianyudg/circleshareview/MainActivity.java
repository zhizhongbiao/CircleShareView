package cn.com.tianyudg.circleshareview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import cn.com.tianyudg.circleshareview.view.BrokenLineStatisticsTableView;
import cn.com.tianyudg.circleshareview.view.CircleShareView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleShareView circleShareView = (CircleShareView) findViewById(R.id.csv);
        BrokenLineStatisticsTableView blst = (BrokenLineStatisticsTableView) findViewById(R.id.blst);
        List<Integer> integers = Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW);
        List<Float> floats = Arrays.asList(0.1f, 0.4f, 0.3f,0.2f);
        List<String> xSubjects = Arrays.asList("十月", "十月","十月","十月","十月","十月","十月");
        List<Integer> ySubjects = Arrays.asList(1542, 2455, 345, 454, 5245, 642, 7424);
        blst.setData(xSubjects,ySubjects);
        circleShareView.setShareAndColor(floats,integers);
    }
}
