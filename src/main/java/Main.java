import com.ssiiagency.DAO.AdminDaoImpl;
import com.ssiiagency.DAO.DAOInt;
import com.ssiiagency.config.AppConfig;
import com.ssiiagency.entities.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
