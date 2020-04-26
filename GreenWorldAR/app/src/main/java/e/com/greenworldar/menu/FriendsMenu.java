package e.com.greenworldar.menu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.R;
import e.com.greenworldar.adapter.MainPagerAdapter;


public class FriendsMenu extends DialogFragment {

    private static final String TAG = "MessagesMoreMenu";

    private Context mContext;

    @BindView(R.id.modelrv_following_image)
    ImageView mImageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_visit_friends, container, false);
        ButterKnife.bind(this, view);

        Glide.with(mContext)
                .load("https://i.redd.it/xzxdniufcvu41.jpg")
                .apply(RequestOptions.circleCropTransform())
                .into(mImageView);



        return view;
    }
}
