import java.util.*;
import java.io.*;
public class WeatherData
{
	private static String code[];
	private static String stationNumber[];
	private static int year[];
	private static int month[];
	private static int day[];
	private static double maxTemp[];
	public static double min, max;
	public static int total, complete;
	
	public WeatherData(String[] pCode, String[] pStationNumber, int[] pYear, int[] pMonth, int[] pDay, double[] pMaxTemp) //Constructors with parameters
	{
		setCode(pCode);
		setStationNumber(pStationNumber);
		setYear(pYear);
		setMonth(pMonth);
		setDay(pDay);
		setMaxTemp(pMaxTemp);
	}
	
	public WeatherData(WeatherData pWeatherData) //copy constructor is used to make a copy of the object. 
	{
		setCode(pWeatherData.getCode());
		setStationNumber(pWeatherData.getStationNumber());
		setYear(pWeatherData.getYear());
		setMonth(pWeatherData.getMonth());
		setDay(pWeatherData.getDay());
		setMaxTemp(pWeatherData.getMaxTemp());
	}
	public WeatherData()
	{
		setCode(new String[10000]);
		setStationNumber(new String[12000]);
		setYear(new int[10000]);
		setMonth(new int[10000]);
		setDay(new int[10000]);
		setMaxTemp(new double[10000]);
		complete = 0;
		total = 0;
		min = 50;
		max = 0;
	}
	
	public String[] getCode()
	{
		return code;
	}
	public String[] getStationNumber()
	{
		return stationNumber;
	}
	public int[] getYear()
	{
		return year;
	}
	public int[] getMonth()
	{
		return month;
	}
	public int[] getDay()
	{
		return day;
	}
	public double[] getMaxTemp()
	{
		return maxTemp;
	}
	
	public String toString(int i)
	{
		String weatherDataString;
		weatherDataString = "Code is: " + getCode()[i] + " StationNumber is: " + getStationNumber()[i] + "Year is: "  + getYear()[i] + "Month is: " + getMonth()[i] + "Day is: " + getDay()[i] + "Max Temp is: " + getMaxTemp()[i];
	return weatherDataString;
	}

	public boolean equals(Object inObject)
	{
		boolean isEqual = false;
		WeatherData inWeatherData = null;
		if(inObject instanceof WeatherData)
		{
			inWeatherData = (WeatherData)inObject;
			if(getCode().equals(inWeatherData.getCode()))
				if(getStationNumber().equals(inWeatherData.getStationNumber()))
					if(getYear() == inWeatherData.getYear())
						if(getMonth() == inWeatherData.getMonth())
							if(getDay() == inWeatherData.getDay())
								if(getMaxTemp() == inWeatherData.getMaxTemp())
									isEqual = true;
		}
		return isEqual;
	}
	
	public void setCode(String code[])
	{
		WeatherData.code = code;
	}
	public void setStationNumber(String stationNumber[])
	{
		WeatherData.stationNumber = stationNumber;
	}
	public void setYear(int year[])
	{
		WeatherData.year = year;
	}
	public void setMonth(int month[])
	{
		WeatherData.month = month;
	}
	public void setDay(int day[])
	{
		WeatherData.day = day;
	}
	public void setMaxTemp(double maxTemp[])
	{
		WeatherData.maxTemp = maxTemp;
	}

	
	public static void readcsv(String path)
	{
	
		String line=" ";
		int i=0;
		try
		{
			BufferedReader bufRdr = new BufferedReader(new FileReader(path));
			line = bufRdr.readLine();
			
			while((line=bufRdr.readLine())!=null)
			{
				total++;
				String[] data = line.split(",");	
				if(data.length>5)
				{
					if(!(data[5].isEmpty()))
					{
						code[i] = data[0];
						stationNumber[i] = data[1];
						year[i] = Integer.parseInt(data[2]);
						month[i] = Integer.parseInt(data[3]);
						day[i] = Integer.parseInt(data[4]);
						maxTemp[i] = Double.parseDouble(data[5]);
						i++;
						complete++;
					}
				}
				
			}
			bufRdr.close();
		}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();		
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
		
	}
	
	public static void WhatIsMax()
	{
		for(int i =0; i<maxTemp.length; i++)
		{
			if(maxTemp[i] > max);
			{
				max = maxTemp[i];
			}
		}

	}

	public static void WhatIsMin()
	{
		for(int i = 0; i<maxTemp.length;i++)
		{
			if((min<maxTemp[i]) && (maxTemp[i]!=0))
			{
				min = maxTemp[i];
			}
		}
	}


}


