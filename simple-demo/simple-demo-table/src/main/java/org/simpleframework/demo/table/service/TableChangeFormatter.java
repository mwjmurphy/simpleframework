package org.simpleframework.demo.table.service;

import java.util.List;

import org.simpleframework.demo.table.extract.RowChange;
import org.simpleframework.demo.table.schema.TableSchema;

public class TableChangeFormatter {

   private final RowChangeFormatter formatter;
   private final TableSchema schema;
   
   public TableChangeFormatter(TableSchema schema) {
      this.formatter = new RowChangeFormatter(schema);
      this.schema = schema;
   }

   public String formatChanges(List<RowChange> changes, long sequence) {
      long time = System.currentTimeMillis();
      String table = schema.getTable();
      
      if(!changes.isEmpty()) {
         StringBuilder builder = new StringBuilder();
         
         builder.append(ChangeType.TABLE.code);
         builder.append(sequence);
         builder.append("@");
         builder.append(time);
         builder.append(":");       
         builder.append(table);
         
         for(RowChange change : changes) {
            String text = formatter.formatChange(change);            
            
            if(text != null) {
               int count = builder.length();
               
               if(count > 0) {
                  builder.append("|");
               }
               builder.append(text);
            }
         }
         return builder.toString();
      }
      return null;
   }
}