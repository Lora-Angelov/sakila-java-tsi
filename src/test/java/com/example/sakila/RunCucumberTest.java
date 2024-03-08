package com.example.sakila;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"}
        //features = "src/test/resources/com.example.sakila/Cucumber"
)
public class RunCucumberTest {

}
