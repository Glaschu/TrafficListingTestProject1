package org.me.myandroidstuff;

import java.util.Date;
import java.util.List;

/**
 * Created by jamesglasgow on 22/02/16.
 */
public class RoadInfo {
    private String Title;
    private String Discription;
    private String GPS;
    private Date Startdate;
    private Date Enddate;
    private String PubDate;

    public RoadInfo()
    {
        //super();
        Title="";
        Discription="";
         GPS="";
        PubDate="";
        Startdate=null;
        Enddate=null;

    }

    public RoadInfo(String aTitle, String aDiscription,String aGPS, String aPubDate)
    {
        //super();
        Title = aTitle;
        Discription = aDiscription;
        GPS = aGPS;
        PubDate=aPubDate;
    }

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String aTitle)
    {
        Title = aTitle;
    }
    public String getDiscription()
    {
        return Discription;
    }

    public void setDiscription(String aDiscription)
    {
        Discription = aDiscription;
    }
    public String getGPS()
    {
        return GPS;
    }

    public void setGPS(String aGPS)
    {
        GPS = aGPS;
    }
    public String getPubDate()
    {
        return PubDate;
    }

    public void setPubDate(String aPubDate)
    {
        PubDate = aPubDate;
    }
    public String toString()
    {
        String temp;

        temp = Title + " ";

        return temp;
    }
    public void setStartDate(Date date)
    {
        Startdate = date;
    }
    public void setEndDate(Date date)
    {
        Enddate = date;
    }
    public Date getStartDate()
    {
        return Startdate;
    }
    public Date getEndDate()
    {
        return Enddate;
    }

}
