package br.com.adriana.nogueira.util;

import br.com.adriana.nogueira.services.PetService;

import br.com.adriana.nogueira.services.PetStoreService;
import com.google.inject.AbstractModule;


    public class PetModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(PetService.class);
            bind(PetStoreService.class);

        }
    }