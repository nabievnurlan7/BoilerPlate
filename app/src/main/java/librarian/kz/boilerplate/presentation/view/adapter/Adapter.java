package librarian.kz.boilerplate.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import librarian.kz.boilerplate.presentation.model.PresentationModel;
import librarian.kz.boilerplate.R;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.TownshipViewHolder>
{
    List<PresentationModel> presentationModels;

    @Override
    public Adapter.TownshipViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_township_item, parent, false);
        return new TownshipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.TownshipViewHolder holder, int position)
    {
        holder.bind(presentationModels.get(position));
    }

    @Override
    public int getItemCount()
    {
        return presentationModels !=null? presentationModels.size():0;
    }

    public void setTownships(List<PresentationModel> townships)
    {
        if(townships == null)
        {
            throw  new IllegalArgumentException("List can't be null");
        }

        presentationModels = townships;
        notifyDataSetChanged();
    }

    class TownshipViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.township_image)
        ImageView townshipImage;
        @BindView(R.id.township_name)
        TextView townshipName;

        TownshipViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(PresentationModel township)
        {
            Picasso.with(townshipImage.getContext())
                    .load(township.getImageUrl())
                    .into(townshipImage);

            townshipName.setText(township.getName());
        }
    }
}