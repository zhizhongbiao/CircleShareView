package cn.com.tianyudg.circleshareview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : WaterFlower.
 * Created on 2017/11/16.
 * Desc :
 */

public class CircleShareView extends View {


    private int width;
    private int height;
    private int halfWidth;
    private int halfHeight;
    private int bigRadius;
    private int smallRadius;
    private Paint mBigPaint;
    private RectF rectF;
    private Paint mSmallPaint;

    private List<Float> startAngles = new ArrayList<>();

    private float defaultStartAngle = -90;
    private List<Float> shares;
    private List<Integer> colors;

    public void setDefaultStartAngle(float defaultStartAngle) {
        this.defaultStartAngle = defaultStartAngle;
        invalidate();
    }

    public void setShareAndColor(List<Float> shares, List<Integer> colors) {
        this.shares = shares;
        this.colors = colors;
        invalidate();
    }

    private void setSmallCircleColor(@ColorInt int color) {
        mSmallPaint.setColor(color);
        invalidate();
    }

    public CircleShareView(Context context, List<Float> shares, List<Integer> colors) {
  
        this(context, null);
        this.shares = shares;
        this.colors = colors;
    }


    public CircleShareView(Context context) {
        this(context, null);
    }

    public CircleShareView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleShareView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CircleShareView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initBigPaint();
        initSmallPaint();
    }

    private void initBigPaint() {
        mBigPaint = new Paint();
        mBigPaint.setAntiAlias(true);
        mBigPaint.setStyle(Paint.Style.FILL);
        mBigPaint.setColor(Color.RED);


    }

    private void initSmallPaint() {
        mSmallPaint = new Paint();
        mSmallPaint.setAntiAlias(true);
        mSmallPaint.setStyle(Paint.Style.FILL);
        mSmallPaint.setColor(Color.WHITE);
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
        bigRadius = Math.min(halfHeight, halfWidth);
        smallRadius = bigRadius / 3;
        //RectF是以本身这个View为参照
        rectF = new RectF(halfWidth - bigRadius, halfHeight - bigRadius,
                halfWidth + bigRadius, halfHeight + bigRadius);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (shares == null || shares.isEmpty()) {
            throw new RuntimeException("List<Float> shares can not be null and its size can not be zero");
        }

        if (colors == null || colors.isEmpty()) {
            throw new RuntimeException("List<Integer> colors can not be null and its size can not be zero");
        }

        if (colors.size() != shares.size()) {
            throw new RuntimeException("List<Integer> colors's size must be same with List<Float> shares's  ");
        }
        startAngles.clear();
        startAngles.add(defaultStartAngle);
        for (Float share : shares) {
            startAngles.add(share * 360 - 90);
        }

        for (int i = 0; i < colors.size(); i++) {
            mBigPaint.setColor(colors.get(i));
            canvas.drawArc(rectF, startAngles.get(i), shares.get(i) * 360, true, mBigPaint);
        }
        canvas.drawCircle(halfWidth, halfHeight, smallRadius, mSmallPaint);


    }
}
