package org.me.myandroidstuff;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by jamesglasgow on 22/02/16.
 */
public class Htmlparser {

    public LinkedList<RoadInfo> ParseStart(String dataToParse){

        URL url1 = null;
        try {
            url1 = new URL(dataToParse);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.e("Checks", "Website " + url1);
        LinkedList<RoadInfo> alist = null;
        alist=parseData(url1);
        return alist;
    }

    private LinkedList<RoadInfo> parseData(URL dataToParse)
    {
        RoadInfo Info=null;
        LinkedList <RoadInfo> alist = null;

        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            //xpp.setInput( new StringReader ( dataToParse ) );
            xpp.setInput(getInputStream(dataToParse), "UTF_8");
            boolean stared=false;
            int eventType = xpp.getEventType();
            //boolean insideItem = false;
            alist  = new LinkedList<RoadInfo>();
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                // Found a start tag
                if(eventType == XmlPullParser.START_TAG)
                {
                    // Check which Tag we have
                    if (xpp.getName().equalsIgnoreCase("item"))//channel
                    {
                        if(!stared){
                            stared=true;
                        }
                        Log.e("MyTag", "Parsing error1");
                    }
                    else
                        // Check which Tag we have
                        if (xpp.getName().equalsIgnoreCase("title")&&stared)
                        {

                            Info = new RoadInfo();
                            //
                            Info.setTitle(xpp.nextText());
                            Log.e("Testing","title "+Info.getTitle());
                        }
                        else if (xpp.getName().equalsIgnoreCase("description")&&stared)
                        {
                            //Info.setTitle(xpp.nextText());
                            Info.setDiscription(xpp.nextText());
                            Log.e("Testing", "description "+Info.getDiscription());

                        }else if (xpp.getName().equalsIgnoreCase("pubDate")&&stared)
                        {
                            Info.setPubDate(xpp.nextText());
                            Log.e("Testing", "pubDate "+Info.getPubDate());
                        }
					/*else if (xpp.getName().equalsIgnoreCase("georss"))
					{
						Info.setGPS(xpp.nextText());
						Log.e("MyTag", "Parsing error5");
					}
					else if (xpp.getName().equalsIgnoreCase("pubDate"))
					{
						Info.setPubDate(xpp.nextText());
						Log.e("MyTag", "Parsing error6");
					}*/
                }else
                if(eventType == XmlPullParser.END_TAG)
                {
                    if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        //Log.e("MyTag","widget is " + widget.toString());
                        alist.add(Info);
                    }
                    else
                    if (xpp.getName().equalsIgnoreCase("channel"))
                    {
                        int size;
                        size = alist.size();
                        Log.e("MyTag","channel size is " + size);
                    }
                }

                // Get the next event
                eventType = xpp.next();

            } // End of while
        }
        catch (XmlPullParserException ae1)
        {
            Log.e("MyTag","Parsing error " + ae1.toString());
        }
        catch (IOException ae1)
        {
            Log.e("MyTag", "IO error during parsing");
        }
        /*ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout., headlines);
       ListView lv = (ListView)findViewById(R.id.listDis);
        lv.setAdapter(adapter);*/

        Log.e("MyTag", "End document");
        return alist;

    }
    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }

    }

}
