package rmi;

import java.util.Set;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.InvalidAttributeValueException;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanRegistrationException;
import javax.management.NotCompliantMBeanException;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.QueryExp;
import javax.management.ReflectionException;

public interface RemoteMBeanServer {
	public ObjectInstance createMBean(String className, ObjectName name) throws ReflectionException,
			InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException;

	public ObjectInstance createMBean(String className, ObjectName name, ObjectName loaderName)
			throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException,
			NotCompliantMBeanException, InstanceNotFoundException;

	public ObjectInstance createMBean(String className, ObjectName name, Object[] params, String[] signature)
			throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException,
			NotCompliantMBeanException;

	public ObjectInstance createMBean(String className, ObjectName name, ObjectName loaderName, Object[] params,
			String[] signature) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException,
			MBeanException, NotCompliantMBeanException, InstanceNotFoundException;

	public void unregisterMBean(ObjectName name) throws InstanceNotFoundException, MBeanRegistrationException;

	public ObjectInstance getObjectInstance(ObjectName name) throws InstanceNotFoundException;

	public boolean isRegistered(ObjectName name);

	public Integer getMBeanCount();

	public Object getAttribute(ObjectName name, String attribute)
			throws MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException;

	public AttributeList getAttributes(ObjectName name, String[] attributes)
			throws InstanceNotFoundException, ReflectionException;

	public void setAttribute(ObjectName name, Attribute attribute) throws InstanceNotFoundException,
			AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException;

	public AttributeList setAttributes(ObjectName name, AttributeList attributes)
			throws InstanceNotFoundException, ReflectionException;

	public Object invoke(ObjectName name, String operationName, Object[] params, String[] signature)
			throws InstanceNotFoundException, MBeanException, ReflectionException;

	public String getDefaultDomain();

	public void addNotificationListener(ObjectName name, NotificationListener listener, NotificationFilter filter,
			Object handback) throws InstanceNotFoundException;

	public void addNotificationListener(ObjectName name, ObjectName listener, NotificationFilter filter,
			Object handback) throws InstanceNotFoundException;

	public void removeNotificationListener(ObjectName name, NotificationListener listener)
			throws InstanceNotFoundException, ListenerNotFoundException;

	public void removeNotificationListener(ObjectName name, ObjectName listener)
			throws InstanceNotFoundException, ListenerNotFoundException;

	public MBeanInfo getMBeanInfo(ObjectName name)
			throws InstanceNotFoundException, IntrospectionException, ReflectionException;

	public boolean isInstanceOf(ObjectName name, String className) throws InstanceNotFoundException;

	public Set queryMBeans(ObjectName name, QueryExp query);

	public Set queryNames(ObjectName name, QueryExp query);

	public void close();
}
