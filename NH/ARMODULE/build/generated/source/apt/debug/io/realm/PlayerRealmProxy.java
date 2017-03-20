package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayerRealmProxy extends com.szb.ARMODULE.model.database.Player
    implements RealmObjectProxy, PlayerRealmProxyInterface {

    static final class PlayerColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long passwordIndex;
        public long genderIndex;
        public long achivementrateIndex;
        public long birthIndex;
        public long createtimeIndex;

        PlayerColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(6);
            this.idIndex = getValidColumnIndex(path, table, "Player", "id");
            indicesMap.put("id", this.idIndex);
            this.passwordIndex = getValidColumnIndex(path, table, "Player", "password");
            indicesMap.put("password", this.passwordIndex);
            this.genderIndex = getValidColumnIndex(path, table, "Player", "gender");
            indicesMap.put("gender", this.genderIndex);
            this.achivementrateIndex = getValidColumnIndex(path, table, "Player", "achivementrate");
            indicesMap.put("achivementrate", this.achivementrateIndex);
            this.birthIndex = getValidColumnIndex(path, table, "Player", "birth");
            indicesMap.put("birth", this.birthIndex);
            this.createtimeIndex = getValidColumnIndex(path, table, "Player", "createtime");
            indicesMap.put("createtime", this.createtimeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final PlayerColumnInfo otherInfo = (PlayerColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.passwordIndex = otherInfo.passwordIndex;
            this.genderIndex = otherInfo.genderIndex;
            this.achivementrateIndex = otherInfo.achivementrateIndex;
            this.birthIndex = otherInfo.birthIndex;
            this.createtimeIndex = otherInfo.createtimeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final PlayerColumnInfo clone() {
            return (PlayerColumnInfo) super.clone();
        }

    }
    private PlayerColumnInfo columnInfo;
    private ProxyState<com.szb.ARMODULE.model.database.Player> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("password");
        fieldNames.add("gender");
        fieldNames.add("achivementrate");
        fieldNames.add("birth");
        fieldNames.add("createtime");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PlayerRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PlayerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.szb.ARMODULE.model.database.Player>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordIndex);
    }

    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$gender() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genderIndex);
    }

    public void realmSet$gender(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genderIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genderIndex, value);
    }

    @SuppressWarnings("cast")
    public float realmGet$achivementrate() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.achivementrateIndex);
    }

    public void realmSet$achivementrate(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.achivementrateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.achivementrateIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$birth() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.birthIndex);
    }

    public void realmSet$birth(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.birthIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.birthIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.birthIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.birthIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$createtime() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.createtimeIndex);
    }

    public void realmSet$createtime(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.createtimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.createtimeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Player")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Player");
            realmObjectSchema.add(new Property("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("gender", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("achivementrate", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("birth", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("createtime", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Player");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Player")) {
            Table table = sharedRealm.getTable("class_Player");
            table.addColumn(RealmFieldType.STRING, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "password", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "gender", Table.NULLABLE);
            table.addColumn(RealmFieldType.FLOAT, "achivementrate", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "birth", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "createtime", Table.NOT_NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_Player");
    }

    public static PlayerColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Player")) {
            Table table = sharedRealm.getTable("class_Player");
            final long columnCount = table.getColumnCount();
            if (columnCount != 6) {
                if (columnCount < 6) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final PlayerColumnInfo columnInfo = new PlayerColumnInfo(sharedRealm.getPath(), table);

            if (table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
            }

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' is required. Either set @Required to field 'id' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("password")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'password' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("password") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'password' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.passwordIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'password' is required. Either set @Required to field 'password' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("gender")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gender' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("gender") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gender' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.genderIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gender' is required. Either set @Required to field 'gender' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("achivementrate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'achivementrate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("achivementrate") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'achivementrate' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.achivementrateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'achivementrate' does support null values in the existing Realm file. Use corresponding boxed type for field 'achivementrate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("birth")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'birth' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("birth") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'birth' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.birthIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'birth' is required. Either set @Required to field 'birth' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("createtime")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'createtime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("createtime") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'createtime' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.createtimeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'createtime' does support null values in the existing Realm file. Use corresponding boxed type for field 'createtime' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Player' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Player";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.szb.ARMODULE.model.database.Player createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.szb.ARMODULE.model.database.Player obj = realm.createObjectInternal(com.szb.ARMODULE.model.database.Player.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((PlayerRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((PlayerRealmProxyInterface) obj).realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                ((PlayerRealmProxyInterface) obj).realmSet$password(null);
            } else {
                ((PlayerRealmProxyInterface) obj).realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("gender")) {
            if (json.isNull("gender")) {
                ((PlayerRealmProxyInterface) obj).realmSet$gender(null);
            } else {
                ((PlayerRealmProxyInterface) obj).realmSet$gender((String) json.getString("gender"));
            }
        }
        if (json.has("achivementrate")) {
            if (json.isNull("achivementrate")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'achivementrate' to null.");
            } else {
                ((PlayerRealmProxyInterface) obj).realmSet$achivementrate((float) json.getDouble("achivementrate"));
            }
        }
        if (json.has("birth")) {
            if (json.isNull("birth")) {
                ((PlayerRealmProxyInterface) obj).realmSet$birth(null);
            } else {
                ((PlayerRealmProxyInterface) obj).realmSet$birth((String) json.getString("birth"));
            }
        }
        if (json.has("createtime")) {
            if (json.isNull("createtime")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'createtime' to null.");
            } else {
                ((PlayerRealmProxyInterface) obj).realmSet$createtime((int) json.getInt("createtime"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.szb.ARMODULE.model.database.Player createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.szb.ARMODULE.model.database.Player obj = new com.szb.ARMODULE.model.database.Player();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PlayerRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((PlayerRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
            } else if (name.equals("password")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PlayerRealmProxyInterface) obj).realmSet$password(null);
                } else {
                    ((PlayerRealmProxyInterface) obj).realmSet$password((String) reader.nextString());
                }
            } else if (name.equals("gender")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PlayerRealmProxyInterface) obj).realmSet$gender(null);
                } else {
                    ((PlayerRealmProxyInterface) obj).realmSet$gender((String) reader.nextString());
                }
            } else if (name.equals("achivementrate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'achivementrate' to null.");
                } else {
                    ((PlayerRealmProxyInterface) obj).realmSet$achivementrate((float) reader.nextDouble());
                }
            } else if (name.equals("birth")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PlayerRealmProxyInterface) obj).realmSet$birth(null);
                } else {
                    ((PlayerRealmProxyInterface) obj).realmSet$birth((String) reader.nextString());
                }
            } else if (name.equals("createtime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'createtime' to null.");
                } else {
                    ((PlayerRealmProxyInterface) obj).realmSet$createtime((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.szb.ARMODULE.model.database.Player copyOrUpdate(Realm realm, com.szb.ARMODULE.model.database.Player object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.szb.ARMODULE.model.database.Player) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.szb.ARMODULE.model.database.Player copy(Realm realm, com.szb.ARMODULE.model.database.Player newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.szb.ARMODULE.model.database.Player) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.szb.ARMODULE.model.database.Player realmObject = realm.createObjectInternal(com.szb.ARMODULE.model.database.Player.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PlayerRealmProxyInterface) realmObject).realmSet$id(((PlayerRealmProxyInterface) newObject).realmGet$id());
            ((PlayerRealmProxyInterface) realmObject).realmSet$password(((PlayerRealmProxyInterface) newObject).realmGet$password());
            ((PlayerRealmProxyInterface) realmObject).realmSet$gender(((PlayerRealmProxyInterface) newObject).realmGet$gender());
            ((PlayerRealmProxyInterface) realmObject).realmSet$achivementrate(((PlayerRealmProxyInterface) newObject).realmGet$achivementrate());
            ((PlayerRealmProxyInterface) realmObject).realmSet$birth(((PlayerRealmProxyInterface) newObject).realmGet$birth());
            ((PlayerRealmProxyInterface) realmObject).realmSet$createtime(((PlayerRealmProxyInterface) newObject).realmGet$createtime());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.szb.ARMODULE.model.database.Player object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.szb.ARMODULE.model.database.Player.class);
        long tableNativePtr = table.getNativeTablePointer();
        PlayerColumnInfo columnInfo = (PlayerColumnInfo) realm.schema.getColumnInfo(com.szb.ARMODULE.model.database.Player.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$id = ((PlayerRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$password = ((PlayerRealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        String realmGet$gender = ((PlayerRealmProxyInterface)object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.achivementrateIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$achivementrate(), false);
        String realmGet$birth = ((PlayerRealmProxyInterface)object).realmGet$birth();
        if (realmGet$birth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthIndex, rowIndex, realmGet$birth, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.createtimeIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$createtime(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.szb.ARMODULE.model.database.Player.class);
        long tableNativePtr = table.getNativeTablePointer();
        PlayerColumnInfo columnInfo = (PlayerColumnInfo) realm.schema.getColumnInfo(com.szb.ARMODULE.model.database.Player.class);
        com.szb.ARMODULE.model.database.Player object = null;
        while (objects.hasNext()) {
            object = (com.szb.ARMODULE.model.database.Player) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$id = ((PlayerRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                }
                String realmGet$password = ((PlayerRealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                }
                String realmGet$gender = ((PlayerRealmProxyInterface)object).realmGet$gender();
                if (realmGet$gender != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.achivementrateIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$achivementrate(), false);
                String realmGet$birth = ((PlayerRealmProxyInterface)object).realmGet$birth();
                if (realmGet$birth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.birthIndex, rowIndex, realmGet$birth, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.createtimeIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$createtime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.szb.ARMODULE.model.database.Player object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.szb.ARMODULE.model.database.Player.class);
        long tableNativePtr = table.getNativeTablePointer();
        PlayerColumnInfo columnInfo = (PlayerColumnInfo) realm.schema.getColumnInfo(com.szb.ARMODULE.model.database.Player.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$id = ((PlayerRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$password = ((PlayerRealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        String realmGet$gender = ((PlayerRealmProxyInterface)object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.achivementrateIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$achivementrate(), false);
        String realmGet$birth = ((PlayerRealmProxyInterface)object).realmGet$birth();
        if (realmGet$birth != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthIndex, rowIndex, realmGet$birth, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.birthIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.createtimeIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$createtime(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.szb.ARMODULE.model.database.Player.class);
        long tableNativePtr = table.getNativeTablePointer();
        PlayerColumnInfo columnInfo = (PlayerColumnInfo) realm.schema.getColumnInfo(com.szb.ARMODULE.model.database.Player.class);
        com.szb.ARMODULE.model.database.Player object = null;
        while (objects.hasNext()) {
            object = (com.szb.ARMODULE.model.database.Player) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$id = ((PlayerRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$password = ((PlayerRealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
                }
                String realmGet$gender = ((PlayerRealmProxyInterface)object).realmGet$gender();
                if (realmGet$gender != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.achivementrateIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$achivementrate(), false);
                String realmGet$birth = ((PlayerRealmProxyInterface)object).realmGet$birth();
                if (realmGet$birth != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.birthIndex, rowIndex, realmGet$birth, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.birthIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.createtimeIndex, rowIndex, ((PlayerRealmProxyInterface)object).realmGet$createtime(), false);
            }
        }
    }

    public static com.szb.ARMODULE.model.database.Player createDetachedCopy(com.szb.ARMODULE.model.database.Player realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.szb.ARMODULE.model.database.Player unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.szb.ARMODULE.model.database.Player)cachedObject.object;
            } else {
                unmanagedObject = (com.szb.ARMODULE.model.database.Player)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.szb.ARMODULE.model.database.Player();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PlayerRealmProxyInterface) unmanagedObject).realmSet$id(((PlayerRealmProxyInterface) realmObject).realmGet$id());
        ((PlayerRealmProxyInterface) unmanagedObject).realmSet$password(((PlayerRealmProxyInterface) realmObject).realmGet$password());
        ((PlayerRealmProxyInterface) unmanagedObject).realmSet$gender(((PlayerRealmProxyInterface) realmObject).realmGet$gender());
        ((PlayerRealmProxyInterface) unmanagedObject).realmSet$achivementrate(((PlayerRealmProxyInterface) realmObject).realmGet$achivementrate());
        ((PlayerRealmProxyInterface) unmanagedObject).realmSet$birth(((PlayerRealmProxyInterface) realmObject).realmGet$birth());
        ((PlayerRealmProxyInterface) unmanagedObject).realmSet$createtime(((PlayerRealmProxyInterface) realmObject).realmGet$createtime());
        return unmanagedObject;
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRealmProxy aPlayer = (PlayerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPlayer.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPlayer.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPlayer.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
