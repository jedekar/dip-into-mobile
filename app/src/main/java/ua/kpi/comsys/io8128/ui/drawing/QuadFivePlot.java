package ua.kpi.comsys.io8128.ui.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class QuadFivePlot extends View {
    private Paint paint;
    private Path axes;
    private Path quad;
    private Matrix matrix;

    public QuadFivePlot(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAxes();
        initQuad();
        initPaint();

        matrix = new Matrix();
        matrix.setValues(new float[] {1, 0, 0, 0, 1, 0, 0, 0, 1});
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
    }

    private void initQuad() {
        quad = new Path();
        quad.moveTo(-10, -25);
        quad.quadTo(0, 25, 10, -25);
    }

    private void initAxes() {
        axes = new Path();
        axes.moveTo(-28, 0);
        axes.lineTo(28, 0);

        axes.moveTo(26, 2);
        axes.lineTo(28, 0);
        axes.lineTo(26, -2);

        axes.moveTo(2, -26);
        axes.lineTo(0, -28);
        axes.lineTo(-2, -26);

        axes.moveTo(0, -28);
        axes.lineTo(0, 28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(0xff282829);
        canvas.drawPath(axes, paint);
        paint.setColor(0xff279dd5);
        canvas.drawPath(quad, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int size;
        if (width > height) {
            size = height;
        } else {
            size = width;
        }

        paint.setStrokeWidth(size / 128);

        matrix.setTranslate(width / 2, height / 2);
        matrix.preScale(size / 64, size / 64);
        axes.transform(matrix);
        quad.transform(matrix);
    }
}
