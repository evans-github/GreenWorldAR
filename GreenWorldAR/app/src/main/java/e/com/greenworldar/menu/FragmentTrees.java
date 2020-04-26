package e.com.greenworldar.menu;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.R;
import e.com.greenworldar.adapter.AwardsAdapter;
import e.com.greenworldar.adapter.TreesPlantedGridAdapter;
import e.com.greenworldar.utils.GridSpacingItemDecoration;
import e.com.greenworldar.utils.SpacingUtils;
import e.com.greenworldar.utils.StringUtils;

public class FragmentTrees extends Fragment {


    @BindView(R.id.alertdialog_trees_recycler)
    RecyclerView mGridRecycler;

    private static final int GRID_VIEW_SPACING = 2;
    private static final int GRID_VIEW_ROWCOUNT = 2;
    private TreesPlantedGridAdapter mGridAdapter;
    private Context mContext;
    private ArrayList<String> mPhotos = new ArrayList<>();
    private ArrayList<String> mTreeNames = new ArrayList<>();


    public static FragmentTrees newInstance(){
        return new FragmentTrees();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();


        mPhotos.add("https://i.imgur.com/HpOGhmj.jpg");
        mPhotos.add("https://i.imgur.com/K85msI0.jpg");
        mPhotos.add("https://i.imgur.com/gBIhGBr.jpg");
        mPhotos.add("https://i.imgur.com/tXbPOWI.jpg");
        mPhotos.add("https://i.imgur.com/HE3DfGE.jpg");
        mPhotos.add("https://i.imgur.com/ioexb3T.jpg");
        mPhotos.add("https://i.imgur.com/4amkHJC.jpg");
        mPhotos.add("https://i.imgur.com/e6BGMsh.jpg");
        mPhotos.add("https://i.imgur.com/8iaRTpW.jpg");


        mTreeNames.add("Maple Tree");
        mTreeNames.add("English Oak");
        mTreeNames.add("Redwood Tree");
        mTreeNames.add("Cherryblossom");
        mTreeNames.add("Orange Tree");
        mTreeNames.add("Yew Tree");
        mTreeNames.add("Evergreen");
        mTreeNames.add("Apple Tree");
        mTreeNames.add("Weeping Willow");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_trees, container, false);
        ButterKnife.bind(this, view);

        mGridAdapter = new TreesPlantedGridAdapter(mContext, mPhotos, mTreeNames);
        int spacing = SpacingUtils.convertIntToDP(mContext, GRID_VIEW_SPACING);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, GRID_VIEW_ROWCOUNT);
        mGridRecycler.addItemDecoration(new GridSpacingItemDecoration(GRID_VIEW_ROWCOUNT, spacing, false));
        mGridRecycler.setLayoutManager(gridLayoutManager);
        mGridRecycler.setAdapter(mGridAdapter);

        return view;
    }
}
