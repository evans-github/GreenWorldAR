package e.com.greenworldar.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import e.com.greenworldar.menu.FragmentAnimals;
import e.com.greenworldar.menu.FragmentBuildings;
import e.com.greenworldar.menu.FragmentTrees;


public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_ITEMS = 3;


    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragmentBuildings.newInstance();
            case 1:
                return FragmentAnimals.newInstance();
            case 2:
                return FragmentTrees.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Buildings";
            case 1:
                return "Animals";
            case 2:
                return "Plants";
        }
        return null;
    }
}
