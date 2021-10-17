package com.example.exercise3_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    public interface IPersonItemClickedListener{
        void onPersonClicked(int index);
        void sendInvite(PersonalInfo personalInfo);
    }

    private IPersonItemClickedListener listener;

    private ArrayList<PersonalInfo> personList;

    public PersonAdapter(IPersonItemClickedListener listener){this.listener = listener;}

    public void updatePersonList(ArrayList<PersonalInfo> lists)
    {
        personList = lists;
        notifyDataSetChanged();
    }
    // DU ER NÅET HERTIL ___AD_AS_DS_DA_D_SAED_AS_DA_SD_
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        PersonViewHolder vh = new PersonViewHolder(view, listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position)
    {
        holder.txtName.setText(personList.get(position).getName());

        if(personList.get(position).imageResourceId == 1)
        {
            holder.imgIcon.setImageResource(R.drawable.android_circle);
        } else
        {
            holder.imgIcon.setImageResource(R.drawable.android_hex);
        }
    }

    @Override
    public int getItemCount() {return personList.size();}

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imgIcon;
        TextView txtName;
        Button btnSend;

        IPersonItemClickedListener listener;

        public PersonViewHolder(@NonNull View itemView, IPersonItemClickedListener personItemClickedListener)
        {
            super(itemView);

            imgIcon = itemView.findViewById(R.id.imgPerson);
            txtName = itemView.findViewById(R.id.txtName);
            btnSend = itemView.findViewById(R.id.btnInvite);
            listener = personItemClickedListener;

            itemView.setOnClickListener(this);

            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    listener.sendInvite(personList.get(getAdapterPosition()));
                }
            });
        }

    @Override
    public void onClick(View view) {listener.onPersonClicked(getAdapterPosition());}
    }
}
