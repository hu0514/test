package me.kalyanramswamy.clipboardmanager;

import android.content.ClipboardManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ClipboardAdapter adapter;
    ClipboardRepo clipboardRepo;
    ClipboardManager clipboardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clipboardRepo = new ClipboardRepo(this);
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        recyclerView = (RecyclerView) findViewById(R.id.clipboard_list);

        adapter = new ClipboardAdapter(getAll());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        clipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                List<Clipboard> list = getAll();
                if(list.size() == 1 && list.get(0).getDescription().equals("no data found")){
                    list.remove(0);
                }
                list.add(0,new Clipboard(clipboardManager.getText().toString()));
                setData(list);
            }
        });
        startService(new Intent(this, ClipboardService.class));
    }

    public void setData(List<Clipboard> clipboards){
        adapter = new ClipboardAdapter(clipboards);
        recyclerView.setAdapter(adapter);
    }

    public void addClip(View view) {
        if (clipboardManager.getText() != null) {
            clipboardRepo.insertData(new Clipboard(clipboardManager.getText().toString()));
        }
        setData(getAll());
    }

    public List<Clipboard> getAll(){
        Cursor cursor =  clipboardRepo.getClipboards();
        List<Clipboard> list = new ArrayList<Clipboard>();
        if(cursor.getCount() == 0){
            Clipboard clipboard = new Clipboard("no data found");
            list.add(clipboard);
        }else{
            while(cursor.moveToNext()) {
                Clipboard clipboard = new Clipboard(cursor.getString(1));
                list.add(clipboard);
            }
        }
        return list;
    }
}