package org.simpleframework.demo.table.schema;

import java.io.File;

public class FragmentColumnStyle implements ColumnStyle {

   private final Fragment fragment;
   private final String style;
   private final String caption;
   private final String name;
   private final boolean sortable;
   private final boolean resizable;

   public FragmentColumnStyle(String name, File fragment) {
      this(name, fragment, null);
   }
   
   public FragmentColumnStyle(String name, File fragment, String style) {
      this(name, fragment, style, name);
   }
   
   public FragmentColumnStyle(String name, File fragment, String style, String caption) {
      this(name, fragment, style, caption, true, false);
   }
   
   public FragmentColumnStyle(String name, File fragment, String style, String caption, boolean resizable, boolean sortable) {
      this.fragment = new Fragment(fragment);
      this.resizable = resizable;
      this.sortable = sortable;
      this.caption = caption;  
      this.style = style;
      this.name = name;
   }
   
   @Override
   public String getName() {
      return name;
   }   
   
   @Override
   public String getStyle() {
      return style;
   }
   
   @Override
   public String getTemplate() {
      return fragment.getFragment();
   }
   
   @Override
   public String getTitle() {
      return caption;
   }
   
   @Override
   public boolean isResizable() {
      return resizable;
   }
   
   @Override
   public boolean isSortable() {
      return sortable;
   }
   
   @Override
   public boolean isHidden() {
      return false;
   }
}