package e.com.greenworldar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import e.com.greenworldar.R;


public class AwardsAdapter extends RecyclerView.Adapter<AwardsAdapter.ViewHolder> {

    private ArrayList<String> mAwardImages;
    private ArrayList<String> mAwardNames;
    private ArrayList<String> mAwardPoints;
    private Context mContext;
    private static final String TAG = "AwardsAdapter";

    public AwardsAdapter(ArrayList<String> mAwardImages,
                         ArrayList<String> mAwardNames,
                         ArrayList<String> mAwardPoints,
                         Context mContext) {
        this.mAwardImages = mAwardImages;
        this.mAwardNames = mAwardNames;
        this.mAwardPoints = mAwardPoints;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vh_awards, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.vhAwardName.setText(mAwardNames.get(i));

        Glide.with(mContext)
                .load(mAwardImages.get(i))
                .apply(RequestOptions.circleCropTransform())
                .into(viewHolder.vhAwardImage);

        if(mAwardNames.get(i).contains("Award not unlocked.")){
            viewHolder.vhAwardPoints.setVisibility(View.INVISIBLE);
        }else{
            viewHolder.vhAwardPoints.setText(mAwardPoints.get(i));
            viewHolder.vhAwardPoints.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mAwardImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.vh_awards_imageview)
        ImageView vhAwardImage;
        @BindView(R.id.vh_awards_awardname)
        TextView vhAwardName;
        @BindView(R.id.vh_awards_points)
        TextView vhAwardPoints;

        int mPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosition = getLayoutPosition();

        }
    }

}
