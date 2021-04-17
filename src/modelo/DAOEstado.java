package modelo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class DAOEstado {
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

    public List<estado> Listado(){
        Session session1 = factory.openSession();
        Criteria criter = session1.createCriteria(estado.class);
        //Transaction tr = null;
        List<estado> lista = null;
        try{
            //session1 = getSession().openSession();
            //tr = session1.beginTransaction();
            //tr.setTimeout(2);
            //lista = session1.createCriteria(alumno.class).list();
            lista = criter.list();
            for(estado estad: lista){
                System.out.print("  idEstado: "+estad.getIdEstado());
                System.out.print("  nombre: "+estad.getNombre());
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

    public DAOEstado(String dato){
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
