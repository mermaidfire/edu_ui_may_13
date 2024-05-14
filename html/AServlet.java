package co.eduereka.html5;
import java.io.IOException;

@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer=null;
        while(true) {
            try {
                double random=Math.random()*10000 
                writer = response.getWriter();
                writer.print("data: "+" next update from server will come in "+Math.round(random/1000)+" seconds\n");
                writer.print("data: "+" time: "+Calendar.getInstance().getTime()+"\n\n");
                response.flushBuffer();
                Thread.sleep((long)random);
            }catch (Exception exp) {
                
                writer.close();
                break;
                }
               }
        }
   
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
