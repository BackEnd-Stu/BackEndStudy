package com.servlet.web.frontcontroller.v3;

import com.servlet.web.frontcontroller.Modelview;

import java.util.Map;

public interface ControllerV3 {
    Modelview process(Map<String, String> paramMap);
}
