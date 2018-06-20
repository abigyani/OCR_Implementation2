package artista.hackathon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.google.android.gms.vision.text.TextBlock;

public class MyGraphic extends GraphicOverlay.Graphic{

    private int id;

    private static final int TEXT_COLOR = Color.WHITE;

    private static Paint rectPaint;
    private static Paint textPaint;
    private final TextBlock text;

    public MyGraphic(GraphicOverlay overlay, TextBlock text) {
        super(overlay);

        this.text = text;
        if (rectPaint == null) {
            rectPaint = new Paint();
            rectPaint.setColor(TEXT_COLOR);
            rectPaint.setStyle(Paint.Style.STROKE);
            rectPaint.setStrokeWidth(4.0f);
        }

        if (textPaint == null) {
            textPaint = new Paint();
            textPaint.setColor(TEXT_COLOR);
            textPaint.setTextSize(54.0f);
        }
        // Redraw the overlay, as this graphic has been added.
        postInvalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        if (text == null) {
            return;
        }

        // Draws the bounding box around the TextBlock.
        RectF rect = new RectF(text.getBoundingBox());
        rect = translateRect(rect);
        canvas.drawRect(rect, rectPaint);

        // Render the text at the bottom of the box.
        canvas.drawText(text.getValue(), rect.left, rect.bottom, textPaint);
    }

    @Override
    public boolean contains(float x, float y) {
        return false;
    }
}
