package br.com.guilhermemirand.petclinic.services.map;

import br.com.guilhermemirand.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    T save(T object) {
        if (object == null) {
            return null;
        } else if (object.getId() == null) {
            object.setId(this.getNextId());
        }
        this.map.put(object.getId(), object);
        return object;
    }

    T findById(ID id) {
        return this.map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(this.map.values());
    }

    void deleteById(ID id) {
        this.map.remove(id);
    }

    void delete(T object) {
        this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        return this.map.isEmpty() ? 1l : Collections.max(this.map.keySet()) + 1;
    }
}
