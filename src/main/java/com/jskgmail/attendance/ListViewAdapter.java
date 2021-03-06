package com.jskgmail.attendance;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;

/**
 * Created by JASPREET SINGH on 06-08-2017.
 */

public class ListViewAdapter extends BaseAdapter  {
    Activity context;
    ArrayList<String> title;
    ArrayList<String> description;
    ArrayList<String> per;
    ArrayList<String> perincdec;
    ArrayList<String> ch;
    public ListViewAdapter(MainActivity context, ArrayList<String> title, ArrayList<String> description,ArrayList<String> per,ArrayList<String> perincdec,ArrayList<String> ch)
    {
        super();
        this.context=context;
        this.title=title;
        this.description=description;
        this.per=per;
        this.perincdec=perincdec;
        this.ch=ch;
    }


    @Override
    public int getCount() {

        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtviewtitle;
        TextView txtviewdesc;
        TextView txtper;
        TextView txtperincde;
TextView text;
        ImageView img;
        ImageView imageView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;


        LayoutInflater inflater=context.getLayoutInflater();
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.friend_item,null);
            holder=new ViewHolder();
            holder.txtviewtitle=(TextView)convertView.findViewById(R.id.friendName);


            holder.txtviewdesc=(TextView)convertView.findViewById(R.id.textView14);
            holder.txtper=(TextView)convertView.findViewById(R.id.textView12);
            holder.txtperincde=(TextView)convertView.findViewById(R.id.textView13) ;
            holder.img=(ImageView)convertView.findViewById(R.id.avatar);
            holder.imageView=(ImageView)convertView.findViewById(R.id.imageView2);
holder.text=(TextView)convertView.findViewById(R.id.statusMsg);












        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.txtviewtitle.setText(title.get(position));
        holder.txtviewdesc.setText(description.get(position));
        holder.txtper.setText(per.get(position));
        holder.txtperincde.setText(perincdec.get(position));
        Log.e("sdddsdsdsdsdsdsds", ch.get(position));

      if(  !(ch.get(position).equals(""))) {
          if ((Integer.parseInt(ch.get(position)) == 0))
              holder.img.setImageResource(R.mipmap.inc);
          else
              holder.img.setImageResource(R.mipmap.decccc);
      }
        if(  (ch.get(position).equals(""))) holder.text.setText(" Nothing to show ");
        convertView.setTag(holder);
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color1 = generator.getRandomColor();

        String[] a = title.get(position).split("");
        if ((a.length > 1)) {
            TextDrawable drawable = TextDrawable.builder().beginConfig().withBorder(4).textColor(R.color.caldroid_black).useFont(Typeface.DEFAULT).bold().toUpperCase().endConfig().buildRound(a[1], color1);
            holder.imageView.setImageDrawable(drawable);
        }









notifyDataSetChanged();
        return convertView;
    }


}
