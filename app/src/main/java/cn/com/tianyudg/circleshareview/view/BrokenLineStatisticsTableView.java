package cn.com.tianyudg.circleshareview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : WaterFlower.
 * Created on 2017/11/17.
 * Desc :
 */

public class BrokenLineStatisticsTableView extends View {
    private int width;
    private int height;
    private int halfWidth;
    private int halfHeight;
    private Paint mLinePaint;
    private Paint mTextPaint;
    private float singleLength;

    private List<String> texts = new ArrayList<>();

    public BrokenLineStatisticsTableView(Context context) {
        super(context);
    }

    public BrokenLineStatisticsTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BrokenLineStatisticsTableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLinePaint();
        initTextPaint();
    }

    private void initLinePaint() {
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setColor(Color.RED);
    }

    private void initTextPaint() {
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.BLACK);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initParams();
    }


    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        initParams();
    }

    private void initParams() {
        width = getWidth();
        height = getHeight();
        halfWidth = width / 2;
        halfHeight = height / 2;
        singleLength = width / 6f;

    }

    private float getTextLength(String text, Paint paint) {
        if (!TextUtils.isEmpty(text)) {
            return paint.measureText(text);
        }
        return 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {

//        canvas.drawT

    }
}
