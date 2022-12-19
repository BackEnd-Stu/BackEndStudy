package com.servlet.web.frontcontroller.v2;

import com.servlet.web.frontcontroller.MyView;
import com.servlet.web.frontcontroller.v1.ControllerV1;
import com.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import com.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("FrontControllerServletV2.service");
        String requestURI = request.getRequestURI();

        System.out.println("requestURI = " + requestURI);

        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        try {
            MyView view = controller.process(request, response);
            view.render(request,response);
        } catch (SerialException e) {
            throw new RuntimeException(e);
        }
    }
}
