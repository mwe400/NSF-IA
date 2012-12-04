package org.sci.historycrawl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;

public class urltrim extends EvalFunc<String>
{
	
  public String exec(Tuple input){
  	if (input == null || input.size() == 0)
          return null;
  	 try{
     	Pattern urlPattern = Pattern.compile("(.*://)([^:^/]*)(:\\d*)?(.*)?");	//".*//(.*?)/"	
         Matcher urlMatcher = urlPattern.matcher((String)input.get(0));
     	if(urlMatcher.find())
     		return urlMatcher.group(2);
     }catch(Exception e){
         System.out.println(e.getStackTrace());
     }
		return null;
  }
}
