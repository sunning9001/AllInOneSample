package sample;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

public class GetZkConnection {
	public static void main(String[] args) throws Exception {

		//Curator connection instances (CuratorFramework) are allocated from the CuratorFrameworkFactory.
		//You only need one CuratorFramework object for each ZooKeeper cluster you are connecting to.
		
		CuratorFramework cf = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3));
		
		cf.start();
		
		try {
			cf.blockUntilConnected();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Once you have a CuratorFramework instance, you can make direct calls to ZooKeeper in a similar way to using the raw ZooKeeper object provided in the ZooKeeper distribution. E.g
		//cf.create().forPath("/my/acc", "hello world".getBytes());
		
		
		//Stat z = cf.checkExists().forPath("/my/acc");
		//System.out.println(z);
		//The benefit here is that Curator manages the ZooKeeper connection and will retry operations if there are connection problems.
		System.out.println("1");
		
		//Notifications for background operations and watches are published via the ClientListener interface. 
		//You register listeners with the CuratorFramework instance using the addListener() method.
		//The listener implements two methods:
		//eventReceived()	A background operation has completed or a watch has triggered. Examine the given event for details
		cf.getCuratorListenable().addListener(new CuratorListener() {
			
			@Override
			public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
				
				System.out.println("<");
				System.out.println("path:" + event.getPath()+"event:" + 	event.getType());
				
				System.out.println(event.getWatchedEvent().getType());

				System.out.println(">");
			
			}
		});
		
		 Stat f = cf.checkExists().forPath("/examples/leader");
		
		 cf.getConnectionStateListenable().addListener(new ConnectionStateListener() {
			
			@Override
			public void stateChanged(CuratorFramework client, ConnectionState newState) {
				System.out.println(newState);
				
			}
		});
		 
		
		 System.out.println(f);
		Thread.sleep(1000000);
		
	}
}
