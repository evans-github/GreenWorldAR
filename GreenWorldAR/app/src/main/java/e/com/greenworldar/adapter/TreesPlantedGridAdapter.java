package e.com.greenworldar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import e.com.greenworldar.R;
import e.com.greenworldar.customview.SquareImageView;
import e.com.greenworldar.home.FragmentHome;
import e.com.greenworldar.main.MainActivity;

public class TreesPlantedGridAdapter extends RecyclerView.Adapter<TreesPlantedGridAdapter.ViewHolder> {

    private static final String TAG = "GridViewAdapter";

    private Context mContext;
    private ArrayList<String> mImages;
    private ArrayList<String> mTreeNames;


    public TreesPlantedGridAdapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mTreeNames) {
        this.mContext = mContext;
        this.mImages = mImages;
        this.mTreeNames = mTreeNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vh_treesplanted, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Glide.with(mContext)
                .load(mImages.get(i))
                .apply(RequestOptions.centerCropTransform())
                .into(holder.vhSquareImage);

        holder.vhTreeName.setText(mTreeNames.get(i));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.vh_trees_squareimageview)
        SquareImageView vhSquareImage;
        @BindView(R.id.vh_trees_nameoftree) TextView vhTreeName;
        int mPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            vhSquareImage.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosition = getAdapterPosition();


            MainActivity mainActivity = (MainActivity) mContext;
            FragmentHome fragmentHome = (FragmentHome) mainActivity.getSupportFragmentManager()
                    .findFragmentByTag("FRAG_HOME");
            if (fragmentHome != null) {
                switch (mPosition){
                    case 1:
                        fragmentHome.setTreeModel();
                        fragmentHome.dismissMenu();
                        break;

                }
            }



        }
    }
}
