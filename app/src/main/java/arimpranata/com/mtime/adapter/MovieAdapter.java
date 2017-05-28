package arimpranata.com.mtime.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import arimpranata.com.mtime.R;
import arimpranata.com.mtime.model.ResultsItemMovie;

/**
 * Created by arimpranata on 5/21/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<ResultsItemMovie> listMovie = new ArrayList<>();

    public MovieAdapter(List<ResultsItemMovie> listMovie) {
        this.listMovie = listMovie;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);

        return movieViewHolder;

    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        ResultsItemMovie movieItem = listMovie.get(position);
        holder.bind(movieItem);

    }


    @Override
    public int getItemCount() {
        return listMovie.size();
    }
}
