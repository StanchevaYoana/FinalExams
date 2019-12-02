package viceCity.repositories;


import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.*;


public class GunRepository<T> implements Repository<T> {
    private List<T> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection <T> getModels() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(T model) {
        if (!this.models.contains(model)) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }

    @Override
    public T find(String name) {
        for (T model : models) {
            Gun gun = (Gun) model;
             if(gun.getName().equals(name)){
                 return (T) gun;
             }
            
        }
        return null;
    }
}
