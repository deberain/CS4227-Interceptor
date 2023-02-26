package com.deberain.RentalLogging;

import java.util.Vector;

public class LogDispatcher implements ILogInterceptor {
    private Vector<ILogInterceptor> _interceptors;
    private static LogDispatcher _dispatcher = new LogDispatcher();

    private LogDispatcher() {
        _interceptors = new Vector<ILogInterceptor>();
    }

    public static LogDispatcher GetDispatcherInstance() {
        return _dispatcher;
    }

    public void RegisterLogInterceptor(ILogInterceptor i) {
        _interceptors.addElement(i);
    }

    public void RemoveLogInterceptor(ILogInterceptor i) {
        _interceptors.removeElement(i);
    }

    @Override
    public void onRentalAssignment(RentalLog log) {
        for (ILogInterceptor interceptor : _interceptors) {
            interceptor.onRentalAssignment(log);
        }
    }
}
