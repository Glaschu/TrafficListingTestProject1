package org.me.myandroidstuff;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import android.content.Context;
import android.util.Log;
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
    private int test;
    static boolean Searching =false;
    static Date parsed = null;
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
       //test +=1;
       //Log.e("listtest ",""+test);
       holder.textView1.setText(items.get(position).getTitle());
       holder.textView2.setText(items.get(position).getDiscription());


        return convertView;
    }
    public static void SetSearchDateOn(String DateS){
        String DateString =DateS;

        DateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            parsed = inputFormat.parse(DateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public static void SearchBool(Boolean Bo){
        if(!Bo){
            Searching =false;
        }else if(Bo){Searching =false;}

    }
}


