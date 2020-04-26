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
import e.com.greenworldar.adapter.AnimalsGridAdapter;
import e.com.greenworldar.adapter.TreesPlantedGridAdapter;
import e.com.greenworldar.utils.GridSpacingItemDecoration;
import e.com.greenworldar.utils.SpacingUtils;

public class FragmentAnimals extends Fragment {

    @BindView(R.id.alertdialog_animals_recycler)
    RecyclerView mGridRecycler;

    private static final int GRID_VIEW_SPACING = 2;
    private static final int GRID_VIEW_ROWCOUNT = 2;
    private AnimalsGridAdapter mGridAdapter;
    private Context mContext;
    private ArrayList<String> mPhotos = new ArrayList<>();
    private ArrayList<String> mAnimalNames = new ArrayList<>();



    public static FragmentAnimals newInstance(){
        return new FragmentAnimals();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

        mPhotos.add("https://i.imgur.com/pws1at2.jpg");
        mPhotos.add("https://i.imgur.com/a7nZ2cv.jpg");
        mPhotos.add("https://i.imgur.com/mW2Gpa7.jpg");
        mPhotos.add("https://i.imgur.com/3GG9ctw.jpg");
        mPhotos.add("https://i.imgur.com/ym1f6rc.jpg");
        mPhotos.add("https://i.imgur.com/eZse2vm.jpg");
        mPhotos.add("https://i.imgur.com/TrnvGYf.jpg");
        mPhotos.add("https://i.imgur.com/2g6Opjd.jpg");

        mAnimalNames.add("Chicken");
        mAnimalNames.add("Doggie");
        mAnimalNames.add("Squirrel");
        mAnimalNames.add("Lamb");
        mAnimalNames.add("Horse");
        mAnimalNames.add("Bass");
        mAnimalNames.add("Goat");
        mAnimalNames.add("Cow");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_animals, container, false);
        ButterKnife.bind(this, view);

        mGridAdapter = new AnimalsGridAdapter(mContext, mPhotos, mAnimalNames);
        int spacing = SpacingUtils.convertIntToDP(mContext, GRID_VIEW_SPACING);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, GRID_VIEW_ROWCOUNT);
        mGridRecycler.addItemDecoration(new GridSpacingItemDecoration(GRID_VIEW_ROWCOUNT, spacing, false));
        mGridRecycler.setLayoutManager(gridLayoutManager);
        mGridRecycler.setAdapter(mGridAdapter);


        return view;
    }


}
