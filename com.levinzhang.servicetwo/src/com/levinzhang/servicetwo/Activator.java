package com.levinzhang.servicetwo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.levinzhang.serviceinterface.HelloService;
import com.levinzhang.servicetwo.service.HelloServiceImpl;

public class Activator implements BundleActivator {

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
		HelloServiceImpl helloService = new HelloServiceImpl();
		bundleContext.registerService(HelloService.class, helloService, null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
