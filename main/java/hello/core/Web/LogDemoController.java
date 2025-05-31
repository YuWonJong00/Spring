package hello.core.Web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger mylogger;

    public LogDemoController(LogDemoService logDemoService, MyLogger mylogger) {
        this.logDemoService = logDemoService;
        this.mylogger = mylogger;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + mylogger.getClass());

        mylogger.setRequestURL(requestURL);

        mylogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }
}
