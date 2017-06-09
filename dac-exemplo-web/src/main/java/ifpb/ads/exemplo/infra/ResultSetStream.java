package ifpb.ads.exemplo.infra;

import java.sql.ResultSet;
import java.util.Iterator;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 29/05/2017, 08:50:03
 */
public class ResultSetStream<T> implements Iterator<T>{

    private ResultSet result;
    

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
