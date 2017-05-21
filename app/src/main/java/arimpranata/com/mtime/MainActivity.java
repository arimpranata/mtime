package arimpranata.com.mtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import arimpranata.com.mtime.adapter.MovieAdapter;
import arimpranata.com.mtime.model.PopularMovieResponse;
import arimpranata.com.mtime.model.ResultsItemMovie;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private String apikey = BuildConfig.API_KEY;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Gson gson = new Gson();
    private List<ResultsItemMovie> listResultsPopular = new ArrayList<>();
    private MovieAdapter movieAdapter;

    @BindView(R.id.recyclerview) RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecyclerview();

    }

    private void setupRecyclerview(){
        movieAdapter = new MovieAdapter(listResultsPopular);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(movieAdapter);
        getDataFromApi();

    }

    public void getDataFromApi(){

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        final String url = "https://api.themoviedb.org/3/movie/popular?api_key="+apikey+"&language=en-US&page=1";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);

                PopularMovieResponse popularAPIResponse = gson.fromJson(response, PopularMovieResponse.class);

                for (ResultsItemMovie resultItem : popularAPIResponse.getResults()){
                    listResultsPopular.add(resultItem);
                    Log.d(TAG, "onResponse: "+resultItem.toString());

                }

                movieAdapter.notifyDataSetChanged();

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null){
                    Log.e(TAG, "onErrorResponse: " + error.getMessage());
                } else {
                    Log.e(TAG, "onErrorResponse: " + "Something wrong happened");
                }
            }
        };

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                responseListener,
                errorListener
        );

        requestQueue.add(request);

    }
}
