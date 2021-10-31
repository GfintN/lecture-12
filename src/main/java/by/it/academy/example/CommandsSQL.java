package by.it.academy.example;

public class CommandsSQL {
    private static String update;
    private static String insert;
    private static String delete;
    private static String select;
    private static String join;
    private static StringBuffer stringBuffer;

    public static String getUpdate() {
        return update;
    }

    public static void setUpdate(String selectTable, String selectColumnAndValue) {
        stringBuffer = null;
        stringBuffer.append("UPDATE ").append(selectTable).append(" SET ").append(selectColumnAndValue)
                .append(";");
        CommandsSQL.update = String.valueOf(stringBuffer);
    }

    public static String getInsert() {
        return insert;
    }

    public static void setInsert(String selectTable, String selectColumnAndValue) {
        stringBuffer = null;
        stringBuffer.append("INSERT INTO ").append(selectTable).append(" VALUES ").append(selectColumnAndValue)
                .append(";");
        CommandsSQL.insert = String.valueOf(stringBuffer);
    }

    public static String getDelete() {
        return delete;
    }

    public static void setDelete(String selectTable, String selectColumnAndValue) {
        stringBuffer = null;
        stringBuffer.append("DELETE FROM ").append(selectTable).append(" WHERE ").append(selectColumnAndValue)
                .append(";");
        CommandsSQL.delete = String.valueOf(stringBuffer);
    }

    public static String getSelect() {
        return select;
    }

    public static void setSelect(String selectTable, String selectColumn) {
        stringBuffer = null;
        stringBuffer.append("SELECT ").append(selectColumn).append(" FROM ").append(selectTable).append(";");
        CommandsSQL.select = String.valueOf(stringBuffer);
    }

    public static String getJoin() {
        return join;
    }

    public static void setJoin(String selectTableOne, String selectTableTwo,
                               String columnTableOne, String columnTableTwo) {
        stringBuffer = null;
        stringBuffer.append("SELECT * FROM ").append(selectTableOne).append(" JOIN ").append(selectTableTwo)
                .append(" ON ").append(columnTableOne).append(" = ").append(columnTableTwo).append(";");
        CommandsSQL.join = String.valueOf(stringBuffer);
    }
}
