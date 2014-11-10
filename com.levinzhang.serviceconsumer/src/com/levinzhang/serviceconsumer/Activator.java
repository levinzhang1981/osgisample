package com.levinzhang.serviceconsumer;

import java.util.Collection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import com.levinzhang.serviceinterface.HelloService;

public class Activator implements BundleActivator{

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("This Bundle is Started!");
		
		Runnable test = new Runnable(){
			@Override
			public void run() {
				try {
					while(true){
						Collection<ServiceReference<HelloService>> collection = context.getServiceReferences(HelloService.class,null);
						
						for(ServiceReference<HelloService> serviceReference:collection){
							HelloService service = context.getService(serviceReference);
							service.sayHello();
						}
						Thread.sleep(10000);
					}

				} catch (InvalidSyntaxException e) {
					e.printStackTrace();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
			
		};
		Thread thread = new Thread(test);
		
		thread.start();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	

}
