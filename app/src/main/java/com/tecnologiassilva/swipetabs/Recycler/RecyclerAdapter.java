package com.tecnologiassilva.swipetabs.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tecnologiassilva.swipetabs.PerfilProfesor;
import com.tecnologiassilva.swipetabs.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sergio on 8/5/2016.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private final List<Maestro> mMaestros;
    private Random mRandom;


    public RecyclerAdapter(Context context, RecyclerView recyclerView) {
        mMaestros = new ArrayList<>();//mPasswords = new ArrayList<>();
        mContext = context;//mInflator = LayoutInflator.from(context);
        mRandom = new Random();
        mRecyclerView = recyclerView;


        //Dummy Content
        for (int i = 0; i < 190; i++) {
            mMaestros.add(new Maestro(getRandomName(),
                    getRandomCarrera(),
                    R.drawable.image,
                    getRandomRating()));
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_view, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Maestro currentMaestro = mMaestros.get(position);

        holder.bindToView(currentMaestro);
    }


    @Override
    public int getItemCount() {
        return mMaestros.size();
    }

    private String getRandomName() {
        String[] names = new String[]{
                "DORAME VELASQUEZ MAXIMINO",
                "LEY QUIJADA CECILIA MARGARITA",
                "GARCIA BOJORQUEZ LUIS FELIPE",
                "MENDEZ GALVEZ ALMA IRENE",
                "CHAVARIN AVILA ANA",
                "RODRIGUEZ PEREZ JOSE MIGUEL",
                "ZEPEDA MIRAMONTES FRANCISCA LORENA"
                ,
        };
        return names[mRandom.nextInt(names.length)];
    }

    private String getRandomCarrera() {
        String[] names = new String[]{
                "Ing. Biomedica", "Ing. Eléctrica", "Ing. Electronica",
                "Ing. Industrial", "Ing. Mecánica", "Ing. Mecatronica",
                "Lic. Administración", "Ing. Sistemas Computacionales", "Ing. Informática",
                "Ing. Gestión Empresarial"
        };
        return names[mRandom.nextInt(names.length)];
    }

    public int getRandomRating() {

        return mRandom.nextInt(5);
    }

/*
    public void addName(){
        mNames.add(0,getRandomName());
        notifyItemInserted(0);
        mRecyclerView.getLayoutManager().scrollToPosition(0);

    }*/

    public void deleteName(int position) {
        mMaestros.remove(position);
        notifyItemRemoved(position);
    }

    public void getInfo(int position){

        String maestro_nombre=mMaestros.get(position).getMaestro_Nombre();
        String maestro_carrera = mMaestros.get(position).getMaestro_Carrera();

        Log.v("Nombre", maestro_nombre);
        Log.v("Carrera", maestro_carrera);

    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView maestronameTextView;
        private TextView maestrocarreraTextView;
        private RatingBar maestroRatingBar;
        private ImageView maestroPicture;

        public ViewHolder(final View itemView) {
            super(itemView);

            maestronameTextView = (TextView) itemView.findViewById(R.id.Profesor_textView);
            maestrocarreraTextView = (TextView) itemView.findViewById(R.id.Carrera_textView);
            maestroPicture = (ImageView) itemView.findViewById(R.id.imageView);
            maestroRatingBar= (RatingBar) itemView.findViewById(R.id.ratingBar);


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    deleteName(getAdapterPosition());
                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getInfo(getAdapterPosition());
                    Intent intent  = new Intent(mContext, PerfilProfesor.class);

                    intent.putExtra("Nombre_Maestro",mMaestros.get
                            (getAdapterPosition()).getMaestro_Nombre());
                    intent.putExtra("Nombre_Carrera",mMaestros.get
                            (getAdapterPosition()).getMaestro_Carrera());
                    mContext.startActivity(intent);
                }
            });

        }




        public void bindToView(Maestro maestro) {
            maestronameTextView.setText(maestro.getMaestro_Nombre());
            maestroPicture.setImageResource(maestro.getMaestro_foto());
            maestrocarreraTextView.setText(maestro.getMaestro_Carrera());
            maestroRatingBar.setRating(maestro.getMaestro_rating());
        }
    }
}
