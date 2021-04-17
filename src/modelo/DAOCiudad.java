package modelo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class DAOCiudad {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    SessionFactory session;

    public SessionFactory getSession(){
        setSession();
        return  session;
    }

    public void setSession(){
        this.session = new Configuration().configure().buildSessionFactory();
    }

    public List<ciudad> Listado(){
        Session session1 = factory.openSession();
        Criteria criter = session1.createCriteria(ciudad.class);
        //Transaction tr = null;
        List<ciudad> lista = null;
        try{
            //session1 = getSession().openSession();
            //tr = session1.beginTransaction();
            //tr.setTimeout(2);
            //lista = session1.createCriteria(alumno.class).list();
            lista = criter.list();
            for(ciudad city: lista){
                System.out.print("  idCiudad: "+city.getIdCiudad());
                System.out.print("  nombre: "+city.getNombre());
                System.out.print("  Estado: "+city.getIdEstado());
                System.out.println("");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session1.isOpen()){
                session1.close();
            }
        }
        return lista;
    }

    public DAOCiudad(String dato){
        try{
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion." );
            configuration.configure(dato);
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


}
