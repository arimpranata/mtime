package arimpranata.com.mtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void getDataFromApi(){

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        final String url = "https://api.themoviedb.org/3/";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);

                ApiResponse apiResponse = gson.fromJson(response, ApiResponse.class);

                for (ListForecast listItem : apiResponse.getList()){
                    listWeather.add(listItem);
                }

                adapter.notifyDataSetChanged();

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

    }*/
}
