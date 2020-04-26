package e.com.greenworldar.utils;

import android.content.Context;
import android.util.TypedValue;

public class SpacingUtils {
    public static int convertIntToDP(Context context, int value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
                context.getResources().getDisplayMetrics());
    }
}
