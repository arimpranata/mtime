package arimpranata.com.mtime.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import arimpranata.com.mtime.R;
import arimpranata.com.mtime.model.ResultsItemMovie;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by arimpranata on 5/21/17.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_movieTitle) TextView tvMovieTitle;
    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind (ResultsItemMovie data) {
        tvMovieTitle.setText(data.getOriginalTitle());
        //untuk item yg lain, bikin di layout juga dan set disini juga
    }
}
