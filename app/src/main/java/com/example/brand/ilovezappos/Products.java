package com.example.brand.ilovezappos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by brand on 2/8/2017.
 */

public class Products implements Serializable{

    @SerializedName("originalTerm")
    private String originalTerm;
    @SerializedName("currentResultCount")
    private int currentResultCount;
    @SerializedName("totalResultCount")
    private int totalResultCount;
    @SerializedName("term")
    private String term;
    @SerializedName("results")
    private List<Product> results;

    public Products(String originalTerm, int currentResultCount, int totalResultCount, String term, List<Product> results){
        this.originalTerm = originalTerm;
        this.currentResultCount = currentResultCount;
        this.totalResultCount = totalResultCount;
        this.term = term;
        this.results = results;
    }

    public String getOriginalTerm(){
        return originalTerm;
    }
    public void setOriginalTerm(String originalTerm){
        this.originalTerm = originalTerm;
    }
    public int getCurrentResultCount(){
        return currentResultCount;
    }
    public void setCurrentResultCount(int currentResultCount){
        this.currentResultCount = currentResultCount;
    }
    public int getTotalResultCount(){
        return totalResultCount;
    }
    public void setTotalResultCount(int totalResultCount){
        this.totalResultCount = totalResultCount;
    }
    public String getTerm(){
        return term;
    }
    public void setTerm(String term){
        this.term = term;
    }
    public List<Product> getResults(){
        return results;
    }
    public void setResults(List<Product> results){
        this.results = results;
    }
}
