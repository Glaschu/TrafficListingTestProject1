package org.me.myandroidstuff;

import java.util.LinkedList;
import java.util.List;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.os.SystemClock;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class TrafficListingTestProject extends Activity implements View.OnClickListener
{




	private String CurrentUrl = "http://www.trafficscotland.org/rss/feeds/roadworks.aspx";
	private String PlanedUrl = "http://trafficscotland.org/rss/feeds/plannedroadworks.aspx";
	private String IncidentUrl = "http://trafficscotland.org/rss/feeds/currentincidents.aspx";
	private Button Planed;
	private Button Current;
	private Button Incident;
	private ListView RssEntryListView;
	private Integer Num;
	public LinkedList<RoadInfo> alist = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		//LinkedList<RoadInfo> alist = null;
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
	private class ShowDialogAsyncTask extends AsyncTask<Void, Integer, Void>
	{

		int progress_status;

		@Override
		protected void onPreExecute()
		{
			// update the UI immediately after the task is executed
			super.onPreExecute();

			//Toast.makeText(TrafficListingTestProject.this, "Invoke onPreExecute()", Toast.LENGTH_SHORT).show();

			progress_status = 0;
			//txt_percentage.setText("Downloading 0%");

		}

		@Override
		protected Void doInBackground(Void... params)
		{

			while(progress_status<100)
			{

				progress_status += 100;

				publishProgress(progress_status);
				// Sleep but normally do something useful here such as access a web resource
				//SystemClock.sleep(300); // or Thread.sleep(300);
				if (Num==1)
				{

					Htmlparser info =new Htmlparser();
					alist=info.ParseStart(PlanedUrl);

				}
				if (Num==2)
				{
					//LinkedList<RoadInfo> alist = null;
					Htmlparser info =new Htmlparser();
					alist=info.ParseStart(CurrentUrl);
					//RssEntryListView.setAdapter(new RssAdapter(this,alist));

				}
				if (Num==3)
				{
					//LinkedList<RoadInfo> alist = null;
					Htmlparser info =new Htmlparser();
					alist=info.ParseStart(IncidentUrl);
					//RssEntryListView.setAdapter(new RssAdapter(this,alist));

				}
				// Really need to do some calculation on progress
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values)
		{
			super.onProgressUpdate(values);

			//progressBar.setProgress(values[0]);

			//txt_percentage.setText("Downloading " +values[0] + "%");

		}

		@Override
		protected void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			//Toast.makeText(TrafficListingTestProject.this,"Invoke onPostExecute()", Toast.LENGTH_SHORT).show();
			RssEntryListView.setAdapter(new RssAdapter(TrafficListingTestProject.this,alist));
			//txt_percentage.setText("Download complete");
			//startButton.setEnabled(true);
			//progressBar.setVisibility(View.INVISIBLE);

		}

	}



	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("in on click");
		if (v==Planed)
		{
			Num=1;
			new ShowDialogAsyncTask().execute();
			//LinkedList<RoadInfo> alist = null;
			//Htmlparser info =new Htmlparser();
			//alist=info.ParseStart(PlanedUrl);
			//RssEntryListView.setAdapter(new RssAdapter(this,alist));
		}
		if (v==Current)
		{

			Num=2;
			new ShowDialogAsyncTask().execute();
			//LinkedList<RoadInfo> alist = null;
			//Htmlparser info =new Htmlparser();
			//alist=info.ParseStart(CurrentUrl);
			//RssEntryListView.setAdapter(new RssAdapter(this,alist));

		}
		if (v==Incident)
		{
			Num=3;
			new ShowDialogAsyncTask().execute();
			//LinkedList<RoadInfo> alist = null;
			//Htmlparser info =new Htmlparser();
			//alist=info.ParseStart(IncidentUrl);
			//RssEntryListView.setAdapter(new RssAdapter(this,alist));

		}
	}
}