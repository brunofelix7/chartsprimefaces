package br.unipe.chartsprimefaces.bean;

import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;

@Model
@ManagedBean(name = "helloBean")
public class HelloBean{

   private String name;
   private String label;

   public void action(String value){
      System.out.println("Click and get: " + value);
      label = "Hello " + name;
   }

   public String getLabel(){
      return label;
   }

   public String getName(){
      return name;
   }

   public void setName(String name){
      this.name = name;
   }
}