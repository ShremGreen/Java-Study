package fruit.servlets;
import fruit.DAO.FruitDAO;
import fruit.DAO.impl.FruitDAOImpl;
import fruit.pojo.Fruit;
import myssm.mySpringMVC.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")//注解 配置xml
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList();
        //保存到session作用域
        HttpSession session = req.getSession();
        session.setAttribute("fruitList", fruitList);

        //此处的试图名称是 index
        //thymeleaf会把这个 逻辑视图 名称对应到 物理视图 名称上去
        //逻辑视图名称 index
        //物理视图名称 view-prefix + 逻辑视图名称 + view-suffix
        //而配置的xml中，prefix=/，suffix=.html
        //所以真正的视图名称是：/index.html
        super.processTemplate("index",req,resp);

    }
}
