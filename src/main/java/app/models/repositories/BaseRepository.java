package app.models.repositories;

import app.models.entities.IEntidade;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseRepository<T extends IEntidade> {
    private final List<T> entidades;
    private Integer contador;

    public BaseRepository() {
        entidades = new ArrayList<>();
        contador = 0;
    }

    public List<T> getEntidades() {
        return entidades;
    }

    public T getEntidadeById(Integer id) {
        for (T e : entidades) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void add(T e) {
        if(e.getId() != null) {
            for (T entidade : entidades) {
                if (entidade.getId().equals(e.getId())) {
                    update(entidade, e);
                    break;
                }
            }
        } else {
            e.setId(contador);
            contador++;
            entidades.add(e);
        }
    }

    public void delete(Integer id) {
        for (T e : entidades) {
            if (e.getId().equals(id)) {
                entidades.remove(e);
                break;
            }
        }
    }

    public Integer getContador() {
        return contador;
    }

    private void update(T t, T e) {
        var c = t.getClass();
        Method method = null;
        try {
            method = c.getDeclaredMethod("update", e.getClass());
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        try {
            Objects.requireNonNull(method).invoke(t, e);
        } catch (IllegalAccessException | InvocationTargetException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }
}
