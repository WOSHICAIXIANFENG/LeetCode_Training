package com.mum.sample;

public class Stopwatch {
	private long startTime;
    private long stopTime;

    // 一纳秒对应 10亿分之一 秒
    public static final double NANOS_PER_SEC = 1000000000.0;

	/**
	 start the stop watch.
	*/
	public void start(){
		startTime = System.nanoTime();
	}

	/**
	 stop the stop watch.
	*/
	public void stop()
	{	stopTime = System.nanoTime();	}

	/**
	elapsed time in seconds.
	@return the time recorded on the stopwatch in seconds
	*/
	public double time()
	{	return (stopTime - startTime) / NANOS_PER_SEC;	}

	public String toString(){
	    return "elapsed time: " + time() + " seconds.";
	}

	/**
	elapsed time in nanoseconds.
	@return the time recorded on the stopwatch in nanoseconds
	*/
	public long timeInNanoseconds()
	{	return (stopTime - startTime);	}
	
	public static void main(String[] args) {
		Stopwatch watch = new Stopwatch();
		watch.start();
		//....
		watch.stop();
		
		System.out.println("Samuel Test measure time elapsed = " + watch.timeInNanoseconds());

	}

}
