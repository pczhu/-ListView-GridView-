package com.pczhu.listviewchouti;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener, OnItemLongClickListener {

	private MyAdapter adapter = new MyAdapter();
	private ItemAdapter itemadapter = new ItemAdapter();
	private List<String> itemcontent;
	private List<String> item_name;
	private int currentposition = -1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout lin = (LinearLayout) findViewById(R.id.panelContent);
		//ListView listview = (ListView) findViewById(R.id.listview);
		ListView listview = new ListView(this);
		lin.addView(listview,0);
		//lin.addView

		itemcontent = new ArrayList<String>();
		itemcontent.add("A");
		itemcontent.add("B");
		itemcontent.add("C");
		itemcontent.add("D");
		itemcontent.add("E");
		itemcontent.add("F");
		itemcontent.add("G");
		itemcontent.add("H");
		itemcontent.add("I");
		item_name = new ArrayList<String>();
		item_name.add("颜色");
		item_name.add("样式");
		item_name.add("性别");
		item_name.add("种类");
		item_name.add("大小");
		item_name.add("国家");
		item_name.add("价格");
		item_name.add("家具");
		item_name.add("配置");
		item_name.add("配置");


		listview.setAdapter(adapter);

		listview.setOnItemClickListener(this);
		listview.setOnItemLongClickListener(this);
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.drawable.icon_macrame);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		lin.addView(iv,params);
	}
	public class MyAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return item_name.size();
		}
		@Override
		public Object getItem(int position) {
			return item_name.get(position);
		}
		@Override
		public long getItemId(int position) {
			return 0;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;
			GridView gv = null;
			LinearLayout ll = null;
			LinearLayout l2 = null;
			TextView tv_name = null;
			ImageView image = null;
			if(convertView == null){
				view = View.inflate(MainActivity.this, R.layout.item_color, null);
				gv = (GridView) view.findViewById(R.id.gridview);
				ll = (LinearLayout) view.findViewById(R.id.item_name);
				l2 = (LinearLayout) view.findViewById(R.id.item_list);
				tv_name = (TextView) view.findViewById(R.id.textView1);
				image = (ImageView) view.findViewById(R.id.imageView1);
			}else{
				view = convertView;
				gv = (GridView) view.findViewById(R.id.gridview);
				ll = (LinearLayout) view.findViewById(R.id.item_name);
				l2 = (LinearLayout) view.findViewById(R.id.item_list);
				tv_name = (TextView) view.findViewById(R.id.textView1);
				image = (ImageView) view.findViewById(R.id.imageView1);

			}
			gv.setAdapter(itemadapter);
			tv_name.setText(item_name.get(position));
			System.out.println(currentposition+":"+position);
			if(currentposition == position){
				l2.setVisibility(View.VISIBLE);
				image.setSelected(true);
			}else{
				l2.setVisibility(View.GONE);
				image.setSelected(false);
			}
			return view;
		}
	}
	public class ItemAdapter extends BaseAdapter{
		@Override
		public int getCount() {
			return itemcontent.size();
		}
		@Override
		public Object getItem(int position) {
			return null;
		}
		@Override
		public long getItemId(int position) {
			return 0;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView textview = new TextView(MainActivity.this);
			textview.setText(itemcontent.get(position));
			return textview;
		}
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if(currentposition == position){
			currentposition = -1;
			adapter.notifyDataSetChanged();
			return;
		}else{
			currentposition = -1;
			adapter.notifyDataSetChanged();
			currentposition = position;
			adapter.notifyDataSetChanged();
		}
	}
	
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		return true;
	}
}
