package sim.rest.SWS;

import java.util.List;

import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;


public class DBpediaService {

	private static QueryExecutor queryExecutor = new QueryExecutor();
	private static final String DBPEDIA_SPARQL_ENDPOINT = "http://dbpedia.org/sparql";
	
	
	public static List<String> getListOfPublishedBooks(String name){
		String query =					
"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX foaf: <http://xmlns.com/foaf/0.1/> PREFIX onto: <http://dbpedia.org/ontology/> SELECT ?string WHERE { ?uri rdf:type onto:Book . ?uri onto:author ?author .?author foaf:name '"+name+"'@en .OPTIONAL {?uri rdfs:label ?string . FILTER (lang(?string) = 'en') }}";
		
		return queryExecutor.executeSelectQueryOverSparqlEndpoint(query, "string", DBPEDIA_SPARQL_ENDPOINT);

	}

	public static List<String> getAbstract(String name){
	
		String query =
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> PREFIX foaf: <http://xmlns.com/foaf/0.1/> PREFIX dbo: <http://dbpedia.org/ontology/> PREFIX rdf: <"+Constants.RDF+"> PREFIX dbpedia: <http://dbpedia.org/resource/> SELECT ?abstract WHERE {?s dbo:abstract ?abstract . ?s foaf:name ?name .?s rdf:type dbo:Person .FILTER ( regex(str(?name), \""+name+"\") && lang(?abstract) = 'en')}";
		return queryExecutor.executeSelectQueryOverSparqlEndpoint(query, "abstract",DBPEDIA_SPARQL_ENDPOINT);
		
	}
	public static List<String> getThumbnil(String name){
		
		String query =
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> PREFIX foaf: <http://xmlns.com/foaf/0.1/> PREFIX dbo: <http://dbpedia.org/ontology/> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX dbpedia: <http://dbpedia.org/resource/> SELECT ?thumbnail WHERE {?s dbo:thumbnail ?thumbnail .?s foaf:name ?name .?s rdf:type dbo:Person .FILTER  regex(str(?name), '"+name+"')}";
		return queryExecutor.executeSelectQueryOverSparqlEndpoint(query, "thumbnail",DBPEDIA_SPARQL_ENDPOINT);
		
	}

public static List<String> getMoviesStarred(String name){
	String query = 
	"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> PREFIX foaf: <http://xmlns.com/foaf/0.1/> PREFIX dbo: <http://dbpedia.org/ontology/> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX dbpedia: <http://dbpedia.org/resource/> SELECT ?starred WHERE {?s rdf:type dbo:Film .?s foaf:name ?starred .?s dbo:starring ?starring .?starring foaf:name ?name .FILTER  regex(str(?name), '"+name+"')}";
	return queryExecutor.executeSelectQueryOverSparqlEndpoint(query, "starred",DBPEDIA_SPARQL_ENDPOINT);
	
}
public static List<String> getMoviesDirected(String name){
	String query = 
	"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> PREFIX foaf: <http://xmlns.com/foaf/0.1/> PREFIX dbo: <http://dbpedia.org/ontology/> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> PREFIX dbpedia: <http://dbpedia.org/resource/> SELECT ?starred WHERE {?s rdf:type dbo:Film .?s foaf:name ?starred .?s dbo:producer ?producer .?producer foaf:name ?name .FILTER  regex(str(?name), '"+name+"')}";
	return queryExecutor.executeSelectQueryOverSparqlEndpoint(query, "starred",DBPEDIA_SPARQL_ENDPOINT);
	
}
}
	
