package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer implements Serializable {
    // fields
    private final int id;
    private final String name;
    private final Collection<Reward> rewards = new ArrayList<>();

    // constructors
    public DuckRacer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // business / action methods
    public void win(Reward reward) {
        rewards.add(reward);
    }


    // getters / setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    // a derived property - from size of collection
    public int getWins() {
        return rewards.size();
    }
    // note: we are returning a read only view to our internal rewards collection
    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    // toString()
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": id=" + getId() +
                ", name='" + getName() + '\'' +
                ", wins=" + getWins() +
                ", rewards=" + getRewards();
    }
}