package com.amaap.marsrover;

import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.google.inject.AbstractModule;

public class RoverModule extends AbstractModule {

    @Override
    public void configure() {
        bind(RoverRepository.class).to(InMemoryRoverRepository.class);

    }


}
