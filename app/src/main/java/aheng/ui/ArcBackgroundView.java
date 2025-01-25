package aheng.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/**
 * @author AHeng
 * @date 2023/03/15 3:23
 */
public class ArcBackgroundView extends View {
    
    private Paint mPaint;
    private int mStartColor, mEndColor;
    
    public ArcBackgroundView(Context context) {
        this(context, null);
        
    }
    
    public ArcBackgroundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public ArcBackgroundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mStartColor = ContextCompat.getColor(context, R.color.blue);
        mEndColor = ContextCompat.getColor(context, R.color.blue);
        // mEndColor = ContextCompat.getColor(context, R.color.red);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        LinearGradient linearGradient = new LinearGradient(0, 0, width, height, mStartColor, mEndColor, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient);
        canvas.drawRect(new Rect(0, 0, width, height - 80), mPaint);
        RectF oval = new RectF(0, height - 160, width, height);
        canvas.drawArc(oval, 0, 180, false, mPaint);//画圆弧，这个时候，绘制没有经过圆心
    }
}
