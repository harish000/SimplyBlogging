package com.mongodb.MongoDB101;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                App.class, "/");
        System.out.println( "Hello Moon!" );
        Spark.get(new Route("/Mongo") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
				// TODO Auto-generated method stub
				StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");

                    Map<String, String> answerMap = new HashMap<String, String>();
                    answerMap.put("name", "Something else");

                    helloTemplate.process(answerMap, writer);
                } catch (Exception e) {
                    halt(500);
                }
                return writer;
			}
		});
    }
}
