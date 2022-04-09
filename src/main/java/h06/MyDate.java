package h06;

import java.util.Calendar;

public class MyDate
{
	private final int year;
	private final int month;
	private final int day;
	private final int hour;
	private final int minute;

	private final long coefficientYear = 4563766470487201L;
	private final long coefficientMonth = 73232;
	private final long coefficientDay = 4;
	private final long coefficientHour = 1234;
	private final long coefficientMinute = 99998;
	private final long coefficientSum = 98924;

	private final boolean randomBoolean;

    /**
     * Creates a new date consisting of a calendar and a boolean value deciding how to calculate the hash value.
     * @param date The date.
     * @param randomBoolean The boolean value used to determine the calculation of the hash value.
     */
	public MyDate(Calendar date, boolean randomBoolean)
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Returns the year of the date stored in this object.
	 * @return The year of the date stored in this object.
	 */
	public int getYear()
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Returns the month of the date stored in this object.
	 * @return The month of the date stored in this object.
	 */
	public int getMonth()
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Returns the day of month of the date stored in this object.
	 * @return The day of month of the date stored in this object.
	 */
	public int getDay()
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Returns the hour of the date stored in this object.
	 * @return The hour of the date stored in this object.
	 */
	public int getHour()
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

	/**
	 * Returns the minute of the date stored in this object.
	 * @return The minute of the date stored in this object.
	 */
	public int getMinute()
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

    /**
     * Return the boolean value set in the constructor.
     * @return The boolean value set in the constructor.
     */
    public boolean getBool()
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

	@Override
	public int hashCode()
	{
		// TODO
		throw new RuntimeException("Not implemented");
	}

    @Override
    public boolean equals(Object obj)
	{
		// TODO
		throw new RuntimeException("Not implemented");
    }
}
