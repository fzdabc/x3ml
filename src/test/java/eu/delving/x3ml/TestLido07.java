package eu.delving.x3ml;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static eu.delving.x3ml.AllTests.document;
import static eu.delving.x3ml.AllTests.engine;
import static eu.delving.x3ml.AllTests.policy;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author Gerald de Jong <gerald@delving.eu>
 */

public class TestLido07 {
    private final Logger log = Logger.getLogger(getClass());
    private Queue<String> uuidQueue = new LinkedBlockingQueue<String>();

    private void log(String title, String[] list) {
        log.info(title);
        for (String line : list) {
            log.info(line);
        }
    }

    @Test
    public void testSimpleCoinExample() throws X3MLException {
        uuidQueue.add("uuid:A");
        uuidQueue.add("uuid:B");
        X3MLEngine engine = engine("/lido07/lido07.x3ml");
        X3MLContext context = engine.execute(
                document("/lido07/lido07.xml"),
                policy("/lido07/lido07-value-policy.xml")
        );
        context.write(System.out);
//        String [] mappingResult = context.toStringArray();
//        String [] expectedResult = AllTests.xmlToNTriples("/coin/coin1-rdf.xml");
//        log("result", mappingResult);
//        log("expected", expectedResult);
//        assertArrayEquals("Does not match expected", expectedResult, mappingResult);
    }


}