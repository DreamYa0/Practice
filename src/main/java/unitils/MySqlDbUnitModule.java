package unitils;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.unitils.dbunit.DbUnitModule;
import org.unitils.dbunit.util.DbUnitDatabaseConnection;

/**
 * Created by dreamyao on 2017/5/26.
 */
public class MySqlDbUnitModule extends DbUnitModule{

    @Override
    public DbUnitDatabaseConnection getDbUnitDatabaseConnection(
            final String schemaName) {
        DbUnitDatabaseConnection result = dbUnitDatabaseConnections
                .get(schemaName);
        if (null != result) {
            return result;
        }
        result = super.getDbUnitDatabaseConnection(schemaName);
        result.getConfig().setProperty(
                DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
                new MySqlDataTypeFactory());
        result.getConfig().setProperty(
                DatabaseConfig.PROPERTY_METADATA_HANDLER,
                new MySqlMetadataHandler());
        return result;
    }

}
