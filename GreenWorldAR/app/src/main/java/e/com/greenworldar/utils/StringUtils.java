package e.com.greenworldar.utils;

import android.util.Log;

import java.util.Calendar;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class StringUtils {
    public static String formatMemberAge(long account_age){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(account_age * 1000);
        return "Member since " + cal.get(Calendar.YEAR);
    }

    public static String formatDescription(String description){
        try{
            return description.replace("\\n", System.lineSeparator());
        }catch (Exception e){
            Log.d(TAG, "formatDescription: Exception: " + e);
            return description;
        }

    }

    public static String formatUsername(String username){
        return "u/" + username;
    }


}
