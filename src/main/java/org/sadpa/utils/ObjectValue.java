package org.sadpa.utils;

import java.util.HashMap;
import java.util.Map;

public class ObjectValue {
	 
	  private final Map<String,Object> values = new HashMap<>();
	 
	  public void put( String key, Object value ) {
	    values.put( key, value );
	  }
	 
	  public Object get( String key ) {
	    return values.get( key );
	  }
}
