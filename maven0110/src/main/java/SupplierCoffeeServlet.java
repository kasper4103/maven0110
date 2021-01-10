

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import java.util.*;
/**
 * Servlet implementation class SupplierCoffeeServlet
 */
@WebServlet("/SupplierCoffeeServlet")
public class SupplierCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierCoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maven0110");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Supplier sp = new Supplier();
          
        sp.setCity("Taipei");
        sp.setSupName("Gjun");
        sp.setState("TW");
        sp.setStreet("Kung Yuan Road");
        sp.setZip("101");
        sp.setSupId(1);
        
        Coffee c1=new Coffee();
        c1.setCofName("Flavor A");
        c1.setPrice(200.0);
        c1.setSales(10);
        c1.setTotal(5);
        c1.setSupplier(sp);

        Coffee c2=new Coffee();
        c2.setCofName("Flavor B");
        c2.setPrice(100.0);
        c2.setSales(11);
        c2.setTotal(6);
        c2.setSupplier(sp);

        em.persist(c1);
        em.persist(c2);

        ArrayList<Coffee> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        sp.setCoffees(list);          
        em.persist(sp);

        em.getTransaction().commit();
        em.close();
        emf.close();

		response.getWriter().append("Supplier Coffees Saved  ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
