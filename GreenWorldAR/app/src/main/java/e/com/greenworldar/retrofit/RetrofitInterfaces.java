package e.com.greenworldar.retrofit;


import e.com.greenworldar.notifications.UserNotificationsDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitInterfaces {
    public interface IGetUserReports {
        @GET("userreports")
        Call<UserNotificationsDto> listRepos(@Query("key1") String user_id);
    }
}
