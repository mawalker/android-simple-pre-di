package com.example.testsimplepredi.first.samplerepo;

import org.jetbrains.annotations.TestOnly;

public class ClassUsingSampleRepo {

    private final SampleRepo repo;

    public ClassUsingSampleRepo(){
        repo = new SampleRepo.Builder().build();
    }

    @TestOnly
    public ClassUsingSampleRepo(SampleRepo testingRepo){
        repo = testingRepo;
    }

    public String getConfig(){
        return repo.getConfig();
    }
}
