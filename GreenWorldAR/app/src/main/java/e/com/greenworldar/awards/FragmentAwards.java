package e.com.greenworldar.awards;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.R;

import e.com.greenworldar.adapter.AwardsAdapter;
import e.com.greenworldar.utils.StringUtils;

public class FragmentAwards extends Fragment {

    @BindView(R.id.alertdialog_awards_recycler)
    RecyclerView mRecycler;

    private Context mContext;
    private AwardsAdapter mAdapter;
    private ArrayList<String> mAwardImages = new ArrayList<>();
    private ArrayList<String> mAwardNames = new ArrayList<>();
    private ArrayList<String> mAwardPoints = new ArrayList<>();


    public static FragmentAwards newInstance(){
        return new FragmentAwards();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

        mAwardImages.add("https://i.imgur.com/MjW28AV.jpg");
        mAwardImages.add("https://i.imgur.com/5FcGbh3.jpg");
        mAwardImages.add("https://i.imgur.com/nmEXKkh.gif");
        mAwardImages.add("https://i.imgur.com/4BM9OQk.jpg");
        mAwardImages.add("https://i.imgur.com/8LmyzL0.png");
        mAwardImages.add("https://i.imgur.com/9tauwsn.jpg");

        mAwardImages.add("https://i.imgur.com/ZhGiehP.png");
        mAwardImages.add("https://i.imgur.com/ZhGiehP.png");
        mAwardImages.add("https://i.imgur.com/ZhGiehP.png");
        mAwardImages.add("https://i.imgur.com/ZhGiehP.png");
        mAwardImages.add("https://i.imgur.com/ZhGiehP.png");



        mAwardNames.add(StringUtils.formatDescription("The Long Walker \nWalk 100,000 steps in one day"));
        mAwardNames.add(StringUtils.formatDescription("Mr.wheels \nBike to work 3 days a week"));
        mAwardNames.add(StringUtils.formatDescription("Lousiana Heat \nDo not turn on air conditioning on 3 hot days"));
        mAwardNames.add(StringUtils.formatDescription("Train gains \nReducing CO2 by taking \nmuni 5 days in a row"));
        mAwardNames.add(StringUtils.formatDescription("The Ice Man \nDo not open heater for a month"));
        mAwardNames.add(StringUtils.formatDescription("Bye Felicia \nSell your car and take muni \nfor the next year"));

        mAwardNames.add("Award not unlocked.");
        mAwardNames.add("Award not unlocked.");
        mAwardNames.add("Award not unlocked.");
        mAwardNames.add("Award not unlocked.");
        mAwardNames.add("Award not unlocked.");


        mAwardPoints.add("+225p");
        mAwardPoints.add("+300p");
        mAwardPoints.add("+750p");
        mAwardPoints.add("+500p");
        mAwardPoints.add("+750p");
        mAwardPoints.add("+1,000p");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_awards, container, false);
        ButterKnife.bind(this, view);

        mRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new AwardsAdapter(mAwardImages, mAwardNames, mAwardPoints, mContext);
        mRecycler.setAdapter(mAdapter);

        return view;
    }

    @OnClick(R.id.fragawards_back_button)
    public void initBackButton(){
        getFragmentManager().popBackStack();
    }
}
