package com.example.myfirstapp;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LanguageAdapter extends ArrayAdapter<Language> {
	private Context context;
	private int layoutResourceID;
	private Language[] data;
	public LanguageAdapter(Context context, int layoutResourceID, Language[] data) {
		super(context, layoutResourceID, data);
		
		this.context = context;
		this.layoutResourceID = layoutResourceID;
		this.data = data;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		LanguageHolder holder = null;
		
		if (row == null) {
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResourceID, parent, false);
			
			holder = new LanguageHolder();
			holder.img = (ImageView)row.findViewById(R.id.imgIcon);
			holder.txt = (TextView)row.findViewById(R.id.txtTitle);
			row.setTag(holder);
		}
		else {
			holder = (LanguageHolder)row.getTag();
		}
		Language language = data[position];
		holder.txt.setText(language.title);
		holder.img.setImageResource(language.icon);
		
		return row;
	}
	private static class LanguageHolder {
		ImageView img;
		TextView txt;
	}
}
