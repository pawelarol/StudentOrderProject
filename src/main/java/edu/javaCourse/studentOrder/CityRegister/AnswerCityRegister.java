package edu.javaCourse.studentOrder.CityRegister;

import java.util.ArrayList;
import java.util.List;

public class AnswerCityRegister {
   private List<CityRegisterItem> items;

   public void addItem(CityRegisterItem item){
      if(items == null){
         items = new ArrayList<>(10);
      }
      items.add(item);
   }



   public List<CityRegisterItem> getItems() {
      return items;
   }
}
