package e.com.greenworldar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import e.com.greenworldar.R;
import e.com.greenworldar.notifications.UserNotificationsDto;
import e.com.greenworldar.utils.MethodCalculateTime;


public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    private Context mContext;
    private List<UserNotificationsDto.UserReports> mList;
    private long mServerTime;


    public NotificationsAdapter(Context mContext, List<UserNotificationsDto.UserReports> mList, long mServerTime) {
        this.mContext = mContext;
        this.mList = mList;
        this.mServerTime = mServerTime;
    }

    @NonNull
    @Override
    public NotificationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.vh_notifications, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.vhBody.setText(mList.get(i).getReport_summary());
        viewHolder.vhPostedBy.setText(String.valueOf(mList.get(i).getPerson_name()));
        viewHolder.vhDatePosted.setText(MethodCalculateTime.calculateAge(mServerTime, mList.get(i).getDate_posted()));
        viewHolder.vhContactInfo.setText(mList.get(i).getContact_info());

        if(i == 0){
            Glide.with(mContext)
                    .load("https://i.imgur.com/AZPmhjr.jpg")
                    .transform(new CenterCrop(), new RoundedCorners(12))
                    .into(viewHolder.vhPreview);
        }else if(i == 1){
            Glide.with(mContext)
                    .load("https://i.imgur.com/3BxKGrH.jpg")
                    .transform(new CenterCrop(), new RoundedCorners(12))
                    .into(viewHolder.vhPreview);
        }else if(i == 2){
            Glide.with(mContext)
                    .load("https://i.imgur.com/Dgzavsm.png")
                    .transform(new CenterCrop(), new RoundedCorners(12))
                    .into(viewHolder.vhPreview);
        }else{
            Glide.with(mContext)
                    .load("https://i.imgur.com/8uulZ8e.jpg")
                    .transform(new CenterCrop(), new RoundedCorners(12))
                    .into(viewHolder.vhPreview);
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.vh_notifications_image_preview) ImageView vhPreview;
        @BindView(R.id.vh_notifications_message_body) TextView vhBody;
        @BindView(R.id.vh_notifications_posted_by) TextView vhPostedBy;
        @BindView(R.id.vh_notifications_date_posted) TextView vhDatePosted;
        @BindView(R.id.vh_notifications_contact_info) TextView vhContactInfo;

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
