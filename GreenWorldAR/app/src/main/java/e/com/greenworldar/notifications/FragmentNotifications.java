package e.com.greenworldar.notifications;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.R;
import e.com.greenworldar.adapter.NotificationsAdapter;
import e.com.greenworldar.retrofit.RetrofitClientInstance;
import e.com.greenworldar.retrofit.RetrofitInterfaces;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentNotifications extends Fragment {
    private static final String TAG = "FragmentReports";

    @BindView(R.id.fragnotifications_recycler)
    RecyclerView mReportsRecycler;
    private NotificationsAdapter mNotificationsAdapter;
    private List<UserNotificationsDto.UserReports> mListReports;
    private long mServerTime;

    public static FragmentNotifications newInstance(){
        return new FragmentNotifications();
    }

    private Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mListReports = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_notifications, container, false);
        ButterKnife.bind(this, view);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RetrofitInterfaces.IGetUserReports service = RetrofitClientInstance.getRetrofitInstance()
                .create(RetrofitInterfaces.IGetUserReports.class);
        Call<UserNotificationsDto> call = service.listRepos("1");
        call.enqueue(new Callback<UserNotificationsDto>() {
            @Override
            public void onResponse(@NonNull Call<UserNotificationsDto> call, @NonNull Response<UserNotificationsDto> response) {
                if(response.isSuccessful() && response.body() != null){
                    UserNotificationsDto userNotificationsDto = response.body();
                    mListReports = userNotificationsDto.getUser_reports();
                    mServerTime = userNotificationsDto.getServer_time();

                    mNotificationsAdapter = new NotificationsAdapter(mContext, mListReports, mServerTime);
                    mReportsRecycler.setLayoutManager(new LinearLayoutManager(mContext));
                    mReportsRecycler.setAdapter(mNotificationsAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserNotificationsDto> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: Failed to get notifications: " + t);
            }
        });

    }

    @OnClick(R.id.fragnotifications_back_button)
    public void initBackButton(){
        getFragmentManager().popBackStack();
    }
}
