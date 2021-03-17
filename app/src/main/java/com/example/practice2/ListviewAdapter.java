package com.example.practice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListviewAdapter extends BaseAdapter {

    List<String> stringList;
    List<Integer> integerList;
    boolean playStatus = false;
    int playingTrack = -1;

    public boolean isPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(boolean playStatus) {
        this.playStatus = playStatus;
        notifyDataSetChanged();
    }

    public int getPlayingTrack() {
        return playingTrack;
    }

    public void setPlayingTrack(int playingTrack) {
        this.playingTrack = playingTrack;
        notifyDataSetChanged();
    }



    public ListviewAdapter(List<String> stringList, List<Integer> integerList) {
        this.stringList = stringList;
        this.integerList = integerList;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.listview_layout, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageViewList);
        TextView textView = convertView.findViewById(R.id.textViewList);
        imageView.setImageResource(integerList.get(position));
        textView.setText(stringList.get(position));
        return convertView;
    }
}
