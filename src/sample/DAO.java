package sample;

/**
 * Created by JARVIS on 4/14/17.
 */
import java.util.*;

public interface DAO <T>{
    List<T> findAll();
    List<T> findByUserName();
    List<T> findByEmail();

    boolean insert(T u);
    boolean update(T u);
    boolean delete(T u);
}
