package controller;

import model.Customer;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    static CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }


        switch (action) {
            case "find":
                showResult(req,resp);
                break;
            case "create":
                showCreate(req, resp);
                break;
            case "delete":
                showDelete(req, resp);
                break;
            case "update":
                showUpdate(req, resp);
                break;
            case "detail":
                showDetail(req, resp);
                break;
            case "":

                showAll(req, resp);
                break;

        }
    }

    private void showResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Customer> list = new ArrayList<Customer>();
        List<Customer> list1 = customerService.findAll();
        int check=0;
        for (Customer customer: list1){
            if (customer.getName().contains(name)){
                list.add(customer);
                check=1;
            }
        }
        if (check == 1) {
            req.setAttribute("customerList",list);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/findResult.jsp");
            requestDispatcher.forward(req,resp);

        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/notFound.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/create.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerService.findById(id);
        req.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/detail.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));

        Customer customer = customerService.findById(id);

        req.setAttribute("customer", customer);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("deleteForm.jsp");
        requestDispatcher.forward(req, resp);


    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Customer customer = customerService.findById(id);

        req.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateForm.jsp");
        requestDispatcher.forward(req, resp);


    }

    private void showAll(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = customerService.findAll();
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "":

                showAll(req, resp);
                break;

        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = customerService.findAll().size() + 1;
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        resp.sendRedirect("/customer");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        customerService.update(customer.getId(), customer);
        resp.sendRedirect("/customer");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        customerService.remove(id);

        resp.sendRedirect("/customer");
    }

}

