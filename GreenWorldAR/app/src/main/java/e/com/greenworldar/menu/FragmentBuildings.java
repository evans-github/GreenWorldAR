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
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import e.com.greenworldar.R;
import e.com.greenworldar.adapter.BuildingsGridAdapter;
import e.com.greenworldar.utils.GridSpacingItemDecoration;
import e.com.greenworldar.utils.SpacingUtils;


public class FragmentBuildings extends Fragment {

    @BindView(R.id.alertdialog_buildings_recycler)
    RecyclerView mGridRecycler;

    private static final int GRID_VIEW_SPACING = 2;
    private static final int GRID_VIEW_ROWCOUNT = 2;
    private BuildingsGridAdapter mGridAdapter;
    private Context mContext;
    private ArrayList<String> mPhotos = new ArrayList<>();
    private ArrayList<String> mBuildingNames = new ArrayList<>();

    public static FragmentBuildings newInstance(){
        return new FragmentBuildings();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

        mPhotos.add("https://i.imgur.com/DNCAkQp.jpg");
        mPhotos.add("https://i.imgur.com/cd8Hasu.jpg");
        mPhotos.add("https://i.imgur.com/Ooa8pJU.jpg");
        mPhotos.add("https://i.imgur.com/vlsPsum.jpg");
        mPhotos.add("https://i.imgur.com/LCuUB81.jpg");
        mPhotos.add("https://i.imgur.com/rkR2AOw.jpg");
        mPhotos.add("https://i.imgur.com/ZntyqgD.jpg");
        mPhotos.add("https://i.imgur.com/bhb0UNu.jpg");
        mPhotos.add("https://i.imgur.com/6eDwuyA.jpg");
        mPhotos.add("https://i.imgur.com/xfg1B8x.jpg");
        mPhotos.add("https://i.imgur.com/Xj2VGX1.jpg");

        mBuildingNames.add("House 1");
        mBuildingNames.add("House 2");
        mBuildingNames.add("House 3");
        mBuildingNames.add("River House");
        mBuildingNames.add("House 4");
        mBuildingNames.add("BlackSmith");
        mBuildingNames.add("Pond tower");
        mBuildingNames.add("Watch Tower");
        mBuildingNames.add("River Bridge");
        mBuildingNames.add("Stone Well");
        mBuildingNames.add("Horse Stable");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_buildings, container, false);
        ButterKnife.bind(this, view);

        mGridAdapter = new BuildingsGridAdapter(mContext, mPhotos, mBuildingNames);
        int spacing = SpacingUtils.convertIntToDP(mContext, GRID_VIEW_SPACING);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, GRID_VIEW_ROWCOUNT);
        mGridRecycler.addItemDecoration(new GridSpacingItemDecoration(GRID_VIEW_ROWCOUNT, spacing, false));
        mGridRecycler.setLayoutManager(gridLayoutManager);
        mGridRecycler.setAdapter(mGridAdapter);


        return view;
    }


}
