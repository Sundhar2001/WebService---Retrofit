package com.example.reterofitsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.reterofitsample.instance.RetrofitInstance;
import com.example.reterofitsample.model.NameObj;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.superListView);

        getNames();
    }

    private void getNames() {

        Call<List<NameObj>> call = RetrofitInstance.getInstance().getApi().getNames();
        call.enqueue(new Callback<List<NameObj>>() {

            @Override
            public void onResponse(Call<List<NameObj>> call, Response<List<NameObj>> response) {

                List<NameObj> nameObjs = response.body();

                String[] oneName = new String[nameObjs.size()];

                for (int i = 0; i < nameObjs.size(); i++){

                    oneName[i] = nameObjs.get(i).getName();

                }
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,oneName));


            }

            @Override
            public void onFailure(Call<List<NameObj>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"An error occured" ,Toast.LENGTH_SHORT).show();

            }
        });
    }
}