/**
 * 
 */
package org.aksw.sdw.meta_rdf.file.representations;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.function.Function;

import org.aksw.sdw.meta_rdf.RdfQuad;
import org.aksw.sdw.meta_rdf.file.metafile.MetaStatementsUnit;

/**
 * @author 
 *
 */
public abstract class AbstractRepresentationFormat {
	
	Function<String,String> keyConvert;
	Function<String,String> valueConvert;

	public abstract Collection<RdfQuad> getRepresenationForUnit(MetaStatementsUnit mu);
	public abstract Collection<RdfQuad> getDeduplicatedForUnit(MetaStatementsUnit mu);
	
	public AbstractRepresentationFormat(Function<String,String> keyConvert, Function<String,String> valueConvert) {
		this.keyConvert=keyConvert  ; this.valueConvert= valueConvert;	
	}
	
	public AbstractRepresentationFormat() {
		
		this.keyConvert = 
				(s) -> {
					if (s.startsWith("<") && s.endsWith(">"))
						return s;
					else 
					{
						 String k = null;
						 try {k =  URLEncoder.encode(s, "UTF-8");} catch (UnsupportedEncodingException e) {e.printStackTrace();}
						 return "http://sdw.aksw.org/metardf/Key#"+k;
					}
						
			
				} ;
		this.valueConvert = 
				(s) -> {
					if (s.startsWith("<") && s.endsWith(">"))
						return s;
					if (s.startsWith("\""))
						return s;
					else
						return s.replaceAll("\t", "\\t").replaceAll("\"", "\\\"").replaceAll("\n", "\\n").replaceAll("\r", "\\r");
		};
	}
	

}