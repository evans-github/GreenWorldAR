package e.com.greenworldar.utils;

public class MethodCalculateTime {

    public static String calculateAge(long current_time, long date_posted){
        long value = current_time - date_posted;
        if (value >= 0 && value <= 59){
            return " " + "•" +" " + "Now";

        }else if(value >= 60 && value <= 3599){
            value = value/60;
            return " " + "•" +" " + value + " minutes ago";

        }else if(value >= 3600 && value <= 86399){
            value = value/3600;
            return " " + "•" +" " + value + " hours ago";

        }else if(value >= 86400 && value <= 2591999){
            value = value/86400;
            return " " + "•" +" " + value + " days ago";

        }else if(value >= 2592000 && value <= 31103999){
            value = value/2592000;
            return " " + "•" +" " + value + " months ago";

        }else if(value >= 31104000 && value <= 311039999){
            value = value/31104000;
            return " " + "•" +" " + value + " years ago";

        }else{
            return " null exception ";
        }
    }
}
