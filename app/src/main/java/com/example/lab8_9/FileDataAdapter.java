package com.example.lab8_9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FileDataAdapter extends RecyclerView.Adapter<FileDataAdapter.ViewHolder> {
    private List<String> mData;

    public FileDataAdapter(List<String> data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = mData.get(position);
        holder.textViewFileData.setText(item.replaceAll("\\r?\\n", "").trim());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewFileData;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewFileData = (TextView) itemView.findViewById(R.id.notitaData);
        }
    }
}
