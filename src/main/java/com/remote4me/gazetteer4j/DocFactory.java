package com.remote4me.gazetteer4j;

import org.apache.lucene.document.Document;

import java.io.IOException;
import java.util.Map;

/**
 * Factory methods to create Location from Lucene Document(from Lucene index),
 * to create Lucene Document from Geoname file (when building index)
 */
public interface DocFactory {

    /**
     * @param source a Lucene document (usually from Lucene index)
     * @return new Location instance created from source; never null
     */
    Location createFromLuceneDocument(Document source);

    /**
     * @param lineFromFile each element - a column in a line from Geonames file
     * @param idToAlternateMap
     * @param adm1ToIdMap
     * @param countryToIdMap @return new Lucene Document instance created from lineFromFile; never null
     * @throws IOException when something went wrong
     */
    Document createFromLineInGeonamesFile(
            String[] lineFromFile,
            Map<Integer, AlternateNameRecord> idToAlternateMap,
            Map<String, Location> adm1ToIdMap,
            Map<String, Location> countryToIdMap) throws IOException;

}
