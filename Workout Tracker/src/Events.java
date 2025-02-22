public class Events {
  private String eventName;
  private String bestTime;
  
  public Events(String event, String time)
  {
    this.eventName = event;
    this.bestTime = time;
  }
  
  public String getTime() // returns most up to date best time
  {
    return this.bestTime;
  }
  
  public String getEvent() // return the event name
  {
    return this.eventName;
  }
  
  public String updateTime(String time) // updates best time.
  {
    if(this.getTime().equals(time))
    {
      return "Best time is the same";
    }
    else
    {
      this.bestTime = time;
      return "Best Time has been updated to: " + time;
    }
  }
  
  @Override
  public String toString() {
      return "Events{" +
              "eventName='" + eventName + '\'' +
              ", bestTime=" + bestTime +
              '}';
  }


}
