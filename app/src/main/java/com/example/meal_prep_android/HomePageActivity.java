package com.example.meal_prep_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.meal_prep_android.adapters.AdapterPage;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomePageActivity extends Fragment {

    String[] items= {"hello", "hello", "hello"};

    public HomePageActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

//        prepareListView();
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ViewPager2 viewPager2 = view.findViewById(R.id.view_pager);

        AdapterPage adapterPage = new AdapterPage(getActivity().getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapterPage);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(getDay(position+1));
        }).attach();

    }

    private String getDay(int pos) {
        switch (pos) {
            case 1:
                return "Mon";
            case 2:
                return "Tue";
            case 3:
                return "Wed";
            case 4:
                return "Thu";
            case 5:
                return "Fri";
            case 6:
                return "Sat";
            case 7:
                return "Sun";
        }
        return null;
    }

//    private void prepareListView() {
//        RecyclerView rv = getView().findViewById(R.id.list_recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        DataModelAdapter dataModelAdapter = new DataModelAdapter(items);
//
//        rv.setLayoutManager(layoutManager);
//        rv.setAdapter(dataModelAdapter);
//    }
}

//class DataModelAdapter extends RecyclerView.Adapter<DataModelViewHolder> {
//
//    String[] cardItems;
//
//    public DataModelAdapter(String[] items) {
//        this.cardItems = items;
//    }
//
//    @NonNull
//    @Override
//    public DataModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        View view = layoutInflater.inflate(R.layout.list_item_card_view, parent, false);
//
//        return new DataModelViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DataModelViewHolder holder, int position) {
//    }
//    @Override
//    public int getItemCount() {
//        return 3;
//    }
//}
//
//class DataModelViewHolder extends RecyclerView.ViewHolder {
//    View parent;
//
//    public DataModelViewHolder(@NonNull View itemView) {
//        super(itemView);
//        parent = itemView;
//
//    }
//
//}