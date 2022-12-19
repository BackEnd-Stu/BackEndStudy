package com.servlet.web.frontcontroller.v5.adapter;

import com.servlet.web.frontcontroller.Modelview;
import com.servlet.web.frontcontroller.v3.ControllerV3;
import com.servlet.web.frontcontroller.v4.ControllerV4;
import com.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public Modelview handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws SecurityException, IOException {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        HashMap<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);

        Modelview modelview = new Modelview(viewName);
        modelview.setModel(model);
        return modelview;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
