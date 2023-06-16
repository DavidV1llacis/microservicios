/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package microservicio;

import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.Item;


public class ServicioCatalogo extends HttpServlet {
    
    @PersistenceUnit(unitName="ItemUnit")
    private EntityManagerFactory factory;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * Array para almacenar los items
         */
        
        List<Item> Lista = new ArrayList<Item>();
        Gson gson = new Gson();
        
        /**
         * Recibir los parametros
         */
        
        String codigo = request.getParameter("codigo");
        
        /**
         * Obtener de la Base de datos
         */
        if(codigo!=null){
            
            EntityManager manager = factory.createEntityManager();
            try{
                Item item = manager.find(Item.class, codigo);
                Lista.add(item);
                System.out.println("Codigo encontrado: "+ Lista.get(0).getCodigo());

            }catch (Exception e){
                e.printStackTrace();

            }finally{
                manager.close();
            }
        }
        else{
            EntityManager manager = factory.createEntityManager();
            try{
                List<Object[]> tmp = manager.createNativeQuery("SELECT * FROM items").getResultList(); 
                for(int i=0;i<tmp.size();i++){
                    Lista.add( new Item());
                }
                
                for(int i=0;i<Lista.size();i++){
                    Lista.get(i).setCodigo((String)tmp.get(i)[0]);
                    Lista.get(i).setNombre((String)tmp.get(i)[1]);
                    Lista.get(i).setPrecio((BigDecimal)tmp.get(i)[2]);
                    Lista.get(i).setURL((String)tmp.get(i)[3]);
                    Lista.get(i).setS((Integer)tmp.get(i)[4]);
                    Lista.get(i).setM((Integer)tmp.get(i)[5]);
                    Lista.get(i).setL((Integer)tmp.get(i)[6]);
                }
                
            }catch (Exception e){
                e.printStackTrace();

            }finally{
                manager.close();
            }
        }
        
        /**
         * Enviar respuesta
         */
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Gson gson = new Gson();
            
            String respuesta="{ \"Catalogo\": {";
            
            for(int i=0;i<Lista.size();i++){
                respuesta += String.format("\"Item%s\":",i+1);
                respuesta += String.valueOf(gson.toJson(Lista.get(i)));
                respuesta+="";
                if(i+1!=Lista.size()){
                    respuesta+=",";
                }
            }
            
            respuesta+="}}";
            
            System.out.println(respuesta);
            out.println(respuesta);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
