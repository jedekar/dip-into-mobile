package ua.kpi.comsys.io8128.ui.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class DonutChart extends View {
    private List<DonutSlice> data;
    private Paint paint;

    private float boundLeft;
    private float boundTop;
    private float boundRight;
    private float boundBottom;

    public DonutChart(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < data.size(); ++i) {
            DonutSlice slice = data.get(i);
            paint.setColor(slice.color);
            canvas.drawArc(boundLeft, boundTop, boundRight, boundBottom,
                    360 - slice.endAngle,
                    slice.endAngle - slice.startAngle,
                    false, paint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int width = getWidth();
        int height = getHeight();
        int radius;
        if (width > height) {
            radius = height / 3;
        } else {
            radius = width / 3;
        }

        int stroke = (int) (radius * 0.75);
        paint.setStrokeWidth(stroke);
        boundTop = height / 2 - radius;
        boundBottom = boundTop + radius * 2;
        boundLeft = width / 2 - radius;
        boundRight = boundLeft + radius * 2;
    }

    public void setData(List<DonutSlice> data) {
        this.data = data;
    }
}
