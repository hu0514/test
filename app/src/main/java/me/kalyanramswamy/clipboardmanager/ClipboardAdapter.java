package me.kalyanramswamy.clipboardmanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by kalyanram on 12/1/18.
 */

public class ClipboardAdapter extends RecyclerView.Adapter<ClipboardAdapter.ClipboardHolder> {
    List<Clipboard> data;
    public ClipboardAdapter(List<Clipboard> data) {
        this.data = data;
    }

    @Override
    public ClipboardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.clipboard_layout, parent, false);
        return new ClipboardHolder(view);
    }

    @Override
    public void onBindViewHolder(ClipboardHolder holder, int position) {
        holder.clip.setText(data.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ClipboardHolder extends RecyclerView.ViewHolder {
        TextView sno,clip;

        public ClipboardHolder(View itemView) {
            super(itemView);
            clip = (TextView) itemView.findViewById(R.id.clip);
        }
    }
}
