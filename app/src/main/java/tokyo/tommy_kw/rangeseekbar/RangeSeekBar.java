package tokyo.tommy_kw.rangeseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Supported multitouch for SeekBar
 * @author Kenji Tomita (destinys.lotus.1108mn@gmail.com)
 */
public class RangeSeekBar<T extends Number> extends ImageView {
    private static String TAG = RangeSeekBar.class.getSimpleName();
    private enum KEY_STATE {
        MIN,
        MAX
    }

    private int min;
    private int max;

    /**
     * seekBar interface listener
     */
    public interface OnRangeSeekBarListener {
        void onChanged(int min, int max);
    }


    public RangeSeekBar(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public RangeSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        if (attrs == null) {

        } else {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.RangeSeekBar);
            ta.recycle();
        }
    }

    /**
     * Save state instance when orientation changed.
     * @return
     */
    @Override
    protected Parcelable onSaveInstanceState() {
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATE.MAX.toString(), max);
        bundle.putInt(KEY_STATE.MIN.toString(), min);
        return bundle;
    }

    /**
     * Restore state instance when orientation changed.
     * @param state
     */
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Log.d(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(state);
        Bundle bundle = new Bundle();
        max = bundle.getInt(KEY_STATE.MAX.toString());
        min = bundle.getInt(KEY_STATE.MIN.toString());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        int action = event.getAction();

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public void setRangeValues(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure");
    }
}
