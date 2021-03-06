package org.aksw.sdw.meta_rdf.file.representations;

import java.util.List;
import java.util.function.Function;

import org.aksw.sdw.meta_rdf.MetaStatementsUnitView;
import org.aksw.sdw.meta_rdf.Options;
import org.aksw.sdw.meta_rdf.RdfQuad;

public class GraphRepresentation extends AbstractDedicatedIdRepresentation {
	
	public GraphRepresentation(Function<String,String> keyConvert, Function<String,String> valueConvert) {
		super(keyConvert,valueConvert);
	}
	public GraphRepresentation() {
		super();
	}
	public GraphRepresentation(Function<String, String> keyConvert, Function<String, String> valueConvert, Options options) {
		super(keyConvert, valueConvert, options);
	}
	public GraphRepresentation(Options options) {
		super(options);
	}
	
	@Override
	public String getFileExtension()
	{
		return "nq";
	}
	
	@Override
	protected void addRepresentationForRdfQuad(List<RdfQuad> quads, RdfQuad q, String stmtUri, MetaStatementsUnitView muv)
	{
		RdfQuad q2 = new RdfQuad(stmtUri,q); //add actual statement
		quads.add(q2);	
	}
	
	
}
