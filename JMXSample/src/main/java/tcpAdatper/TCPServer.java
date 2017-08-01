package tcpAdatper;

import java.lang.management.ManagementFactory;
import java.net.ServerSocket;
import java.net.Socket;

import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class TCPServer implements TCPServerMBean, MBeanRegistration, Runnable
{
  private int port = 1555;
  private boolean stopped = false;
  private ServerSocket ss = null;
  private MBeanServer mbs = null;

  public TCPServer()
  {
  }

  public void setPort( int port )
  {
    this.port = port;
  }

  public int getPort()
  {
    return port;
  }

  public boolean start()
  {
    stopped = false;
    Thread t = new Thread( this );
    t.start();
    return true;
  }

  public boolean stop()
  {
    stopped = true;
    return true;
  }

  public void run()
  {
    try
    {
      System.out.println( "Binding to port: " + port );
      ss = new ServerSocket( port );
      while( !stopped )
      {
        Socket client = ss.accept();
        System.out.println( "Client being accepted" );
        Thread t = new Thread( new TCPAdapter( client, mbs ) );
        t.start();
      }
      ss.close();
    }
    catch( Exception e )
    {
      e.printStackTrace();
      stopped = true;
    }
  }

  public void postDeregister() {}
  public void postRegister( Boolean done ) {}
  public void preDeregister() {}

  public ObjectName preRegister( MBeanServer server, ObjectName name )
  {
    this.mbs = server;
    return name;
  }
    public static void main(String[] args) throws MalformedObjectNameException {
		
    	
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		String domainName = "MyMBean";

		// 为MBean（下面的new Hello()）创建ObjectName实例
		ObjectName helloName = new ObjectName(domainName + ":name=HelloWorld");
		
		TCPServer server =new TCPServer();
		
		server.setPort(8888);
		server.preRegister(mbs, helloName);
		server.start();
	}
  
  
}

