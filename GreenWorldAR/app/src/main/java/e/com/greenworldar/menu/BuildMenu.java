package e.com.greenworldar.menu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.tabs.TabLayout;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.adapter.MainPagerAdapter;
import e.com.greenworldar.R;


public class BuildMenu extends DialogFragment {

    private static final String TAG = "MessagesMoreMenu";

    private Context mContext;

    @BindView(R.id.fraghome_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.fraghome_tab_layout)
    TabLayout mTablayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfrag_build_menu, container, false);
        ButterKnife.bind(this, view);


        MainPagerAdapter mPagerAdapter = new MainPagerAdapter(getChildFragmentManager());
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(mPagerAdapter);
        mTablayout.setupWithViewPager(mViewPager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.buildmenu_back_button)
    public void initBackButton(){
        Log.d(TAG, "initBackButton: Clicked");
        this.dismiss();
    }
}
