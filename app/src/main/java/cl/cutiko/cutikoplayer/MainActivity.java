package cl.cutiko.cutikoplayer;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Song> songList = new ArrayList<>();
    private ListView songView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songView = (ListView) findViewById(R.id.song_list);
        getSongList();
        if (songList != null && songList.size() > 0) {
            Collections.sort(songList, new Comparator<Song>() {
                @Override
                public int compare(Song lhs, Song rhs) {
                    return lhs.getTitle().compareTo(rhs.getTitle());
                }
            });
            SongAdapter adapter = new SongAdapter(getApplicationContext(), R.layout.list_item_song, songList);

            songView.setAdapter(adapter);
        }
    }


    public void getSongList() {
        Uri uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC;

        Cursor cursor = getContentResolver().query(uri, projection, selection, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                songList.add(new Song(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }
            cursor.close();
        }

    }
}
