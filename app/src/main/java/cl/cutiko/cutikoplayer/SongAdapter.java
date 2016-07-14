package cl.cutiko.cutikoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cutiko on 14-07-16.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, int resource, List<Song> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewChildHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_song, parent, false);
            holder = new ViewChildHolder();
            holder.songTitle= (TextView) convertView.findViewById(R.id.song_title);
            holder.songArtist = (TextView) convertView.findViewById(R.id.song_artist);
            convertView.setTag(holder);
        } else {
            holder = (ViewChildHolder) convertView.getTag();
        }

        Song song = getItem(position);

        holder.songTitle.setText(song.getTitle());
        holder.songArtist.setText(song.getArtist());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(getItem(position).getId());
    }

    private class ViewChildHolder {
        TextView songTitle, songArtist;
    }
}
