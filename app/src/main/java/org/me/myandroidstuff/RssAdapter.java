package org.me.myandroidstuff;
import java.text.DateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TwoLineListItem;

/**
 * Created by jamesglasgow on 23/02/16.
 */

public class RssAdapter extends BaseAdapter {
    private List<RoadInfo> items;
    private Context context;
    private LayoutInflater inflater;

    public RssAdapter(Context context, List<RoadInfo> items) {
        inflater = LayoutInflater.from(context);
        //this.context = context;
        this.items = items;

    }
  //  @Override
    public int getCount() {
        return items.size();
    }

  //  @Override
    public Object getItem(int position) {
        return items.get(position);
    }
    //@Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder {
        TextView textView1;
        TextView textView2;
    }
   public View getView(int position, View convertView, ViewGroup parent) {

       ViewHolder holder = null;
       // RelativeLayout twoText;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listlayout, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.textTitle);
            holder.textView2 = (TextView) convertView.findViewById(R.id.textDisc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

       holder.textView1.setText(items.get(position).getTitle());
       holder.textView2.setText(items.get(position).getDiscription());


        return convertView;
    }
}


