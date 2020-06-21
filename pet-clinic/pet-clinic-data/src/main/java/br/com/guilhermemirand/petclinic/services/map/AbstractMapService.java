package br.com.guilhermemirand.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    T save(ID id, T object) {
        return this.map.put(id, object);
    }

    T findById(ID id) {
        return this.map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(this.map.values());
    }

    T deleteById(ID id) {
        return this.map.remove(id);
    }

    boolean delete(T object) {
        return this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
