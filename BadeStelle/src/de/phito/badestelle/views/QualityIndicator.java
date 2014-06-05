package de.phito.badestelle.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class QualityIndicator extends View{

	public QualityIndicator(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public QualityIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public QualityIndicator(Context context) {
		super(context);
	}

	private static final int CIRCLE_SIZE = 30;

	private Paint mCirclePaint = new Paint();
	private RectF mCircleBounds = new RectF(0, 0, CIRCLE_SIZE, CIRCLE_SIZE);
	private int color = Color.BLACK;

	public void setColor(int color) {
		this.color = color;
	}
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mCirclePaint.setColor(this.color);
		mCirclePaint.setStyle(Style.FILL);
		canvas.drawOval(mCircleBounds, mCirclePaint);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(CIRCLE_SIZE, CIRCLE_SIZE);
	}
}
