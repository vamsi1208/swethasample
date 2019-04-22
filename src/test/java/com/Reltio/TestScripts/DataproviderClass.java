package com.Reltio.TestScripts;


import org.testng.annotations.DataProvider;
public class DataproviderClass {
        @DataProvider(name="SearchProvider")
        public static Object[][] getDataFromDataprovider(){
            return new Object[][] {
            	{"HCO","count.greater.or.equals","1","Test1"},
            	{"HCO","count.less.or.equals","2","Test2"},
            	{"GPO","count.greater","0","Test3"}
            };  
}}

/*
 {"entityType", "HCO"},
 
{"countParamter","count.greater.or.equals"},
{"countValue", "1"},
{"saveName","ProviderSave"}

*/