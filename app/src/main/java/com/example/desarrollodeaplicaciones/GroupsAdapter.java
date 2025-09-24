package com.example.desarrollodeaplicaciones;

import java.util.List;

import java.util.Locale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.Color;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.VH> {
    private final List<Group> data;
    public GroupsAdapter(List<Group> d){ data=d; }

    static class VH extends RecyclerView.ViewHolder {
        TextView title, members, amount, tag;
        VH(View v){ super(v);
            title=v.findViewById(R.id.tvGroupTitle);
            members=v.findViewById(R.id.tvGroupMembers);
            amount=v.findViewById(R.id.tvGroupAmount);
            tag=v.findViewById(R.id.tvGroupTag);
        }
    }

    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup p,int vt){
        View v=LayoutInflater.from(p.getContext()).inflate(R.layout.item_group,p,false);
        return new VH(v);
    }

    @Override public void onBindViewHolder(@NonNull VH h,int i){
        Group g=data.get(i);
        h.title.setText(g.title);
        h.members.setText(g.members);
        String sign=g.amount>=0?"+":"-";
        h.amount.setText(String.format(Locale.getDefault(),"%s$%.2f",sign,Math.abs(g.amount)));
        if(g.amount>=0){ h.amount.setTextColor(Color.parseColor("#499537")); h.tag.setText("Te deben"); }
        else { h.amount.setTextColor(Color.parseColor("#D40924")); h.tag.setText("Debes"); }
    }

    @Override public int getItemCount(){ return data.size(); }
}
