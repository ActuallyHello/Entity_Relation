package Repository;

import java.util.ArrayList;

public interface Repos<T> {

    ArrayList<T> getAll();
    T getByKey(String key, String where);
    void add_node(T node);
    void delete_node(String key);
    void update(String key, T new_node);
    Integer max_id();

}
