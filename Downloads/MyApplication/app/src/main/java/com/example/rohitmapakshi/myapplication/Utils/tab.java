package com.example.rohitmapakshi.myapplication.Utils;

/**
 * Created by root on 13/2/17.
 */

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.design.widget.TabLayout;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.WindowManager;

        import com.example.rohitmapakshi.myapplication.R;
        import com.example.rohitmapakshi.myapplication.dept;

        import deptfragments.deptche;
        import deptfragments.deptcivil;
        import deptfragments.deptcse;
        import deptfragments.deptece;
        import deptfragments.depteee;
        import deptfragments.depteie;
        import deptfragments.deptit;
        import deptfragments.deptmech;

public class tab extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 9 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tab,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            }
        });
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return x;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new dept();
                case 1 : return new deptcivil();
                case 2 : return new depteie();
                case 3: return  new deptmech();
                case 4: return  new deptit();
                case 5: return new deptche();
                case 6: return new deptcse();
                case 7:return new deptece();
                case 8:return  new depteee();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "DEPT";
                case 1 :
                    return "CVL";
                case 2 :
                    return "EIE";
                case 3:
                    return "MCH";
                case 4:
                    return "IT";
                case 5:
                    return "CHE";
                case 6:
                    return "CSE";
                case 7:
                    return "ECE";
                case 8:
                    return "EEE";
            }
            return null;
        }
    }

}


