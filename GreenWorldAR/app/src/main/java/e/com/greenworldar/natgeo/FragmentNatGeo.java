package e.com.greenworldar.natgeo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.R;
import e.com.greenworldar.adapter.NotificationsAdapter;
import e.com.greenworldar.main.MainActivity;
import e.com.greenworldar.notifications.UserNotificationsDto;
import e.com.greenworldar.retrofit.RetrofitClientInstance;
import e.com.greenworldar.retrofit.RetrofitInterfaces;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentNatGeo extends Fragment {
    private static final String TAG = "FragmentNatGeo";

    @BindView(R.id.fragnatgeo_iv1)
    ImageView mImageView1;

    @BindView(R.id.fragnatgeo_iv2)
    ImageView mImageView2;

    @BindView(R.id.fragnatgeo_iv3)
    ImageView mImageView3;

    @BindView(R.id.fragnatgeo_iv4)
    ImageView mImageView4;


    public static FragmentNatGeo newInstance(){
        return new FragmentNatGeo();
    }

    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_natgeo, container, false);
        ButterKnife.bind(this, view);

        Glide.with(mContext)
                .load("https://i.imgur.com/x8zXFUH.jpg")
                .apply(RequestOptions.centerCropTransform())
                .into(mImageView1);

        Glide.with(mContext)
                .load("https://i.imgur.com/FvnqrWc.jpg")
                .apply(RequestOptions.centerInsideTransform())
                .into(mImageView2);

        Glide.with(mContext)
                .load("https://i.imgur.com/JANfp7l.jpg")
                .apply(RequestOptions.centerInsideTransform())
                .into(mImageView3);

        Glide.with(mContext)
                .load("https://i.imgur.com/3sMlItQ.jpg")
                .apply(RequestOptions.centerCropTransform())
                .into(mImageView4);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @OnClick(R.id.fragnatgeo_back_button)
    public void initBackButton(){
        getFragmentManager().popBackStack();
    }

    @OnClick(R.id.fragnatgeo_scan)
    public void initScanButton(){
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("National Geographic QR Code Scanner");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.setOrientationLocked(true);
        integrator.initiateScan();
    }
}
