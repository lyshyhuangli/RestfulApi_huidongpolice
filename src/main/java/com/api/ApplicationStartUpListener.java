package com.api;

import com.api.utils.PropertyUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartUpListener implements ApplicationListener<ApplicationStartedEvent>
{
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event)
    {
        PropertyUtil.loadAllProperties();
        //System.out.println("ApplicationStartUpListener EXEC");
    }

}
