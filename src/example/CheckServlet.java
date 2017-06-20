package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 刘灿锐 on 2017/6/20.
 */
@WebServlet(name = "CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=utf-8");

        // 获取存放在session中的验证码
        String code = (String) request.getSession().getAttribute("randCheckCode");
        // 获取页面提交的验证码
        String inputCode = request.getParameter("code").toLowerCase();

        System.out.println("code  " + code);
        System.out.println("inputCode  " + inputCode);
        if (code.toLowerCase().equals(inputCode.toLowerCase())) { // 验证码不区分大小写
            // 验证成功，跳转到成功页面
//            req.setAttribute("code", "true");
            response.getWriter().println("true");
        } else { // 验证失败
//            req.setAttribute("code", "false");
            response.getWriter().println("false");
        }
    }
}
