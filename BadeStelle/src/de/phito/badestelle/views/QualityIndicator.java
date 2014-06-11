package de.phito.badestelle.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * The Class QualityIndicator.
 * 
 * Shows a colored circle that indicates the quality of the water of a lake.
 */
public class QualityIndicator extends View{

	/**
	 * Instantiates a new quality indicator.
	 *
	 * @param context the context
	 * @param attrs the attrs
	 * @param defStyle the def style
	 */
	public QualityIndicator(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * Instantiates a new quality indicator.
	 *
	 * @param context the context
	 * @param attrs the attrs
	 */
	public QualityIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * Instantiates a new quality indicator.
	 *
	 * @param context the context
	 */
	public QualityIndicator(Context context) {
		super(context);
	}

	/** The Constant CIRCLE_SIZE. */
	private static final int CIRCLE_SIZE = 30;

	/** The m circle paint. */
	private Paint mCirclePaint = new Paint();
	
	/** The m circle bounds. */
	private RectF mCircleBounds = new RectF(0, 0, CIRCLE_SIZE, CIRCLE_SIZE);
	
	/** The color. */
	private int color = Color.BLACK;

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	/* (non-Javadoc)
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mCirclePaint.setColor(this.color);
		mCirclePaint.setStyle(Style.FILL);
		canvas.drawOval(mCircleBounds, mCirclePaint);
	}
	
	/* (non-Javadoc)
	 * @see android.view.View#onMeasure(int, int)
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(CIRCLE_SIZE, CIRCLE_SIZE);
	}
}
