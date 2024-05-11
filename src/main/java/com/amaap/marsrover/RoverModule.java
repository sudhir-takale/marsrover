package com.amaap.marsrover;

import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.impl.InMemoryPlateauRepository;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.google.inject.AbstractModule;

public class RoverModule extends AbstractModule {

    @Override
    public void configure() {
        bind(RoverRepository.class).to(InMemoryRoverRepository.class);
        bind(PlateauRepository.class).to(InMemoryPlateauRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();

    }


}
