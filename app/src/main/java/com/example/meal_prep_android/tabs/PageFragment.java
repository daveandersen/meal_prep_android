package com.example.meal_prep_android.tabs;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.meal_prep_android.R;
import com.example.meal_prep_android.models.ListItem;

//import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {

    public static final String TITLE = "title";
    public ArrayList<ListItem> items;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("onCreateView", "onCreateView");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("onViewCreated", "onViewCreated");

        TextView text = view.findViewById(R.id.page_text_view);
        text.setText(getArguments().getString(TITLE));
        try {
            String url = "json/mealData.json";
              parseJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // panggil API

        // masukin jadi list
    }

    private void parseJson(String file){
        JSONParser jsonParser = new JSONParser();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getContext().getAssets().open(file), "UTF-8")))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray result = (JSONArray) obj;
            System.out.println(result);
            Log.d("jsonResult", result.toString());
            items = new ArrayList<ListItem>();

            for(Object o: result){
                if ( o instanceof JSONObject ) {
                   items.add(
                            new ListItem(
                                    ((JSONObject) o).get("id").toString(),
                                    ((JSONObject) o).get("name").toString(),
                                    ((JSONObject) o).get("imageName").toString(),
                                    ((JSONObject) o).get("description").toString(),
                                    ((JSONObject) o).get("ingredients").toString(),
                                    ((JSONObject) o).get("directions").toString(),
                                    ((JSONObject) o).get("category").toString(),
                                    ((JSONObject) o).get("availableOn").toString(),
                                    ((JSONObject) o).get("datePublished").toString(),
                                    ((JSONObject) o).get("url").toString()
                            )
                    );
                }
            }

            for(ListItem item: items){
                System.out.println(item.getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

//    private void prepareListView() {
//        RecyclerView rv = findViewById(R.id.list_recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        DataModelAdapter dataModelAdapter = new DataModelAdapter(users);
//
//        rv.setLayoutManager(layoutManager);
//        rv.setAdapter(dataModelAdapter);
//    }
}

class DataModelAdapter extends RecyclerView.Adapter<DataModelViewHolder> {

    String[] cardItems;

    public DataModelAdapter(String[] items) {
        this.cardItems = items;
    }

    @NonNull
    @Override
    public DataModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item_card_view, parent, false);

        return new DataModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataModelViewHolder holder, int position) {
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}

class DataModelViewHolder extends RecyclerView.ViewHolder {
    View parent;

    public DataModelViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;

    }

}