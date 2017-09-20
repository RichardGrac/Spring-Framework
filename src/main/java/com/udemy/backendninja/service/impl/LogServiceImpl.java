package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.service.LogService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogServiceImpl implements LogService {

    public static final Log LOG = LogFactory.getLog(LogService.class);

    @Override
    public void muestra_log(){
        LOG.info("Hello from LogServiceImpl");
    }
}
