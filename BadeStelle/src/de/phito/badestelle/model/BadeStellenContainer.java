package de.phito.badestelle.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;

import de.phito.badestelle.jsonparser.JSONDefinitions.BadeStellenJSON;
import de.phito.badestelle.jsonparser.JSONDefinitions.BadeStellenJSONContainer;
import android.content.Context;
import android.content.res.AssetManager;

// TODO: Auto-generated Javadoc
/**
 * The Class BadeStellenContainer.
 */
public class BadeStellenContainer {
	
	/** The logger. */
	Logger logger = Logger.getLogger(BadeStellenContainer.class.getSimpleName());
	
	/** The badestellen. */
	private List<BadeStelle> badestellen;
	
	/** The Constant BADESTELLEN_JSON. */
	private static final String BADESTELLEN_JSON = "Badewasser_utf8.json";
	
	/**
	 * Instantiates a new bade stellen container.
	 */
	private BadeStellenContainer(){
	}

	/** The instance. */
	private static BadeStellenContainer instance;
	
	/**
	 * Gets the single instance of BadeStellenContainer.
	 *
	 * @return single instance of BadeStellenContainer
	 */
	public static BadeStellenContainer getInstance(){
		if(instance == null){
			instance = new BadeStellenContainer();
		}
		return instance;
		
	}
	
	/**
	 * Read file.
	 *
	 * @param context the context
	 * @param filename the filename
	 * @return the string builder
	 */
	private StringBuilder readFile(Context context, String filename){
		logger.info("loading json file...");
		StringBuilder stringBuilder = new StringBuilder();
	    InputStream inputStream = null;
	    InputStreamReader inputStreamReader = null;
	    BufferedReader input = null;
	    try {
	    	AssetManager assets = context.getResources().getAssets(); 
	        inputStream = assets.open(filename, Context.MODE_WORLD_READABLE);
	        inputStreamReader = new InputStreamReader(inputStream);
	        input = new BufferedReader(inputStreamReader);
	        String line = "";
	        while ((line = input.readLine()) != null) {
	            stringBuilder.append(line);
	        }
	    } catch (Exception e) {
	    	logger.severe("Error loading JSON!");
	    	logger.severe(e.getMessage());
	    } finally {
	        try {
	            if (inputStreamReader != null)
	                inputStreamReader.close();
	            if (inputStream != null)
	                inputStream.close();
	            if (input != null)
	                input.close();
	        } catch (Exception e2) {
	            logger.severe("Error closing file handlers!");
		    	logger.severe(e2.getMessage());
	        }
	    }
	    logger.info("json successfully loaded!");
	    return stringBuilder;
	}
	
	/**
	 * Load bade stellen json.
	 *
	 * @param context the context
	 */
	public void loadBadeStellenJSON(Context context){
		if(this.badestellen == null){
			badestellen = new ArrayList<BadeStelle>();	
			StringBuilder sb = readFile(context, BADESTELLEN_JSON);
		    logger.info("parsing...");
		    parseFile(sb);
		}
	}
	
	/**
	 * Gets the bade stelle by id.
	 *
	 * @param id the id
	 * @return the bade stelle by id
	 */
	public BadeStelle getBadeStelleById(int id){
		for(BadeStelle bs: this.badestellen){
			if(bs.id == id){
				return bs;
			}
		}
		return null;
	}

	/**
	 * Parses the file.
	 *
	 * @param sb the sb
	 */
	private void parseFile(StringBuilder sb) {
		Gson gson = new Gson();
		BadeStellenJSONContainer badeStellenJson = gson.fromJson(sb.toString(), BadeStellenJSONContainer.class);
		for(BadeStellenJSON listElem: badeStellenJson.index){
			this.badestellen.add(new BadeStelle(listElem));
		}
	}
	
	/**
	 * Gets the badestellen.
	 *
	 * @return the badestellen
	 */
	public List<BadeStelle> getBadestellen() {
		return badestellen;
	}
}
