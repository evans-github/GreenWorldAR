package e.com.greenworldar.home;

import android.animation.AnimatorSet;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.SkeletonNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;


import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.com.greenworldar.R;
import e.com.greenworldar.awards.FragmentAwards;
import e.com.greenworldar.menu.BuildMenu;
import e.com.greenworldar.menu.FriendsMenu;
import e.com.greenworldar.menu.RealTreeMenu;
import e.com.greenworldar.natgeo.FragmentNatGeo;
import e.com.greenworldar.notifications.FragmentNotifications;


public class FragmentHome extends Fragment {

    private static final String TAG = "FragmentHome";

    private Context mContext;
    private ArFragment mArFragment;

    private HashMap<String, String> mPlacedObjects = new HashMap<>();

    private String mSelectedModel;
    private String mModelKey;
    private BuildMenu mBuildMenu;

    @BindView(R.id.mainactivity_energy_points)
    TextView mPlantTreeAr;

    private int mPoints = 3525;

    private RealTreeMenu mRealTreeMenu;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        ButterKnife.bind(this, view);


        mArFragment = (ArFragment) getChildFragmentManager().findFragmentById(R.id.ar_fragment);

        mArFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            if(!mPlacedObjects.containsKey(mModelKey) && mSelectedModel != null && mModelKey != null){
                if(!mModelKey.equals("tree") && !mModelKey.equals("rooster")){
                    mPlacedObjects.put(mModelKey, mSelectedModel);
                }

                createModel(hitResult.createAnchor(), mArFragment);

                minusPoints();

            }else{
                Log.d(TAG, "onCreateView: Already placed house or Selected Model is null");
            }

        });

        initPlantARTree();

        return view;
    }

    private void createModel(Anchor anchor, ArFragment arFragment){
        ModelRenderable.builder()
                .setSource(mContext, Uri.parse(mSelectedModel))
                .build()
                .thenAccept(modelRenderable -> {
                    AnchorNode anchorNode = new AnchorNode(anchor);

                    SkeletonNode skeletonNode = new SkeletonNode();
                    skeletonNode.setParent(anchorNode);
                    skeletonNode.setRenderable(modelRenderable);
                    arFragment.getArSceneView().getScene().addChild(anchorNode);

                    animateModel(modelRenderable);

                });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.mainactivity_build)
    public void initBuildButton(){
        mBuildMenu = new BuildMenu();
        mBuildMenu.show(getFragmentManager(), "FRAG_BUILD");
    }

    public void dismissMenu(){
        mBuildMenu.dismiss();
    }

    @OnClick(R.id.mainactivity_trophies)
    public void initTrophiesButton(){
        FragmentAwards mFragAwards = FragmentAwards.newInstance();
        getFragmentManager().beginTransaction()
                .add(R.id.frag_container, mFragAwards)
                .addToBackStack("FRAG_AWARDS")
                .commit();
    }



    public void initPlantARTree(){
        mPlantTreeAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRealTreeMenu = new RealTreeMenu();
                mRealTreeMenu.show(getFragmentManager(), "FRAG_PLANTREE");
            }
        });
    }

    private void animateModel(ModelRenderable modelRenderable) {

        AnimationData danceData = modelRenderable.getAnimationData("Armature|Pecking.002");
        ModelAnimator modelAnimator = new ModelAnimator(danceData, modelRenderable);
        modelAnimator.setRepeatCount(100);
        modelAnimator.start();


    }

    public void dismissRealTreeMenu(){
        if(mRealTreeMenu != null){
            mRealTreeMenu.dismiss();
        }

    }

    public void setHouseModel(){
        mModelKey = "house";
        mSelectedModel = "house.sfb";
        //58_Movement_LODa_r01.sfb
    }
    public void setWellModel(){
        mModelKey = "well";
        mSelectedModel = "well.sfb";
    }

    public void setRoosterModel(){
        mModelKey = "rooster";
        mSelectedModel = "rooster.sfb";
    }

    public void setTreeModel(){
        mModelKey = "tree";
        mSelectedModel = "tree.sfb";
    }

    public void setLemonTreeModel(){
        mModelKey = "lemontree";
        mSelectedModel = "Cst_800.sfb";
    }

    @OnClick(R.id.fraghome_notifications_button)
    public void initNotificationsButton(){
        FragmentNotifications fragmentNotifications = FragmentNotifications.newInstance();
        getFragmentManager().beginTransaction()
                .add(R.id.frag_container, fragmentNotifications)
                .addToBackStack("FRAG_NOTIFICATIONS")
                .commit();
    }

    @OnClick(R.id.mainactivity_natgeo_button)
    public void initNatGeoButton(){
        FragmentNatGeo fragmentNotifications = FragmentNatGeo.newInstance();
        getFragmentManager().beginTransaction()
                .add(R.id.frag_container, fragmentNotifications)
                .addToBackStack("FRAG_NATGEO")
                .commit();
    }

    @OnClick(R.id.mainactivity_visit_farms)
    public void initVisitFarmsButton(){
        FriendsMenu friendsMenu = new FriendsMenu();
        friendsMenu.show(getFragmentManager(), "FRAG_FRIENDS");
    }

    public void minusPoints(){
        mPoints = mPoints - 250;
        String newPoints = mPoints + " Points";
        mPlantTreeAr.setText(newPoints);
    }
}
