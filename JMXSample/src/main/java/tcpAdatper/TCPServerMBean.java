package tcpAdatper;

public interface TCPServerMBean
{
  public void setPort( int port );
  public int getPort();
  public boolean start();
  public boolean stop();
}

