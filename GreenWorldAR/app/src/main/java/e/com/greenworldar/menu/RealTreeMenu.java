package e.com.greenworldar.menu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.R;
import e.com.greenworldar.adapter.ARTreeGridAdapter;
import e.com.greenworldar.adapter.BuildingsGridAdapter;
import e.com.greenworldar.adapter.MainPagerAdapter;
import e.com.greenworldar.utils.GridSpacingItemDecoration;
import e.com.greenworldar.utils.SpacingUtils;
import e.com.greenworldar.utils.StringUtils;


public class RealTreeMenu extends DialogFragment {

    private static final String TAG = "MessagesMoreMenu";

    private Context mContext;

    @BindView(R.id.realtree_recycler)
    RecyclerView mGridRecycler;

    private static final int GRID_VIEW_SPACING = 3;
    private static final int GRID_VIEW_ROWCOUNT = 3;
    private ARTreeGridAdapter mGridAdapter;
    private ArrayList<String> mPhotos = new ArrayList<>();
    private ArrayList<String> mTreeNames = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

        mPhotos.add("https://i.imgur.com/PkRDhpU.png");
        mPhotos.add("https://i.imgur.com/92tbzme.png");
        mPhotos.add("https://i.imgur.com/u2bf8qb.png");
        mPhotos.add("https://i.imgur.com/0ZP5hSd.png");
        mPhotos.add("https://i.imgur.com/V3cAF1M.png");
        mPhotos.add("https://i.imgur.com/BBMt3A7.png");
        mPhotos.add("https://i.imgur.com/LyC8SY4.png");
        mPhotos.add("https://i.imgur.com/EWJVbYT.png");
        mPhotos.add("https://i.imgur.com/l0qB59C.png");
        mPhotos.add("https://i.imgur.com/NavhIQq.png");
        mPhotos.add("https://i.imgur.com/ZrwQDCz.png");
        mPhotos.add("https://i.imgur.com/NxrbtLN.png");

        mTreeNames.add("Oak Tree");
        mTreeNames.add("Willow Tree");
        mTreeNames.add(StringUtils.formatDescription("Cherry Tree \nNot unlocked."));
        mTreeNames.add("Maple Tree");
        mTreeNames.add("Orange Tree");
        mTreeNames.add("Eucalyptus Tree");
        mTreeNames.add("Evergreen");
        mTreeNames.add(StringUtils.formatDescription("Mahogany Tree\nNot unlocked."));
        mTreeNames.add("Magic Tree");
        mTreeNames.add("Calquat Tree");
        mTreeNames.add("Giant Sequoia");
        mTreeNames.add(StringUtils.formatDescription("Yew Tree \nNot unlocked."));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfrag_tree_menu, container, false);
        ButterKnife.bind(this, view);


        mGridAdapter = new ARTreeGridAdapter(mContext, mPhotos, mTreeNames);
        int spacing = SpacingUtils.convertIntToDP(mContext, GRID_VIEW_SPACING);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, GRID_VIEW_ROWCOUNT);
        mGridRecycler.addItemDecoration(new GridSpacingItemDecoration(GRID_VIEW_ROWCOUNT, spacing, false));
        mGridRecycler.setLayoutManager(gridLayoutManager);
        mGridRecycler.setAdapter(mGridAdapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.realtree_back_button)
    public void initBackButton(){
        this.dismiss();
    }
}
