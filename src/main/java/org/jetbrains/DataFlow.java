package org.jetbrains;

import java.io.File;

public class DataFlow {
    public Object processData(String id) {
        doSomething(id);
        return id;
    }

    private void doSomething(String s) {
        doSomethingElse(s);
    }

    private void doSomethingElse(String id) {
        doOneMoreThing(id);
    }

    private void doOneMoreThing(String xxxx) {
        if (xxxx.length() > 2) {
            oneThing(xxxx);
        } else {
            orAnother(xxxx);
        }
    }

    private void orAnother(String id) {
        doSomethingElseAgainForNewRequirements(id);
    }

    private void doSomethingElseAgainForNewRequirements(String name) {
        System.out.println("name = " + name);
        logSomethingWithId(name);
    }

    private void logSomethingWithId(String idx) {
        System.out.println("id = [" + idx + "]");
    }

    private void oneThing(String id) {
        //region some region
        getSomethingFromTheDatabase(id);
        storeResultsInDataBase(id);
        //endregion
    }

    private void getSomethingFromTheDatabase(String id) {
        //language=SQL
        String sql = "select * from MESSAGES where TEXT like '%b%'";
    }

    private void storeResultsInDataBase(String id) {
        System.out.println("Storing " + id + " in the database");
    }
}
