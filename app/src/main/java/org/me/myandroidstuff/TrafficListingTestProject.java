package org.me.myandroidstuff;

import java.util.LinkedList;
import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class TrafficListingTestProject extends Activity implements View.OnClickListener
{




	private String CurrentUrl = "http://www.trafficscotland.org/rss/feeds/roadworks.aspx";
	private String PlanedUrl = "http://trafficscotland.org/rss/feeds/plannedroadworks.aspx";
	private String IncidentUrl = "http://trafficscotland.org/rss/feeds/currentincidents.aspx";
	private Button Planed;
	private Button Current;
	private Button Incident;
	private ListView RssEntryListView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{


		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		 RssEntryListView = (ListView) findViewById(R.id.listDis);


		Planed = (Button) findViewById(R.id.Planed);
		Planed.setOnClickListener(this);
		Current = (Button) findViewById(R.id.Current);
		Current.setOnClickListener(this);
		Incident = (Button) findViewById(R.id.Incident);
		Incident.setOnClickListener(this);




	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("in on click");
		if (v==Planed)
		{
			LinkedList<RoadInfo> alist = null;
			Htmlparser info =new Htmlparser();
			alist=info.ParseStart(PlanedUrl);
			RssEntryListView.setAdapter(new RssAdapter(this,alist));
		}
		if (v==Current)
		{
			LinkedList<RoadInfo> alist = null;
			Htmlparser info =new Htmlparser();
			alist=info.ParseStart(CurrentUrl);
			RssEntryListView.setAdapter(new RssAdapter(this,alist));

		}
		if (v==Incident)
		{
			LinkedList<RoadInfo> alist = null;
			Htmlparser info =new Htmlparser();
			alist=info.ParseStart(IncidentUrl);
			RssEntryListView.setAdapter(new RssAdapter(this,alist));

		}
	}
}