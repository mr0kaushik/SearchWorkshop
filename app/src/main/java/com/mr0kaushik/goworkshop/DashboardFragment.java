package com.mr0kaushik.goworkshop;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.mr0kaushik.goworkshop.Utils.BottomNavigationViewBehavior;

public class DashboardFragment extends Fragment {
    private static final String TAG = "DashboardFragment";

    private View fragmentView;
    private LinearLayout noItemsLayout;
    private MaterialButton btnNext;
    private Context context;
    private FragmentActivity fragmentActivity;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        context = fragmentView.getContext();
        fragmentActivity = this.getActivity();
        recyclerView = fragmentView.findViewById(R.id.recyclerView);

//        //Setting Title
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Dashboard");


//        adding no content layout
        setupNotFoundLayout();

        //Hide No content layout if recycler view contains item
        Log.d(TAG, "onCreateView: recycler view items count " + recyclerView.getItemDecorationCount());
        if (recyclerView.getItemDecorationCount()>0){
            noItemsLayout.setVisibility(View.GONE);
        }



        //Bottom Behaviour
        BottomNavigationView bottomNavigationView = fragmentActivity.findViewById(R.id.bottom_nav_bar);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());



        return fragmentView;
    }

    private void setupNotFoundLayout() {
        Log.d(TAG, "setupNotFoundLayout: Starting");

        noItemsLayout = fragmentView.findViewById(R.id.noContentLayout);
        btnNext = fragmentView.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Jump to workshop fragment");
                BottomNavigationView bottomNavigationView = fragmentActivity.findViewById(R.id.bottom_nav_bar);
                bottomNavigationView.setSelectedItemId(R.id.menu_workshop);
            }
        });

    }

}
