import java.applet.Applet;

public class AppletMethod extends Applet
{
	public void init()
	{
		System.out.println("init");
	}

    public void start()
    {
    	showMsg("start");
    }
 
    public void stop()
    {
        showMsg("stop");
    }
 
    public void destroy()
    {
        showMsg("destory");
    }
   
    public void showMsg(String msg)
    {
    	System.out.println(msg);
   	}
}
