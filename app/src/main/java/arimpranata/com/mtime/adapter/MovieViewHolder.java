package arimpranata.com.mtime.adapter;

import android.support.annotation.StringDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import arimpranata.com.mtime.R;
import arimpranata.com.mtime.model.ResultsItemMovie;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by arimpranata on 5/21/17.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_overview) TextView tvOverview;
    @BindView(R.id.tv_movieTitle) TextView tvMovieTitle;
    @BindView(R.id.tv_original_language) TextView tvOriginalLang;
    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.iv_poster) ImageView ivPoster;

    private final String baseURL = "http://image.tmdb.org/t/p/";
    private final String posterSize = "w185";

    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    public void bind (ResultsItemMovie data) {
        tvMovieTitle.setText(data.getOriginalTitle());
        tvOverview.setText(data.getOverview());
        tvOriginalLang.setText(data.getOriginalLanguage());
        tvTitle.setText(data.getTitle());
        Picasso.with(itemView.getContext()).load(baseURL + posterSize + data.getPosterPath()).into(ivPoster);

        //untuk item yg lain, bikin di layout juga dan set disini juga
    }
}
